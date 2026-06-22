package com.example.pdi_service.repository;

import com.example.pdi_service.model.Cruce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruceRepository extends JpaRepository<Cruce, Long> {

}