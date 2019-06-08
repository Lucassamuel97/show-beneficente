package br.edu.utfpr.alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.alunos.model.LocalEvent;

public interface LocalEventRepository extends JpaRepository<LocalEvent, Long>{

}
