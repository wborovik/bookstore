package com.example.bookstore.domain.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_sequence")
    @SequenceGenerator(name = "global_sequence", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
}