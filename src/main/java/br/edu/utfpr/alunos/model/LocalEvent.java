package br.edu.utfpr.alunos.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "local_event")
@Data
public class LocalEvent {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

	@Column(name = "city")
    private String city;
	
	@OneToMany
	private Set<Show> show;
	
	public LocalEvent() {
		super();
	} 
	
    public LocalEvent(Long id, Date startDate, Date endDate, String city) {
		this.id = id; 
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.show = new HashSet<Show>();
	}
    
    public void insertShow(Show show){
    	this.show.add(show);
    }
}
