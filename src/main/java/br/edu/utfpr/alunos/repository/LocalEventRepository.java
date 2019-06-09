package br.edu.utfpr.alunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.alunos.model.LocalEvent;

public interface LocalEventRepository extends JpaRepository<LocalEvent, Long>{
    @Query("select l from LocalEvent l where l.city = ?")
    List<LocalEvent> findAllEventGuarapuava(String name);
}
