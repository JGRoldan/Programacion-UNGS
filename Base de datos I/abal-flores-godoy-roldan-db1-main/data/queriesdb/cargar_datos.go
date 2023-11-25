package queriesdb

import (
	"database/sql"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	//"time"

	_ "github.com/lib/pq"
)


func CargarDatos() {
	//Conexion a la BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Cargar json en la tabla tarifas_entrega
	cargarClientes(db)
	cargarDirecciones(db)
	cargarProductos(db)
	cargarTarifasEntrega(db)
	cargarEntradaTrxPedido(db)
}

func cargarClientes(db *sql.DB) {
	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/clientes.json")
	if err != nil {
		log.Fatal(err)
	}

	//Analizar json
	var clientes []Cliente
	err = json.Unmarshal(jsonString, &clientes)
	if err != nil {
		log.Fatal(err)
	}

	for _, cliente := range clientes {
		_, err = db.Exec("INSERT INTO cliente (id_usuarie, nombre, apellido, dni, fecha_nacimiento, telefono, email) VALUES ($1, $2, $3, $4, $5, $6, $7) ",
			cliente.IdUsuarie, cliente.Nombre, cliente.Apellido, cliente.Dni, cliente.FechaNacimiento, cliente.Telefono, cliente.Email)
		if err != nil {
			log.Fatal(err)
		}
	}

	fmt.Println("---------------------------------")
	fmt.Println("Clientes insertados exitosamente.")
	fmt.Println("---------------------------------")
}

func cargarDirecciones(db *sql.DB) {
	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/direcciones.json")
	if err != nil {
		log.Fatal(err)
	}

	//Analizar json
	var direcciones []Direccion
	err = json.Unmarshal(jsonString, &direcciones)
	if err != nil {
		log.Fatal(err)
	}

	for _, dir := range direcciones {
		_, err = db.Exec("INSERT INTO direccion_entrega (id_usuarie, id_direccion_entrega, direccion, localidad, codigo_postal) VALUES ($1, $2, $3, $4, $5) ",
			dir.IdUsuarie, dir.IdDirEntrega, dir.Direccion, dir.Localidad, dir.CodigoPostal)
		if err != nil {
			log.Fatal(err)
		}
	}
	fmt.Println("------------------------------------")
	fmt.Println("direcciones insertados exitosamente.")
	fmt.Println("------------------------------------")
}

func cargarTarifasEntrega(db *sql.DB) {
	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/tarifas_entrega.json")
	if err != nil {
		log.Fatal(err)
	}

	//Analizar json
	var tarifas_entrega []Tarifa_entrega
	err = json.Unmarshal(jsonString, &tarifas_entrega)
	if err != nil {
		log.Fatal(err)
	}

	for _, tar_entr := range tarifas_entrega {
		_, err = db.Exec("INSERT INTO tarifa_entrega (codigo_postal_corto, costo) VALUES ($1, $2) ",
			tar_entr.CodigoPostalCorto, tar_entr.Costo)
		if err != nil {
			log.Fatal(err)
		}
	}

	fmt.Println("----------------------------------------")
	fmt.Println("tarifas_entrega insertados exitosamente.")
	fmt.Println("----------------------------------------")
}

func cargarProductos(db *sql.DB) {
	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/productos.json")
	if err != nil {
		log.Fatal(err)
	}

	//Analizar json
	var productos []Producto
	err = json.Unmarshal(jsonString, &productos)
	if err != nil {
		log.Fatal(err)
	}

	for _, prod := range productos {
		_, err = db.Exec("INSERT INTO producto (id_producto, nombre, precio_unitario, stock_disponible, stock_reservado, punto_reposicion, stock_maximo) VALUES ($1, $2, $3, $4, $5, $6, $7) ",
			prod.IdProducto, prod.Nombre, prod.PrecioUnitario, prod.StockDisponible, prod.StockReservado, prod.PuntoReposicion, prod.StockMaximo)
		if err != nil {
			log.Fatal(err)
		}
	}

	fmt.Println("----------------------------------------")
	fmt.Println("productos insertados exitosamente.")
	fmt.Println("----------------------------------------")
}

func cargarEntradaTrxPedido(db *sql.DB){
	//Leer el json
	jsonString, err := ioutil.ReadFile("data/json/trx_pedido.json")
	if err != nil {
		log.Fatal(err)
	}

	//Analizar json
	var productosEntrada []Entrada_Trx_Pedido
	err = json.Unmarshal(jsonString, &productosEntrada)
	if err != nil {
		log.Fatal(err)
	}

	for _, prod := range productosEntrada {

		if prod.FHoraEntrega == "" {
			prod.FHoraEntrega = "2003-11-17 15:30"
		}

		_, err = db.Exec("INSERT INTO entrada_trx_pedido (id_orden, id_direccion_entrega, operacion, id_usuarie, id_pedido, id_producto, cantidad, fecha_hora_entrega) VALUES ($1, $2, $3, $4, $5, $6, $7, $8) ",
			prod.IdOrden, prod.IdDireccion, prod.Operacion, prod.IdUsuarie, prod.IdPedido, prod.IdProducto, prod.Cantidad, prod.FHoraEntrega)
		if err != nil {
			log.Fatal(err)
		}
	}

	fmt.Println("----------------------------------------")
	fmt.Println("entrada del trx insertados exitosamente.")
	fmt.Println("----------------------------------------")
}
