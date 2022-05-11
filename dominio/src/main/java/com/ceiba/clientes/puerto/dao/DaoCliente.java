package com.ceiba.clientes.puerto.dao;

import com.ceiba.clientes.modelo.dto.DtoClientes;

public interface DaoCliente {

    /**
     * Permite consultar los clientes
     * @return informacion del cliente
     */
    DtoClientes listarClientes(String documentNumber, String phoneNumber );
}
