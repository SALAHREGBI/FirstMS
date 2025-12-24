package com.jobintech.SpringMS.controller;

import com.jobintech.SpringMS.model.Personne;
import com.jobintech.SpringMS.repositories.PersonneRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Personne> findPersonneById( @PathVariable Long id){
        Optional<Personne> personne = personneRepository.findById(id);
        if (personne.isPresent()) {
            return new ResponseEntity<>(personneRepository.findById(id).get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping("/Personnes")
    public ResponseEntity<Personne> savePersonne(@RequestBody Personne personne) {
        Personne savedPersonne = personneRepository.save(personne);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/Personnes/" + savedPersonne.getId());
        return new ResponseEntity<>(savedPersonne, headers, HttpStatus.CREATED);
    }


    @DeleteMapping("/Personnes/{id}")
    public void deletePersonne(@PathVariable Long id){
        personneRepository.deleteById(id);
    }
}

