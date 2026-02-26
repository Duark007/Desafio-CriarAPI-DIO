package com.duark.desafio_criarapi_dio.controller;

import com.duark.desafio_criarapi_dio.entity.User;
import com.duark.desafio_criarapi_dio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;

    @PostMapping
    public ResponseEntity<User> criar(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    @GetMapping
    public List<User> listar() {
        return repository.findAll();
    }
}