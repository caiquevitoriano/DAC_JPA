/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import convert.ConvertLocalDate;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author caique
 */


@SqlResultSetMapping(
		name = "AlunoVO",
		classes = @ConstructorResult(
				targetClass = AlunoVO.class,
				columns= {
						@ColumnResult(name = "nome"),
						@ColumnResult(name = "cpf"),
                                                @ColumnResult(name = "idade")
				})
)

@Entity
public class Aluno extends Pessoa {

    private String matricula;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate dataIngresso;
    private String turma;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, int idade, LocalDate dataNascimento, Endereco endereco, String matricula,
            LocalDate dataIngreso, String turma) {
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

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
