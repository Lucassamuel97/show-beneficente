package br.edu.utfpr.alunos.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.alunos.model.LocalEvent;

public interface LocalEventRepository extends JpaRepository<LocalEvent, Long>{
	
	@Transactional(readOnly = true)
	Page<LocalEvent> findByCity(String string, PageRequest pageRequest);
}
