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

import br.com.souzacar.model.Releases;
import br.com.souzacar.repository.ReleasesRepository;
import br.com.souzacar.utlis.Response;

@RestController
@RequestMapping("/api/releases")
public class ReleasesController {

	@Autowired
	private ReleasesRepository releasesRepository;
	@Autowired
	private Response response;
	@Autowired
	private Releases releases;
	
	public ReleasesController() {
		super();
	}

	public ReleasesController(ReleasesRepository releasesRepository, Response response, Releases releases) {
		super();
		this.releasesRepository = releasesRepository;
		this.response = response;
		this.releases = releases;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response insert(@RequestBody Releases releases){
		try {
			releasesRepository.save(releases);
			response.setData(releases);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response update(@PathVariable long id, @RequestBody Releases releases){
		try {
			releasesRepository.save(releases);
			response.setData(releases);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return response;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response delete(@PathVariable long id){
		releases = releasesRepository.findOne(id);
		
		try {
			releasesRepository.delete(releases);
		} catch (Exception e) {
			response.setStatus(500, e.getMessage());
		}
		
		return new Response(releases, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public Response list(){
		List<Releases> result = new ArrayList<Releases>();
		Iterator<Releases> iterator = releasesRepository.findAll().iterator();
		
		while(iterator.hasNext()){
			result.add(iterator.next());
		}
				
		return new Response(result, null);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Response get(@PathVariable long id){
		releases = releasesRepository.findOne(id);

		return new Response(releases, null);
	}
}