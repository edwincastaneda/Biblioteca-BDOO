package biblioteca;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Autor implements Serializable {
    @Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellidos;

    public Autor( String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
}