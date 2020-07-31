package com.rxsavings.pharmacy.controller;

import com.rxsavings.pharmacy.model.dto.NearestPharmacyDTO;
import com.rxsavings.pharmacy.model.entity.NearestPharmacyEntity;
import com.rxsavings.pharmacy.model.vo.CoordinatesVO;
import com.rxsavings.pharmacy.service.NearestPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/pharmacy")
public class NearestPharmacyController {

    @Autowired
    private NearestPharmacyService nearestPharmacyService;

    @GetMapping("/nearest")
    public NearestPharmacyEntity getNearestPharmacy(@RequestBody CoordinatesVO coordinatesVO){

        return nearestPharmacyService.findNearestPharmacy(coordinatesVO);

    }
}
