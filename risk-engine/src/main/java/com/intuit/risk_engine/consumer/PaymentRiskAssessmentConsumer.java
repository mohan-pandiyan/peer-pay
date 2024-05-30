package com.intuit.risk_engine.consumer;

import com.intuit.common.dto.PaymentDto;
import com.intuit.risk_engine.service.RiskAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PaymentRiskAssessmentConsumer {

    private static final Logger logger = Logger.getLogger(PaymentRiskAssessmentConsumer.class.getName());

    @Autowired
    private RiskAssessmentService riskAssessmentService;

    @KafkaListener(topics = "${kafka.payment-processing-topic-name}", groupId = "${kafka.consumer-group-id}")
    public void consumePayment(PaymentDto paymentDto, Acknowledgment acknowledgment) {
        try {
            riskAssessmentService.assessRisk(paymentDto);
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error assessing risk for transaction: "+paymentDto.getTransactionId(), e);
            // Retry and add to the dead-letter queue if the maximum number of retries is reached
        }
        acknowledgment.acknowledge();
    }
}
