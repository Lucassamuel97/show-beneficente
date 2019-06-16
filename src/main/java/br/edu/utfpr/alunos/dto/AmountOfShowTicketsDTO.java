package br.edu.utfpr.alunos.dto;

import br.edu.utfpr.alunos.model.Show;
import lombok.Data;

@Data
public class AmountOfShowTicketsDTO {
	private int quant;
	private Show show;
	
	public AmountOfShowTicketsDTO(int quant, Show show) {
		super();
		this.quant = quant;
		this.show = show;
	}
}

