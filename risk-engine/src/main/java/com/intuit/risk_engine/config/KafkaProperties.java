package com.intuit.risk_engine.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {

    private String bootstrapServers;
    private String consumerKeySerializer;
    private String consumerValueSerializer;
    private String paymentProcessingTopicName;
    private String consumerGroupId;
    private String consumerAutoOffsetReset;


    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getConsumerKeySerializer() {
        return consumerKeySerializer;
    }

    public void setConsumerKeySerializer(String consumerKeySerializer) {
        this.consumerKeySerializer = consumerKeySerializer;
    }

    public String getConsumerValueSerializer() {
        return consumerValueSerializer;
    }

    public void setConsumerValueSerializer(String consumerValueSerializer) {
        this.consumerValueSerializer = consumerValueSerializer;
    }

    public String getPaymentProcessingTopicName() {
        return paymentProcessingTopicName;
    }

    public void setPaymentProcessingTopicName(String paymentProcessingTopicName) {
        this.paymentProcessingTopicName = paymentProcessingTopicName;
    }
}
