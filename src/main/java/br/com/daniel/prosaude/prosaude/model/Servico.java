package br.com.daniel.prosaude.prosaude.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tempoDuracao;
    private String tipo;
    private BigDecimal valor;

    @ManyToMany
    @JoinTable(
            name = "servico_profissional",
            joinColumns = @JoinColumn(name = "servico_id"),
            inverseJoinColumns = @JoinColumn(name = "profissional_id")
    )
    private Set<Profissional> profissionais = new HashSet<>();
}
