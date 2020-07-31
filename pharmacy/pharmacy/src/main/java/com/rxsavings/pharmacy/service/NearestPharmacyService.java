package com.rxsavings.pharmacy.service;

import com.rxsavings.pharmacy.model.dto.NearestPharmacyDTO;
import com.rxsavings.pharmacy.model.entity.NearestPharmacyEntity;
import com.rxsavings.pharmacy.model.vo.CoordinatesVO;

public interface NearestPharmacyService {

    NearestPharmacyEntity findNearestPharmacy(CoordinatesVO coordinatesVO);
}
