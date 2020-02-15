package com.pdrofreitas.zeckRepresentation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZeckendorfRepresentationDto {

    private Integer originalNumber;
    private String bitRepresentation;
    private String decimalSum;

}
