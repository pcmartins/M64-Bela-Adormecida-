package br.com.souzacar.model;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

//Cliente

@Entity
@Component
public class Clients extends Person{

	private TypePerson typePerson;

	public TypePerson getTypePerson() {
		return typePerson;
	}

	public void setTypePerson(TypePerson typePerson) {
		this.typePerson = typePerson;
	}
}