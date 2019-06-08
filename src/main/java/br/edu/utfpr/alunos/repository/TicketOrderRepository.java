package br.edu.utfpr.alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.alunos.model.TicketOrder;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long>{

}
