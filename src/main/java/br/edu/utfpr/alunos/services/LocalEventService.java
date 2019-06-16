package br.edu.utfpr.alunos.services;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.edu.utfpr.alunos.model.LocalEvent;
import br.edu.utfpr.alunos.repository.LocalEventRepository;

@Service
public class LocalEventService {
    @Autowired
    LocalEventRepository localEventRepository;
    
    public List<LocalEvent> findAllEventGuarapuava() {
    	LocalEvent localevent = new LocalEvent();
    	localevent.setCity("Guarapuava");
    	Example<LocalEvent> localEventExample = Example.of(localevent);
    	
    	return localEventRepository.findAll(localEventExample);
    }

}
