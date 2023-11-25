package store_procedure

import (
	"bufio"
	"database/sql"
	"io/ioutil"
	"log"
	"os"
	"strings"
	"strconv"
	"time"
)

func CrearStoreProcedureCrearCierreDelPedido(){
	//Conexion a BD

	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Lectura del .sql store procedure crear pedido
	sqlFile, err := ioutil.ReadFile("data/store_procedure/sp_cierre_del_pedido.sql")
	if err != nil{
		log.Fatal(err)
	}

	_, err = db.Exec(string(sqlFile))
	if err != nil {
		log.Fatal(err)
	}

	log.Println("----------------------------------------------------------")
	log.Println("Stored Procedure de Cierre Del Pedido creado correctamente")
	log.Println("----------------------------------------------------------")
}

func CierreDelPedido() bool {
	reader := bufio.NewReader(os.Stdin)

	log.Println("Ingresar el id del pedido")
	idPedidoInput, _ := reader.ReadString('\n')
	idPedidoInput = strings.TrimSpace(idPedidoInput)
	idPedidoInputInt, err := strconv.ParseInt(idPedidoInput, 10, 0)
	if err != nil {
		log.Println("Id Pedido invalido.", err)
		return false
	}

	log.Println("Ingresar la fecha y hora de entrega (en formato 'YYYY-MM-DD HH:MM:SS'):")
	fechaYHoraDeEntregaInput, _ := reader.ReadString('\n')
	fechaYHoraDeEntregaInput = strings.TrimSpace(fechaYHoraDeEntregaInput)
	fechaYHoraDeEntregaInputTime, err := time.Parse("2006-01-02 15:04:05", fechaYHoraDeEntregaInput)
	if err != nil {
		log.Println("Fecha y Hora de Entrega invalida.", err)
		return false
	}

	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Ejecutar el store procedure
	_, err = db.Exec("SELECT cierre_del_pedido($1, $2)", idPedidoInputInt, fechaYHoraDeEntregaInputTime)
	if err != nil {
		log.Fatal(err)
	}


	log.Println("-------------------------------------------------------------")
	log.Println("Stored Procedure de Cierre Del Pedido ejecutado correctamente")
	log.Println("-------------------------------------------------------------")
	return true
}