package br.edu.utfpr.alunos.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.edu.utfpr.alunos.model.User;

public class UserDTO {
	
	private Long id;
	
	@NotEmpty(message = "O nome do usuario não pode ser nulo")
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
