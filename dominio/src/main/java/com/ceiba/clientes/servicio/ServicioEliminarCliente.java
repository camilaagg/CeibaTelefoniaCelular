package com.ceiba.clientes.servicio;

import com.ceiba.clientes.puerto.repositorio.RepositorioClientes;

public class ServicioEliminarCliente {

    private final RepositorioClientes repositorioClientes;



    public ServicioEliminarCliente(RepositorioClientes repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }

    public void ejecutar(long idCliente) {

        this.repositorioClientes.eliminarClientes(idCliente);
    }
}
