package com.jobintech.SpringMS.exception;

public class PersonneNotFoundException extends RuntimeException {
    public PersonneNotFoundException(Long id) {
        super("Personne " + id + " n'existe pas");
    }
}
