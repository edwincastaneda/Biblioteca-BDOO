package biblioteca;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Edwin Castañeda
 */

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

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

    
}