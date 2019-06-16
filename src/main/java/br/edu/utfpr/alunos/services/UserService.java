package br.edu.utfpr.alunos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    UserRepository userRepository;
	
	public Page<User> findAll(PageRequest pageRequest) {
		 return userRepository.findAll(pageRequest);
	}
	
}
