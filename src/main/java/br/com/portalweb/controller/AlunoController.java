package br.com.portalweb.controller;

import br.com.portalweb.entity.Aluno;
import br.com.portalweb.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<Aluno> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{rmAluno}")
    public ResponseEntity<Aluno> buscar(@PathVariable String rmAluno) {
        return service.buscarPorRm(rmAluno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@Valid @RequestBody Aluno aluno) {
        Aluno salvo = service.salvar(aluno);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{rmAluno}")
    public ResponseEntity<Aluno> atualizar(@PathVariable String rmAluno, @Valid @RequestBody Aluno aluno) {
        return service.atualizar(rmAluno, aluno)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{rmAluno}")
    public ResponseEntity<Void> excluir(@PathVariable String rmAluno) {
        if (service.excluir(rmAluno)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
