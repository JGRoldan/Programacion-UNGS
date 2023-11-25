package queriesdb

import (
	"database/sql"
	"io/ioutil"
	"log"

	_ "github.com/lib/pq"
)

func CrearTablas(){

	connStr := "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable"
	db, err := sql.Open("postgres", connStr)

	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Leer archivo sql
	sqlTablas, err := ioutil.ReadFile("data/queriesdb/crear_tablas.sql")
	if err != nil {
		log.Fatal(err)
	}
	



	//Crear tablas
	_, err = db.Exec(string(sqlTablas))
	if err != nil {
		log.Fatal(err)
	}

	log.Println("----------------------------------")
	log.Println("Se crearon las tablas exitosamente")
	log.Println("----------------------------------")
}
