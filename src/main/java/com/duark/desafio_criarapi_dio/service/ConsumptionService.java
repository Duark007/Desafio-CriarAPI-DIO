package com.duark.desafio_criarapi_dio.service;

import com.duark.desafio_criarapi_dio.entity.ActivityType;
import com.duark.desafio_criarapi_dio.entity.ConsumptionLog;
import com.duark.desafio_criarapi_dio.entity.User;
import com.duark.desafio_criarapi_dio.repository.ActivityTypeRepository;
import com.duark.desafio_criarapi_dio.repository.ConsumptionLogRepository;
import com.duark.desafio_criarapi_dio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConsumptionService {

    private final ConsumptionLogRepository consumptionLogRepository;
    private final UserRepository userRepository;
    private final ActivityTypeRepository activityRepository;

    public ConsumptionLog registrarConsumo(Long usuarioId, Long atividadeId, Double quantidade) {
        // Busca as entidades
        User user = userRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        ActivityType activity = activityRepository.findById(atividadeId)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));

        // Cria e calcula
        ConsumptionLog log = new ConsumptionLog();
        log.setUsuario(user);
        log.setAtividade(activity);
        log.setQuantidade(quantidade);
        log.setData(LocalDateTime.now());
        log.setTotalCarbonoGerado(quantidade * activity.getFatorEmissao());

        // Salva apenas UMA vez aqui
        return consumptionLogRepository.save(log);
    }
}
