package br.edu.utfpr.alunos.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "local_event")
@Data
public class LocalEvent {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "data_inicio")
    private Date startDate;

    @Column(name = "data_evento")
    private Date endDate;

	@Column(name = "cidade")
    private String city;
	
	public LocalEvent() {
		super();
	}
	
    public LocalEvent(Long id, Date startDate, Date endDate, String city) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
	}
}
