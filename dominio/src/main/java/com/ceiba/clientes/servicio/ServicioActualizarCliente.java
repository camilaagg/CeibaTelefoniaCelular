package com.ceiba.clientes.servicio;

import com.ceiba.clientes.modelo.entidad.Clientes;
import com.ceiba.clientes.puerto.repositorio.RepositorioClientes;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCliente {


    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";
    private final RepositorioClientes repositorioClientes;


    public ServicioActualizarCliente(RepositorioClientes repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }

    public void ejecutar(Clientes cliente) {

        validarExistenciaPrevia(cliente);
        this.repositorioClientes.actualizarClientes(cliente);
    }


    private void validarExistenciaPrevia(Clientes cliente) {
        boolean existe = this.repositorioClientes.existeCliente(cliente.getDocumentNumber(), cliente.getPhoneNumber());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
