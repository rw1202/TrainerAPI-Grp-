package com.qa.TrainerAPI.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.TrainerAPI.persistence.domain.Trainee;
import com.qa.TrainerAPI.persistence.domain.Trainer;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

//	Optional<Trainee> findById(Long Id);

}
