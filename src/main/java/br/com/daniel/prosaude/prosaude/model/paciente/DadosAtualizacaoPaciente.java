package br.com.daniel.prosaude.prosaude.model.paciente;

import br.com.daniel.prosaude.prosaude.model.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}