package com.ceiba.clientes.puerto.repositorio;

import com.ceiba.clientes.modelo.entidad.Clientes;

public interface RepositorioClientes {

    /**
     * Permite crear clientes
     * @param cliente
     * @return el id generado
     */
    Long crearCliente(Clientes cliente);

    /**
     * Permite actualizar un cliente
     * @param cliente
     */
    void actualizarClientes(Clientes cliente);

    /**
     * Permite eliminar un cliente
     * @param id
     */
    void eliminarClientes(Long id);


    boolean existeCliente(String documentType, String phoneNumber);
}
