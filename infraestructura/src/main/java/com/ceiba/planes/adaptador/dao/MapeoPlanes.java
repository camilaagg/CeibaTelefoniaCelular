package com.ceiba.planes.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.planes.modelo.dto.DtoPlanes;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPlanes implements RowMapper<DtoPlanes>, MapperResult {

    @Override
    public DtoPlanes mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String planName = resultSet.getString("nombre_plan");
        String planValue = resultSet.getString("valor_plan");
        String planSpecification = resultSet.getString("especificaciones_plan");

        return new DtoPlanes(id,planName,planValue,planSpecification);
    }
}
