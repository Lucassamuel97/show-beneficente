package br.edu.utfpr.alunos.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    
    //@ManyToMany
    //private Set<Show> show;
    
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
