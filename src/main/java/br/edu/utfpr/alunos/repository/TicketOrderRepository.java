package br.edu.utfpr.alunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.alunos.model.TicketOrder;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long>{
	@Query("select t from TicketOrder t where user.id = ?")
    List<TicketOrder> findByUserRequestsParam(Long id);
	
	@Query("select t from TicketOrder t where t.amount BETWEEN 3 AND 5")
	List<TicketOrder> findAllTicketsRequests();
	
	@Query("select t from TicketOrder t WHERE t.donationValue = (SELECT MAX(b.donationValue) from TicketOrder b)")
	List<TicketOrder> finduserGreaterOrder();
}
