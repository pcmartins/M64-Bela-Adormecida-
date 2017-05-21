package br.com.souzacar.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

//Lançamentos

@Entity(name = "releases")
@Component
public class Releases {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String description;
	protected Calendar dueDate;
	@ManyToOne
	protected Accounts sourceAccount;
	@ManyToOne
	protected Accounts destinationAccount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Calendar getDueDate() {
		return dueDate;
	}
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
	public Accounts getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(Accounts sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public Accounts getDestinationAccount() {
		return destinationAccount;
	}
	public void setDestinationAccount(Accounts destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
}