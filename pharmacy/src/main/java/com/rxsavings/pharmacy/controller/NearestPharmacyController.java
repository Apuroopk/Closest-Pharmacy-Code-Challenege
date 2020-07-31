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

/**
 * Handles the HTTP requests made for calculating the distance to the nearest Pharmacy using {@link CoordinatesVO}
 * module and maps these requests to the appropriate methods in {@link NearestPharmacyService}
 */
@RestController
@RequestMapping(value = "/api/v1/pharmacy")
public class NearestPharmacyController {

    @Autowired
    private NearestPharmacyService nearestPharmacyService;

    /**
     * Handles the get request for calculating the distance to the nearest pharmacy.
     * @param coordinatesVO is the {@link CoordinatesVO} object that contains the latitude and longitude coordinates
     * @returns the {@link NearestPharmacyDTO} entity that has the pharmacy details
     */
    @GetMapping("/nearest")
    public NearestPharmacyDTO getNearestPharmacy(@RequestBody CoordinatesVO coordinatesVO){

        return nearestPharmacyService.findNearestPharmacy(coordinatesVO);

    }
}
