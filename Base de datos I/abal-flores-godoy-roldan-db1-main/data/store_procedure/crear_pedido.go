package store_procedure

import (
	"bufio"
	"database/sql"
	"io/ioutil"
	"log"
	"os"
	"strings"
	"strconv"
)

func CrearStoreProcedureCrearPedido(){
	//Conexion a BD

	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Lectura del .sql store procedure crear pedido
	sqlFile, err := ioutil.ReadFile("data/store_procedure/sp_crear_pedido.sql")
	if err != nil{
		log.Fatal(err)
	}

	_, err = db.Exec(string(sqlFile))
	if err != nil {
		log.Fatal(err)
	}

	log.Println("-----------------------------------------------------")
	log.Println("Stored Procedure de Crear Pedido creado correctamente")
	log.Println("-----------------------------------------------------")
}

func GenerarPedido() bool {
	reader := bufio.NewReader(os.Stdin)

	log.Println("Ingresar el id del usuarie")
	idUsuarieInput, _ := reader.ReadString('\n')
	idUsuarieInput = strings.TrimSpace(idUsuarieInput)
	idUsuarieInputInt, err := strconv.ParseInt(idUsuarieInput, 10, 0)
	if err != nil {
		log.Println("Id usuarie invalido.", err)
		return false
	}

	log.Println("Ingresar el id de direccion")
	idDireccionInput, _ := reader.ReadString('\n')
	idDireccionInput = strings.TrimSpace(idDireccionInput)
	idDireccionInputInt, err := strconv.ParseInt(idDireccionInput, 10, 0)
	if err != nil {
		log.Println("Id de direccion invalido.", err)
		return false
	}

	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Ejecutar el store procedure
	_, err = db.Exec("SELECT crearPedido($1, $2)", idUsuarieInputInt, idDireccionInputInt)
	if err != nil {
		log.Fatal(err)
	}


	log.Println("--------------------------------------------------------")
	log.Println("Stored Procedure de crear pedido ejecutado correctamente")
	log.Println("--------------------------------------------------------")
	return true
}