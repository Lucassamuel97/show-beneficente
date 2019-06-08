package br.edu.utfpr.alunos.model;

import java.util.Date;
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
    	super();
    }

	public Show(Long id, Date date, String band) {
		super();
		this.id = id;
		this.date = date;
		this.band = band;
	}
 
}
