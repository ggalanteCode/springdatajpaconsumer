package com.soprasteria.springdatajpaconsumer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clienti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@Id
	private Integer codiceCliente;
	
	private String nome;
	
	private String cognome;
	
	private String indirizzo;
	
	private String email;
	
	private String telefono;
	
	private Integer prodottoAcquistato;
	
	private String nomeDescrizioneProdottoAcquistato;

}
