package queriesdb

type Cliente struct {
	IdUsuarie       int    `json:"id_usuarie"`
	Nombre          string `json:"nombre"`
	Apellido        string `json:"apellido"`
	Dni             int    `json:"dni"`
	FechaNacimiento string `json:"fecha_nacimiento"` // Cambiado a string
	Telefono        string `json:"telefono"`
	Email           string `json:"email"`
}

type Direccion struct {
	IdUsuarie    int    `json:"id_usuarie"`
	IdDirEntrega int    `json:"id_direccion_entrega"`
	Direccion    string `json:"direccion"`
	Localidad    string `json:"localidad"`
	CodigoPostal string `json:"codigo_postal"`
}
type Tarifa_entrega struct {
	CodigoPostalCorto string  `json:"codigo_postal_corto"`
	Costo             float64 `json:"costo"`
}

type Producto struct {
	IdProducto      int     `json:"id_producto"`
	Nombre          string  `json:"nombre"`
	PrecioUnitario  float64 `json:"precio_unitario"`
	StockDisponible int     `json:"stock_disponible"`
	StockReservado  int     `json:"stock_reservado"`
	PuntoReposicion int     `json:"punto_reposicion"`
	StockMaximo     int     `json:"stock_maximo"`
}

type Entrada_Trx_Pedido struct{
	IdOrden			int 	`json:"id_orden"`
	IdDireccion		int		`json:"id_direccion_entrega"`	
	Operacion		string  `json:"operacion"`
	IdUsuarie		int 	`json:"id_usuarie"`
	IdPedido		int 	`json:"id_pedido"`
	IdProducto		int 	`json:"id_producto"`
	Cantidad		int 	`json:"cantidad"`
	FHoraEntrega	string  `json:"fecha_hora_entrega"`
}