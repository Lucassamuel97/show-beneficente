package br.edu.utfpr.alunos.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shows")
public class Show {
	@Id
    @Column(name = "id")
	private Long id;
	
    @Column(name = "date")
	private Date date;
    
    @Column(name = "band")
	private String band;

    @OneToMany
    private Set<TicketOrder> TicketOrders;
    
    @OneToMany
    private Set<LocalEvent> localEvents;
       
    public Show() {
    	
    }
    
    public Show(Long id, Date date, String band, Set<LocalEvent> localEvents, Set<TicketOrder> ticketOrders) {
    	setId(id);
    	setDate(date);
    	setBand(band);
    	this.localEvents = localEvents;
    	this.TicketOrders = ticketOrders;
    }
}
