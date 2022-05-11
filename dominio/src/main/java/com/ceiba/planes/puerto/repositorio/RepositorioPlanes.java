package com.ceiba.planes.puerto.repositorio;

import com.ceiba.planes.modelo.entidad.Planes;

public interface RepositorioPlanes {

    /**
     * Permite crear planes
     * @param planes
     * @return el id generado
     */
    Long crearPlan(Planes planes);

    boolean existePlan(String nombre);
}
