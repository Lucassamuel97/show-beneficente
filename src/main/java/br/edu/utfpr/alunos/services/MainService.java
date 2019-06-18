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
        User user1 = new User(1L, "Lucas", 21);
        User user2 = new User(2L, "joão", 21);
        User user3 = new User(3L, "José", 21);
        
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        
        Show show1 = new Show(1L, new Date(), "Paralamas do sucesso");
        Show show2 = new Show(2L, new Date(), "Raimundos");
        Show show3 = new Show(3L, new Date(), "Velhas virgens");
        Show show4 = new Show(4L, new Date(), "Banda Djavu");
        Show show5 = new Show(5L, new Date(), "lil nas x");
        Show show6 = new Show(6L, new Date(), "Velhas virgens");
        
        
        showRepository.save(show1);
        showRepository.save(show2);
        showRepository.save(show3);
        showRepository.save(show4);
        showRepository.save(show5);
        showRepository.save(show6);
        
        LocalEvent local1 = new LocalEvent(1L, new Date(), new Date(), "Guarapuava");
        local1.insertShow(show1);
        local1.insertShow(show2);
        localEventRepository.save(local1);
        
        LocalEvent local2 = new LocalEvent(2L, new Date(), new Date(), "Palmital");
        local2.insertShow(show3);
        local2.insertShow(show4);
        localEventRepository.save(local2);
        
        LocalEvent local3 = new LocalEvent(3L, new Date(), new Date(), "Curitiba");
        local3.insertShow(show5);
        local3.insertShow(show6);
        localEventRepository.save(local3);
        
        
        TicketOrder tickt1 = new TicketOrder(1L, 3, 2.0, user1, show1);
        TicketOrder tickt2 = new TicketOrder(2L, 4, 200.0, user1, show2);
        TicketOrder tickt3 = new TicketOrder(3L, 10, 2.0, user2, show3);
        TicketOrder tickt4 = new TicketOrder(4L, 10, 2.0, user3, show1);
        
        ticketOrderRepository.save(tickt1);
        ticketOrderRepository.save(tickt2);
        ticketOrderRepository.save(tickt3);
        ticketOrderRepository.save(tickt4);
    }
}