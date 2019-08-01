/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author caique
 */
@Entity
public class Aluno extends Pessoa{
    private String matricula;
    @Temporal(TemporalType.DATE)
    private Date dataIngresso;
    private String turma;

 public Aluno(String nome, String cpf, int idade, Date dataNascimento, Endereco endereco, String matricula,
			Date dataIngreso, String turma) {
		super(nome, cpf, idade, dataNascimento, endereco);
		this.matricula = matricula;
		this.dataIngresso = dataIngreso;
		this.turma = turma;
	}

	public String getmatricula() {
        return matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    
    
    
    
}
