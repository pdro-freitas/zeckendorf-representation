package com.pdrofreitas.zeckRepresentation.service;

import com.pdrofreitas.zeckRepresentation.model.ZeckendorfRepresentationDto;
import com.pdrofreitas.zeckRepresentation.util.FibonacciSeqGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ZeckRepresentationServiceImpl implements ZeckRepresentationService {

    @Override
    public List<ZeckendorfRepresentationDto> getRepresentation(final int lowNum, final int highNum) {
        List<ZeckendorfRepresentationDto> representationDtoList = new ArrayList<>();

        List<Integer> fibonacciSequence = FibonacciSeqGenerator.getFibonacciSequenceReversed(highNum);

        List<Integer> integerList = IntStream.rangeClosed(lowNum, highNum).boxed().collect(Collectors.toList());
        integerList.parallelStream().forEach(t -> {

            ZeckendorfRepresentationDto representationDto = this.getZeckRepresentationDto(t, fibonacciSequence);
            representationDtoList.add(representationDto);
        });

        return representationDtoList.stream().sorted(Comparator.comparing(ZeckendorfRepresentationDto::getOriginalNumber)).collect(Collectors.toList());
    }


    private ZeckendorfRepresentationDto getZeckRepresentationDto(Integer numberToRepresent, List<Integer> fibSeq) {
        ZeckendorfRepresentationDto representationDto = ZeckendorfRepresentationDto.builder()
                .originalNumber(numberToRepresent)
                .bitRepresentation("")
                .decimalSum("")
                .build();


        if (numberToRepresent == 0 || numberToRepresent == 1) {
            representationDto.setBitRepresentation(String.valueOf(numberToRepresent));
            representationDto.setDecimalSum(String.valueOf(numberToRepresent));
        } else {
            while (numberToRepresent > 0) {

                for (Integer fibonnaciNumber : fibSeq) {
                    if (fibonnaciNumber <= numberToRepresent) {

                        representationDto.setBitRepresentation(representationDto.getBitRepresentation() + "1");
                        representationDto.setDecimalSum(
                                representationDto.getDecimalSum().isEmpty() ? representationDto.getDecimalSum() + fibonnaciNumber : representationDto.getDecimalSum() + "+" + fibonnaciNumber
                        );

                        numberToRepresent = numberToRepresent - fibonnaciNumber;
                    } else {
                        representationDto.setBitRepresentation(representationDto.getBitRepresentation() + "0");
                    }
                }

            }
        }
        return representationDto;
    }
}
