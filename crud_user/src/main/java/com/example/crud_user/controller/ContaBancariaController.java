package com.example.crud_user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_user.model.ContaBancaria;
import com.example.crud_user.service.ContaBancariaService;

@RestController
@RequestMapping("/contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService service;

    @PostMapping
    public ResponseEntity<ContaBancaria> criarConta(@RequestBody ContaBancaria conta) {
        return ResponseEntity.ok(service.criarConta(conta));
    }

    @GetMapping
    public List<ContaBancaria> buscarTodas() {
        return service.buscarTodasContas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarContaPorId(id));
    }

    @PutMapping("/{id}/depositar")
    public ResponseEntity<ContaBancaria> depositar(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        return ResponseEntity.ok(service.depositar(id, payload.get("valor")));
    }

    @PutMapping("/{id}/sacar")
    public ResponseEntity<ContaBancaria> sacar(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        return ResponseEntity.ok(service.sacar(id, payload.get("valor")));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ContaBancaria> alterarStatus(@PathVariable Long id, @RequestParam boolean ativa) {
        return ResponseEntity.ok(service.ativarDesativarConta(id, ativa));
    }
}
