package com.intuit.peerpay_api.model;

import com.intuit.common.dto.PaymentDto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentRequest {
    @NotNull(message = "User ID is required")
    private UUID userId;
    @NotNull(message = "Payee ID is required")
    private UUID payeeId;
    @NotNull(message = "Payment method ID is required")
    private UUID paymentMethod;
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;
    @NotBlank(message = "Currency is required")
    @Pattern(regexp = "[A-Z]{3}", message = "Currency must be a valid ISO 4217 code")
    private String currency;
    @NotBlank(message = "Idempotency key is required")
    private String idempotencyKey;
    private Long paymentTime;

    public PaymentRequest() {
        super();
    }

    public PaymentRequest(UUID userId, UUID payeeId, UUID paymentMethod, BigDecimal amount, String currency, String idempotencyKey, Long paymentTime) {
        this.userId = userId;
        this.payeeId = payeeId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.currency = currency;
        this.idempotencyKey = idempotencyKey;
        this.paymentTime = paymentTime;
    }

    public PaymentDto toPaymentDto() {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setUserId(this.getUserId());
        paymentDto.setPayeeId(this.getPayeeId());
        paymentDto.setPaymentMethod(this.getPaymentMethod());
        paymentDto.setAmount(this.getAmount());
        paymentDto.setCurrency(this.getCurrency());
        paymentDto.setIdempotencyKey(this.getIdempotencyKey());
        if (this.paymentTime == null) {
            paymentDto.setPaymentTime(System.currentTimeMillis());
        } else {
            paymentDto.setPaymentTime(this.getPaymentTime());
        }
        paymentDto.setServerTime(System.currentTimeMillis());
        paymentDto.setTransactionId(UUID.randomUUID());
        return paymentDto;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
    }

    public UUID getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(UUID paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public Long getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Long paymentTime) {
        this.paymentTime = paymentTime;
    }
}
