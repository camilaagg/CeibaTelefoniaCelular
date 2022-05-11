package com.ceiba.planes.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.planes.modelo.entidad.Planes;
import com.ceiba.planes.puerto.repositorio.RepositorioPlanes;
import com.ceiba.planes.servicio.testdatabuilder.PlanesTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearPlanesTest {


    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Plan")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelPlan() {
        // arrange
        Planes planes = new PlanesTestDataBuilder().build();
        RepositorioPlanes repositorioPlanes = Mockito.mock(RepositorioPlanes.class);
        Mockito.when(repositorioPlanes.existePlan(Mockito.anyString())).thenReturn(true);
        ServicioCrearPlanes servicioCrearPlanes = new ServicioCrearPlanes(repositorioPlanes);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPlanes.execute(planes), ExcepcionDuplicidad.class,"El plan ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el plan de manera correcta")
    void deberiaCrearElPlanDeManeraCorrecta() {
        // arrange
        Planes planes = new PlanesTestDataBuilder().build();
        RepositorioPlanes repositorioPlanes = Mockito.mock(RepositorioPlanes.class);
        Mockito.when(repositorioPlanes.existePlan(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioPlanes.crearPlan(planes)).thenReturn(10L);
        ServicioCrearPlanes servicioCrearPlanes = new ServicioCrearPlanes(repositorioPlanes);
        // act
        Long idPlan = servicioCrearPlanes.execute(planes);
        //- assert
        assertEquals(10L,idPlan);
        Mockito.verify(repositorioPlanes, Mockito.times(1)).crearPlan(planes);
    }
}
