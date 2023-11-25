create or replace function crearPedido(par_id_usuarie int, par_id_direccion int)
returns boolean as $$
declare
	--Declaracion de variables locales
    var_count_id_usuarie int;
    var_count_id_direccion_entrega int;
    var_cod_postal_tarifa_establecida int;
    var_costo_envio decimal(12,2);
begin
    --Verificar que el id usuarie exista.
    select count(*) into var_count_id_usuarie from cliente where cliente.id_usuarie = par_id_usuarie;	
    if var_count_id_usuarie = 0 then
    	--Cargar error, en caso de que no exista el id usuarie.
	   insert into error (id_usuarie, id_direccion_entrega, operacion, f_error, motivo)
	    values (par_id_usuarie, par_id_direccion, 'creación', current_timestamp, '?id de usuarie no válido');
	    return false; 
    end if;

    --Verificar que el id de la dirección de entrega exista para le cliente.
    select count(*) into var_count_id_direccion_entrega from direccion_entrega where direccion_entrega.id_usuarie = par_id_usuarie
    and direccion_entrega.id_direccion_entrega = par_id_direccion;

    if var_count_id_direccion_entrega = 0 then
	    --Cargar error, en caso de que no exista el id direccion entrega.
	   insert into error (id_usuarie, id_direccion_entrega, operacion, f_error, motivo)
	    values (par_id_usuarie, par_id_direccion, 'creación', current_timestamp, '?id de direccion no válido');
	    return false; 
    end if;

    --Verificar que el cod postal de la direccion de entrega tenga una tarifa establecida.
    select count(*) into var_cod_postal_tarifa_establecida from tarifa_entrega where codigo_postal_corto = substring((select codigo_postal from direccion_entrega where id_usuarie = par_id_usuarie AND id_direccion_entrega = par_id_direccion), 2, 4);

    if var_cod_postal_tarifa_establecida = 0 then 
        --Cargar error, en caso de que la direccion de enterga no tengo una tarifa establecida.
	   insert into error (id_usuarie, id_direccion_entrega, operacion, f_error, motivo)
	    values (par_id_usuarie, par_id_direccion, 'creación', current_timestamp, '?dirección de entrega fuera del area de atención.');
	    return false; 
    end if;

    --Se realizaron las verificaciones

    --Calculo costo de envio 
    select costo into var_costo_envio from tarifa_entrega where codigo_postal_corto = substring((select codigo_postal from direccion_entrega where id_usuarie = par_id_usuarie AND id_direccion_entrega = par_id_direccion), 2, 4);

    --Insertar fila en tabla pedido
   insert into pedido (f_pedido, id_usuarie, id_direccion_entrega, costo_envio, estado)
    values (current_timestamp, par_id_usuarie, par_id_direccion, var_costo_envio, 'ingresado');

  return true;
end;
$$ language plpgsql;
