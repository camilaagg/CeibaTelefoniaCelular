package com.ceiba.usuario.controlador;


import com.ceiba.ApplicationMock;
import com.ceiba.clientes.comando.ComandoClientes;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoClientesTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPlanesTest.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un cliente")
    void deberiaCrearUnCliente() throws Exception {
        // arrange
        ComandoClientes cliente = new ComandoClientesTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/clientes/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }


    @Test
    @DisplayName("Deberia actualizar un cliente")
    void deberiaActualizarUnCliente() throws Exception {
        // arrange
        ComandoClientes cliente = new ComandoClientesTestDataBuilder().build();
        cliente.setId(1L);
        cliente.setPlanId("1");
        cliente.setDocumentNumber("1048223150");
        cliente.setPhoneNumber("3173896424");
        // act - assert
        mocMvc.perform(put("/clientes/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia obtener cliente")
    void deberiaObtenerCliente() throws Exception {
        String documentNumber = "1048223150";
        String phoneNumber = "3173896424";
        mocMvc.perform(get("/clientes/{documentNumber}/{phoneNumber}", documentNumber, phoneNumber))


                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.documentType").value("CC"))
                .andExpect(jsonPath("$.documentNumber", is("1048223150")))
                .andExpect(jsonPath("$.clientName", is("PEPITO")))
                .andExpect(jsonPath("$.phoneNumber", is("3173896424")))
                .andExpect(jsonPath("$.namePlan", is("plan Silver")))
                .andExpect(jsonPath("$.valuePlan", is("20.000")))
                .andExpect(jsonPath("$.time", is(35)))
                .andExpect(jsonPath("$.id", is(1)));


    }

    @Test
    @DisplayName("Deberia eliminar un cliente")
    void deberiaEliminarUnCliente() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/clientes/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
