package br.com.daniel.prosaude.prosaude.controller;

import br.com.daniel.prosaude.prosaude.model.Profissional.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    private final ProfissionalRepository repository;

    @Autowired
    public ProfissionalController(ProfissionalRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProfissional dados,
                                    UriComponentsBuilder uriBuilder) {
        var profissional = new Profissional(dados);
        repository.save(profissional);
        var uri = uriBuilder.path("/profissionais/{id}").buildAndExpand(profissional.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosAtualizadoDetalhadoProfissional(profissional));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProfissional>> listar(@PageableDefault(
            size = 10, sort = {"nome"}) Pageable paginacao) {

        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfissional::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProfissional dados) {
        var profissional = repository.getReferenceById(dados.id());
        profissional.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosAtualizadoDetalhadoProfissional(profissional));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.inativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosAtualizadoDetalhadoProfissional(medico));
    }
}