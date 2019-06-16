package br.edu.utfpr.alunos.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.utfpr.alunos.model.LocalEvent;
import br.edu.utfpr.alunos.repository.LocalEventRepository;

@Service
public class LocalEventService {
    @Autowired
    LocalEventRepository localEventRepository;
    
    public Page<LocalEvent> findAllEventGuarapuava(PageRequest pageRequest) {
    	return localEventRepository.findAllEventGuarapuava("Guarapuava", pageRequest);
    }

}
