package com.ceiba.clientes.comando.manejador;

import com.ceiba.clientes.comando.ComandoClientes;
import com.ceiba.clientes.comando.fabrica.FabricaClientes;
import com.ceiba.clientes.modelo.entidad.Clientes;
import com.ceiba.clientes.servicio.ServicioActualizarCliente;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCliente implements ManejadorComando<ComandoClientes> {

    private final FabricaClientes fabricaClientes;
    private final ServicioActualizarCliente servicioActualizarCliente;

    public ManejadorActualizarCliente(FabricaClientes fabricaClientes, ServicioActualizarCliente servicioActualizarCliente) {
        this.fabricaClientes = fabricaClientes;
        this.servicioActualizarCliente = servicioActualizarCliente;
    }

    public void ejecutar(ComandoClientes comandoClientes) {
        Clientes clientes = this.fabricaClientes.crearCliente(comandoClientes);
        this.servicioActualizarCliente.ejecutar(clientes);
    }
}
