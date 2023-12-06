package com.example.bookstore.service.common;

import com.example.bookstore.domain.common.AbstractEntity;
import com.example.bookstore.repository.common.AbstractRepository;
import com.example.bookstore.util.PageSetting;
import com.example.bookstore.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
public abstract class AbstractService<T extends AbstractEntity, R extends AbstractRepository<T>> {
    protected final R repository;

    public Page<T> getAllEntities(PageSetting pageSetting) {
        return repository.findAll(pageSetting.getPageable());
    }

    public T getEntityById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Entity with identifier %s does not exist", id)));
    }

    public T updateEntityById(Long id, T entity, String... ignoredFields) {
        T entityUpdate = getEntityById(id);
        Utils.copyNonNullProperties(entity, entityUpdate, ignoredFields);
        return createEntity(entityUpdate);
    }

    public T createEntity(T entity) {
        return repository.save(entity);
    }

    public void deleteEntityById(Long id) {
        repository.delete(getEntityById(id));
    }
}