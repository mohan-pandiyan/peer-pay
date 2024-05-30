package com.intuit.risk_engine.service;

import com.intuit.common.dto.PaymentDto;
import com.intuit.risk_engine.model.PaymentProcessing;
import com.intuit.risk_engine.repository.PaymentProcessingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class RiskAssessmentService {

    private static final Logger logger = Logger.getLogger(RiskAssessmentService.class.getName());

    @Autowired
    private PaymentProcessingRepository paymentProcessingRepository;

    public boolean assessRisk(PaymentDto paymentDto) {
        if (paymentDto.getTransactionId() == null) {
            throw new IllegalArgumentException("Transaction ID is required");
        }
        if (paymentDto.getTransactionId().hashCode() % 10 < 7) {
               logger.info("Transaction approved: " + paymentDto.toString());
               // Approved 70% of the time. Add to the database
                paymentProcessingRepository.save(PaymentProcessing.fromPaymentDto(paymentDto, "RISK_APPROVED"));
               return true;
        }
        else {
            logger.info("Transaction declined: " + paymentDto.toString());
            // Declined 30% of the time. Do not add to the database
            paymentProcessingRepository.save(PaymentProcessing.fromPaymentDto(paymentDto, "RISK_DECLINED"));
            return false;
        }
        // Update the status of the transaction in the database

    }
}
