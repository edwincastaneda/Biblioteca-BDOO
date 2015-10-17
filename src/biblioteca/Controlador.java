package biblioteca;

import java.util.List;
import javax.persistence.*;

public class Controlador {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void creaBD() {
        this.emf = Persistence.createEntityManagerFactory("$objectdb/db/biblioteca.odb");
        this.em = this.emf.createEntityManager();
    }

    public void cerrarBD() {
        this.em.close();
        this.emf.close();
    }

    public void insertaAutores(String nombre, String apellidos) {
        this.em.getTransaction().begin();
        Autor autor = new Autor(nombre, apellidos);
        this.em.persist(autor);
        this.em.getTransaction().commit();
    }

    public void insertaEditoriales(String nombre, String pais) {
        this.em.getTransaction().begin();
        Editorial editorial = new Editorial(nombre, pais);
        this.em.persist(editorial);
        this.em.getTransaction().commit();
    }

    public void insertaLibros(String nombre, String isbn, String idAutor, String idEditorial) {
        this.em.getTransaction().begin();
        //Obtengo el Autor del libro
        String qryAutor = "SELECT a FROM Autor AS a WHERE id in (" + idAutor + ")";
        TypedQuery<Autor> queryAutorLibro = this.em.createQuery(qryAutor, Autor.class);
        List<Autor> autorLibro = queryAutorLibro.getResultList();

        //Obtengo la casa editora del libro
        String qryEditorial = "SELECT e FROM Editorial AS e WHERE id=" + idEditorial;
        TypedQuery<Editorial> queryEditorialLibro = this.em.createQuery(qryEditorial, Editorial.class);
        Editorial editorialLibro = queryEditorialLibro.getSingleResult();

        Libro libro = new Libro(nombre, isbn, editorialLibro, autorLibro);
        this.em.persist(libro);
        this.em.getTransaction().commit();
    }
}
