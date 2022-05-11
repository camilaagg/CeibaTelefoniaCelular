package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.planes.comando.ComandoPlanes;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoPlanesTestDataBuilder;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPlanesTest.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorPlanesTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un plan")
    void deberiaCrearUnPlan() throws Exception{
        // arrange
        ComandoPlanes plan = new ComandoPlanesTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/planes/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(plan)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }


    @Test
    @DisplayName("Deberia listar planes")
    void deberiaListarPlanes() throws Exception {
        Long id = 10L;
        mocMvc.perform(get("/planes/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].planName", is("plan Silver")))
                .andExpect(jsonPath("$[0].planValue", is("50.0")))
                .andExpect(jsonPath("$[0].planSpecification", is("5 GB, 500 MINUTOS, 100 SMS")))
                .andExpect(jsonPath("$[0].id", is(1)));

    }
}
