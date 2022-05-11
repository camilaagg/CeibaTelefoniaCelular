package com.ceiba.clientes.comando.fabrica;


import com.ceiba.clientes.comando.ComandoClientes;
import com.ceiba.clientes.modelo.entidad.Clientes;
import org.springframework.stereotype.Component;

@Component
public class FabricaClientes {

    public Clientes crearCliente(ComandoClientes comandoClientes) {

        return new Clientes(
                comandoClientes.getId(),
                comandoClientes.getDocumentType(),
                comandoClientes.getDocumentNumber(),
                comandoClientes.getClientName(),
                comandoClientes.getPhoneNumber(),
                comandoClientes.getPlanId(),
                comandoClientes.getPlanValue(),
                comandoClientes.getStartDate()
        );
    }



}
