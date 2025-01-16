package com.hospital.medicalsystem.domain.repository;

import com.hospital.medicalsystem.domain.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query("FROM Worker w WHERE w.occupation.id = 1 ORDER BY RAND() LIMIT 1")
    Worker findRandomDoctors();

}
