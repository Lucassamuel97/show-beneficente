package br.edu.utfpr.alunos.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.edu.utfpr.alunos.model.User;
import lombok.Data;

@Data
public class UserDTO {
	
	private Long id;
	
	@NotBlank(message = "O nome do usuario não pode estar em branco")
    @Length(min = 2, max = 100, message = "O nome do usuario deve conter no mínimo 2 e máximo 100 caracteres.")
    private String name;

    private int age;
    
	public UserDTO(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.age = user.getAge();
	}
}
