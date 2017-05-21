package br.com.souzacar.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.souzacar.model.Brand;
import br.com.souzacar.repository.BrandRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

	@Autowired
	private BrandRepository brandRepository;
	@Autowired
	private Response response;
	@Autowired
	private Brand brand;
	
	public BrandController() {
		super();
	}

	public BrandController(BrandRepository brandRepository, Response response, Brand brand) {
		super();
		this.brandRepository = brandRepository;
		this.response = response;
		this.brand = brand;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Brand> result = new ArrayList<Brand>();
		Iterator<Brand> iterator = brandRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@Transactional(readOnly = true)
	public Response get(@PathVariable long id){
		brand = brandRepository.findOne(id);

		return new Response(brand, null);
	}
}