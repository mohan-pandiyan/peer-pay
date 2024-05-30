package com.intuit.peerpay_api.service;

import com.intuit.common.dto.PaymentDto;
import com.intuit.peerpay_api.config.KafkaProperties;
import com.intuit.peerpay_api.model.PaymentRequest;
import com.intuit.peerpay_api.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PaymentService {
    private static final Logger LOGGER = Logger.getLogger(PaymentService.class.getName());

    @Autowired
    private KafkaTemplate<String, PaymentDto> kafkaTemplate;

    @Autowired
    private KafkaProperties kafkaProperties;

    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        PaymentDto paymentDto = paymentRequest.toPaymentDto();
        CompletableFuture<SendResult<String, PaymentDto>> future =
                kafkaTemplate.send(
                        kafkaProperties.getPaymentProcessingTopicName(),
                        paymentDto.getUserId().toString(),
                        paymentDto
                );
        try {
            future.get(1, java.util.concurrent.TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            LOGGER.log(Level.SEVERE, "Error sending payment to Kafka", e);
            throw new RuntimeException("Error sending payment to Kafka");
        } finally {
            kafkaTemplate.flush();
        }
        return PaymentResponse.fromPaymentDto(paymentDto);
    }
}
