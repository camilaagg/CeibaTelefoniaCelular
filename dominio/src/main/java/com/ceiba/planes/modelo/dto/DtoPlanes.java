package com.ceiba.planes.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class DtoPlanes {

    private Long id;
    private String planName;
    private String planValue;
    private String planSpecification;
}
