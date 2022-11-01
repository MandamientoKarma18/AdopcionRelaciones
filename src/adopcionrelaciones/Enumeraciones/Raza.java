/*

 */
package adopcionrelaciones.Enumeraciones;

public enum Raza {
    GOLDEN("Golden"),
    PASTOR("Pastor"),
    POODLE("Poodle"),
    LABRADOR("Labrador"),
    BOXER("Boxer"),
    BULLDOG("Bulldog"),
    YORKSHIRE("Yorkshire"),
    BEAGLE("Beagle"),
    HUSKY("Husky"),
    DALMATA("Dalmata"),
    BORDER_COLLIE("Border Collie"),
    CHIHUAHUA("Chihuahua"),
    ROTTWEILER("Rottweiler"),
    NO_DEFINIDO ("-");

    private String nombre;
    private Raza(String nombre) {               //Constructor
        this.nombre= nombre;
    }
    private String getname() {
        return nombre; 
    }

    public Raza getNombre(String input) {       //input es la entrada teclado
        for(Raza aux : values()) {
            if(aux.getname().equals(input))
                return aux;
        }
        return NO_DEFINIDO;
    }
}
