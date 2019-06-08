package br.edu.utfpr.alunos.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
    private Show show;
	
	public LocalEvent() {
		super();
	}
	
    public LocalEvent(Long id, Date startDate, Date endDate, String city, Show show) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.show = show;
	}
}
