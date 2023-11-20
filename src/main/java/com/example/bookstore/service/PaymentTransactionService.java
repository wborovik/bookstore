package com.example.bookstore.service;

import com.example.bookstore.domain.PaymentTransaction;
import com.example.bookstore.repository.PaymentTransactionRepository;
import com.example.bookstore.service.common.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PaymentTransactionService extends AbstractService<PaymentTransaction, PaymentTransactionRepository> {
    public PaymentTransactionService(PaymentTransactionRepository repository) {
        super(repository);
    }
}