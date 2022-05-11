package com.ceiba.clientes.servicio;

import com.ceiba.clientes.modelo.entidad.Clientes;
import com.ceiba.clientes.puerto.repositorio.RepositorioClientes;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCliente {

    private static final String EL_USUARIO_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    private final RepositorioClientes repositorioClientes;

    public ServicioCrearCliente(RepositorioClientes repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }

    public Long ejecutar(Clientes cliente) {
        validarExistenciaPrevia(cliente);
        return this.repositorioClientes.crearCliente(cliente);
    }

    private void validarExistenciaPrevia(Clientes cliente) {
        boolean existe = this.repositorioClientes.existeCliente(cliente.getDocumentNumber(), cliente.getPhoneNumber());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
