package biblioteca;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Libro implements Serializable {
    @Id @GeneratedValue
    private Integer id;
    private String titulo;
    private String isbn;
 
    @ManyToOne
    private Editorial editorial;
 
    @ManyToMany
    private List<Autor> autores;

    public Libro(String titulo, String isbn, Editorial editorial, List<Autor> autores) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.autores = autores;
    }   
}