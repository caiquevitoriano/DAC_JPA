/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade;
import domain.AlunoVO;

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
import jdk.nashorn.internal.objects.NativeRegExp;

/**
 *
 * @author caique
 */
public class App {

    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("atividade1")
                .createEntityManager();

        new povoarBanco(em).dadosIniciais();
//    letraB(em);  
//    letraD(em);
//    letraF(em);
//    letraE(em);
//    letraA(em);
        letraC(em);
    }

    private static void letraB(EntityManager em) {

        String jpql = "SELECT DISTINCT(p) FROM Professor p, IN (p.telefones) t WHERE p.endereco.rua = :nomeRua";

        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.setParameter("nomeRua", "QUE ATIVIDADE FACIL");
        List<Professor> professores = query.getResultList();
        for (Professor professor : professores) {
            System.out.println(professor.getNome());
        }
    }

    // buscar
    private static void letraD(EntityManager em) {
        String jpql = "SELECT p FROM Professor p, IN(p.telefones) t WHERE t.numero like :numFinal ";

        Query query = em.createQuery(jpql, Professor.class);
        query.setParameter("numFinal", "%8");

        List<Professor> resulList = query.getResultList();
        for (Professor professor : resulList) {
            System.out.println(professor.getNome());
        }
    }

    private static void letraF(EntityManager em) {

        String jpql = "SELECT l FROM Livro l, "
                + " IN (l.autores) a"
                + " WHERE a.nome = 'J%'";
        Query query = em.createQuery(jpql, Livro.class);
//    	query.setParameter("nome", "J%");
        List<Livro> resulList = query.getResultList();

        for (Livro livro : resulList) {
            System.out.println(livro.getNome());
        }

    }

    // falta passar o intervalo de lançamento do livro 
    private static void letraE(EntityManager em) {

        String jpql = "SELECT l FROM Livro l JOIN l.autores a WHERE a.endereco.cidade = 'RUSSIA'";

        Query query = em.createQuery(jpql, Livro.class);

        List<Livro> resulList = query.getResultList();

        for (Livro livro : resulList) {
            System.out.println(livro.getNome());
        }
    }

    private static void letraA(EntityManager em) {
        String jpql = "SELECT DISTINCT(l) FROM Livro l IN(l.autores) a"
                + " WHERE NOT (a.dataNascimento = :nasc)";
        TypedQuery<Livro> query = em.createQuery(jpql, Livro.class);
        query.setParameter("nasc", LocalDate.of(1982, 11, 21));
        List<Livro> resulList = query.getResultList();

        for (Livro livro : resulList) {
            System.out.println(livro.getNome());
        }
    }

    private static void letraC(EntityManager em) {
        String jpql = "SELECT cpf, nome, idade FROM Aluno a "
                + " WHERE a.turma = #turma "; 
        
        Query query = em.createNativeQuery(jpql, "AlunoVO");
        query.setParameter("turma", "2019.1");
        
        List<AlunoVO> resultList = query.getResultList();

        for (AlunoVO alunoVO : resultList) {
            System.out.println(alunoVO.getNome());
        }
    }

}
