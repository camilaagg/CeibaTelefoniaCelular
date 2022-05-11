package com.ceiba.clientes.comando.manejador;

import com.ceiba.clientes.servicio.ServicioEliminarCliente;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCliente implements ManejadorComando<Long> {

    private final ServicioEliminarCliente servicioEliminarCliente;

    public ManejadorEliminarCliente(ServicioEliminarCliente servicioEliminarCliente) {
        this.servicioEliminarCliente = servicioEliminarCliente;
    }

    public void ejecutar(Long idUsuario) {

        this.servicioEliminarCliente.ejecutar(idUsuario);
    }
}
