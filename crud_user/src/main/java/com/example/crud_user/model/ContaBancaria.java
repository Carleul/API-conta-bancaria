package com.example.crud_user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroConta;

    private String nomeTitular;

    private Double saldo = 0.0;

    private boolean ativa = true;

    // Construtor vazio obrigatório para JPA
    public ContaBancaria() {}

    // Construtor com atributos (exceto id e saldo inicial)
    public ContaBancaria(String numeroConta, String nomeTitular, boolean ativa) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.ativa = ativa;
        this.saldo = 0.0;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    // Métodos de negócio
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser positivo.");
        }
        if (valor > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        this.saldo -= valor;
    }
}
