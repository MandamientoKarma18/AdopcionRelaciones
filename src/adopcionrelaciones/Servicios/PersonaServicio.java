/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package adopcionrelaciones.Servicios;
import adopcionrelaciones.Entidades.Perro;
import adopcionrelaciones.Entidades.Persona;
import adopcionrelaciones.Enumeraciones.Raza;

import java.util.HashSet;
import java.util.Scanner;

public class PersonaServicio {
    private HashSet<Persona> personas;
    private HashSet<Perro> perros;
    private Scanner read;
    
    public PersonaServicio(){
        this.personas = new HashSet<Persona>();
        this.perros = new HashSet<Perro>();
        this.read = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void agregarPersonas(){
        boolean loop = true;boolean loop2 = true;
        do{
            System.out.println("Nombre:");
            String nombrep = read.next();
            System.out.println("Apellido:");
            String apellido = read.next();
            boolean loop3 = true; Integer documento;
            do{
                System.out.println("DNI:");
                documento = read.nextInt();
                if (documento.toString().length()>8||documento.toString().length()<6) {
                    System.out.println("DNI Invalido.");
                    
                } else{
                    loop3 = false;
                }
            } while(loop3);
            System.out.println("Edad:");
            int edad = read.nextInt();
            personas.add(new Persona(nombrep, apellido, edad, documento));
            System.out.println("Desea seguir agregando socios? s/n");
              do{
                    switch(read.next()){
                        case "s":
                            loop2 = false;
                            break;
                        case "n":
                            loop = false;
                            loop2 = false;
                            break;
                        default:
                            System.out.println("Ingrese una opcion valida.");
                    }
                } while(loop2);
        } while(loop);
    }
    public void agregarPerros(){
        boolean loop = true;boolean loop2 = true;
        do{
            System.out.println("Nombre:");
            String nombrep = read.next();
            System.out.println("Edad:");
            int edad = read.nextInt();
            System.out.println("Tamaño en cm:");
            double tamano = read.nextDouble();
            boolean loop3 = true; String razainput;
            Raza raza = Raza.NO_DEFINIDO;
            do{
                System.out.println("Raza:");
                razainput = read.next();
                if (raza.getNombre(razainput)==Raza.NO_DEFINIDO) {
                    System.out.println("Raza Invalida.");
                } else{
                    loop3 = false;
                }
            } while(loop3);
            perros.add(new Perro(nombrep, raza.NO_DEFINIDO.getNombre(razainput), edad, tamano));
            System.out.println("Desea seguir agregando Perros? s/n");
              do{
                    switch(read.next()){
                        case "s":
                            loop2 = false;
                            break;
                        case "n":
                            loop = false;
                            loop2 = false;
                            break;
                        default:
                            System.out.println("Ingrese una opcion valida.");
                    }
                } while(loop2);
        } while(loop);
    }
    public void adopcionPerros(){
        boolean loop = true; boolean loop2 = true;
        do{
            boolean loop3 = true; Integer documento;
            do{
                System.out.println("Ingrese DNI del afiliado:");
                documento = read.nextInt();
                if (documento.toString().length()>8||documento.toString().length()<6) {
                    System.out.println("DNI Invalido.");
                    
                } else{
                    loop3 = false;
                }
            } while(loop3);
            System.out.println("Lista de perros en Adopcion: ");
            mostrarPerros();
            System.out.println("Ingrese el Perro a Adoptar:");
            String nombrep = read.next();
            boolean invalidperro = true; boolean invalidpersona = true;
            for (Persona aux : personas) {
                if (documento==aux.getDocumento()) {
                    for (Perro aux2 : perros) {
                        if (nombrep.equalsIgnoreCase(aux2.getNombre())) {
                            aux.setPerro(aux2);
                            invalidperro = false;
                            System.out.println("Adopcion Completa!");
                        }
                        invalidperro = false;
                    }
                    invalidpersona = false;
                }
            }
            if (invalidpersona) {
                System.out.println("Documento Invalido!");
            } else if(invalidperro){
                System.out.println("Perro no Existe!");
            }
            System.out.println("Desea seguir con la adopcion? s/n");
            do{
                    switch(read.next()){
                        case "s":
                            loop2 = false;
                            break;
                        case "n":
                            loop = false;
                            loop2 = false;
                            break;
                        default:
                            System.out.println("Ingrese una opcion valida.");
                    }
                } while(loop2);
        } while(loop);
    }
    public void mostrarPerros(){
        for (Perro aux : perros) {
            System.out.println(aux);
        }
    }
    public void mostrarPersonas(){
        for (Persona aux : personas) {
            System.out.println(aux);
        }
    }
}
