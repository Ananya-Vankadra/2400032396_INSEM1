
package com.example.jwt.controller;

import com.example.jwt.entity.UserRecord;
import com.example.jwt.repository.UserRecordRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final UserRecordRepository repository;

    public HelloController(UserRecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/check/{id}")
    public ResponseEntity<UserRecord> hello(@PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
