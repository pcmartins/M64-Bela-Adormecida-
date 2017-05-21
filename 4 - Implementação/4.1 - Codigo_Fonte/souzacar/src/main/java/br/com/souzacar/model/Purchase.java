package br.com.souzacar.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

//Compra

@Entity
@Component
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Calendar releaseDate;
	private BigDecimal amount;
	private String description;
	@ManyToOne
	private Providers providers;
	@OneToMany
	private List<Product> products;
}
