package com.example.bookstore.domain;

import com.example.bookstore.domain.common.AuditEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class UserRole extends AuditEntity {
    @NotBlank
    @Column(unique = true)
    private String roleName;
    @NotBlank
    private String description;
}