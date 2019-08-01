package domain;

import domain.Autor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-08-01T16:13:16")
@StaticMetamodel(Livro.class)
public class Livro_ { 

    public static volatile SingularAttribute<Livro, Date> lancamento;
    public static volatile SingularAttribute<Livro, String> ISBN;
    public static volatile SingularAttribute<Livro, String> nome;
    public static volatile ListAttribute<Livro, Autor> autores;

}