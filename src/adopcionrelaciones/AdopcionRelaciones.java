/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package adopcionrelaciones;
import adopcionrelaciones.Servicios.PersonaServicio;
import java.util.Scanner;

public class AdopcionRelaciones {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("¡Bienvenido al Programa de Adopcion de Mascotas!");
        PersonaServicio ps = new PersonaServicio();
        System.out.println("Perros:");
        ps.agregarPerros();
        System.out.println("Personas:");
        ps.agregarPersonas();
        System.out.println("Adopcion:");
        ps.adopcionPerros();
        ps.mostrarPersonas();
    }
    
}
