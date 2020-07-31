package com.rxsavings.pharmacy.service;

import com.rxsavings.pharmacy.model.dto.AddressDTO;
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

/**
 * Implementation for the {@link NearestPharmacyService}
 */
@Service
public class NearestPharmacyServiceImpl implements NearestPharmacyService{

    @Autowired
    private StoresRepository storesRepository;

    @Override
    public NearestPharmacyDTO findNearestPharmacy(CoordinatesVO coordinatesVO) {

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
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreetAddress(requiredPharmacy.getAddress());
        addressDTO.setCity(requiredPharmacy.getCity());
        addressDTO.setState(requiredPharmacy.getState());
        addressDTO.setZip(requiredPharmacy.getZip());

        NearestPharmacyDTO nearestPharmacyDTO = new NearestPharmacyDTO();

        nearestPharmacyDTO.setName(requiredPharmacy.getName());
        nearestPharmacyDTO.setAddress(addressDTO);
        nearestPharmacyDTO.setDistance(minDist);

        return nearestPharmacyDTO;
    }

    public static double distance(double latitude1,
                                  double latitude2, double longitude1,
                                  double longitude2)
    {

        /**
         * Uses an inbuilt math module named toRadians that converts from degrees to radians.
         */
        longitude1 = Math.toRadians(longitude1);
        longitude2 = Math.toRadians(longitude2);
        latitude1 = Math.toRadians(latitude1);
        latitude2 = Math.toRadians(latitude2);


        double dlongitude = longitude2 - longitude1;
        double dlatitude = latitude2 - latitude1;
        double a = Math.pow(Math.sin(dlatitude / 2), 2)
                + Math.cos(latitude1) * Math.cos(latitude2)
                * Math.pow(Math.sin(dlongitude / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        /**
         * using the radius of earth(in miles)
         */
        double r = 3956;

        return(c * r);
    }
}
