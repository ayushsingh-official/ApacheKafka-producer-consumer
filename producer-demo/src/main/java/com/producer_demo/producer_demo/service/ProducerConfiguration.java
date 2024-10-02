package com.producer_demo.producer_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerConfiguration {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

}
