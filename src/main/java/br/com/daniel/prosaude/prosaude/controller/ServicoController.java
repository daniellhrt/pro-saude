package br.com.daniel.prosaude.prosaude.controller;

import br.com.daniel.prosaude.prosaude.model.Servico;
import br.com.daniel.prosaude.prosaude.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoController(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable(value = "id") Long servicoId) {
        Optional<Servico> servico = servicoRepository.findById(servicoId);
        return servico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Servico> createServico(@RequestBody Servico servico) {
        Servico newServico = servicoRepository.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(newServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(
            @PathVariable(value = "id") Long servicoId,
            @RequestBody Servico servicoDetails) {

        Optional<Servico> servico = servicoRepository.findById(servicoId);

        if (servico.isPresent()) {
            Servico servicoUpdate = servico.get();

            servicoUpdate.setTipo(servicoDetails.getTipo());
            servicoUpdate.setTempoDuracao(servicoDetails.getTempoDuracao());
            servicoUpdate.setValor(servicoDetails.getValor());
            servicoUpdate.getProfissionais().clear();

            if (servicoDetails.getProfissionais() !=null){
                servicoUpdate.getProfissionais().addAll(servicoDetails.getProfissionais());
            }

            servicoRepository.save(servicoUpdate);
            return ResponseEntity.ok(servicoUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Servico> deleteServico(@PathVariable(value = "id") Long servicoId) {
        Optional<Servico> servico = servicoRepository.findById(servicoId);
        if (servico.isPresent()) {
            servicoRepository.delete(servico.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
