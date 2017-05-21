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

import br.com.souzacar.model.Accounts;
import br.com.souzacar.repository.AccountsRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

	@Autowired
	private AccountsRepository accountsRepository;
	@Autowired
	private Response response;
	@Autowired
	private Accounts accounts;
	
	public AccountsController() {
		super();
	}

	public AccountsController(AccountsRepository accountsRepository, Response response, Accounts accounts) {
		super();
		this.accountsRepository = accountsRepository;
		this.response = response;
		this.accounts = accounts;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Accounts accounts){
		try {
			accountsRepository.save(accounts);
			response.setData(accounts);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Accounts accounts){
		try {
			accountsRepository.save(accounts);
			response.setData(accounts);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		accounts = accountsRepository.findOne(id);
		
		try {
			accountsRepository.delete(accounts);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(accounts, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Accounts> result = new ArrayList<Accounts>();
		Iterator<Accounts> iterator = accountsRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		accounts = accountsRepository.findOne(id);

		return new Response(accounts, null);
	}
}
