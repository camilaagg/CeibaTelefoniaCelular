package com.ceiba.clientes.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.clientes.comando.ComandoClientes;
import com.ceiba.clientes.comando.fabrica.FabricaClientes;
import com.ceiba.clientes.modelo.entidad.Clientes;
import com.ceiba.clientes.servicio.ServicioCrearCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoClientes, ComandoRespuesta<Long>> {


    private final FabricaClientes fabricaClientes;
    private final ServicioCrearCliente servicioCrearCliente;


    public ManejadorCrearCliente( FabricaClientes fabricaClientes, ServicioCrearCliente servicioCrearCliente) {
        this.fabricaClientes = fabricaClientes;
        this.servicioCrearCliente = servicioCrearCliente;
    }


    public ComandoRespuesta<Long> ejecutar(ComandoClientes comandoClientes) {

        Clientes cliente = this.fabricaClientes.crearCliente(comandoClientes);
        return new ComandoRespuesta<>(this.servicioCrearCliente.ejecutar(cliente));


    }


}
