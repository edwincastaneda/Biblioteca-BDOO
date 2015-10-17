package biblioteca;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Edwin Castañeda
 */

@Entity
public class Editorial implements Serializable{
    @Id @GeneratedValue
    private Integer id;
    private String nombre;
    private String pais;

    public Editorial(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", pais=" + pais + '}';
    }
    
    
}
