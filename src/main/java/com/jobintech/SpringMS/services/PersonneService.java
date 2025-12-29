package com.jobintech.SpringMS.services;

import com.jobintech.SpringMS.exception.PersonneNotFoundException;
import com.jobintech.SpringMS.model.Personne;
import com.jobintech.SpringMS.repositories.PersonneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonneService {

    private final PersonneRepository personneRepository;

    public List<Personne> findAll() {
        log.info("Récupération de la liste des personnes");
        return personneRepository.findAll();
    }
    public Personne findById(Long id) {
        log.debug("Recherche de la personne avec ID: {}", id);
        return personneRepository.findById(id).orElseThrow(() -> new PersonneNotFoundException(id));
    }
    public Personne create(Personne personne) {
        log.info("Création d'une nouvelle personne: {} {}", personne.getNom(), personne.getPrenom());
        return personneRepository.save(personne);
    }

    public void delete(Long id) {
        log.warn("Suppression de la personne avec ID: {}", id);
        personneRepository.deleteById(id);
    }
}