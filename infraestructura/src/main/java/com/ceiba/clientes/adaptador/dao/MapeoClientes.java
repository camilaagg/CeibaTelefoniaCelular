package com.ceiba.clientes.adaptador.dao;

import com.ceiba.clientes.modelo.dto.DtoClientes;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoClientes implements RowMapper<DtoClientes>, MapperResult {

    @Override
    public DtoClientes mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String documentType = resultSet.getString("tipo_identificacion");
        String documentNumber = resultSet.getString("numero_identificacion");
        String nameClient = resultSet.getString("nombre_cliente");
        String phoneNumber = resultSet.getString("numero_telefono");
        String namePlan = resultSet.getString("nombre_plan");
        String valuePlan = resultSet.getString("valor_plan");


        Long time = diffDays(resultSet, "fecha_inicio");

        return new DtoClientes(id,documentType,documentNumber,nameClient, phoneNumber,namePlan,valuePlan, time );
    }

}
