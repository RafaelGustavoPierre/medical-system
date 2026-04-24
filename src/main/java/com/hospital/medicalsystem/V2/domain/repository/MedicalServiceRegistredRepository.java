package com.hospital.medicalsystem.V2.domain.repository;

import com.hospital.medicalsystem.V2.domain.model.MedicalServiceRegistered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalServiceRegistredRepository extends JpaRepository<MedicalServiceRegistered, Long> {
}
