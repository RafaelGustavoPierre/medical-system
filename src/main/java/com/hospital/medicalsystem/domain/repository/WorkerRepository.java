package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
