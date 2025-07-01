package com.example.crud_user.repository;

import com.example.crud_user.model.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
}