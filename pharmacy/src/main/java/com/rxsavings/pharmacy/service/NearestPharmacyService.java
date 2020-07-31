package com.rxsavings.pharmacy.service;

import com.rxsavings.pharmacy.model.dto.NearestPharmacyDTO;
import com.rxsavings.pharmacy.model.entity.NearestPharmacyEntity;
import com.rxsavings.pharmacy.model.vo.CoordinatesVO;

/**
 * NearestPharmacyService Interface to connect the NearestPharmacyController to the {@link CoordinatesVO}
 */
public interface NearestPharmacyService {
    /**
     * Calculates the distance between the given {@link CoordinatesVO} and each individual pharmacy coordinates
     * present in the database.
     *
     * @param coordinatesVO is the {@link CoordinatesVO} object that has the latitude and longitude coordinates
     * @returns the {@link NearestPharmacyDTO} entity that has all the closest pharmacy details
     */
    NearestPharmacyDTO findNearestPharmacy(CoordinatesVO coordinatesVO);
}
