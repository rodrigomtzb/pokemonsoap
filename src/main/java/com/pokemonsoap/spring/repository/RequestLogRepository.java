package com.pokemonsoap.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemonsoap.spring.entity.RequestLog;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
}
