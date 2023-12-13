package br.com.daniel.prosaude.prosaude.controller;

import br.com.daniel.prosaude.prosaude.model.servico.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoController(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }


}
