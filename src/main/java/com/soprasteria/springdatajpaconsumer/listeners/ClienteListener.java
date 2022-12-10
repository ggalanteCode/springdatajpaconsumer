package com.soprasteria.springdatajpaconsumer.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.soprasteria.springdatajpaconsumer.model.Cliente;
import com.soprasteria.springdatajpaconsumer.service.ClienteConsumerService;

import static com.soprasteria.springdatajpaconsumer.constants.KafkaConstants.*;

@Component
public class ClienteListener {
	
	@Autowired
	private ClienteConsumerService clienteConsumerService;

	@KafkaListener(topics = TOPIC_NAME, containerFactory = KAFKA_LISTENER_CONTAINER_FACTORY)
	public void listener(@Payload Cliente cliente) {
		System.out.println(cliente + " è stato ascoltato dal consumer");
		clienteConsumerService.insertCliente(cliente);
	}

}
