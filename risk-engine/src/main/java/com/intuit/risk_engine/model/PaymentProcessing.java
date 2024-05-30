package com.intuit.risk_engine.model;

import com.intuit.common.dto.PaymentDto;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table(value = "payment_processing")
public class PaymentProcessing {

    @PrimaryKeyColumn(name = "transaction_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID transactionId;

    @PrimaryKeyColumn(name = "updated_time", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private long updatedTime;

    private String status;

    private String metadata;

    public PaymentProcessing(String status, String metadata, UUID transactionId) {
        this.status = status;
        this.metadata = metadata;
        this.transactionId = transactionId;
        this.updatedTime = System.currentTimeMillis();
    }

    public PaymentProcessing() {
        super();
    }

    public static PaymentProcessing fromPaymentDto(PaymentDto paymentDto, String status) {
        return new PaymentProcessing(status, paymentDto.toString() , paymentDto.getTransactionId());
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentProcessing that = (PaymentProcessing) o;
        return updatedTime == that.updatedTime && Objects.equals(transactionId, that.transactionId) && Objects.equals(status, that.status) && Objects.equals(metadata, that.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, updatedTime, status, metadata);
    }

    @Override
    public String toString() {
        return "PaymentProcessing{" +
                "transactionId=" + transactionId +
                ", updatedTime=" + updatedTime +
                ", status='" + status + '\'' +
                ", metadata='" + metadata + '\'' +
                '}';
    }
}
