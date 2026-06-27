package com.example.sag_service.repository;

import com.example.sag_service.model.RegistroSAG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroSAGRepository extends JpaRepository<RegistroSAG, Long> {
}
