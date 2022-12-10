package com.soprasteria.springdatajpaconsumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soprasteria.springdatajpaconsumer.model.Cliente;
import com.soprasteria.springdatajpaconsumer.repo.ClienteRepository;
import com.soprasteria.springdatajpaconsumer.service.ClienteConsumerService;

@Service
public class ClienteConsumerServiceImpl implements ClienteConsumerService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void insertCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println(cliente + " sta per essere inserito nel db");
		clienteRepository.save(cliente);
	}

}
