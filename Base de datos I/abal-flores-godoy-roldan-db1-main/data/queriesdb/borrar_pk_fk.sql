alter table direccion_entrega drop constraint id_usuarie_fk;
alter table pedido_detalle drop constraint id_pedido_fk;
alter table pedido_detalle drop constraint id_producto_fk;
alter table reposicion drop constraint id_producto_fk;

alter table cliente drop constraint cliente_pk;
alter table direccion_entrega drop constraint direccion_entrega_pk;
alter table tarifa_entrega drop constraint tarifa_entrega_pk;
alter table producto drop constraint producto_pk;
alter table pedido drop constraint pedido_pk;
alter table pedido_detalle drop constraint pedido_detalle_pk;
alter table reposicion drop constraint reposicion_pk;
alter table error drop constraint error_pk;
alter table envio_email drop constraint envio_email_pk;


