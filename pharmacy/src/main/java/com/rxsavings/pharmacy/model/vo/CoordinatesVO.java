package com.rxsavings.pharmacy.model.vo;

import lombok.Data;

/**
 * Model class that has the latitude and longitude details that are
 * used while calculating the distance to the nearest pharmacy
 */
@Data
public class CoordinatesVO {

    private Double latitude;
    private Double longitude;
}
