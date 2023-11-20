package com.example.bookstore.domain.common;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditEntity extends AbstractEntity {
    @NotNull
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime changed;
    @Version
    private int version;

    @PrePersist
    private void prePersist() {
        if (Objects.nonNull(changed) && changed.equals(created)) {
            changed = null;
        }
    }

    @PreUpdate
    private void preUpdate() {
        prePersist();
    }
}