package br.com.daniel.prosaude.prosaude.model.Profissional;

public record DadosListagemProfissional(
        Long id,
        String nome,
        String email,
        String crm) {
    public DadosListagemProfissional(Profissional profissional) {
        this(profissional.getId(), profissional.getNome(), profissional.getEmail(), profissional.getCrm());
    }
}