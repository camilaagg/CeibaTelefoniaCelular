package com.ceiba.planes.servicio.testdatabuilder;

import com.ceiba.planes.modelo.entidad.Planes;

public class PlanesTestDataBuilder {

    private Long id;
    private String namePlan;
    private String valuePlan;
    private String specificationPlan;

    public PlanesTestDataBuilder() {

        id = 3L;
        namePlan = "Plan gold";
        valuePlan = "50.000";
        specificationPlan = "5 GB, 500 MINUTOS, 300 SMS";

    }

    public PlanesTestDataBuilder conNamePlan(String namePlan) {
        this.namePlan = namePlan;
        return this;
    }

    public PlanesTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PlanesTestDataBuilder conValuePlan(String valuePlan) {
        this.valuePlan = valuePlan;
        return this;
    }

    public PlanesTestDataBuilder conSpecificationPlan(String specificationPlan) {
        this.specificationPlan = specificationPlan;
        return this;
    }

    public Planes build() {
        return new Planes(id, namePlan, valuePlan, specificationPlan);
    }


}
