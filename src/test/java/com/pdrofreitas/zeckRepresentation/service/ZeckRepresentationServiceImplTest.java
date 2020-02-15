package com.pdrofreitas.zeckRepresentation.service;

import com.pdrofreitas.zeckRepresentation.model.ZeckendorfRepresentationDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ZeckRepresentationServiceImplTest {

    @InjectMocks
    ZeckRepresentationService zeckRepresentationService = new ZeckRepresentationServiceImpl();


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void generateZeckRepresentationTest1() {

        ZeckendorfRepresentationDto dto5 = ZeckendorfRepresentationDto.builder().originalNumber(5).decimalSum("5").bitRepresentation("01000").build();
        ZeckendorfRepresentationDto dto6 = ZeckendorfRepresentationDto.builder().originalNumber(6).decimalSum("5+1").bitRepresentation("01001").build();
        ZeckendorfRepresentationDto dto7 = ZeckendorfRepresentationDto.builder().originalNumber(7).decimalSum("5+2").bitRepresentation("01010").build();
        ZeckendorfRepresentationDto dto8 = ZeckendorfRepresentationDto.builder().originalNumber(8).decimalSum("8").bitRepresentation("10000").build();
        ZeckendorfRepresentationDto dto9 = ZeckendorfRepresentationDto.builder().originalNumber(9).decimalSum("8+1").bitRepresentation("10001").build();
        ZeckendorfRepresentationDto dto10 = ZeckendorfRepresentationDto.builder().originalNumber(10).decimalSum("8+2").bitRepresentation("10010").build();
        List<ZeckendorfRepresentationDto> testSetDtos = new ArrayList<ZeckendorfRepresentationDto>() {{
            add(dto5);
            add(dto6);
            add(dto7);
            add(dto8);
            add(dto9);
            add(dto10);
        }};

        List<ZeckendorfRepresentationDto> representation = zeckRepresentationService.getRepresentation(5, 10);

        Assert.assertEquals("Representations dont match", representation, testSetDtos);

    }
}