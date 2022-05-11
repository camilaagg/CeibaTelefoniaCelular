package com.ceiba.planes.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Planes {

    private static final String SE_DEBE_INGRESAR_EL_VALOR_DEL_PLAN= "Se debe ingresar el valor del plan";
    private static final String SE_DEBE_INGRESAR_LA_ESPECIFICACION_DEL_PLAN = "Se debe ingresar la especificacion del plan";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PLAN = "Se debe ingresar el nombre de plan";

    private Long id;
    private String namePlan;
    private String valuePlan;
    private String specificationPlan;


    public Planes(Long id, String namePlan, String valuePlan, String specificationPlan) {

        validarObligatorio(namePlan, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PLAN);
        validarObligatorio(valuePlan, SE_DEBE_INGRESAR_EL_VALOR_DEL_PLAN);
        validarObligatorio(specificationPlan, SE_DEBE_INGRESAR_LA_ESPECIFICACION_DEL_PLAN);
        this.id = id;
        this.namePlan = namePlan;
        this.valuePlan = valuePlan;
        this.specificationPlan = specificationPlan;
    }
}
