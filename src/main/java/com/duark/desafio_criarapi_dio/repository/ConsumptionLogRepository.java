package com.duark.desafio_criarapi_dio.repository;

import com.duark.desafio_criarapi_dio.entity.ConsumptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {}
