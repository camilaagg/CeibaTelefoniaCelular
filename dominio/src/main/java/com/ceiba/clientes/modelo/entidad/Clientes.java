package com.ceiba.clientes.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Clientes {

    private static final String SE_DEBE_INGRESAR_EL_TIPO_DOCUMENTO= "Se debe ingresar el tipo de documento";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DOCUMENTO = "Se debe ingresar el número de documento";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_TELEFONO= "Se debe ingresar el número telefonico";
    private static final String SE_DEBE_INGRESAR_EL_ID_PLAN = "Se debe ingresar el id del plan";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_PLAN = "Se debe ingresar el valor del plan";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_INICIO = "Se debe ingresar la fecha de inicio";

    private static final int LONGITUD_NUMERO_TELEFONO= 10;

    private static final String EL_NUMERO_TELEFONO_DEBE_TENER_10_CARACTERES = "El número de telefono debe tener una longitud igual a %s";
    private Long id;
    private String documentType;
    private String documentNumber;
    private String clientName;
    private String phoneNumber;

    private String planId;
    private String planValue;
    private LocalDateTime startDate;


    public Clientes(Long id, String documentType, String documentNumber, String clientName, String phoneNumber, String planId, String planValue, LocalDateTime startDate) {
        validarObligatorio(documentType, SE_DEBE_INGRESAR_EL_TIPO_DOCUMENTO);
        validarObligatorio(documentNumber, SE_DEBE_INGRESAR_EL_NUMERO_DOCUMENTO);
        validarObligatorio(clientName, SE_DEBE_INGRESAR_EL_NOMBRE_CLIENTE);
        validarObligatorio(phoneNumber, SE_DEBE_INGRESAR_EL_NUMERO_TELEFONO);
        validarObligatorio(planId, SE_DEBE_INGRESAR_EL_ID_PLAN);
        validarObligatorio(planValue, SE_DEBE_INGRESAR_EL_VALOR_PLAN);
        validarObligatorio(startDate, SE_DEBE_INGRESAR_LA_FECHA_INICIO);
        validarLongitud(phoneNumber, LONGITUD_NUMERO_TELEFONO, String.format(EL_NUMERO_TELEFONO_DEBE_TENER_10_CARACTERES,LONGITUD_NUMERO_TELEFONO));

        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.planId = planId;
        this.planValue = planValue;
        this.startDate = startDate;
    }
}
