package com.qa.TrainerAPI.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.TrainerAPI.persistence.domain.Trainee;

@Repository
public interface TrainerRepository extends JpaRepository<Trainee, Long> {

//	Optional<Trainee> findById(Long Id);

}
