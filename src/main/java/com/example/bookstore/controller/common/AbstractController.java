package com.example.bookstore.controller.common;

import com.example.bookstore.domain.common.AbstractEntity;
import com.example.bookstore.repository.common.AbstractRepository;
import com.example.bookstore.service.common.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
public abstract class AbstractController<T extends AbstractEntity, S extends AbstractService<T, R>, R extends AbstractRepository<T>> {
    protected final S service;

    @GetMapping("{id}")
    public T getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    @PostMapping
    public T createEntity(@RequestBody T entity) throws Exception {
        return service.createEntity(entity);
    }

    @PatchMapping("{id}")
    public T updateEntityById(@PathVariable Long id, @RequestBody T entity) throws Exception {
        return service.updateEntityById(id, entity);
    }
}