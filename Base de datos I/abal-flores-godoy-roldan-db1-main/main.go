package main

import (
	"abal-flores-godoy-roldan-db1/data/queriesdb" // queriesdb
    "abal-flores-godoy-roldan-db1/data/store_procedure"
	"abal-flores-godoy-roldan-db1/data/boltDB"
	"bufio"
	"fmt"
	"os"
	"strings"
)

func leerTeclado() string {
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	return strings.TrimSpace(input)
}

func presionarEnter() {
	fmt.Println("Presione Enter para continuar...")
	reader := bufio.NewReader(os.Stdin)
	reader.ReadString('\n')
}



func main(){
	
	
	asciiArt := `CHANGO ONLINE`

	for{
		fmt.Println(asciiArt)
		fmt.Println("----------------------------------------------------------------")
		fmt.Println("-------------------------MENU PRNICIPAL-------------------------")
		fmt.Println("----------------------------------------------------------------")
		fmt.Println("Integrantes: ")
		fmt.Println("- Abal ")
		fmt.Println("- Flores ")
		fmt.Println("- Godoy ")
		fmt.Println("- Roldan ")
		fmt.Println("----------------------------------------------------------------")
		fmt.Println()
		fmt.Println("Ingrese alguna de las siguientes opciones:")
		fmt.Println("1 - Gestionar Base de Datos")
		fmt.Println("2 - Stored Procedures y Triggers")
		fmt.Println("3 - Ejecutar NoSql y guardar en JSON")
		fmt.Println("4 - Salir")
		fmt.Println()
		
		inputMenuPrincipal := leerTeclado()

		switch inputMenuPrincipal {
			case "1":
				for {
					fmt.Print("-----------------------------")
					fmt.Print("---------- SUBMENU ----------")
					fmt.Print("-----------------------------")
					fmt.Println("Ingrese alguna de las siguientes opciones:")
					fmt.Println("1 - Crear la base de datos")
					fmt.Println("2 - Crear tablas")
					fmt.Println("3 - Crear Keys")
					fmt.Println("4 - Cargar datos en las tablas")
					fmt.Println("5 - Eliminar PK y FK")
					fmt.Println("6 - Eliminar Base de Datos")
					fmt.Println("7 - Volver al menú principal")
					fmt.Print("-----------------------------")

					inputSubMenu := leerTeclado()
			
					switch inputSubMenu {
					case "1":
						queriesdb.CrearDataBase() 
						presionarEnter()
					case "2":
						queriesdb.CrearTablas()
						presionarEnter()
					case "3":
						queriesdb.CrearKeys()
						presionarEnter()
					case "4":
						queriesdb.CargarDatos()
						presionarEnter()
					case "5":
						queriesdb.BorrarKeys()
						presionarEnter()
					case "6":
						queriesdb.EliminarDataBase()
						presionarEnter()
					case "7":
						fmt.Println("Volviendo al menu principal...")
					default:
						fmt.Println("Acción no válida. Por favor, ingrese un número válido.")
					}
					if inputSubMenu == "7"{
						break;
					}
					
				}
			case "2":
					fmt.Print("--------------------------------------------------------")
					fmt.Print("---------- SUBMENU STORED PROCEDURES TRIGGERS ----------")
					fmt.Print("--------------------------------------------------------")
					fmt.Println("Ingrese alguna de las siguientes opciones:")
					fmt.Println("1 - Crear Stored Procedures")
					fmt.Println("2 - Crear Triggers")
					fmt.Println("3 - Ejecutar Stored Procedure: Crear Pedido")
					fmt.Println("4 - Ejecutar Stored Procedure: Agregar Producto")
					fmt.Println("5 - Ejecutar Stored Procedure: Cancelar Pedido")
					fmt.Println("6 - Ejecutar Stored Procedure: Cierre Pedido")
					fmt.Println("7 - Ejecutar Stored Procedure: Entrega Pedido")
					fmt.Println("8 - Ejecutar Stored Procedure: Solicitud de reposicion")
					fmt.Println("9 - Ejecutar Carga De Pedidos")
					fmt.Println("10 - Menu Principal")
					fmt.Print("--------------------------------------------------------")

					inputSubMenu := leerTeclado()

					switch inputSubMenu {
					case "1":
						store_procedure.CrearStoreProcedureCrearPedido()
						store_procedure.CrearStoreProcedureAgregarProducto()
						store_procedure.CrearStoreProcedureCancelarPedido()
						store_procedure.CrearStoreProcedureCrearCierreDelPedido()
						store_procedure.CrearStoreProcedureEntregaPedido()
						store_procedure.CrearStoreProcedureGenerarSolicitudReposicion()
						presionarEnter()
					case "2":
						store_procedure.CrearTriggerEnvioMail()
						presionarEnter()
					case "3":
						store_procedure.GenerarPedido()
						presionarEnter()
					case "4":
						store_procedure.AgregarProducto()
						presionarEnter()
					case "5":
						store_procedure.CancelarPedido()
						presionarEnter()
					case "6":
						store_procedure.CierreDelPedido()
						presionarEnter()
					case "7":
						store_procedure.EntregaPedido()
						presionarEnter()
					case "8":
						store_procedure.GenerarSolicitudReposicion()
						presionarEnter()
					case "9":
						queriesdb.CargarEntradasTrx()
						presionarEnter()
					case "10":
						fmt.Println("Volviendo al menu principal...")
					default:
						fmt.Println("Acción no válida. Por favor, ingrese un número válido.")
					}
					if inputSubMenu == "10"{
						break;
					}

			case "3":
					fmt.Println("--------------------------------------------------------------------------------------")
					fmt.Println("----------------------------------SUBMENU BOLTDB--------------------------------------")
					fmt.Println("######################################################################################")
					fmt.Println("Ingrese alguna de las siguientes opciones:")
					fmt.Println("1 - Crear NoSQL de clientes")
					fmt.Println("2 - Crear NoSQL de entrega")
					fmt.Println("3 - Crear NoSQL de direcciones de entrega")
					fmt.Println("4 - Crear NoSQL de pedidos")
					fmt.Println("5 - Volver ")

					inputSubMenu := leerTeclado()

					switch inputSubMenu {
					case "1":
						boltDB.BoltDBmainCliente()
						presionarEnter()
					case "2":
						boltDB.BoltDBmainDirecciones()
						presionarEnter()
					case "3":
						boltDB.BoltDBMainProductos()
						presionarEnter()
					case "4":
						boltDB.BoltDBMainPedido()
						presionarEnter()
					case "5":
						fmt.Println("Volviendo al menu principal...")
						presionarEnter()
					}
					if inputSubMenu == "5"{
						break;
					}

			case "4":
				fmt.Println("SALIENDO...")
				break
			default:
				fmt.Println("Acción no válida. Por favor, ingrese un número válido.")
		}
	}

}

