package com.example.bookstore.controller.common;

import com.example.bookstore.domain.common.AbstractEntity;
import com.example.bookstore.util.PageSetting;
import com.example.bookstore.repository.common.AbstractRepository;
import com.example.bookstore.service.common.AbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RequiredArgsConstructor
public abstract class AbstractController<T extends AbstractEntity, S extends AbstractService<T, R>, R extends AbstractRepository<T>> {
    protected final S service;

//    @GetMapping
//    public List<T> getAllEntities() {
//        return service.getAllEntities();
//    }

//    @GetMapping("/page")
//    public Page<T> getAllWithPaginationAndSorting(@PathVariable int page, @PathVariable int size,
//                                                  @PathVariable String field, @PathVariable boolean isDesc) {
//        return service.getAllWithPaginationAndSorting(page, size, field, isDesc);
//    }

    @GetMapping
    public Page<T> getAllEntities(PageSetting pageSettings) {
        return service.getAllEntities(pageSettings);
    }
    @GetMapping("{id}")
    public T getEntityById(@PathVariable Long id) {
        return service.getEntityById(id);
    }

    @PostMapping
    public T createEntity(@RequestBody T entity) {
        return service.createEntity(entity);
    }

    @PatchMapping("{id}")
    public T updateEntityById(@PathVariable Long id, @RequestBody T entity) {
        return service.updateEntityById(id, entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEntityById(@PathVariable Long id) {
        service.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}