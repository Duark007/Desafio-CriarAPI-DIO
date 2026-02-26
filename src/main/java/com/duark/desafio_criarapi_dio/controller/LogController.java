package com.duark.desafio_criarapi_dio.controller;

import com.duark.desafio_criarapi_dio.entity.ConsumptionLog;
import com.duark.desafio_criarapi_dio.repository.ConsumptionLogRepository;
import com.duark.desafio_criarapi_dio.service.ConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor // Com isso, você não precisa de @Autowired em cada campo
public class LogController {

    private final ConsumptionService service;
    private final ConsumptionLogRepository repository;

    @PostMapping
    public ResponseEntity<ConsumptionLog> registrar(@RequestBody LogRequestDTO dto) {
        // O service já faz tudo e retorna o objeto pronto
        ConsumptionLog logSalvo = service.registrarConsumo(dto.usuarioId(), dto.atividadeId(), dto.quantidade());
        return ResponseEntity.status(HttpStatus.CREATED).body(logSalvo);
    }

    @GetMapping
    public List<ConsumptionLog> listarTodos() {
        return repository.findAll();
    }
}

record LogRequestDTO(Long usuarioId, Long atividadeId, Double quantidade) {}