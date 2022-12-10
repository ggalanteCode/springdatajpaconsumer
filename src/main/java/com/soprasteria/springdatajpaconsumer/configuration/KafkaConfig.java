package com.soprasteria.springdatajpaconsumer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.soprasteria.springdatajpaconsumer.model.Cliente;

import static com.soprasteria.springdatajpaconsumer.constants.KafkaConstants.*;

@Configuration
@EnableKafka
public class KafkaConfig {
	
	@Bean
	public ConsumerFactory<String, Cliente> consumerFactory() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_CONFIG);
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID_JSON);
	    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	    props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, Cliente.class);
	    return new DefaultKafkaConsumerFactory<String, Cliente>(
	            props,
	            new StringDeserializer(),
	            new ErrorHandlingDeserializer<>(new JsonDeserializer<Cliente>(Cliente.class, false).trustedPackages("*")));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Cliente> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Cliente> factory = new ConcurrentKafkaListenerContainerFactory<String, Cliente>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
