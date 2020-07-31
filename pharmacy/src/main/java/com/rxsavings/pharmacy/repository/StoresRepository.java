package com.rxsavings.pharmacy.repository;

import com.rxsavings.pharmacy.model.entity.NearestPharmacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoresRepository extends CrudRepository<NearestPharmacyEntity, Integer> {
}
