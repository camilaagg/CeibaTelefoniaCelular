package com.ceiba.clientes.servicio;

import com.ceiba.clientes.puerto.repositorio.RepositorioClientes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarClienteTest {

    @Test
    @DisplayName("Deberia eliminar el cliente llamando al repositorio")
    void deberiaEliminarElClienteLlamandoAlRepositorio() {
        RepositorioClientes repositorioClientes = Mockito.mock(RepositorioClientes.class);
        ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioClientes);

        servicioEliminarCliente.ejecutar(1l);

        Mockito.verify(repositorioClientes, Mockito.times(1)).eliminarClientes(1l);

    }
}
