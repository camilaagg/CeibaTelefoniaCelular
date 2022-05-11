package com.ceiba.clientes.comando.manejador;

import com.ceiba.clientes.modelo.dto.DtoClientes;
import com.ceiba.clientes.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarCliente {

    private final DaoCliente daoCliente;


    public ManejadorConsultarCliente( DaoCliente daoCliente){
        this.daoCliente = daoCliente;
    }



    public DtoClientes ejecutar(String documentType, String phoneNumber ) {
        return this.daoCliente.listarClientes(documentType, phoneNumber);
    }



}
