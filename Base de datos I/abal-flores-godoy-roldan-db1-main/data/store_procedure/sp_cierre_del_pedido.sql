create or replace function cierre_del_pedido (par_id_pedido int, par_fecha_y_hora_entrega timestamp) 
returns boolean as $$
declare
        var_cantidad_productos int;
        var_hora_entrega time;
        var_fecha_de_entrega date;
begin
        --valida que el id del pedido exista en la tabla
        if not exists(select 1 from pedido p where p.id_pedido = par_id_pedido) then
            --cargamos en la tabla el error
            insert into error (id_pedido, operacion, f_error, motivo)
	        values (par_id_pedido, 'cierre', CURRENT_TIMESTAMP, '?id de pedido no valido');
            
            return false;
        end if;

        --valida que el pedido tenga al menos un producto agregado
        if not exists(select 1 from pedido_detalle pd where pd.id_pedido = par_id_pedido) then
            insert into error (id_pedido, operacion, f_error, motivo)
	        values (par_id_pedido, 'cierre', CURRENT_TIMESTAMP, '?pedido vacio');
 
            return false;
        end if;

        --valida que la fecha de entrega del pedido sea mayor a la fecha actual.
        if par_fecha_y_hora_entrega < current_timestamp then 
            insert into error (id_pedido, operacion, f_error, motivo)
	        values (par_id_pedido, 'cierre', CURRENT_TIMESTAMP, '?fecha de entrega no valida');
            return false;
        end if;

        --validaciones pasadas
        --actualizamos la fecha de entrega
        --casteamos la fecha de entrega a time para poder actualizar la tabla 

        select cast(par_fecha_y_hora_entrega as date) into var_fecha_de_entrega;

        update pedido set fecha_entrega = var_fecha_de_entrega where id_pedido = par_id_pedido;

        -- actualizamos la fecha de entrega del pedido desde y hasta que hora puede llegar
        -- casteo la fecha de emtrega a time para sacar la hora

        select cast(par_fecha_y_hora_entrega as time) into var_hora_entrega;

        update pedido set hora_entrega_desde = var_hora_entrega where id_pedido = id_pedido;
        update pedido set hora_entrega_hasta = (var_hora_entrega + interval '2 hour') where id_pedido = par_id_pedido;

        --actualizar estado pedido
        update pedido set estado = 'completado' where id_pedido = par_id_pedido;

        return true;
end;
$$ language plpgsql;
