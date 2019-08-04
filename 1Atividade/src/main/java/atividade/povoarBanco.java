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
import domain.Professor;
import domain.Telefone;
import domain.TelefoneType;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author caique
 */
public class povoarBanco {

    private final EntityManager em;

    public povoarBanco(EntityManager em) {
        this.em = em;
    }

    public void dadosIniciais() {

        Endereco end1 = new Endereco("PROTAZIO DE SOUSA", "JARDIM OASIS", "CAJAZEIRAS", "58900-000");
        Endereco end2 = new Endereco("CLOVES ROLIM", "CENTRO", "SANTA HELENA", "58925-000");
        Endereco end3 = new Endereco("NA RUSSIA", "RUSSIA", "RUSSIA", "11111-000");
        Endereco end4 = new Endereco("QUE ATIVIDADE FACIL", "MENTIRA", "É NÃO", "00000-000");

        Aluno aluno1 = new Aluno(
                "CAIQUE VITORIANO",
                "123.123.123-12",
                22,
                LocalDate.of(1997, 04, 27),
                end1,
                "111",
                LocalDate.of(2012, 04, 21),
                "ads"
        );

        Aluno aluno2 = new Aluno(
                "TEREZINHA DE JESUS",
                "222.222.222-22",
                50,
                LocalDate.of(1977, 02, 11),
                end2,
                "222",
                LocalDate.of(1997, 04, 21),
                "ads"
        );

        Livro livro1 = new Livro("EU, ROBÔ", "111-1", LocalDate.of(1950, 01, 01));
        Livro livro2 = new Livro("A FUNDAÇÃO", "222-2", LocalDate.of(1958, 01, 01));
        Livro livro3 = new Livro("VISÕES DE ROBÔ", "333-3", LocalDate.of(1990, 01, 01));
        Livro livro4 = new Livro("Biblia", "444-4", LocalDate.of(1300, 01, 01));
        
        List<Livro> livrosJesus = new ArrayList<>();
        livrosJesus.add(livro4);

        List<Livro> livrosIsimov = new ArrayList<>();

        livrosIsimov.add(livro3);
        livrosIsimov.add(livro1);
        livrosIsimov.add(livro2);

        Autor autor1 = new Autor(
                "UFIP",
                "333.333.333-33",
                "ALEXA LINS",
                22,
                LocalDate.of(1997, 05, 06),
                end1
        );

        Autor autor2 = new Autor(
                "UFURSS",
                "444.444.444-44",
                "ISAAC ISIMOV",
                22,
                LocalDate.of(1982, 11, 21),
                end3);

        autor2.setLivros(livrosIsimov);

        Autor autor3 = new Autor("IFPB", livrosIsimov, "555.555.555-55", "AUTOR DESCONHECIDO", 80, LocalDate.of(1500, 11, 25), end3);
        Autor autor4 = new Autor("CEU", livrosJesus, "999.999.999-99", "JESUS", 80, LocalDate.of(0001, 12, 25), end4);
        autor4.setLivros(livrosJesus);
        
        
        Telefone tele1 = new Telefone("9999-9988", TelefoneType.RESIDENCIAL);
        List<Telefone> telefones1 = new ArrayList<>();
        telefones1.add(tele1);
        Professor prof1 = new Professor("666.666.666-66", "José Vitoriano Neto", 50, LocalDate.of(1960, 11, 11), end2);
        prof1.setTelefones(telefones1);

        Telefone tele2 = new Telefone("9999-9999", TelefoneType.RESIDENCIAL);
        List<Telefone> telefones2 = new ArrayList<>();
        telefones2.add(tele2);
        Professor prof2 = new Professor("777.777.777-77", "Francisco Ferreira", 30, LocalDate.of(1989, 11, 01), end2);
        prof2.setTelefones(telefones2);

        Professor prof3 = new Professor("888.888.888-88", "Ana Cavalcante", 47, LocalDate.of(1979, 12, 01), end4);
        prof3.setTelefones(telefones2);

        em.getTransaction().begin();
//        em.persist(livro4);
//        em.persist(autor4);
        //  em.persist(prof3);
//        em.persist(tele1);
//        em.persist(prof1);
//        em.persist(tele2);
//        em.persist(prof2);
//        em.persist(aluno1);
//        em.persist(aluno2);
//        em.persist(livro1);
//        em.persist(livro2);
//        em.persist(livro3);
//        em.persist(autor1);
//        em.persist(autor2);
//        em.persist(autor3);
        em.getTransaction().commit();

    }

}
