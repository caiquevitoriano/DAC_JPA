/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author caique
 */
@Entity
public class Autor extends Pessoa {

    private String instituicaoVinculada;

    @ManyToMany
    @JoinTable(name = "AUTOR_LIVRO", joinColumns
            = {
                @JoinColumn(name = "autor_id")}, inverseJoinColumns
            = {
                @JoinColumn(name = "livro_id")})
    private List<Livro> livros;

    public Autor() {
        this.livros = new ArrayList<>();
    }

    public Autor(String instituicaoVinculada, List<Livro> livros, String cpf, String nome, int idade, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, nome, idade, dataNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = livros;
    }

    public Autor(String instituicaoVinculada, String cpf, String nome, int idade, LocalDate dataNascimento, Endereco endereco) {
        super(cpf, nome, idade, dataNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = new ArrayList<>();
    }

    public String getInstituicaoVinculada() {
        return instituicaoVinculada;
    }

    public void setInstituicaoVinculada(String instituicaoVinculada) {
        this.instituicaoVinculada = instituicaoVinculada;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
