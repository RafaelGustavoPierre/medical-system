package com.hospital.medicalsystem.V2.domain.repository;

import com.hospital.medicalsystem.V2.domain.model.Worker;
import com.hospital.medicalsystem.V2.domain.model.WorkerHealthInsurance;
import com.hospital.medicalsystem.V2.domain.model.WorkerHealthInsuranceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerHealthInsuranceRepository extends JpaRepository<WorkerHealthInsurance, WorkerHealthInsuranceId> {

    @Query("SELECT whi.worker FROM WorkerHealthInsurance whi WHERE whi.healthInsurance.id = :healthInsuranceId")
    List<Worker> findWorkersByHealthInsuranceId(@Param("healthInsuranceId") Long healthInsuranceId);

}