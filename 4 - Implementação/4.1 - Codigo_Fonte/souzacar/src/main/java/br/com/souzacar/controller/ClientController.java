package br.com.souzacar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.souzacar.model.Client;
import br.com.souzacar.repository.ClientRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private Response response;
	@Autowired
	private Client client;

	public ClientController() {
		super();
	}

	public ClientController(ClientRepository clientRepository, Response response, Client client) {
		super();
		this.clientRepository = clientRepository;
		this.response = response;
		this.client = client;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Client client){
		try {
			clientRepository.save(client);
			response.setData(client);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Client client){
		try {
			clientRepository.save(client);
			response.setData(client);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		client = clientRepository.findOne(id);
		try {
			clientRepository.delete(client);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return new Response(client, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Client> result = new ArrayList<Client>();
		Iterator<Client> iterator = clientRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response list(@PathVariable long id){
		client = clientRepository.findOne(id);
		
		return new Response(client, null);
	}
}