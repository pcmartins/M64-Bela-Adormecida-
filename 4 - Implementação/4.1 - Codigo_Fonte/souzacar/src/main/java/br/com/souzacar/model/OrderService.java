//package br.com.souzacar.model;
//
//import java.util.Calendar;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
//import org.springframework.stereotype.Component;
//
////Ordem de Serviço
//
//@Entity
//@Component
//public class OrderService {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	private String nameClient;
//	private Calendar releaseDate;
//	private String description;
//	@ManyToOne
//	private Vehicle vehicle;
//	@OneToMany
//	private Product product;
//}
