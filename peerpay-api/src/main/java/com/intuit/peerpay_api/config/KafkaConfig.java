package com.intuit.peerpay_api.config;

import com.intuit.common.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, PaymentDto> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put("bootstrap.servers", kafkaProperties.getBootstrapServers());
        configProps.put("acks", kafkaProperties.getProducerAcks());
        configProps.put("key.serializer", kafkaProperties.getProducerKeySerializer());
        configProps.put("value.serializer", kafkaProperties.getProducerValueSerializer());
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, PaymentDto> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
