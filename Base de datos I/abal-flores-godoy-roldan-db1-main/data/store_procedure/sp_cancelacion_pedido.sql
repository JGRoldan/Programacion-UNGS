create or replace function cancelacion_pedido (par_id_pedido int) 
returns boolean as $$
declare 
    var_registro record;
begin   

    --Valido id pedido exista
    if not exists (select * from pedido where id_pedido = par_id_pedido) then

        insert into error (id_pedido, operacion, f_error, motivo)
	    values (par_id_pedido, 'cancelacion', current_timestamp, '?id de pedido no valido.');

        return false;
    end if;

     --Valido estado pedido
    if not exists 
            (select * from pedido 
                where id_pedido = par_id_pedido 
                and estado='ingresado' 
                or estado='completado'
            ) then
        
        insert into error (id_pedido, operacion, f_error, motivo)
	    values (par_id_pedido, 'cancelacion', current_timestamp, '?pedido ya entregado o completado.');    

        return false;
    end if;

    update pedido set estado = 'cancelado' where id_pedido = par_id_pedido;

    for var_registro in select id_producto, cantidad from pedido_detalle where id_pedido = par_id_pedido loop
            --actualizo producto (resto stock_reservado - la cantidad del pedido cancelado)
        update producto set stock_reservado = (stock_reservado - var_registro.cantidad) where id_producto = var_registro.id_producto ;

            --actualizo tabla producto sumando al stock disponible la cantidad del pedido cancelado
        update producto set stock_disponible = (stock_disponible + var_registro.cantidad) where id_producto = var_registro.id_producto ; 
    end loop;

    return true;

end;
$$ language plpgsql;