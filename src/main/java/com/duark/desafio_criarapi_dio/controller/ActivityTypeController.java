package com.duark.desafio_criarapi_dio.controller;

import com.duark.desafio_criarapi_dio.entity.ActivityType;
import com.duark.desafio_criarapi_dio.repository.ActivityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades") // Melhor usar um path substantivo no plural
@RequiredArgsConstructor // Cria o construtor para o repository automaticamente
public class ActivityTypeController {

    private final ActivityTypeRepository repository;

    @PostMapping
    public ResponseEntity<ActivityType> criar(@RequestBody ActivityType activityType) {
        ActivityType novaAtividade = repository.save(activityType);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAtividade);
    }

    @GetMapping
    public ResponseEntity<List<ActivityType>> listarTodas() {
        return ResponseEntity.ok(repository.findAll());
    }
}