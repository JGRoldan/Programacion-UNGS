create or replace function entrega_pedido (par_pedido_id int) 
returns boolean as $$
declare

    var_estado_pedido char(10);
    var_registro record;
begin
        --Valida que el id exista en la tabla
        if not exists (select * from pedido where id_pedido  = par_pedido_id) then
            insert into error (id_pedido, operacion, f_error, motivo)
	        values (par_id_pedido, 'cancelacion', current_timestamp, '?id de pedido no valido.');  

            return false;
        end if;

        --Estado del pedido
        if var_estado_pedido != 'completado' then
            insert into error (id_pedido, operacion, f_error, motivo)
            values ( par_pedido_id, 'cancelacion', current_date, '?pedido sin cerrar o ya entregado.');
            
            return false;
        end if;


        --Estado pedido = entregado
        update pedido set estado = 'entregado' where id_pedido = par_pedido_id;

        --Por cada fila que este relacionada con el id_pedido q fue entregado => se guarda
        --el id_producto y cantidad en var_registro 
        for var_registro in select id_producto, cantidad from pedido_detalle where id_pedido = par_pedido_id loop

            update producto set stock_reservado = (stock_reservado - var_registro.cantidad) 
            where id_producto = var_registro.id_producto;

        end loop;
        return true;
end;

$$ language plpgsql;
