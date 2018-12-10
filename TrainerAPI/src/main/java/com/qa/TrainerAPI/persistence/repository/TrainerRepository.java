package com.qa.TrainerAPI.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.qa.TrainerAPI.persistence.domain.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {



}
