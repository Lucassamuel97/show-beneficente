package br.edu.utfpr.alunos.dto;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import br.edu.utfpr.alunos.model.LocalEvent;
import lombok.Data;

@Data
public class LocalEventDTO {
	private Long id;
	private Date startDate;
	private Date endDate;
	
	@NotBlank(message = "O nome da cidade não pode ficar em branco")
	private String city;
	
	public LocalEventDTO(Long id, Date startDate, Date endDate, String city) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
	}
	
	public LocalEventDTO(LocalEvent localEvent) {
		this.id = localEvent.getId();
		this.startDate = localEvent.getStartDate();
		this.endDate = localEvent.getEndDate();
		this.city = localEvent.getCity();
	}
}
