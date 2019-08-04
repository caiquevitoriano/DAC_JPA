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
import domain.Telefone;
import java.time.Instant;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import jdk.nashorn.internal.objects.NativeRegExp;

/**
 *
 * @author caique
 */
public class AppCriteria {

    public static void main(String[] args) {

        EntityManager em = Persistence
                .createEntityManagerFactory("atividade1")
                .createEntityManager();

        //new povoarBanco(em).dadosIniciais();
        letraA(em);
//        letraB(em);
//        letraC(em);
//        letraD(em);
//        letraE(em);
//        letraF(em);
    }

    private static void letraA(EntityManager em) {
//      String jpql = "SELECT DISTINCT(l) FROM Livro l IN(l.autores) a"
//              + " WHERE NOT (a.dataNascimento = :nasc)";

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
        Root<Livro> root = criteria.from(Livro.class);
        
        Join<Livro, Autor> join = root.join("autores", JoinType.LEFT);
        Predicate dataNascimento = builder.notEqual(join.get("dataNascimento"), LocalDate.of(1982, 11, 12));
        criteria.distinct(true).where(dataNascimento);
        
        em.createQuery(criteria).getResultList().forEach(
                l-> System.out.println(l.getNome())
        );
    }

    private static void letraB(EntityManager em) {

//      String jpql = "SELECT DISTINCT(p) FROM Professor p, IN (p.telefones) t WHERE p.endereco.rua = :nomeRua";
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Professor> criteria = builder.createQuery(Professor.class);
        Root<Professor> root = criteria.from(Professor.class);

        Predicate rua = builder.equal(root.get("endereco").get("rua"), "QUE ATIVIDADE FACIL");
        Join<Professor, Telefone> join = root.join("telefones", JoinType.LEFT);
        Predicate telefone = builder.isNotNull(join.get("numero"));
        criteria.where(rua, telefone);

        TypedQuery<Professor> query = em.createQuery(criteria);
        query.getResultList().forEach(
                p -> System.out.println(p.getNome())
        );

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

    private static void letraD(EntityManager em) {
        String jpql = "SELECT p FROM Professor p, IN(p.telefones) t WHERE t.numero like :numFinal ";

        Query query = em.createQuery(jpql, Professor.class);
        query.setParameter("numFinal", "%8");

        List<Professor> resulList = query.getResultList();
        for (Professor professor : resulList) {
            System.out.println(professor.getNome());
        }
    }

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
