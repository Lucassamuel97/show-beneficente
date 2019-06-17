package br.edu.utfpr.alunos.dto;

import br.edu.utfpr.alunos.model.Show;
import lombok.Data;

@Data
public class AmountOfShowTicketsDTO {
	private Long quant;
	private Show show;
	
	public AmountOfShowTicketsDTO(Long quant, Show show) {
		super();
		this.quant = quant;
		this.show = show;
	}
}

