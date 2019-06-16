package br.edu.utfpr.alunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.utfpr.alunos.dto.AmountOfShowTicketsDTO;
import br.edu.utfpr.alunos.model.TicketOrder;
import br.edu.utfpr.alunos.model.User;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long>{
	@Query("select t from TicketOrder t where user.id = ?")
    List<TicketOrder> findByUserRequestsParam(Long id);
	
	@Query("select t from TicketOrder t where t.amount BETWEEN 3 AND 5")
	List<TicketOrder> findAllTicketsRequests();
	
	@Query("select t.user from TicketOrder t WHERE t.donationValue = (SELECT MAX(b.donationValue) from TicketOrder b)")
	User finduserGreaterOrder();
	
	@Query("select t.user from TicketOrder t where t.show.id = ?")
    List<User> findPerShowUser(Long id);
	
	@Query("select COUNT(*) as quant, t.show FROM ticket_order GROUP BY t.show")
	List<AmountOfShowTicketsDTO> findAmountOfShowTicketsDTO();
}
