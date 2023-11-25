package boltDB

import (
	"database/sql"
	"encoding/json"
	"fmt"
	"log"
	"io/ioutil"

	"github.com/boltdb/bolt"
)

type Cliente struct {
	IdUsuarie        int    `json:"id_usuarie"`
	Nombre           string `json:"nombre"`
	Apellido         string `json:"apellido"`
	Dni              int    `json:"dni"`
	FechaNacimiento  string `json:"fecha_nacimiento"`
	Telefono         string `json:"telefono"`
	Email            string `json:"email"`
}

func guardarEnBoltDBCliente(){
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Creando la bd en bolt
	boltDB, err := bolt.Open("Cliente.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	// Crea el bucket para cliente 
	err = boltDB.Update(func(tx *bolt.Tx) error {
		_, err := tx.CreateBucketIfNotExists([]byte("cliente"))
		return err
	})
	if err != nil {
		log.Fatal(err)
	}

	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/clientes.json")
	if err != nil {
		log.Fatal(err)
	}

	var clientes []Cliente
	err = json.Unmarshal([]byte(jsonString), &clientes)
	if err != nil {
		log.Fatal(err)
	}

	//Guardar clientes en la bd
	err = boltDB.Update(func(tx *bolt.Tx) error {
		bucket := tx.Bucket([]byte("cliente"))
		for _, c := range clientes {
			jsonString, err := json.Marshal(c)
			if err != nil {
				log.Fatal(err)
			}

			err = bucket.Put([]byte(fmt.Sprintf("%d", c.IdUsuarie)), jsonString)
			if err != nil {
				log.Fatal(err)
			}
		}
		return nil
	})

	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Base de datos cliente y datos guardados correctamente.")
}

func mostrarEnBoltDBCliente() {
	boltDB, err := bolt.Open("Cliente.db", 0600, nil)
	if err != nil {
		log.Fatal(err)
	}
	defer boltDB.Close()

	err = boltDB.View(func(tx *bolt.Tx) error {
		// Traer bucket "cliente"
		clienteBucket := tx.Bucket([]byte("cliente"))
		if clienteBucket == nil {
			log.Fatal(err)
		}

		//Iterar bucket y mostrar por pantalla
		err := clienteBucket.ForEach(func(k, v []byte) error {
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
