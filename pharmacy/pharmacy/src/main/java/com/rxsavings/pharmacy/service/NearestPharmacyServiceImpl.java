package com.rxsavings.pharmacy.service;

import com.rxsavings.pharmacy.model.dto.NearestPharmacyDTO;
import com.rxsavings.pharmacy.model.entity.NearestPharmacyEntity;
import com.rxsavings.pharmacy.model.vo.CoordinatesVO;
import com.rxsavings.pharmacy.repository.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class NearestPharmacyServiceImpl implements NearestPharmacyService{

    @Autowired
    private StoresRepository storesRepository;

    @Override
    public NearestPharmacyEntity findNearestPharmacy(CoordinatesVO coordinatesVO) {

        if(coordinatesVO == null) return null;

        List<NearestPharmacyEntity> nearestPharmacyEntities = (List) storesRepository.findAll();

        Double minDist = Double.MAX_VALUE;
        NearestPharmacyEntity requiredPharmacy = null;
        for(NearestPharmacyEntity nearestPharmacyEntity : nearestPharmacyEntities){

            double distance = distance(coordinatesVO.getLatitude(), nearestPharmacyEntity.getLatitude(),
                    coordinatesVO.getLongitude(), nearestPharmacyEntity.getLongitude());

            if(distance < minDist){
                requiredPharmacy = nearestPharmacyEntity;
                minDist = distance;
            }
        }

        return requiredPharmacy;
    }

    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }
}
