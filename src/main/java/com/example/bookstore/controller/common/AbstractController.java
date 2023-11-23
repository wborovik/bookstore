package com.example.bookstore.controller.common;

import com.example.bookstore.domain.common.AbstractEntity;
import com.example.bookstore.repository.common.AbstractRepository;
import com.example.bookstore.service.common.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RequiredArgsConstructor
public abstract class AbstractController<T extends AbstractEntity, S extends AbstractService<T, R>, R extends AbstractRepository<T>> {
    protected final S service;

    @GetMapping
    public List<T> getAllEntities() {
        return service.getAllEntities();
    }

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

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEntityById(@PathVariable Long id) {
        service.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}