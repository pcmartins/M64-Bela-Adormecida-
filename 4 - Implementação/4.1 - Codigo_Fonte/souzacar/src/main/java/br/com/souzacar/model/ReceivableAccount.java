package br.com.souzacar.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ReceivableAccount extends Account{

	private String nameClient;
}
