package com.ceiba.planes.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.planes.comando.fabrica.FabricaPlanes;
import com.ceiba.planes.modelo.entidad.Planes;
import com.ceiba.planes.servicio.ServicioCrearPlanes;
import com.ceiba.planes.comando.ComandoPlanes;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPlanes implements ManejadorComandoRespuesta<ComandoPlanes, ComandoRespuesta<Long>> {


    private final FabricaPlanes fabricaPlanes;
    private final ServicioCrearPlanes servicioCrearPlanes;

    public ManejadorCrearPlanes(FabricaPlanes fabricaPlanes, ServicioCrearPlanes servicioCrearPlanes) {
        this.fabricaPlanes = fabricaPlanes;
        this.servicioCrearPlanes = servicioCrearPlanes;
    }


    public ComandoRespuesta<Long> ejecutar(ComandoPlanes comandoPlanes) {

        Planes planes = this.fabricaPlanes.crearPlanes(comandoPlanes);
        return new ComandoRespuesta<>(this.servicioCrearPlanes.execute(planes));


    }
}
