package com.ceiba.clientes.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.clientes.modelo.entidad.Clientes;
import com.ceiba.clientes.puerto.repositorio.RepositorioClientes;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.clientes.servicio.testdatabuilder.ClientesTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarClienteTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del cliente")
    void deberiaValidarLaExistenciaPreviaDelCliente() {
        // arrange
        Clientes cliente = new ClientesTestDataBuilder().conId(1L).build();
        RepositorioClientes repositorioClientes = Mockito.mock(RepositorioClientes.class);
        Mockito.when(repositorioClientes.existeCliente(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioClientes);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class,"El usuario no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente el cliente")
    void deberiaActualizarCorrectamenteElCliente() {
        // arrange
        Clientes clientes = new ClientesTestDataBuilder().conId(1L).build();
        RepositorioClientes repositorioClientes = Mockito.mock(RepositorioClientes.class);
        Mockito.when(repositorioClientes.existeCliente(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarCliente ServicioActualizarCliente = new ServicioActualizarCliente(repositorioClientes);
        // act
        ServicioActualizarCliente.ejecutar(clientes);
        //assert
        Mockito.verify(repositorioClientes,Mockito.times(1)).actualizarClientes(clientes);
    }
}
