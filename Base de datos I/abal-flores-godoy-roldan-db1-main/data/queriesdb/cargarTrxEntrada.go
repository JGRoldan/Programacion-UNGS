package queriesdb

import (
	"database/sql"
	"log"
	"strings"
	_ "github.com/lib/pq"
)

func CargarEntradasTrx(){
	//Conexion a BD
	db, err := sql.Open("postgres", "user=postgres host=localhost dbname=Abal-Flores-Godoy-Roldan-db1 sslmode=disable")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()

	//Traer las filas de la tabla entrada trx pedido
	filas, err := db.Query("select * from entrada_trx_pedido")
	if err != nil {
		log.Fatal(err)
	}
	defer filas.Close()

	for filas.Next(){
		var filaPedido Entrada_Trx_Pedido
		err := filas.Scan(&filaPedido.IdOrden, &filaPedido.IdDireccion, &filaPedido.Operacion, &filaPedido.IdUsuarie, &filaPedido.IdPedido, &filaPedido.IdProducto, &filaPedido.Cantidad, &filaPedido.FHoraEntrega)
		if err != nil {
			log.Fatal(err)
		}

		spPorEjecutar := strings.TrimSpace(filaPedido.Operacion)

		switch spPorEjecutar {
			case "creación":
				_, err = db.Exec("SELECT crearPedido($1, $2)", filaPedido.IdUsuarie, filaPedido.IdDireccion)
			case "producto":
				_, err = db.Exec("SELECT crearProducto($1, $2, $3)", filaPedido.IdPedido, filaPedido.IdProducto, filaPedido.Cantidad)
			case "cierre":
				_, err = db.Exec("SELECT cierre_del_pedido($1, $2)", filaPedido.IdPedido, filaPedido.FHoraEntrega)
			case "entrega":
				_, err = db.Exec("SELECT entrega_pedido($1)", filaPedido.IdPedido)
			case "cancelación":
				_, err = db.Exec("SELECT cancelacion_pedido($1)", filaPedido.IdPedido)
			default:
				log.Printf("Operación desconocida: %s\n", spPorEjecutar)
		}
	}

	if err = filas.Err(); 
	err != nil {
		log.Fatal(err)
	}

	log.Println("------------------------------------")
	log.Println("Entrada Trx Ejecutados Correctamente")
	log.Println("------------------------------------")
}