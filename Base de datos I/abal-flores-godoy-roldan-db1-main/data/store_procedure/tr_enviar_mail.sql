create or replace function enviar_mail() returns trigger as $$

declare
    this_pedido pedido%rowtype;
    email_del_cliente text;
    nombre_del_cliente text;
    cuerpo text;
    direccion_de_entrega varchar(60);
    detalle_del_producto text;
    cantidad int;
    precio_unitario decimal(12,2);
    nombre_del_producto text;

    begin

        this_pedido := new;
        select email into email_del_cliente from cliente where id_usuarie = this_pedido.id_usuarie;

        select nombre into nombre_del_cliente from cliente where id_usuarie = this_pedido.id_usuarie;

        select direccion into direccion_de_entrega from direccion_entrega d where d.id_usuarie = this_pedido.id_usuarie;

        select p.nombre into nombre_del_producto from producto p where p.id_producto in (select d.id_producto from pedido_detalle d where d.id_pedido = this_pedido.id_pedido);
       
        select d.cantidad into cantidad from pedido_detalle d where d.id_pedido = this_pedido.id_pedido;

        select d.precio_unitario into precio_unitario from pedido_detalle d where d.id_pedido = this_pedido.id_pedido;


        if this_pedido.estado = 'completado' then
            cuerpo:='Supermercado ChangoMas' || '\n '||  
                    'Detalles del pedido con id numero :' || ' '|| this_pedido.id_pedido || ' ' || 
                    'ha sido aceptado , detalles: \n '  || 
                    'ID: ' ||  this_pedido.id_pedido || '\n' || 
                    'Fecha del pedido : '|| this_pedido.f_pedido || '\n'||
                    'Nombre del producto : ' || nombre_del_producto || '\n' ||
                    'Cantidad: ' || cantidad || '\n' ||
                    'Precio por unidad : ' || precio_unitario || '\n' ||
                    'Precio total:' || this_pedido.monto_total || '\n';

            insert into envio_email(f_generacion, email_cliente, asunto, cuerpo, f_envio, estado) 
            values(current_timestamp, email_del_cliente, 'Pedido Aceptado', cuerpo, current_timestamp, this_pedido.estado);
             
        elsif this_pedido.estado = 'cancelado' then
            cuerpo:='Supermercado ChangoMas' || '\n' || 
                    'Te informamos que el pedido con el ID numero :' || ' '|| this_pedido.id_pedido || ' ' || 
                    'fue cancelado , detalles: \n '  || 
                    'ID: ' ||  this_pedido.id_pedido || '\n' || 
                    'Fecha del pedido : '|| this_pedido.f_pedido || '\n'||
                    'Nombre del producto : ' || nombre_del_producto || '\n' ||
                    'Cantidad: ' || cantidad || '\n' ||
                    'Precio por unidad : ' || precio_unitario || '\n' ||    
                    'Precio total:' || this_pedido.monto_total || '\n';

            insert into envio_email(f_generacion, email_cliente, asunto, cuerpo, f_envio, estado) 
            values(current_timestamp, email_del_cliente, 'Pedido Cancelado', cuerpo, current_timestamp, this_pedido.estado);
    
        elsif this_pedido.estado = 'entregado' then
            cuerpo:=' Supermercado ChangoMas' || '\n'  || 
                    'Te informamos que el pedido con el ID numero :' || ' '|| this_pedido.id_pedido || ' ' || 
                    'ha sido entregado , detalles: \n '  || 
                    'ID: ' ||  this_pedido.id_pedido || '\n' || 
                    'Fecha del pedido : '|| this_pedido.f_pedido || '\n'||
                    'Nombre del producto : ' || nombre_del_producto || '\n' ||
                    'Cantidad: ' || cantidad || '\n' ||
                    'Precio por unidad : ' || precio_unitario || '\n' ||
                    'Precio total:' || this_pedido.monto_total || '\n';

            insert into envio_email(f_generacion, email_cliente, asunto, cuerpo, f_envio, estado) 
            values(current_timestamp, email_del_cliente, 'Pedido Entregado', cuerpo, current_timestamp, this_pedido.estado);
    
            cuerpo :='Encuesta del pedido : ' || ' ' || this_pedido.id_pedido || ' '||
                     'para saber el nivel de satisfaccion por su compra en ChangoMas \n';

            insert into envio_email(f_generacion, email_cliente, asunto, cuerpo, f_envio, estado) 
            values(current_timestamp, email_del_cliente, 'Encuesta de satisfaccion', cuerpo, (current_timestamp + interval '1 day'), this_pedido.estado);
    
    end if;
    return new;

end;
$$ language plpgsql;

--TRIGGER 

create or replace trigger enviar_mail_trigger
after insert or update on pedido
for each row execute function enviar_mail();
