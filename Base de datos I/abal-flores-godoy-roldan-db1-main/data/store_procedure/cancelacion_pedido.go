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

func CrearStoreProcedureCancelarPedido(){
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Lectura del .sql store procedure cancelar pedido
	sqlFile, err := ioutil.ReadFile("data/store_procedure/sp_cancelacion_pedido.sql")
	if err != nil{
		log.Fatal(err)
	}

	_, err = db.Exec(string(sqlFile))
	if err != nil {
		log.Fatal(err)
	}

	log.Println("--------------------------------------------------------")
	log.Println("Stored Procedure de Cancelar Pedido creado correctamente")
	log.Println("--------------------------------------------------------")
}

func CancelarPedido() bool {
	reader := bufio.NewReader(os.Stdin)

	log.Println("Ingresar el id del pedido")
	idPedidoInput, _ := reader.ReadString('\n')
	idPedidoInput = strings.TrimSpace(idPedidoInput)
	idPedidoInputInt, err := strconv.ParseInt(idPedidoInput, 10, 0)
	if err != nil {
		log.Println("Id del pedido invalido.", err)
		return false
	}

	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Ejecutar el store procedure
	_, err = db.Exec("SELECT cancelacion_pedido($1)", idPedidoInputInt)
	if err != nil {
		log.Fatal(err)
	}

	log.Println("--------------------------------------------------------")
	log.Println("Stored Procedure de Cancelar Pedido ejecutado correctamente")
	log.Println("--------------------------------------------------------")
	return true
}