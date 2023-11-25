package queriesdb

import (
	"database/sql"
	"log"

	_ "github.com/lib/pq"
)

func CrearDataBase(){

	connStr := "user=postgres host=localhost dbname=postgres sslmode=disable"
	
	db, err := sql.Open("postgres", connStr)
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	_, err = db.Exec(`CREATE DATABASE "Abal-Flores-Godoy-Roldan-db1";`)
	if err != nil {
		log.Fatal(err)
	}

	log.Println("-----------------------------------------------------")
	log.Println("Se creo la base de datos Abal-Flores-Godoy-Roldan-db1")
	log.Println("-----------------------------------------------------")
}

func EliminarDataBase() {

	connStr := "user=postgres host=localhost dbname=postgres sslmode=disable"

	db, err := sql.Open("postgres", connStr)
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	_, err = db.Exec(`DROP DATABASE IF EXISTS "Abal-Flores-Godoy-Roldan-db1";`)
	if err != nil {
		log.Fatal(err)
	}

	log.Println("--------------------------------------------------------")
	log.Println("Se elimino la base de datos Abal-Flores-Godoy-Roldan-db1")
	log.Println("--------------------------------------------------------")

}
