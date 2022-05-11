package com.ceiba.planes.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.planes.modelo.entidad.Planes;
import com.ceiba.planes.puerto.repositorio.RepositorioPlanes;

public class ServicioCrearPlanes {

    private static final String EL_NOMBRE_DEL_PLAN_YA_EXISTE_EN_EL_SISTEMA = "El plan ya existe en el sistema";

    private final RepositorioPlanes repositorioPlanes;



    public ServicioCrearPlanes(RepositorioPlanes repositorioPlanes) {
        this.repositorioPlanes = repositorioPlanes;
    }

    public Long execute(Planes planes) {
        validarExistenciaPrevia(planes);
        return this.repositorioPlanes.crearPlan(planes);
    }

    private void validarExistenciaPrevia(Planes planes) {
        boolean exist = this.repositorioPlanes.existePlan(planes.getNamePlan());
        if(exist) {
            throw new ExcepcionDuplicidad(EL_NOMBRE_DEL_PLAN_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
