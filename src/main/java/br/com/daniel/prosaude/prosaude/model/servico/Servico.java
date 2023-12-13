package br.com.daniel.prosaude.prosaude.model.servico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "servicos")
@Entity(name = "Servico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String tempoDuracao;
    private String tipo;
    private BigDecimal valor;

    public Servico(DadosCadastroServico dados) {

        this.descricao = dados.descricao();
        this.tempoDuracao = dados.tempoDuracao();
        this.tipo = dados.tipo();
        this.valor = dados.valor();
    }

}
