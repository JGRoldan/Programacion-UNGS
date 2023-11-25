create or replace function generarSolicitudReposicion()
returns boolean as $$
declare 
    var_fila record;
    var_cantidad_reponer int;
begin 
    --Verificar si ya existe alguna solicitud de reposicion pendiente para fecha actual
    if exists (select 1 from reposicion where estado = 'pendiente' and fecha_solicitud = CURRENT_DATE) then
        return false;
    end if;

    --Recorrer todos los productos 
    for var_fila in select * from producto loop 
        --Verificar si hay que reponer stock
        if(var_fila.stock_disponible + var_fila.stock_reservado) <= var_fila.punto_reposicion then
            --Calcular cantidad a reponer
            var_cantidad_reponer = var_fila.stock_maximo - (var_fila.stock_disponible + var_fila.stock_reservado);

            --Agregar registro solicitud
            insert into reposicion(id_producto, fecha_solicitud, cantidad_a_reponer, estado) 
            values (var_fila.id_producto, current_date, var_cantidad_reponer, 'pendiente');
        end if;
    end loop;

    return true;
end;
$$ language plpgsql;