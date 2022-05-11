package com.ceiba.clientes.comando;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComandoClientes {

    private Long id;
    private String documentType;
    private String documentNumber;
    private String clientName;
    private String phoneNumber;
    private String planId;
    private String planValue;
    private LocalDateTime startDate;
}
