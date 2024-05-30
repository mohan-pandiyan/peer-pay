package com.intuit.peerpay_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.peerpay_api.model.Payee;
import com.intuit.peerpay_api.repository.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Arrays;

@Component
public class PayeeDataLoader implements CommandLineRunner {

    @Autowired
    private PayeeRepository payeeRepository;

    @Value("classpath:payees.json")
    private Resource payeeData;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = payeeData.getInputStream()) {
            Payee[] payees = objectMapper.readValue(inputStream, Payee[].class);
            Arrays.stream(payees).forEach(payeeRepository::save);
        }
    }
}
