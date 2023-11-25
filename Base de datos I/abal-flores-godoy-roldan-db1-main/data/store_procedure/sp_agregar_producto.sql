create or replace function crearProducto(par_id_pedido int, par_id_producto int, par_cantidad int)
returns boolean as $$
declare
    --Declaracion de variables locales
    var_count_id_pedido int;
    var_estado_pedido char(10);
    var_stock_disponible int;
    var_stock_reservado int;
    var_precio_unitario decimal(12,2);
    var_monto_total_pedido decimal(12,2);
    var_count_producto_en_pedido int;
    var_count_id_producto int;
begin
    --Verificar id pedido exista
    select count(*) into var_count_id_pedido from pedido where pedido.id_pedido = par_id_pedido;

    if var_count_id_pedido = 0 then
        --Cargar error si id pedido no existe
        insert into error (id_pedido, id_producto, cantidad, operacion, f_error, motivo)
	    values (par_id_pedido, par_id_producto, par_cantidad, 'producto', current_timestamp, '?id de pedido no valido');

        return false;  
    end if;

    --Verificar pedido se encuentre en estado ingresado
    select estado into var_estado_pedido from pedido where pedido.id_pedido = par_id_pedido;

    if var_estado_pedido != 'ingresado' then
        insert into error (id_pedido, id_producto, cantidad, operacion, f_error, motivo)
	    values (par_id_pedido, par_id_producto, par_cantidad, 'producto', current_timestamp, '?pedido cerrado');
	    
        return false;  
    end if;

    --Verificar que id de producto exista
    select count(*) into var_count_id_producto from producto where producto.id_producto = par_id_producto;

    if var_count_id_producto = 0 then
        insert into error (id_pedido, id_producto, cantidad, operacion, f_error, motivo)
	    values (par_id_pedido, par_id_producto, par_cantidad, 'producto', current_timestamp,  '?id de producto no válido');
	    
        return false;  
    end if;

    --Verificar que el producto tenga stock disponible
    select stock_disponible, stock_reservado, precio_unitario into var_stock_disponible, var_stock_reservado, var_precio_unitario from producto where id_producto = par_id_producto;
    if var_stock_disponible < par_cantidad then 
        insert into error (id_pedido, id_producto, cantidad, operacion, f_error, motivo)
	    values (par_id_pedido, par_id_producto, par_cantidad, 'producto', current_timestamp,  '?stock no disponible para el producto' || par_id_producto);

        return false;  
    end if;

    --Verificar si producto ya esta en el pedido

    select count(*) into var_count_producto_en_pedido from pedido_detalle where id_producto = par_id_producto and id_pedido = par_id_pedido;

    if var_count_producto_en_pedido = 0 then 
        --Si no existe, lo inserto
        insert into pedido_detalle(id_pedido, id_producto, cantidad, precio_unitario)
        values (par_id_pedido, par_id_producto, par_cantidad, var_precio_unitario);
    else 
        --Sino actualizar la cantidad
        update pedido_detalle set cantidad = (cantidad + par_cantidad) where id_producto = par_id_producto and id_pedido = par_id_pedido;
    end if;

    --Actualizar stocks producto segun pedido
    update producto
     set 
        stock_reservado = var_stock_reservado + par_cantidad,
        stock_disponible = var_stock_disponible - par_cantidad
    where id_producto = par_id_producto;

    --Calcular monto total
    select precio_unitario * cantidad into var_monto_total_pedido from pedido_detalle where id_pedido = par_id_pedido;

    --Actualizar monto total del pedido
    update pedido
     set 
        monto_total = var_monto_total_pedido
    where id_pedido = par_id_pedido;

    
    return true;
end;
$$ language plpgsql;