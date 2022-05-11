package com.ceiba.planes.puerto.dao;

import com.ceiba.planes.modelo.dto.DtoPlanes;

import java.util.List;

public interface DaoPlanes {

    /**
     * Permite listar los planes disponibles
     * @return los planes disponibles
     */
    List<DtoPlanes> listarPlanes(Long days);
}
