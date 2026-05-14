package br.com.portalweb.service;

import br.com.portalweb.entity.Aluno;
import br.com.portalweb.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Optional<Aluno> buscarPorRm(String rmAluno) {
        return repository.findById(rmAluno);
    }

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    public Optional<Aluno> atualizar(String rmAluno, Aluno dados) {
        return repository.findById(rmAluno).map(existente -> {
            existente.setNmAluno(dados.getNmAluno());
            existente.setDsTurma(dados.getDsTurma());
            existente.setDsEmail(dados.getDsEmail());
            return repository.save(existente);
        });
    }

    public boolean excluir(String rmAluno) {
        if (!repository.existsById(rmAluno)) {
            return false;
        }
        repository.deleteById(rmAluno);
        return true;
    }
}
