package com.pdrofreitas.zeckRepresentation.service;

import com.pdrofreitas.zeckRepresentation.model.ZeckendorfRepresentationDto;

import java.util.List;

public interface ZeckRepresentationService {

    List<ZeckendorfRepresentationDto> getRepresentation(int lowNum, int highNum);
}
