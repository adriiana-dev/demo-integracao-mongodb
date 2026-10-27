package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Estudante;
import com.example.demo_integracao_mongodb.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteRepository repo;

    @PostMapping
    public Estudante inserir(@RequestBody Estudante e) {
        return repo.save(e);
    }

    @GetMapping
    public List<Estudante> listarTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudante> consultarPorId(@PathVariable String id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public Estudante alterar(@PathVariable String id, @RequestBody Estudante e) {
        e.setId(id);
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id) {
        repo.deleteById(id);
    }
}