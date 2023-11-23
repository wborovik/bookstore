package com.example.bookstore.service.common;

import com.example.bookstore.domain.common.AbstractEntity;
import com.example.bookstore.repository.common.AbstractRepository;
import com.example.bookstore.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractService<T extends AbstractEntity, R extends AbstractRepository<T>> {
    protected final R repository;

    public List<T> getAllEntities() {
        return repository.findAll();
    }

    public T getEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            log.error(String.format("Error: object with identifier %s does not exist in the database", id));
            return new EntityNotFoundException("Entity id not found: " + id);
        });
    }

    public T updateEntityById(Long id, T entity, String... ignoredFields) throws Exception {
        T entityUpdate = getEntityById(id);
        Utils.copyNonNullProperties(entity, entityUpdate, ignoredFields);
        return createEntity(entityUpdate);
    }

    public T createEntity(T entity) throws Exception {
        return repository.save(entity);
    }

    public void deleteEntityById(Long id) {
        repository.delete(getEntityById(id));
    }
}