package com.cloudap1delivery.cloudap1delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudap1delivery.cloudap1delivery.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    long countByCpf(String cpf);
    long countByEmail(String cpf);
}
