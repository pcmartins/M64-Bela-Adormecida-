package br.com.souzacar.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.souzacar.model.OrderService;

public interface OrderServiceRepository extends CrudRepository<OrderService, Long> {

}
