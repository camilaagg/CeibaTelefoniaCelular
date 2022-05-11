package com.ceiba.clientes.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.clientes.modelo.entidad.Clientes;
import com.ceiba.clientes.puerto.repositorio.RepositorioClientes;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.clientes.servicio.testdatabuilder.ClientesTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearClienteTest {


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la longitud del numero de telefono")
    void deberiaLanzarUnaExepcionCuandoSeValideLaLongitudDelNumeroDeTelefono() {
        // arrange
        // arrange
        ClientesTestDataBuilder clientesTestDataBuilder = new ClientesTestDataBuilder().conPhoneNumber("124498751245");
        // act - assert
        BasePrueba.assertThrows(clientesTestDataBuilder::build, ExcepcionLongitudValor.class, "El número de telefono debe tener una longitud igual a 10");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Cliente")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelCliente() {
        // arrange
        Clientes cliente = new ClientesTestDataBuilder().build();
        RepositorioClientes repositorioClientes = Mockito.mock(RepositorioClientes.class);
        Mockito.when(repositorioClientes.existeCliente(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioClientes);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }



    @Test
    @DisplayName("Deberia Crear el cliente de manera correcta")
    void deberiaCrearElClienteDeManeraCorrecta() {
        // arrange
        Clientes cliente = new ClientesTestDataBuilder().build();
        RepositorioClientes repositorioClientes = Mockito.mock(RepositorioClientes.class);
        Mockito.when(repositorioClientes.existeCliente(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioClientes.crearCliente(cliente)).thenReturn(10L);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioClientes);
        // act
        Long id = servicioCrearCliente.ejecutar(cliente);
        //- assert
        assertEquals(10L,id);
        Mockito.verify(repositorioClientes, Mockito.times(1)).crearCliente(cliente);
    }
}
