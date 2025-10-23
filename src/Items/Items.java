package Items;

import Entity.Jugador;

public class Items {
    private String nombre;

    // Constructor
    public Items(String nombre) {
        this.nombre = nombre;
    }
    
    public final static Items VACIO = new Items("Vacío");
    
    public static final Items PIEL_SERPIENTE = new Items("Piel de serpiente");
    public static final Items OREJA_GOBLIN = new Items("Oreja de goblin");
    public static final Items CORONA_GOBLIN = new Items("Corona del rey goblin");
    public static final Items HUESOS = new Items("Huesos de esqueleto");
    public static final Items ORBE_SLIME = new Items("Orbe de slime");
    public static final Items TAG_BANDIDO = new Items("Identificador de un bandido");
    public static final Items PIEL_LOBO = new Items("Piel de lobo");
    public static final Items CUERNO_DEMONIO = new Items("Cuerno de un demonio");
    public static final Items CUERNO_GRANDE_DEMONIO = new Items("Cuerno grande de un demonio");
    public static final Items CORONA_DEMONIO = new Items("Corona del rey demonio");

    // Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para mostrar nombre del ítem
    public String mostrarInfo() {
        return "Nombre: " + nombre;
    }
    
    public void usar(Jugador jugador) {
    	
    }
}
