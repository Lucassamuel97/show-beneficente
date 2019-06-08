package br.edu.utfpr.alunos.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "shows")
@Data
public class Show {
	@Id
    @Column(name = "id")
	private int id;
	
    @Column(name = "date")
	private Date date;
    
    @Column(name = "band")
	private String band;
    
    private Set<LocalEvent> local;
        
    public Show(int id, Date date, String band) {
    	setId(id);
    	setDate(date);
    	setBand(band);
    }
}
