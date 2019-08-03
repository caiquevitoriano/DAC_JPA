/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author caique
 */
@Entity
public class Professor extends Pessoa {

    private Double salario;
    private List<Telefone> telefones;

    public Professor() {
    }

    public Professor(String nome, String cpf, int idade, LocalDate dataNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataNascimento, endereco);
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

}
