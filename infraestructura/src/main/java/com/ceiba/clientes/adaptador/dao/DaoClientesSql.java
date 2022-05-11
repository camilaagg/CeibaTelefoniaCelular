package com.ceiba.clientes.adaptador.dao;

import com.ceiba.clientes.modelo.dto.DtoClientes;
import com.ceiba.clientes.puerto.dao.DaoCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoClientesSql implements DaoCliente {

    private static final String NO_EXISTE_CLIENTE = "No existe el cliente en el sistema";

    private static final String CLIENTE_EXISTE_MAS_DE_UNA_VEZ = "El cliente existe mas de una vez";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "clientes", value = "consultar_cliente")
    private static String sqlConsultarCliente;

    public DaoClientesSql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public DtoClientes listarClientes(String documentNumber, String phoneNumber) {

        DtoClientes client = new DtoClientes();

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificationNumber", documentNumber);
        paramSource.addValue("phoneNumber", phoneNumber);

        List<DtoClientes> list = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlConsultarCliente, paramSource, new MapeoClientes());

        if (list.size() > 1) {

            throw new ExcepcionDuplicidad(CLIENTE_EXISTE_MAS_DE_UNA_VEZ);

        } else if (list.isEmpty()) {

            throw new ExcepcionSinDatos(NO_EXISTE_CLIENTE);

        } else {

           client =  new DtoClientes(list.get(0).getId(), list.get(0).getDocumentType(), list.get(0).getDocumentNumber(), list.get(0).getClientName(), list.get(0).getPhoneNumber(), list.get(0).getNamePlan(), list.get(0).getValuePlan(), list.get(0).getTime());


        }


        return client;


    }
}
