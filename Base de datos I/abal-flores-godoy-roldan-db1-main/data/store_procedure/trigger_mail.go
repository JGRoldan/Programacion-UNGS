package store_procedure

import (
	"database/sql"
	"io/ioutil"
	"log"
)

func CrearTriggerEnvioMail() {
	//Conectamos a la BBDD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Leemos el archivo .sql
	sqlFile, err := ioutil.ReadFile("data/store_procedure/tr_enviar_mail.sql")
	if err != nil {
		log.Fatal(err)
	}

	_, err = db.Exec(string(sqlFile))
	if err != nil {
		log.Fatal(err)
	}

	log.Println("##########################################")
	log.Println("Trigger de envio mails creado exitosamente")
	log.Println("##########################################")
}