package br.com.daniel.prosaude.prosaude.controller;

import br.com.daniel.prosaude.prosaude.model.Profissional;
import br.com.daniel.prosaude.prosaude.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profissional")
public class ProfissionalController {

    private final ProfissionalRepository profissionalRepository;

    @Autowired
    public ProfissionalController(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    @GetMapping
    public List<Profissional> getAllProfissionais() {
        return profissionalRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissional> getProfissionalById(@PathVariable(value = "id") Long profissionalId) {
        Optional<Profissional> profissional = profissionalRepository.findById(profissionalId);
        return profissional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Profissional> createProfissional(@RequestBody Profissional profissional) {
        Profissional newProfissional = profissionalRepository.save(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProfissional);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissional> updateProfissional(
            @PathVariable(value = "id") Long profissionalId,
            @RequestBody Profissional profissionalDetails) {

        Optional<Profissional> profissional = profissionalRepository.findById(profissionalId);
        if (profissional.isPresent()) {
            Profissional profissionalUpdate = profissional.get();
            profissionalUpdate.setNome(profissionalDetails.getNome());
            profissionalUpdate.setCpf(profissionalDetails.getCpf());
            profissionalUpdate.setEmail(profissionalDetails.getEmail());
            profissionalUpdate.setEspecialidade(profissionalDetails.getEspecialidade());
            profissionalRepository.save(profissionalUpdate);
            return ResponseEntity.ok(profissionalUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfissional(@PathVariable(value = "id") Long profissionalId) {
        Optional<Profissional> profissional = profissionalRepository.findById(profissionalId);
        if (profissional.isPresent()) {
            profissionalRepository.delete(profissional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}