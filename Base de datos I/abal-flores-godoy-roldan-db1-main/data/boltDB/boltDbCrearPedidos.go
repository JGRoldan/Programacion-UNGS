package boltDB

import(
	"database/sql"
	"encoding/json"
	"fmt"
	"log"
	"io/ioutil"

	"github.com/boltdb/bolt"
)

type Pedido struct {
	IdPedido				int 	`json:"id_pedido"`
	Fpedido 				string	`json:"f_pedido"`
	FechaEntrega 			string	`json:"fecha_entrega"`
	HoraEntregaDesde 		string	`json:"hora_entrega_desde"`
	HoraEntregaHasta 		string	`json:"hora_entrega_hasta"`
	IdUsuarie 				int		`json:"id_usuarie"`
	IdDireccionEntrega 		int		`json:"id_direccion_entrega"`
	MontoTotal 				float64	`json:"monto_total"`
	CostoEnvio 				float64	`json:"costo_envio"`
	Estado 					string	`json:"estado"`
}

func guardarEnBoltDBPedido(){
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Creando la bd en bolt
	boltDB, err := bolt.Open("Pedido.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	// Crea el bucket para producto 
	err = boltDB.Update(func(tx *bolt.Tx) error {
		_, err := tx.CreateBucketIfNotExists([]byte("pedido"))
		return err
	})
	if err != nil {
		log.Fatal(err)
	}

	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/pedido.json")
	if err != nil {
		log.Fatal(err)
	}

	var pedidos []Pedido
	err = json.Unmarshal([]byte(jsonString), &pedidos)
	if err != nil {
		log.Fatal(err)
	}

	//Guardar productos en la bd
	err = boltDB.Update(func(tx *bolt.Tx) error {
		bucket := tx.Bucket([]byte("pedido"))
		for _, c := range pedidos {
			jsonString, err := json.Marshal(c)
			if err != nil {
				log.Fatal(err)
			}

			err = bucket.Put([]byte(fmt.Sprintf("%d", c.IdPedido)), jsonString)
			if err != nil {
				log.Fatal(err)
			}
		}
		return nil
	})

	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Base de datos pedidos y datos guardados correctamente.")
}

func mostrarEnBoltDBPedido() {
	boltDB, err := bolt.Open("Pedido.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	err = boltDB.View(func(tx *bolt.Tx) error {
		// Traer bucket "pedido"
		pedidoBucket := tx.Bucket([]byte("pedido"))
		if pedidoBucket == nil {
			log.Fatal(err)
		}

		//Iterar bucket y mostrar por pantalla
		err := pedidoBucket.ForEach(func(k, v []byte) error {
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
