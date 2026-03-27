package com.testspring_boot.testspring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testspring_boot.testspring_boot.entity.Emprunt;
import com.testspring_boot.testspring_boot.repository.EmpruntRepository;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntRepository empruntRepository;

    @GetMapping
    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable Long id) {
        return empruntRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Emprunt createEmprunt(@RequestBody Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(@PathVariable Long id, @RequestBody Emprunt empruntDetails) {
        return empruntRepository.findById(id)
                .map(emprunt -> {
                    emprunt.setUser(empruntDetails.getUser());
                    emprunt.setBook(empruntDetails.getBook());
                    emprunt.setDateEmprunt(empruntDetails.getDateEmprunt());
                    emprunt.setDateRetourPrevue(empruntDetails.getDateRetourPrevue());
                    emprunt.setDateRetourReelle(empruntDetails.getDateRetourReelle());
                    emprunt.setReturned(empruntDetails.isReturned());
                    Emprunt updated = empruntRepository.save(emprunt);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
