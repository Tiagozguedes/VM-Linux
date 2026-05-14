package br.com.portalweb.controller;

import br.com.portalweb.entity.Aluno;
import br.com.portalweb.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    private AlunoService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("alunos", service.listarTodos());
        model.addAttribute("aluno", new Aluno());
        return "index";
    }
}
