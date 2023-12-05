package br.com.daniel.prosaude.prosaude.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @ManyToOne
    private Profissional profissional;
}
