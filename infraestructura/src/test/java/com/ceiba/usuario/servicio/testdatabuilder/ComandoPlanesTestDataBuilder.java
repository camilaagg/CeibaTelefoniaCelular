package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.planes.comando.ComandoPlanes;

public class ComandoPlanesTestDataBuilder {

    private Long id;
    private String namePlan;
    private String valuePlan;
    private String specificationPlan;

    public ComandoPlanesTestDataBuilder() {
        namePlan = "Plan Bronce";
        valuePlan = "30.000";
        specificationPlan = "3 GB, 200 MINUTOS, 100 SMS";
    }

    public ComandoPlanes build() {
        return new ComandoPlanes(id,namePlan, valuePlan,specificationPlan);
    }
}
