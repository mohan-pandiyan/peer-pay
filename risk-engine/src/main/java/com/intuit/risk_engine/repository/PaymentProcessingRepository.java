package com.intuit.risk_engine.repository;

import com.intuit.risk_engine.model.PaymentProcessing;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface PaymentProcessingRepository extends CassandraRepository<PaymentProcessing, UUID> {

}
