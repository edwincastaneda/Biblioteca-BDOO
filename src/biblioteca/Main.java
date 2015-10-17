package biblioteca;

import java.util.List;
import javax.persistence.*;

public class Main {

    private EntityManagerFactory emf;
    private EntityManager em;

    public static void main(String[] args) {

        Main main = new Main();

        main.creaBD();

        // EDITORIALES
        main.insertaEditoriales("Little, Brown and Company", "EE. UU.");
        main.insertaEditoriales("Scholastic","EE. UU.");        
        main.insertaEditoriales("Maclay & Assoc","EE. UU.");
        
        // AUTORES
        main.insertaAutores("Stephenie","Meyer");
        main.insertaAutores("J. K.","Rowling");
        main.insertaAutores("Suzanne","Collins");
        main.insertaAutores("Stephen","King");
        main.insertaAutores("Ramsey","Campbell");
        main.insertaAutores("William F","Nolan");
        main.insertaAutores("Robert","Bloch");
        main.insertaAutores("Richard","Matheson");
        main.insertaAutores("David B.","Silva");
        main.insertaAutores("G. Wayne","Miller");
        main.insertaAutores("James","Kisner");
        main.insertaAutores("John","Kisner");
        main.insertaAutores("Douglas E.","Winter");
        main.insertaAutores("Richard Christian","Matheson");
        main.insertaAutores("Ray","Russell");
        main.insertaAutores("Stanley","Wiater");
        main.insertaAutores("Joe R.","Lansdale");
        main.insertaAutores("Katherine Marie","Ramsland");
        main.insertaAutores("Mort","Castle");
        main.insertaAutores("James","Herbert");
        main.insertaAutores("Dennis","Hamilton");
        main.insertaAutores("Charles R.","Saunders");
        main.insertaAutores("Ardath","Mayhar");
        main.insertaAutores("Steve Rasnic","Tem");
        main.insertaAutores("Thomas F.","Monteleone");
        main.insertaAutores("John Robert","Bensink");
        main.insertaAutores("J. N.","Williamson");
        main.insertaAutores("Thomas","Sullivan");
        main.insertaAutores("Alan","Rodgers");
        
        // LIBROS
        main.insertaLibros("The Hunger Games",  "2-266-18269-2, 0-439-02348-3", "6","2");
        main.insertaLibros("Masques II: All-New Stories of Horror and the Supernatural", "978-0940776241, 0940776243", "7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32","3");
        
        main.cerrarBD();
 
    }

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
        String qryAutor="SELECT a FROM Autor AS a WHERE id in (" + idAutor + ")";
        TypedQuery<Autor> queryAutorLibro = this.em.createQuery(qryAutor, Autor.class);
        List<Autor> autorLibro = queryAutorLibro.getResultList();

        //Obtengo la casa editora del libro
        String qryEditorial="SELECT e FROM Editorial AS e WHERE id=" + idEditorial;
        TypedQuery<Editorial> queryEditorialLibro = this.em.createQuery(qryEditorial, Editorial.class);
        Editorial editorialLibro = queryEditorialLibro.getSingleResult();

        Libro libro = new Libro(nombre, isbn, editorialLibro, autorLibro);
        this.em.persist(libro);
        this.em.getTransaction().commit();
    }

}
