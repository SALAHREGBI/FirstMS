package com.jobintech.SpringMS.controller;

import com.jobintech.SpringMS.model.Personne;
import com.jobintech.SpringMS.repositories.PersonneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RestController
public class PersonneController {
    private PersonneRepository personneRepository;
    @GetMapping("/Personnes" )
    public List<Personne> listePersonnes() {
        return personneRepository.findAll();
    }
    @GetMapping("/Personnes/{id}")

    public Personne findPersonneById( @PathVariable Long id){
        return personneRepository.findById(id).get();
    }

    @PostMapping("/Personnes")
    public Personne savePersonne(@RequestBody Personne personne) {
        return personneRepository.save(personne);
    }
    @DeleteMapping("/Personnes/{id}")
    public void deletePersonne(@PathVariable Long id){
        personneRepository.deleteById(id);
    }
}
