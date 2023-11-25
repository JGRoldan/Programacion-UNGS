package boltDB

import(
	"database/sql"
	"encoding/json"
	"fmt"
	"log"
	"io/ioutil"

	"github.com/boltdb/bolt"
)

type PedidoDetalle struct {
	IdPedido				int 	`json:"id_pedido"`
	IdProducto 				int		`json:"id_producto"`
	Cantidad 				int		`json:"cantidad"`
	PrecioUnitario 			float64	`json:"precio_unitario"`
}

func guardarEnBoltDBPedidoDetalle(){
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Creando la bd en bolt
	boltDB, err := bolt.Open("PedidoDetalle.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	// Crea el bucket para producto 
	err = boltDB.Update(func(tx *bolt.Tx) error {
		_, err := tx.CreateBucketIfNotExists([]byte("pedidodetalle"))
		return err
	})
	if err != nil {
		log.Fatal(err)
	}

	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/pedido_detalle.json")
	if err != nil {
		log.Fatal(err)
	}

	var pedidosdetalles []PedidoDetalle
	err = json.Unmarshal([]byte(jsonString), &pedidosdetalles)
	if err != nil {
		log.Fatal(err)
	}

	//Guardar productos en la bd
	err = boltDB.Update(func(tx *bolt.Tx) error {
		bucket := tx.Bucket([]byte("pedidodetalle"))
		for _, c := range pedidosdetalles {
			jsonString, err := json.Marshal(c)
			if err != nil {
				log.Fatal(err)
			}

			pks := fmt.Sprintf("%d:%d", c.IdPedido, c.IdProducto)

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

	fmt.Println("Base de datos pedidos detalles y datos guardados correctamente.")
}

func mostrarEnBoltDBPedidoDetalle() {
	boltDB, err := bolt.Open("PedidoDetalle.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	err = boltDB.View(func(tx *bolt.Tx) error {
		// Traer bucket "pedidodetalle"
		pedidoDetalleBucket := tx.Bucket([]byte("pedidodetalle"))
		if pedidoDetalleBucket == nil {
			log.Fatal(err)
		}

		//Iterar bucket y mostrar por pantalla
		err := pedidoDetalleBucket.ForEach(func(k, v []byte) error {
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
