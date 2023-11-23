package com.example.bookstore.controller;

import com.example.bookstore.controller.common.AbstractController;
import com.example.bookstore.domain.PaymentTransaction;
import com.example.bookstore.repository.PaymentTransactionRepository;
import com.example.bookstore.service.PaymentTransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookstore/transactions")
public class PaymentTransactionController extends AbstractController<PaymentTransaction, PaymentTransactionService, PaymentTransactionRepository> {
    public PaymentTransactionController(PaymentTransactionService service) {
        super(service);
    }
}