package br.com.souzacar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

//Pessoa

@Entity
@Component
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String name;
	protected String phone;
	protected String cellPhone;
	protected String email;
	protected String address;
	protected String cep;
	@Column( unique=true )
	protected String cpfCnpj;
	protected String rgInscricaoEstadual;
	protected String document;
	protected String contact;
	protected String dateRegiter;
	protected String updateDate;
	protected boolean isActive;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(Long id, String name, String phone, String cellPhone, String email, String address, String cep,
			String cpfCnpj, String rgInscricaoEstadual, String document, String contact, String dateRegiter,
			String updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.cellPhone = cellPhone;
		this.email = email;
		this.address = address;
		this.cep = cep;
		this.cpfCnpj = cpfCnpj;
		this.rgInscricaoEstadual = rgInscricaoEstadual;
		this.document = document;
		this.contact = contact;
		this.dateRegiter = dateRegiter;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRgInscricaoEstadual() {
		return rgInscricaoEstadual;
	}

	public void setRgInscricaoEstadual(String rgInscricaoEstadual) {
		this.rgInscricaoEstadual = rgInscricaoEstadual;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDateRegiter() {
		return dateRegiter;
	}

	public void setDateRegiter(String dateRegiter) {
		this.dateRegiter = dateRegiter;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}