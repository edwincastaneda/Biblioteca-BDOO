package biblioteca;

import java.io.Serializable;
import javax.persistence.*;

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
}
