package com.ceiba.planes.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.planes.modelo.entidad.Planes;
import com.ceiba.planes.puerto.repositorio.RepositorioPlanes;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPlanesSql implements RepositorioPlanes {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="planes", value="crear_plan")
    private static String sqlCrearPlan;

    @SqlStatement(namespace="planes", value="existe_plan")
    private static String sqlExistePlan;

    public RepositorioPlanesSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crearPlan(Planes planes) {
        return this.customNamedParameterJdbcTemplate.crearPlan(planes, sqlCrearPlan);
    }

    @Override
    public boolean existePlan(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("planName", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePlan,paramSource, Boolean.class);
    }

}
