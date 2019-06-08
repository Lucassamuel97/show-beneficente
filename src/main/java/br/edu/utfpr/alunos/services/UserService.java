/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.alunos.services;

import br.edu.utfpr.alunos.model.Show;
import br.edu.utfpr.alunos.model.TicketOrder;
import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.repository.UserRepository;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    public static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public void init() {
        User user = new User(1L, "Lucas", 21);
        Show show = new Show(1L, new Date(), "Paralamas");
        TicketOrder ticketOrder = new TicketOrder(1L, 2,2.0, user, show);
        
        userRepository.save(user);
        userRepository.save(show);
        userRepository.save(user);
    }
}
