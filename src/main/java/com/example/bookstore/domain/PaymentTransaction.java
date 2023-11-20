package com.example.bookstore.domain;

import com.example.bookstore.domain.common.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class PaymentTransaction extends AuditEntity {
    @NotNull
    @OneToOne
    private Book book;
    @NotNull
    @OneToOne
    private UserAccount account;
    @NotNull
    private BigDecimal price;
}