package br.edu.utfpr.alunos.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import br.edu.utfpr.alunos.model.Show;

@Data
public class ShowDTO {
	private Long id;
	private Date date;
	
	@NotBlank(message = "O nome da banda não pode ficar em branco")
	private String band;
	
	public ShowDTO(Long id, Date date, String band) {
		this.id = id;
		this.date = date;
		this.band = band;
	}
	
	public ShowDTO(Show show) {
		this.id = show.getId();
		this.date = show.getDate();
		this.band = show.getBand();
	}
}
