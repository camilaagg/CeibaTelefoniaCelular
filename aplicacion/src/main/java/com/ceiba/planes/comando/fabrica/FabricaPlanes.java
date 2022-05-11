package com.ceiba.planes.comando.fabrica;

import com.ceiba.planes.modelo.entidad.Planes;
import com.ceiba.planes.comando.ComandoPlanes;
import org.springframework.stereotype.Component;

@Component
public class FabricaPlanes {

    public Planes crearPlanes(ComandoPlanes comandoPlanes) {
        return new Planes(
                comandoPlanes.getId(),
                comandoPlanes.getNamePlan(),
                comandoPlanes.getValuePlan(),
                comandoPlanes.getSpecificationPlan()
        );
    }

}
