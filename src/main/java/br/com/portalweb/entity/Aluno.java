package br.com.portalweb.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "t_aluno")
public class Aluno {

    @Id
    @Column(name = "rm_aluno", length = 20)
    @NotBlank(message = "RM e obrigatorio")
    private String rmAluno;

    @Column(name = "nm_aluno", length = 100, nullable = false)
    @NotBlank(message = "Nome e obrigatorio")
    private String nmAluno;

    @Column(name = "ds_turma", length = 20, nullable = false)
    @NotBlank(message = "Turma e obrigatoria")
    private String dsTurma;

    @Column(name = "ds_email", length = 100)
    private String dsEmail;

    public Aluno() {}

    public Aluno(String rmAluno, String nmAluno, String dsTurma, String dsEmail) {
        this.rmAluno = rmAluno;
        this.nmAluno = nmAluno;
        this.dsTurma = dsTurma;
        this.dsEmail = dsEmail;
    }

    public String getRmAluno() { return rmAluno; }
    public void setRmAluno(String rmAluno) { this.rmAluno = rmAluno; }

    public String getNmAluno() { return nmAluno; }
    public void setNmAluno(String nmAluno) { this.nmAluno = nmAluno; }

    public String getDsTurma() { return dsTurma; }
    public void setDsTurma(String dsTurma) { this.dsTurma = dsTurma; }

    public String getDsEmail() { return dsEmail; }
    public void setDsEmail(String dsEmail) { this.dsEmail = dsEmail; }
}
