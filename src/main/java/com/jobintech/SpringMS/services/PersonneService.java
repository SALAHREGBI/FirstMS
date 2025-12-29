package com.jobintech.SpringMS.services;

import com.jobintech.SpringMS.model.Personne;
import com.jobintech.SpringMS.repositories.PersonneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {
    private final PersonneRepository personneRepository;
    public PersonneService(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }
    public List<Personne> findAll() {
        return personneRepository.findAll();
    }
    public Personne findById(long id) {
        return personneRepository.findById((long) id).orElse(null);
    }
    public Personne create(Personne personne) {
        Personne p = new Personne(personne.getNom(), personne.getPrenom());
        return personneRepository.save(p);
    }

}
