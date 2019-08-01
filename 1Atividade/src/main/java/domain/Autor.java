/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author caique
 */
@Entity
public class Autor extends Pessoa{
    
        private String instituicaoVinculada;
        private List<Livro> livros;

    public Autor() {
    } 

    public Autor(String instituicaoVinculada, List<Livro> livros, String nome, String cpf, int idade, Date dataNascimento, Endereco endereco) {
        super(nome, cpf, idade, dataNascimento, endereco);
        this.instituicaoVinculada = instituicaoVinculada;
        this.livros = livros;
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
