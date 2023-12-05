package br.com.daniel.prosaude.prosaude.repository;

import br.com.daniel.prosaude.prosaude.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
