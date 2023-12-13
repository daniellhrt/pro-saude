package br.com.daniel.prosaude.prosaude.model.Profissional;

import br.com.daniel.prosaude.prosaude.model.endereco.DadosEndereco;
import jakarta.validation.Valid;

public record DadosAtualizacaoProfissional(
        Long id,
        String nome,
        String telefone,
        @Valid
        DadosEndereco endereco
) {
}
