package br.edu.utfpr.alunos.repository;



import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.alunos.model.LocalEvent;

public interface LocalEventRepository extends JpaRepository<LocalEvent, Long>{
	
	@Transactional(readOnly = true)	
	<S extends LocalEvent> List<S> findAll(Example<S> example);
}
