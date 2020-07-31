package com.rxsavings.pharmacy.model.dto;

import lombok.Data;

/**
 * Includes the name of the pharmacy, address and distance in the json returned.
 */
@Data
public class NearestPharmacyDTO {

    private String name;
    private AddressDTO address;
    private Double distance;
}
