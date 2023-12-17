package br.com.daniel.prosaude.prosaude.model.paciente;

import br.com.daniel.prosaude.prosaude.model.endereco.Endereco;

public record DadosAtualizadoDetalhadoPaciente(
        Long id,
        String nome,
        String cpf,
        String email,
        String telefone,
        Endereco endereco
) {
    public DadosAtualizadoDetalhadoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(),
                paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco()
        );
    }

}
