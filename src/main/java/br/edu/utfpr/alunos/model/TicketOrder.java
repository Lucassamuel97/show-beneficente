package br.edu.utfpr.alunos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_order")
public class TicketOrder {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "donation_value")
    private double donationValue;
    
    @ManyToOne
    private Show show;
    
    @ManyToOne
    private User user;
    
	public TicketOrder() {
		super();
	}
	
	public TicketOrder(Long id, int amount, double donationValue, User user, Show show) {
		super();
		this.id = id;
		this.amount = amount;
		this.donationValue = donationValue;
		this.user = user;
		this.show = show;
	}    
}
