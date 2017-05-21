package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long>{

}
