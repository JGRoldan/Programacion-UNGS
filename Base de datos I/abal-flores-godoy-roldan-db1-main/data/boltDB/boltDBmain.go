package boltDB

import (

	_ "github.com/lib/pq"
)

func BoltDBmainCliente() {
	guardarEnBoltDBCliente()
	mostrarEnBoltDBCliente()
}

func BoltDBmainDirecciones(){
	guardarEnBoltDBDirecciones()
	mostrarEnBoltDBDirecciones()
}

func BoltDBMainProductos(){
	guardarEnBoltDBProductos()
	mostrarEnBoltDBProductos()
}

func BoltDBMainPedido(){
	guardarEnBoltDBPedido()
	mostrarEnBoltDBPedido()
	guardarEnBoltDBPedidoDetalle()
	mostrarEnBoltDBPedidoDetalle()
}