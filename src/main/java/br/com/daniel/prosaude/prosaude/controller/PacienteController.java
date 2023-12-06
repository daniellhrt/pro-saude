package br.com.daniel.prosaude.prosaude.controller;

import br.com.daniel.prosaude.prosaude.model.Paciente;
import br.com.daniel.prosaude.prosaude.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable(value = "id") Long pacienteId) {
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente newPaciente = pacienteRepository.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(
            @PathVariable(value = "id") Long pacienteId,
            @RequestBody Paciente pacienteDetails) {

        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        if (paciente.isPresent()) {
            Paciente pacienteUpdate = paciente.get();
            pacienteUpdate.setNome(pacienteDetails.getNome());
            pacienteUpdate.setCpf(pacienteDetails.getCpf());
            pacienteUpdate.setEmail(pacienteDetails.getEmail());
            pacienteRepository.save(pacienteUpdate);
            return ResponseEntity.ok(pacienteUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable(value = "id") Long pacienteId) {
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        if (paciente.isPresent()) {
            pacienteRepository.delete(paciente.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
