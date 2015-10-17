package biblioteca;

import java.util.List;
import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        Controlador controlador = new Controlador();

       controlador.creaBD();

        // EDITORIALES
       controlador.insertaEditoriales("Little, Brown and Company", "EE. UU.");
       controlador.insertaEditoriales("Scholastic","EE. UU.");        
       controlador.insertaEditoriales("Maclay & Assoc","EE. UU.");
        
        // AUTORES
       controlador.insertaAutores("Stephenie","Meyer");
       controlador.insertaAutores("J. K.","Rowling");
       controlador.insertaAutores("Suzanne","Collins");
       controlador.insertaAutores("Stephen","King");
       controlador.insertaAutores("Ramsey","Campbell");
       controlador.insertaAutores("William F","Nolan");
       controlador.insertaAutores("Robert","Bloch");
       controlador.insertaAutores("Richard","Matheson");
       controlador.insertaAutores("David B.","Silva");
       controlador.insertaAutores("G. Wayne","Miller");
       controlador.insertaAutores("James","Kisner");
       controlador.insertaAutores("John","Kisner");
       controlador.insertaAutores("Douglas E.","Winter");
       controlador.insertaAutores("Richard Christian","Matheson");
       controlador.insertaAutores("Ray","Russell");
       controlador.insertaAutores("Stanley","Wiater");
       controlador.insertaAutores("Joe R.","Lansdale");
       controlador.insertaAutores("Katherine Marie","Ramsland");
       controlador.insertaAutores("Mort","Castle");
       controlador.insertaAutores("James","Herbert");
       controlador.insertaAutores("Dennis","Hamilton");
       controlador.insertaAutores("Charles R.","Saunders");
       controlador.insertaAutores("Ardath","Mayhar");
       controlador.insertaAutores("Steve Rasnic","Tem");
       controlador.insertaAutores("Thomas F.","Monteleone");
       controlador.insertaAutores("John Robert","Bensink");
       controlador.insertaAutores("J. N.","Williamson");
       controlador.insertaAutores("Thomas","Sullivan");
       controlador.insertaAutores("Alan","Rodgers");
        
        // LIBROS
       controlador.insertaLibros("The Hunger Games",  "2-266-18269-2, 0-439-02348-3", "6","2");
       controlador.insertaLibros("Masques II: All-New Stories of Horror and the Supernatural", "978-0940776241, 0940776243", "7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32","3");
        
       controlador.cerrarBD();
 
    }

}
