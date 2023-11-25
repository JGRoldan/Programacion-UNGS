package boltDB

import (
	"database/sql"
	"encoding/json"
	"fmt"
	"log"
	"io/ioutil"

	"github.com/boltdb/bolt"
)

type Direccion_Entrega struct {
	IdUsuarie        int    `json:"id_usuarie"`
	IdDirEntrega     int 	`json:"id_direccion_entrega"`
	Direccion        string `json:"direccion"`
	Localidad        string `json:"localidad"`
	CodigoPostal  	 string `json:"codigo_postal"`
}

func guardarEnBoltDBDirecciones(){
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Creando la bd en bolt
	boltDB, err := bolt.Open("Direccion_Entrega.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	// Crea el bucket para direcciones 
	err = boltDB.Update(func(tx *bolt.Tx) error {
		_, err := tx.CreateBucketIfNotExists([]byte("direccion_entrega"))
		return err
	})
	if err != nil {
		log.Fatal(err)
	}

	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/direcciones.json")
	if err != nil {
		log.Fatal(err)
	}

	var direcciones []Direccion_Entrega
	err = json.Unmarshal([]byte(jsonString), &direcciones)
	if err != nil {
		log.Fatal(err)
	}

	//Guardar direcciones en la bd
	err = boltDB.Update(func(tx *bolt.Tx) error {
		bucket := tx.Bucket([]byte("direccion_entrega"))
		for _, c := range direcciones {
			jsonString, err := json.Marshal(c)
			if err != nil {
				log.Fatal(err)
			}

			pks := fmt.Sprintf("%d:%d", c.IdUsuarie, c.IdDirEntrega)

			err = bucket.Put([]byte(pks), jsonString)
			if err != nil {
				log.Fatal(err)
			}
		}
		return nil
	})

	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Base de datos direcciones de entrega y datos guardados correctamente.")
}

func mostrarEnBoltDBDirecciones() {
	boltDB, err := bolt.Open("Direccion_Entrega.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	err = boltDB.View(func(tx *bolt.Tx) error {
		// Traer bucket "direccion_entrega"
		direccionesBucket := tx.Bucket([]byte("direccion_entrega"))
		if direccionesBucket == nil {
			log.Fatal(err)
		}

		//Iterar bucket y mostrar por pantalla
		err := direccionesBucket.ForEach(func(k, v []byte) error {
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