package br.com.souzacar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.souzacar.model.Models;
import br.com.souzacar.repository.ModelRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/models")
public class ModelController {

	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private Response response;
	@Autowired
	private Models model;
	
	public ModelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModelController(ModelRepository modelRepository, Response response, Models model) {
		super();
		this.modelRepository = modelRepository;
		this.response = response;
		this.model = model;
	}
		
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Models> result = new ArrayList<Models>();
		Iterator<Models> iterator = modelRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
		
		return new Response(result, null);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		model = modelRepository.findOne(id);
		
		return new Response(model, null);
	}
}