package br.edu.utfpr.alunos.controller;

import java.util.ArrayList;
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

import br.edu.utfpr.alunos.dto.AmountOfShowTicketsDTO;
import br.edu.utfpr.alunos.dto.LocalEventDTO;
import br.edu.utfpr.alunos.dto.TicketOrderDTO;
import br.edu.utfpr.alunos.dto.UserDTO;
import br.edu.utfpr.alunos.model.LocalEvent;
import br.edu.utfpr.alunos.model.TicketOrder;
import br.edu.utfpr.alunos.model.User;
import br.edu.utfpr.alunos.services.LocalEventService;
import br.edu.utfpr.alunos.services.TicketOrderService;
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
	TicketOrderService ticketOrderService;

	private int paginationAmount = 10;

	//ok
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
	
	//ok
	// Apresentar os eventos cadastrados para Guarapuava.
	@GetMapping(value = "/eventos-guara")
	public ResponseEntity<Response<List<LocalEventDTO>>> findAllEventGuarapuava(){
		
		Response<List<LocalEventDTO>> response = new Response<>();
		List<LocalEvent> localEvents = localEventService.findAllEventGuarapuava();
		ArrayList<LocalEventDTO> localEventsDTOs = new ArrayList<LocalEventDTO>();
		
		for (LocalEvent localEvent : localEvents) {
			localEventsDTOs.add(new LocalEventDTO(localEvent));
		}
		response.setData(localEventsDTOs);
		return ResponseEntity.ok(response);
	}
	
	// Apresentar todos os usuários que tem José como primeiro nome.
	@GetMapping(value = "/usuario-jose")
	public ResponseEntity<Response<List<UserDTO>>> findByNameUserParam(@RequestParam("nome") String name){
		Response<List<UserDTO>> response = new Response<>();
		
		ArrayList<User> users = userService.findByNameUserParam(name);
		
		ArrayList<UserDTO> userDTOs = new ArrayList<UserDTO>();
		
		for (User user : users) {
			userDTOs.add(new UserDTO(user));
		}
		response.setData(userDTOs);
		return ResponseEntity.ok(response);
	}

	// Apresentar os pedidos de ingressos de um dado usuário. /usuarios-pedido?id=1
	@GetMapping(value = "/usuarios-pedido")
	public ResponseEntity<Response<List<TicketOrderDTO>>> findByUserRequestsParam(@RequestParam("id") Long id) {
		Response<List<TicketOrderDTO>> response = new Response<>();
		
		List<TicketOrder> ticktsOrders = ticketOrderService.findByUserRequestsParam(id);
		ArrayList<TicketOrderDTO> ticktsOrderDTOs = new ArrayList<TicketOrderDTO>();
		
		for (TicketOrder tickt : ticktsOrders) {
			ticktsOrderDTOs.add(new TicketOrderDTO(tickt));
		}
		response.setData(ticktsOrderDTOs);
		return ResponseEntity.ok(response);
	}
	
	// Apresentar os usuários que compraram ingressos para um dado show.
	@GetMapping(value = "/usuarios-show")
	public ResponseEntity<Response<List<UserDTO>>> findByUserByshow(@RequestParam("id") Long id) {
		Response<List<UserDTO>> response = new Response<>();
		
		List<User> users = ticketOrderService.findPerShowUser(id);
		ArrayList<UserDTO> usersDTOs = new ArrayList<UserDTO>();
		
		for (User user : users) {
			usersDTOs.add(new UserDTO(user));
		}
		response.setData(usersDTOs);
		return ResponseEntity.ok(response);
	}

	//ok
	// Apresentar os shows e usuários que compraram entre 3 e 5 ingressos.(Retorna Todos os dados)
	@GetMapping(value = "/usuarios-compras")
	public ResponseEntity<Response<List<TicketOrderDTO>>> findAllTicketsRequests() {
		
		Response<List<TicketOrderDTO>> response = new Response<>();
		
		List<TicketOrder> ticktsOrders = ticketOrderService.findAllTicketsRequests();
		ArrayList<TicketOrderDTO> ticktsOrderDTOs = new ArrayList<TicketOrderDTO>();
		
		for (TicketOrder tickt : ticktsOrders) {
			ticktsOrderDTOs.add(new TicketOrderDTO(tickt));
		}
		response.setData(ticktsOrderDTOs);
		return ResponseEntity.ok(response);
	}

	//ok
	// Apresentar o usuário que doou o maior valor em um pedido.
	@GetMapping(value = "/usuarios-maior-valor")
	public ResponseEntity<Response<UserDTO>> finduserGreaterOrder() {
		Response<UserDTO> response = new Response<>();
		
		User user = ticketOrderService.findUserGreaterOrder();
		UserDTO userDTO = new UserDTO(user);
		
		response.setData(userDTO);
		return ResponseEntity.ok(response);
	}
	
//	 Apresentar a quantidade de ingressos vendidos para cada show.
	@GetMapping(value = "/quant-ingressos")
	public ResponseEntity<Response<List<AmountOfShowTicketsDTO>>> findAmountOfShowTickets(){
		Response<List<AmountOfShowTicketsDTO>> response = new Response<>();
		
		List<AmountOfShowTicketsDTO> amouts = ticketOrderService.findAmountOfShowTicketsDTO();
	
		response.setData(amouts);
		return ResponseEntity.ok(response);
	}
}
