package store_procedure

import (
	"database/sql"
	"io/ioutil"
	"log"
)

func CrearStoreProcedureGenerarSolicitudReposicion(){
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Lectura del .sql store procedure cancelar pedido
	sqlFile, err := ioutil.ReadFile("data/store_procedure/sp_generar_solicitud_reposicion.sql")
	if err != nil{
		log.Fatal(err)
	}

	_, err = db.Exec(string(sqlFile))
	if err != nil {
		log.Fatal(err)
	}

	log.Println("------------------------------------------------------------------------")
	log.Println("Stored Procedure de Generar Solicitud de Reposicion creado correctamente")
	log.Println("------------------------------------------------------------------------")
}

func GenerarSolicitudReposicion() bool {
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Ejecutar el store procedure
	_, err = db.Exec("SELECT generarSolicitudReposicion()")
	if err != nil {
		log.Fatal(err)
	}

	log.Println("---------------------------------------------------------------------------")
	log.Println("Stored Procedure de Generar Solicitud de Reposicion ejecutado correctamente")
	log.Println("---------------------------------------------------------------------------")
	return true
}