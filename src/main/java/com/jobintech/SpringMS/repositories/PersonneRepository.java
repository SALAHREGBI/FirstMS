package com.jobintech.SpringMS.repositories;

import com.jobintech.SpringMS.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
