package com.ceiba.clientes.adaptador.repositorio;

import com.ceiba.clientes.modelo.entidad.Clientes;
import com.ceiba.clientes.puerto.repositorio.RepositorioClientes;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClientesSql implements RepositorioClientes {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;



    @SqlStatement(namespace="clientes", value="crear_cliente")
    private static String sqlCrearCliente;

    @SqlStatement(namespace="clientes", value="existe_cliente")
    private static String sqlExisteCliente;

    @SqlStatement(namespace="clientes", value="actualizar_cliente")
    private static String sqlActualizarCliente;

    @SqlStatement(namespace="clientes", value="eliminar_cliente")
    private static String sqlEliminarCliente;


    public RepositorioClientesSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crearCliente(Clientes client) {
        return this.customNamedParameterJdbcTemplate.crearCliente(client, sqlCrearCliente);
    }

    @Override
    public void actualizarClientes(Clientes client) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", client.getId());
        paramSource.addValue("planId", client.getPlanId());
        paramSource.addValue("planValue", client.getPlanValue());

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarCliente, paramSource);

    }

    @Override
    public void eliminarClientes(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarCliente, paramSource);

    }

    @Override
    public boolean existeCliente(String documentNumber, String phoneNumber) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("documentNumber", documentNumber);
        paramSource.addValue("phoneNumber", phoneNumber);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCliente,paramSource, Boolean.class);
    }


}
