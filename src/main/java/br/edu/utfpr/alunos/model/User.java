package br.edu.utfpr.alunos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
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
