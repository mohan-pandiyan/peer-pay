package com.intuit.peerpay_api.repository;

import com.intuit.peerpay_api.model.Payee;
import com.intuit.peerpay_api.model.PayeeResponse;
import com.intuit.peerpay_api.model.PaymentMethod;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class PayeeRepository {

    private final ConcurrentHashMap<UUID, Payee> payees = new ConcurrentHashMap<>();

    public Payee save(Payee payee) {
        payees.put(payee.getId(), payee);
        return payee;
    }

    public List<PayeeResponse> getPayeesByName(String name) {
        if (name == null || name.isEmpty()) {
            return payees.values().stream()
                    .map(Payee::toPayeeResponse)
                    .collect(Collectors.toList());
        } else {
            return payees.values().stream()
                    .filter(payee -> payee.getName().contains(name))
                    .map(Payee::toPayeeResponse)
                    .collect(Collectors.toList());
        }
    }

    public List<PaymentMethod> getPaymentMethodsByPayeeId(UUID payeeId) {
        return payees.get(payeeId).getPaymentMethods();
    }

}
