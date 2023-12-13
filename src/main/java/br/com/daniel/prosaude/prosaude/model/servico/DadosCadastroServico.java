package br.com.daniel.prosaude.prosaude.model.servico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroServico(
        @NotBlank
        String descricao,
        @NotBlank
        String tempoDuracao,
        @NotBlank
        String tipo,
        @NotNull
        BigDecimal valor
) {
}
