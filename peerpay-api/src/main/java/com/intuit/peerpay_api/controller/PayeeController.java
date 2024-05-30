package com.intuit.peerpay_api.controller;


import com.intuit.peerpay_api.model.PayeeResponse;
import com.intuit.peerpay_api.model.PaymentMethod;
import com.intuit.peerpay_api.repository.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payees")
public class PayeeController {

    @Autowired
    private PayeeRepository payeeRepository;

    @GetMapping
    public ResponseEntity<List<PayeeResponse>> getPayeesByName(@RequestParam(name = "name", required = false) String name) {
        return ResponseEntity.ok(payeeRepository.getPayeesByName(name));
    }

    @GetMapping("/{payeeId}/payment-methods")
    public ResponseEntity<List<PaymentMethod>> getPamentMethodsByPayeeId(@PathVariable(name = "payeeId") UUID payeeId) {
        return ResponseEntity.ok(payeeRepository.getPaymentMethodsByPayeeId(payeeId));
    }




}
