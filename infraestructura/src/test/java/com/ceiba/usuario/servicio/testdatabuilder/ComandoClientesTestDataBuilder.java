package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.clientes.comando.ComandoClientes;

import java.time.LocalDateTime;

public class ComandoClientesTestDataBuilder {

    private Long id;
    private String documentType;
    private String documentNumber;
    private String clientName;
    private String phoneNumber;
    private String planId;
    private String planValue;
    private LocalDateTime startDate;


    public ComandoClientesTestDataBuilder() {
        documentType = "CC";
        documentNumber = "1075295150";
        clientName = "Camila";
        phoneNumber = "3159846258";
        planId = "1";
        planValue = "30.000";
        startDate = LocalDateTime.now();

    }

    public ComandoClientes build() {
        return new ComandoClientes(id, documentType, documentNumber, clientName, phoneNumber, planId, planValue, startDate);
    }
}
