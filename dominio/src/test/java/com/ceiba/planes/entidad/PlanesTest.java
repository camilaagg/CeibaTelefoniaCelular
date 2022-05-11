package com.ceiba.planes.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.planes.modelo.entidad.Planes;
import com.ceiba.planes.servicio.testdatabuilder.PlanesTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanesTest {
    @Test
    @DisplayName("Deberia crear correctamente el plan")
    void deberiaCrearCorrectamenteElPlan() {
        // arrange
        //act
        Planes planes = new PlanesTestDataBuilder().build();
        //assert
        assertEquals(3, planes.getId());
        assertEquals("Plan gold", planes.getNamePlan());
        assertEquals("50.000", planes.getValuePlan());
        assertEquals("5 GB, 500 MINUTOS, 300 SMS", planes.getSpecificationPlan());
    }

    @Test
    void deberiaFallarSinNombreDePlan() {

        //Arrange
        PlanesTestDataBuilder planesTestDataBuilder = new PlanesTestDataBuilder().conNamePlan(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    planesTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de plan");
    }

    @Test
    void deberiaFallarSinValorDelPlan() {

        //Arrange
        PlanesTestDataBuilder planesTestDataBuilder = new PlanesTestDataBuilder().conValuePlan(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    planesTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el valor del plan");
    }

    @Test
    void deberiaFallarSinEspecificacionDePlan() {

        //Arrange
        PlanesTestDataBuilder planesTestDataBuilder = new PlanesTestDataBuilder().conSpecificationPlan(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    planesTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la especificacion del plan");
    }

}
