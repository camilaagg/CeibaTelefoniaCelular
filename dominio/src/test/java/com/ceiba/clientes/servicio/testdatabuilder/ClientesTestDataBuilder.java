package com.ceiba.clientes.servicio.testdatabuilder;

import com.ceiba.clientes.modelo.entidad.Clientes;

import java.time.LocalDateTime;

public class ClientesTestDataBuilder {


    private Long id;
    private String documentType;
    private String documentNumber;
    private String clientName;
    private String phoneNumber;
    private String planId;
    private String planValue;
    private LocalDateTime startDate;

    public ClientesTestDataBuilder() {

        id = 3L;
        documentType = "CC";
        documentNumber = "106548941";
        clientName = "Alejandro";
        phoneNumber = "3456218741";
        planId = "1";
        planValue = "30.000";
        startDate = LocalDateTime.now();

    }

    public ClientesTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ClientesTestDataBuilder conDocumentType(String documentType) {
        this.documentType = documentType;
        return this;
    }

    public ClientesTestDataBuilder conDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
        return this;
    }

    public ClientesTestDataBuilder conClientName( String clientName) {
        this.clientName = clientName;
        return this;
    }

    public ClientesTestDataBuilder conPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ClientesTestDataBuilder conPlanId(String planId) {
        this.planId = planId;
        return this;
    }

    public ClientesTestDataBuilder conPlanValue(String planValue) {
        this.planValue = planValue;
        return this;
    }

    public ClientesTestDataBuilder conStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public Clientes build() {
        return new Clientes(id, documentType, documentNumber, clientName, phoneNumber, planId, planValue, startDate);
    }


}
