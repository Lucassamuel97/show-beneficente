package br.edu.utfpr.alunos.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;
    
    @OneToMany
    Set<TicketOrder> ticketOrders;
    
    public User() {
        super();
    }
    
	public User(Long id, String name, int age, Set<TicketOrder> ticketsOrders) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.ticketOrders = ticketsOrders;
	}
}
