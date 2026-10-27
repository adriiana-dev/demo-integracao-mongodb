package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Professor;
import com.example.demo_integracao_mongodb.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public Professor cadastrar(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @GetMapping
    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Professor> buscarPorId(@PathVariable String id) {
        return professorRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable String id, @RequestBody Professor professor) {
        professor.setId(id);
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        professorRepository.deleteById(id);
    }
}