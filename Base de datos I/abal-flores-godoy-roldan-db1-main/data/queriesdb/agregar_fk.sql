alter table direccion_entrega
add constraint id_usuarie_fk
foreign key (id_usuarie)
references cliente (id_usuarie);

alter table pedido_detalle
add constraint id_pedido_fk
foreign key (id_pedido)
references pedido (id_pedido);

alter table pedido_detalle
add constraint id_producto_fk
foreign key (id_producto)
references producto (id_producto);

alter table reposicion
add constraint id_producto_fk
foreign key (id_producto)
references producto (id_producto);

