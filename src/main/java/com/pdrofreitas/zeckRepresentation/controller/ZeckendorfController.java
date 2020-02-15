package com.pdrofreitas.zeckRepresentation.controller;

import com.pdrofreitas.zeckRepresentation.service.ZeckRepresentationService;
import com.pdrofreitas.zeckRepresentation.util.ServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ServiceConstants.API.ZECKENDORF_URL})
public class ZeckendorfController {

    @Autowired
    private ZeckRepresentationService zeckRepresentationService;

    @GetMapping({ServiceConstants.ENDPOINTS.GET_REPRESENTATION})
    public ResponseEntity calculate(@RequestParam(name = ServiceConstants.PARAMS.LOW_NUM_PARAM) final Integer lowNum,
                                    @RequestParam(name = ServiceConstants.PARAMS.HIGH_NUM_PARAM) final Integer highNum) {

        return ResponseEntity.ok(zeckRepresentationService.getRepresentation(lowNum, highNum));
    }
}
