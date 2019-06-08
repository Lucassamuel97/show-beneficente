package br.edu.utfpr.alunos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "donation_value")
    private double donationValue;
    
    @OneToMany
    private Show show;
    
    @OneToMany
    private User user;
    
	public Ticket() {
		super();
	}
	
	public Ticket(Long id, int amount, double donationValue) {
		super();
		this.id = id;
		this.amount = amount;
		this.donationValue = donationValue;
	}    
}
