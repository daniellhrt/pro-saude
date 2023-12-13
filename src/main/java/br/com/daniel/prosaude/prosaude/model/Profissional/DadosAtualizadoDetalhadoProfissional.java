package br.com.daniel.prosaude.prosaude.model.Profissional;

import br.com.daniel.prosaude.prosaude.model.endereco.Endereco;

public record DadosAtualizadoDetalhadoProfissional(
        Long id,
        String nome,
        String telefone,
        String email,
        String crm,
        String especialidade,
        Endereco endereco) {

    public DadosAtualizadoDetalhadoProfissional(Profissional profissional) {
        this(profissional.getId(), profissional.getNome(), profissional.getTelefone(), profissional.getEmail(),
                profissional.getCrm(), profissional.getEspecialidade(), profissional.getEndereco());


    }
}
