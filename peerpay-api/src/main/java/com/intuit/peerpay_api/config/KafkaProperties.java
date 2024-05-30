package com.intuit.peerpay_api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {

    private String bootstrapServers;
    private String producerAcks;
    private String producerKeySerializer;
    private String producerValueSerializer;
    private String paymentProcessingTopicName;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getProducerAcks() {
        return producerAcks;
    }

    public void setProducerAcks(String producerAcks) {
        this.producerAcks = producerAcks;
    }

    public String getProducerKeySerializer() {
        return producerKeySerializer;
    }

    public void setProducerKeySerializer(String producerKeySerializer) {
        this.producerKeySerializer = producerKeySerializer;
    }

    public String getProducerValueSerializer() {
        return producerValueSerializer;
    }

    public void setProducerValueSerializer(String producerValueSerializer) {
        this.producerValueSerializer = producerValueSerializer;
    }

    public String getPaymentProcessingTopicName() {
        return paymentProcessingTopicName;
    }

    public void setPaymentProcessingTopicName(String paymentProcessingTopicName) {
        this.paymentProcessingTopicName = paymentProcessingTopicName;
    }
}
