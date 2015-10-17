package biblioteca;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Edwin Castañeda
 */

public class Main {

    public static void main(String[] args) {    
        
        //crear la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/biblioteca.odb");
        EntityManager em = emf.createEntityManager();
        
        
        em.getTransaction().begin();
        
        //Crea Editoriales
        Editorial editorial1 = new Editorial("Little, Brown and Company","EE. UU.");
        Editorial editorial2 = new Editorial("Scholastic","EE. UU.");
        Editorial editorial3 = new Editorial("Maclay & Assoc","EE. UU.");
        em.persist(editorial1);
        em.persist(editorial2);
        em.persist(editorial3);
        
        //Crea Autores
        Autor autor1 = new Autor("Stephenie","Meyer");
        Autor autor2 = new Autor("J. K.","Rowling");
        Autor autor3 = new Autor("Suzanne","Collins");
        Autor autor4 = new Autor("Stephen","King");
        Autor autor5 = new Autor("Ramsey","Campbell");
        Autor autor6 = new Autor("William F","Nolan");
        Autor autor7 = new Autor("Robert","Bloch");
        Autor autor8 = new Autor("Richard","Matheson");
        Autor autor9 = new Autor("David B.","Silva");
        Autor autor10 = new Autor("G. Wayne","Miller");
        Autor autor11 = new Autor("James","Kisner");
        Autor autor12 = new Autor("John","Kisner");
        Autor autor13 = new Autor("Douglas E.","Winter");
        Autor autor14 = new Autor("Richard Christian","Matheson");
        Autor autor15 = new Autor("Ray","Russell");
        Autor autor16 = new Autor("Stanley","Wiater");
        Autor autor17 = new Autor("Joe R.","Lansdale");
        Autor autor18 = new Autor("Katherine Marie","Ramsland");
        Autor autor19 = new Autor("Mort","Castle");
        Autor autor20 = new Autor("James","Herbert");
        Autor autor21 = new Autor("Dennis","Hamilton");
        Autor autor22 = new Autor("Charles R.","Saunders");
        Autor autor23 = new Autor("Ardath","Mayhar");
        Autor autor24 = new Autor("Steve Rasnic","Tem");
        Autor autor25 = new Autor("Thomas F.","Monteleone");
        Autor autor26 = new Autor("John Robert","Bensink");
        Autor autor27 = new Autor("J. N.","Williamson");
        Autor autor28 = new Autor("Thomas","Sullivan");
        Autor autor29 = new Autor("Alan","Rodgers");
        
        em.persist(autor1);
        em.persist(autor2);
        em.persist(autor3);
        em.persist(autor4);
        em.persist(autor5);
        em.persist(autor6);
        em.persist(autor7);
        em.persist(autor8);
        em.persist(autor9);
        em.persist(autor10);
        em.persist(autor11);
        em.persist(autor12);
        em.persist(autor13);
        em.persist(autor14);
        em.persist(autor15);
        em.persist(autor16);
        em.persist(autor17);
        em.persist(autor18);
        em.persist(autor19);
        em.persist(autor20);
        em.persist(autor21);
        em.persist(autor22);
        em.persist(autor23);
        em.persist(autor24);
        em.persist(autor25);
        em.persist(autor26);
        em.persist(autor27);
        em.persist(autor28);
        em.persist(autor29);
        
        em.getTransaction().commit();
      
        em.getTransaction().begin();
        
        // :::Creo Libro "The Hunger Games" :::
        //Obtengo el Autor del libro
        TypedQuery<Autor> queryAutorLibro1 = em.createQuery("SELECT a FROM Autor AS a WHERE id=6", Autor.class);
        List<Autor> autorLibro1 = queryAutorLibro1.getResultList();
        
        //Obtengo la casa editora del libro
        TypedQuery<Editorial> queryEditorialLibro1 = em.createQuery("SELECT e FROM Editorial AS e WHERE id=2", Editorial.class);
        Editorial editorialLibro1 = queryEditorialLibro1.getSingleResult();
        
        //Creacion del objeto Libro
        Libro libro1 = new Libro("The Hunger Games", "2-266-18269-2, 0-439-02348-3", editorialLibro1, autorLibro1); 
        em.persist(libro1);
        
      
       
        // :::Creo Libro "Masques II: All-New Stories of Horror and the Supernatural" :::
        TypedQuery<Autor> queryAutorLibro2 = em.createQuery("SELECT a FROM Autor AS a WHERE id in (7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32)", Autor.class);
        List<Autor> autorLibro2 = queryAutorLibro2.getResultList();
        
        TypedQuery<Editorial> queryEditorialLibro2 = em.createQuery("SELECT e FROM Editorial AS e WHERE id=3", Editorial.class);
        Editorial editorialLibro2 = queryEditorialLibro2.getSingleResult();
        
        Libro libro2 = new Libro("Masques II: All-New Stories of Horror and the Supernatural", "978-0940776241, 0940776243", editorialLibro2, autorLibro2);
        
        em.persist(libro2);
        em.getTransaction().commit();
        
       
        // cerrar conexiones de manager y manager factory
        em.close();
        emf.close();
        
    }
    
}
