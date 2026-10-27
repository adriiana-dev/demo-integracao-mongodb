package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Curso;
import com.example.demo_integracao_mongodb.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repo;

    @PostMapping
    public Curso inserir(@RequestBody Curso c) {
        return repo.save(c);
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> consultarPorId(@PathVariable String id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public Curso alterar(@PathVariable String id, @RequestBody Curso c) {
        c.setId(id);
        return repo.save(c);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable String id) {
        repo.deleteById(id);
    }
}