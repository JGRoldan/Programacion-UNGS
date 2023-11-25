package queriesdb

import (
	"database/sql"
	"io/ioutil"
	"log"

	_ "github.com/lib/pq"
)

func CrearKeys(){

	connStr := "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable"
	db, err := sql.Open("postgres", connStr)

	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Leer archivo sql
	sqlPk, err := ioutil.ReadFile("data/queriesdb/agregar_pk.sql")
	if err != nil {
		log.Fatal(err)
	}

	sqlFk, err2 := ioutil.ReadFile("data/queriesdb/agregar_fk.sql")
	if err != nil {
		log.Fatal(err2)
	}
	



	//Crear tablas
	_, err = db.Exec(string(sqlPk))
	if err != nil {
		log.Fatal(err)
	}
	_, err2 = db.Exec(string(sqlFk))
	if err2 != nil {
		log.Fatal(err2)
	}

	log.Println("-------------------------------")
	log.Println("Se crearon Pk y Fk exitosamente")
	log.Println("-------------------------------")
}
