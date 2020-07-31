package com.rxsavings.pharmacy.model.dto;

import lombok.Data;

/**
 * Includes the sub components of the Address in the API response.
 */
@Data
public class AddressDTO {

    private String streetAddress;
    private String city;
    private String state;
    private String zip;
}
