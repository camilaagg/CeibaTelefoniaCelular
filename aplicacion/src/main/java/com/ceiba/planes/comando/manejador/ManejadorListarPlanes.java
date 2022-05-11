package com.ceiba.planes.comando.manejador;


import com.ceiba.planes.modelo.dto.DtoPlanes;
import com.ceiba.planes.puerto.dao.DaoPlanes;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPlanes {

    private final DaoPlanes daoPlanes;

    public ManejadorListarPlanes(DaoPlanes daoPlanes){
        this.daoPlanes = daoPlanes;
    }

    public List<DtoPlanes> ejecutar(Long days){

        return this.daoPlanes.listarPlanes( days);
    }
}
