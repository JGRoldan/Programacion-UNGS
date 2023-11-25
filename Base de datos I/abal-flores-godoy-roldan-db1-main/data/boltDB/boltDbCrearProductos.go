package boltDB

import (
	"database/sql"
	"encoding/json"
	"fmt"
	"log"
	"io/ioutil"

	"github.com/boltdb/bolt"
)

type Producto struct {
	IdProducto		 	int 	`json:"id_producto"`
	Nombre 				string	`json:"nombre"`
	PrecioUnitario		float64	`json:"precio_unitario"`
	StockDisponible		int		`json:"stock_disponible"`
	StockReservado		int		`json:"stock_reservado"`	
	PuntoReposicion		int		`json:"punto_reposicion"`
	StockMaximo			int		`json:"stock_maximo"`
}

func guardarEnBoltDBProductos(){
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Creando la bd en bolt
	boltDB, err := bolt.Open("Producto.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	// Crea el bucket para producto 
	err = boltDB.Update(func(tx *bolt.Tx) error {
		_, err := tx.CreateBucketIfNotExists([]byte("producto"))
		return err
	})
	if err != nil {
		log.Fatal(err)
	}

	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/productos.json")
	if err != nil {
		log.Fatal(err)
	}

	var productos []Producto
	err = json.Unmarshal([]byte(jsonString), &productos)
	if err != nil {
		log.Fatal(err)
	}

	//Guardar productos en la bd
	err = boltDB.Update(func(tx *bolt.Tx) error {
		bucket := tx.Bucket([]byte("producto"))
		for _, c := range productos {
			jsonString, err := json.Marshal(c)
			if err != nil {
				log.Fatal(err)
			}

			err = bucket.Put([]byte(fmt.Sprintf("%d", c.IdProducto)), jsonString)
			if err != nil {
				log.Fatal(err)
			}
		}
		return nil
	})

	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Base de datos producto y datos guardados correctamente.")
}

func mostrarEnBoltDBProductos() {
	boltDB, err := bolt.Open("Producto.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	err = boltDB.View(func(tx *bolt.Tx) error {
		// Traer bucket "productos"
		productoBucket := tx.Bucket([]byte("producto"))
		if productoBucket == nil {
			log.Fatal(err)
		}

		//Iterar bucket y mostrar por pantalla
		err := productoBucket.ForEach(func(k, v []byte) error {
			fmt.Printf("Clave: %s\n", k)
			fmt.Printf("Valor: %s\n", v)
			fmt.Println("--------------------")
			return nil
		})
		if err != nil {
			return err
		}

		return nil
	})

	if err != nil {
		log.Fatal(err)
	}
}
