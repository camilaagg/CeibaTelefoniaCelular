package com.ceiba.clientes.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.clientes.comando.ComandoClientes;
import com.ceiba.clientes.comando.manejador.ManejadorActualizarCliente;
import com.ceiba.clientes.comando.manejador.ManejadorConsultarCliente;
import com.ceiba.clientes.comando.manejador.ManejadorCrearCliente;
import com.ceiba.clientes.comando.manejador.ManejadorEliminarCliente;
import com.ceiba.clientes.modelo.dto.DtoClientes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador comando clientes"})
public class ComandoControladorClientes {

    private final ManejadorConsultarCliente consulterClient;

    private final ManejadorCrearCliente createClient;

    private final ManejadorActualizarCliente updateCliente;

    private final ManejadorEliminarCliente eliminateClient;

    public ComandoControladorClientes(ManejadorConsultarCliente consulterClient, ManejadorCrearCliente createClient, ManejadorActualizarCliente updateCliente, ManejadorEliminarCliente eliminateClient) {
        this.consulterClient = consulterClient;
        this.createClient = createClient;
        this.updateCliente = updateCliente;
        this.eliminateClient = eliminateClient;
    }

    @GetMapping(value= "/{documentNumber}/{phoneNumber}")
    @ApiOperation("Obtener cliente")
    public DtoClientes obtenerCliente(@PathVariable String documentNumber, @PathVariable String phoneNumber) {
        return this.consulterClient.ejecutar(documentNumber, phoneNumber);
    }

    @PostMapping(value = "/create")
    @ApiOperation("Crear Clientes")
    public ComandoRespuesta<Long> crearClientes(@RequestBody ComandoClientes comandoClientes) {

        return createClient.ejecutar(comandoClientes);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminarCliente(@PathVariable Long id) {

        eliminateClient.ejecutar(id);


    }

    @PutMapping(value="/update")
    @ApiOperation("Actualizar Usuario")
    public void actualizarCliente(@RequestBody ComandoClientes comandoClientes) {

        updateCliente.ejecutar(comandoClientes);

    }
}
