package com.ceiba.configuracion;

import com.ceiba.clientes.puerto.repositorio.RepositorioClientes;
import com.ceiba.clientes.servicio.ServicioActualizarCliente;
import com.ceiba.clientes.servicio.ServicioCrearCliente;
import com.ceiba.clientes.servicio.ServicioEliminarCliente;
import com.ceiba.planes.puerto.repositorio.RepositorioPlanes;
import com.ceiba.planes.servicio.ServicioCrearPlanes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {



    @Bean
    public ServicioCrearPlanes servicioCrearPlan(RepositorioPlanes repositorioPlanes) {
        return new ServicioCrearPlanes(repositorioPlanes);
    }

    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioClientes repositorioClientes) {
        return new ServicioCrearCliente(repositorioClientes);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioClientes repositorioClientes) {
        return new ServicioActualizarCliente(repositorioClientes);
    }
    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioClientes repositorioClientes) {
        return new ServicioEliminarCliente(repositorioClientes);
    }
	

}
