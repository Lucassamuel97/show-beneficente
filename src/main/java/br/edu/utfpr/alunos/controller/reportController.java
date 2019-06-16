package br.edu.utfpr.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.alunos.dto.LocalEventDTO;
import br.edu.utfpr.alunos.dto.UserDTO;
import br.edu.utfpr.alunos.model.LocalEvent;
import br.edu.utfpr.alunos.model.TicketOrder;
import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.repository.LocalEventRepository;
import br.edu.utfpr.alunos.repository.ShowRepository;
import br.edu.utfpr.alunos.repository.TicketOrderRepository;
import br.edu.utfpr.alunos.repository.UserRepository;
import br.edu.utfpr.alunos.services.LocalEventService;
import br.edu.utfpr.alunos.services.UserService;
import br.edu.utfpr.alunos.util.Response;

@RestController
@RequestMapping("/api/relatorio")
@CrossOrigin(origins = "*")
public class reportController {
	@Autowired
	UserService userService;

	@Autowired
	LocalEventService localEventService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TicketOrderRepository ticketOrderRepository;

	@Autowired
	ShowRepository showRepository;

	@Autowired
	LocalEventRepository localEventRepository;

	private int paginationAmount = 10;

	// Apresentar todos usuários cadastrados.
	@GetMapping(value = "/usuarios")
	public ResponseEntity<Response<List<UserDTO>>> findAllPagination(
			@RequestParam(value = "pag", defaultValue = "0") int page,
			@RequestParam(value = "ord", defaultValue = "name") String order,
			@RequestParam(value = "dir", defaultValue = "ASC") String direction) {

		Response<List<UserDTO>> response = new Response<>();

		PageRequest pageRequest = new PageRequest(page, this.paginationAmount, Sort.Direction.valueOf(direction),
				order);
		Page<User> users = userService.findAll(pageRequest);
		Page<UserDTO> usersdDTOs = users.map(s -> new UserDTO(s));
		response.setData(usersdDTOs.getContent());
		return ResponseEntity.ok(response);
	}
	
	// Apresentar os eventos cadastrados para Guarapuava.
	@GetMapping(value = "/eventos-guara")
	public ResponseEntity<Response<List<LocalEventDTO>>> findAllEventGuarapuava(
			@RequestParam(value = "pag", defaultValue = "0") int page,
			@RequestParam(value = "ord", defaultValue = "city") String order,
			@RequestParam(value = "dir", defaultValue = "ASC") String direction){

		Response<List<LocalEventDTO>> response = new Response<>();
		PageRequest pageRequest = new PageRequest(page, this.paginationAmount, Sort.Direction.valueOf(direction),
				order);
		Page<LocalEvent> localEvents = localEventService.findAllEventGuarapuava(pageRequest);
		Page<LocalEventDTO> localEventsDTOs = localEvents.map(s -> new LocalEventDTO(s));
		response.setData(localEventsDTOs.getContent());
		return ResponseEntity.ok(response);
	}
	
	// Apresentar todos os usuários que tem José como primeiro nome.
	@GetMapping(value = "/usuarios-jose")
	public List<User> findByNameUserParam(@RequestParam("nome") String name){
		List<User> users = userRepository.findByNameBeginsWith(name);
		return users;
	}

	// Apresentar os pedidos de ingressos de um dado usuário. /usuarios-pedido?id=1
	@GetMapping(value = "/usuarios-pedido")
	public List<TicketOrder> findByUserRequestsParam(@RequestParam("id") Long id) {
		List<TicketOrder> ticktsOrder = ticketOrderRepository.findByUserRequestsParam(id);
		return ticktsOrder;
	}

	// Apresentar os usuários que compraram ingressos para um dado show.

	// Apresentar os shows e usuários que compraram entre 3 e 5 ingressos.
	@GetMapping(value = "/usuarios-compras")
	public List<TicketOrder> findAllTicketsRequests() {
		List<TicketOrder> ticktsOrder = ticketOrderRepository.findAllTicketsRequests();
		return ticktsOrder;
	}

	// Apresentar o usuário que doou o maior valor em um pedido.
	@GetMapping(value = "/usuarios-maior-valor")
	public List<TicketOrder> finduserGreaterOrder() {
		List<TicketOrder> ticktsOrder = ticketOrderRepository.finduserGreaterOrder();
		return ticktsOrder;
	}

	// Apresentar a quantidade de ingressos vendidos para cada show.

}
