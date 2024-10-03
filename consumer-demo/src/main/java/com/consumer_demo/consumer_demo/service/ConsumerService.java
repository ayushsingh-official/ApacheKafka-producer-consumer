package com.consumer_demo.consumer_demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

//	@RetryableTopic(attempts = "3", backoff = @Backoff(delay = 3000, multiplier = 2))
	@KafkaListener(topics = "payment-topic", groupId = "group_id", containerFactory = "concurrentKafkaListenerContainerFactory")
	public void consume(ConsumerRecord<String, String> message) {
		log.info("Key: {} | Value: {}", message.key(), message.value());
		log.info("Partition: {} | Offset: {}", message.partition(), message.offset());
//		Integer.parseInt(message.value());

	}

//	@DltHandler
//	public void processFailureMessages(ConsumerRecord<String, String> message) {
//		log.info("Dead letter topic Key: {} | Value: {}", message.key(), message.value());
//
//		// Send email notifications about failure message
//
//	}

}
