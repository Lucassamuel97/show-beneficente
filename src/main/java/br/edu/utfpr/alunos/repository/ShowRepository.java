package br.edu.utfpr.alunos.repository;

import br.edu.utfpr.alunos.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
	
}
