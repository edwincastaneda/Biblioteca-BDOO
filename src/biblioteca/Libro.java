package biblioteca;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author Edwin Castañeda
 */

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



    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", editorial=" + editorial + ", autores=" + autores + '}';
    }
    
    
    
}