package br.edu.utfpr.alunos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	@Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "idade")
    private int age;
    
    public User() {
        super();
    }
	public User(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
