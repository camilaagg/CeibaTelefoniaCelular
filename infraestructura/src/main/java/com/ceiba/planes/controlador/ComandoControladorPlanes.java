package com.ceiba.planes.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.planes.comando.manejador.ManejadorCrearPlanes;
import com.ceiba.planes.comando.manejador.ManejadorListarPlanes;
import com.ceiba.planes.comando.ComandoPlanes;
import com.ceiba.planes.modelo.dto.DtoPlanes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planes")
@Api(tags = { "Controlador comando planes"})
public class ComandoControladorPlanes {

    private final ManejadorListarPlanes manejadorListarPlanes;

    private final ManejadorCrearPlanes manejadorCrearPlanes;

    public ComandoControladorPlanes(ManejadorListarPlanes manejadorListarPlanes, ManejadorCrearPlanes manejadorCrearPlanes) {
        this.manejadorListarPlanes = manejadorListarPlanes;
        this.manejadorCrearPlanes = manejadorCrearPlanes;
    }


    @GetMapping(value = "{days}")
    @ApiOperation("Listar Planes")
    public List<DtoPlanes> listarPlanes(@PathVariable Long days) {

        return this.manejadorListarPlanes.ejecutar(days);
    }

    @PostMapping(value = "/create")
    @ApiOperation("Crear Planes")
    public ComandoRespuesta<Long> crearPlanes(@RequestBody ComandoPlanes comandoPlanes) {

        return manejadorCrearPlanes.ejecutar(comandoPlanes);
    }

}
