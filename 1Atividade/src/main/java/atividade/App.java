/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade;

import domain.Aluno;
import domain.Autor;
import domain.Endereco;
import domain.Livro;
import domain.Pessoa;
import domain.Professor;
import java.time.Instant;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author caique
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("atividade1")
                .createEntityManager();
        
    //new povoarBanco(em).dadosIniciais();
        
    letraD(em);

    }

    
    private static void letraD(EntityManager em) {    	
    	String jpql = "SELECT p FROM Professor p, IN(p.telefones) t WHERE t.numero like :numFinal ";
    	
        Query query = em.createQuery(jpql, Professor.class);
    	query.setParameter("numFinal", "%8");
        
    	List<Professor> resulList = query.getResultList();
    	for (Professor professor : resulList) {
			System.out.println(professor.getNome());
		}
    }
    

}
