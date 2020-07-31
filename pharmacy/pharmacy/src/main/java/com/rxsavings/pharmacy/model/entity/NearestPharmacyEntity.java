package com.rxsavings.pharmacy.model.entity;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "pharmacies")
public class NearestPharmacyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
}
