package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Models;

public interface ModelRepository extends CrudRepository<Models, Long>{

}
