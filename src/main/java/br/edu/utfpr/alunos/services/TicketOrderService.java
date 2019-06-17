package br.edu.utfpr.alunos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.alunos.dto.AmountOfShowTicketsDTO;
import br.edu.utfpr.alunos.model.TicketOrder;
import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.repository.TicketOrderRepository;
import br.edu.utfpr.alunos.repository.UserRepository;

@Service
public class TicketOrderService {
    @Autowired
    TicketOrderRepository ticketOrderRepository;
    @Autowired
    UserRepository userRepository;
    
    public List<TicketOrder> findByUserRequestsParam(Long id){
    	return ticketOrderRepository.findByUserRequestsParam(id);
    }
    
    public List<User> findPerShowUser(Long id){
    	return ticketOrderRepository.findPerShowUser(id);
    }

	public List<TicketOrder> findAllTicketsRequests() {
		return ticketOrderRepository.findAllTicketsRequests();
	}

	public User findUserGreaterOrder() {
		return ticketOrderRepository.finduserGreaterOrder();
	}
	
	public List<AmountOfShowTicketsDTO> findAmountOfShowTicketsDTO() {
		return ticketOrderRepository.findAmountOfShowTicketsDTO();
	}
    
}
