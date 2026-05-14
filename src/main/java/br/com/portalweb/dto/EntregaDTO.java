package br.com.portalweb.dto;

import jakarta.validation.constraints.NotBlank;

public class EntregaDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String rm;

    @NotBlank
    private String turma;

    public EntregaDTO() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getRm() { return rm; }
    public void setRm(String rm) { this.rm = rm; }

    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }
}
