/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.alunos.repository;

import br.edu.utfpr.alunos.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
public interface UserRepository extends JpaRepository<User, Long> {
    
	@Transactional(readOnly = true)
    
    //Encontrar por nome comeca com ____
    @Query("select u from User u where u.name like %?1")
    List<User> findByNameBeginsWith(String name);
}
