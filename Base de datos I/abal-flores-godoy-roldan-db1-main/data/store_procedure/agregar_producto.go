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

func CrearStoreProcedureAgregarProducto(){
	//Conexion a BD

	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Lectura del .sql store procedure crear pedido
	sqlFile, err := ioutil.ReadFile("data/store_procedure/sp_agregar_producto.sql")
	if err != nil{
		log.Fatal(err)
	}

	_, err = db.Exec(string(sqlFile))
	if err != nil {
		log.Fatal(err)
	}

	log.Println("---------------------------------------------------------")
	log.Println("Stored Procedure de Agregar Producto creado correctamente")
	log.Println("---------------------------------------------------------")
}

func AgregarProducto() bool {
	reader := bufio.NewReader(os.Stdin)

	log.Println("Ingresar el id del pedido")
	idPedidoInput, _ := reader.ReadString('\n')
	idPedidoInput = strings.TrimSpace(idPedidoInput)
	idPedidoInputInt, err := strconv.ParseInt(idPedidoInput, 10, 0)
	if err != nil {
		log.Println("Id Pedido invalido.", err)
		return false
	}

	log.Println("Ingresar el id del producto")
	idProductoInput, _ := reader.ReadString('\n')
	idProductoInput = strings.TrimSpace(idProductoInput)
	idProductoInputInt, err := strconv.ParseInt(idProductoInput, 10, 0)
	if err != nil {
		log.Println("Id Producto Invalido.", err)
		return false
	}

	log.Println("Ingresar la cantidad de productos")
	cantidadDeProductosInput, _ := reader.ReadString('\n')
	cantidadDeProductosInput = strings.TrimSpace(cantidadDeProductosInput)
	cantidadDeProductosInputInt, err := strconv.ParseInt(cantidadDeProductosInput, 10, 0)
	if err != nil {
		log.Println("Id Producto Invalido.", err)
		return false
	}

	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Ejecutar el store procedure
	_, err = db.Exec("SELECT crearProducto($1, $2, $3)", idPedidoInputInt, idProductoInputInt, cantidadDeProductosInputInt)
	if err != nil {
		log.Fatal(err)
	}


	log.Println("------------------------------------------------------------")
	log.Println("Stored Procedure de Agregar Producto ejecutado correctamente")
	log.Println("------------------------------------------------------------")
	return true
}