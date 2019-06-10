package br.edu.utfpr.alunos.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.utfpr.alunos.model.Show;
import br.edu.utfpr.alunos.model.TicketOrder;
import br.edu.utfpr.alunos.model.User;
import lombok.Data;

@Data
public class TicketOrderDTO {
	private long id;
	
	@NotEmpty(message = "A quantidade de ingressos não pode estar vazia")
	private int amount;
	
	@NotEmpty(message = "O valor da doação não pode estar vazio")
	private double donationValue;
	
	@NotNull(message = "")
	private Show show;
	
	@NotNull(message = "")
	private User user;
	
	public TicketOrderDTO(Long id, int amount, double donationValue, User user, Show show) {
		this.id = id;
		this.amount = amount;
		this.donationValue = donationValue;
		this.user = user;
		this.show = show;
	}
	
	public TicketOrderDTO(TicketOrder ticketOrder) {
		this.id = ticketOrder.getId();
		this.amount = ticketOrder.getAmount();
		this.donationValue = ticketOrder.getDonationValue();
		this.user = ticketOrder.getUser();
		this.show = ticketOrder.getShow();
	}
}
