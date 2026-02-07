package com.jobintech.SpringMS.controller;

import com.jobintech.SpringMS.model.Personne;
import com.jobintech.SpringMS.services.PersonneService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Personnes")
@AllArgsConstructor
@Slf4j
public class PersonneController {

    private final PersonneService personneService;

    @GetMapping
    public List<Personne> listePersonnes() {
        return personneService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> findPersonneById(@PathVariable Long id) {
        Personne personne = personneService.findById(id);
        return ResponseEntity.ok(personne);
    }

    @PostMapping
    public ResponseEntity<Personne> savePersonne(@RequestBody Personne personne) {
        Personne savedPersonne = personneService.create(personne);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/ws/Personnes/" + savedPersonne.getId());
        return new ResponseEntity<>(savedPersonne, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonne(@PathVariable Long id) {
        personneService.delete(id);
    }
}