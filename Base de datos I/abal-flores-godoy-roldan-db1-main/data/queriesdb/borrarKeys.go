package queriesdb

import (
	"database/sql"
	"io/ioutil"
	"log"

	_ "github.com/lib/pq"
)

func BorrarKeys() {

	connStr := "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable"
	db, err := sql.Open("postgres", connStr)

	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	
	sqlDelKeys, err := ioutil.ReadFile("data/queriesdb/borrar_pk_fk.sql")
	if err != nil {
		log.Fatal(err)
	}

	_, err = db.Exec(string(sqlDelKeys))
	if err != nil {
		log.Fatal(err)
	}

	log.Println("--------------------------------")
	log.Println("PK y FK eliminadas correctamente")
	log.Println("--------------------------------")
}
