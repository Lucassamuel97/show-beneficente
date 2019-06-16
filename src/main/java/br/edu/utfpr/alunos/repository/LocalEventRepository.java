package br.edu.utfpr.alunos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.utfpr.alunos.model.LocalEvent;

public interface LocalEventRepository extends JpaRepository<LocalEvent, Long>{
    @Query("select l from LocalEvent l where l.city like %:name")
    Page<LocalEvent> findAllEventGuarapuava(@Param("name") String city, PageRequest pageRequest);
}
