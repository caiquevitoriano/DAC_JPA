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

//        new povoarBanco(em).dadosIniciais();

//        letraA(em);
//        letraB(em);
//        letraC(em);
//        letraD(em);
//        letraE(em);
//        letraF(em);
    }
    
//    a. Uma consulta que selecione todos os livros dos autores que não nasceram no dia
//       21/11/1982.
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

//    b. Uma consulta que selecione todos os professores que possuem Telefone e residem
//       na rua “Que atividade fácil”.
    private static void letraB(EntityManager em) {

        String jpql = "SELECT DISTINCT(p) FROM Professor p, IN (p.telefones) t WHERE p.endereco.rua = :nomeRua";

        TypedQuery<Professor> query = em.createQuery(jpql, Professor.class);
        query.setParameter("nomeRua", "QUE ATIVIDADE FACIL");
        List<Professor> professores = query.getResultList();
        for (Professor professor : professores) {
            System.out.println(professor.getNome());
        }
    }

//    c. Uma classe, AlunoVO, que representa o nome, CPF e idade do Aluno. Crie uma
//       consulta, que retorna uma lista de todos os AlunoVO, selecionando todos os alunos
//       que pertencem a turma de 2019.1.
    private static void letraC(EntityManager em) {
        String jpql = "SELECT cpf, nome, idade FROM Aluno a "
                + " WHERE a.turma = #turma ";

        Query query = em.createNativeQuery(jpql, "AlunoVO");
        query.setParameter("turma", "2019.1");

        List<AlunoVO> resultList = query.getResultList();

        for (AlunoVO alunoVO : resultList) {
            System.out.println(alunoVO.toString());
        }
    }

//    d. Uma consulta que seleciona todas os Professores que possuem algum telefone
//       que termina em 8.
    private static void letraD(EntityManager em) {
        String jpql = "SELECT p FROM Professor p, IN(p.telefones) t WHERE t.numero like :numFinal ";

        Query query = em.createQuery(jpql, Professor.class);
        query.setParameter("numFinal", "%8");

        List<Professor> resulList = query.getResultList();
        for (Professor professor : resulList) {
            System.out.println(professor.getNome());
        }
    }

//    e. Uma consulta que seleciona todos os livros dos Autores da cidade de Cajazeiras e
//       tiveram seu lançamento entre os dias 01/01/2019 e 12/12/2019.
    private static void letraE(EntityManager em) {

        String jpql = "SELECT l FROM Livro l JOIN l.autores a WHERE a.endereco.cidade = :cidade AND "
                + "l.lancamento BETWEEN :data1 AND :data2";

        Query query = em.createQuery(jpql, Livro.class);
        query.setParameter("cidade", "CAJAZEIRAS-PB");
    	query.setParameter("data1", LocalDate.of(2019, 01, 01));
    	query.setParameter("data2", LocalDate.of(2019, 12, 12));

        List<Livro> resulList = query.getResultList();

        for (Livro livro : resulList) {
            System.out.println(livro.getNome());
        }
    }

//    f. Uma consulta que selecione os Livros dos Autores que começam com a letra “J”.
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

}
