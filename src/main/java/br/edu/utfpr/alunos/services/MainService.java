package br.edu.utfpr.alunos.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.alunos.model.LocalEvent;
import br.edu.utfpr.alunos.model.Show;
import br.edu.utfpr.alunos.model.TicketOrder;
import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.repository.LocalEventRepository;
import br.edu.utfpr.alunos.repository.ShowRepository;
import br.edu.utfpr.alunos.repository.TicketOrderRepository;
import br.edu.utfpr.alunos.repository.UserRepository;

@Service
public class MainService {
	
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    TicketOrderRepository ticketOrderRepository;
    
    @Autowired
    ShowRepository showRepository;
    
    @Autowired
    LocalEventRepository localEventRepository;
    
    
    public void init() {
        User user = new User(1L, "Lucas", 21);
        Show show = new Show(1L, new Date(), "Paralamas");
        
        LocalEvent local_evento = new LocalEvent(1L, new Date() ,new Date() , "Guarapuava");
        local_evento.insertShow(show);
        
        TicketOrder ticketOrder = new TicketOrder(1L, 2,2.0, user, show);
     
        userRepository.save(user);
        showRepository.save(show);

    }
}