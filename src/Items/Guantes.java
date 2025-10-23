package Items;

import Entity.Jugador;

public class Guantes extends Armadura{
	
	int fuerza;

	public Guantes(String nombre, int defensaF, int defensaM, int velocidad, int inteligencia, int fuerza) {
		super(nombre, defensaF, defensaM, velocidad, inteligencia);
		// TODO Auto-generated constructor stub
		this.fuerza = fuerza;
	}
	
	public static final Guantes VACIO = new Guantes("Vacío", 0, 0, 0, 0, 0);
	public static final Guantes GUANTES_CUERO = new Guantes("Guantes de cuero", 5, 5, 6, 0, 3);
	public static final Guantes GUANTES_HIERRO = new Guantes("Guantes de hierro", 10, 3, -2, 0, 5);
	public static final Guantes GUANTES_ARCANOS = new Guantes("Guantes arcanos", 5, 10, 5, 10, 2);


	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	public void usar(Jugador jugador) {
    	jugador.setGuantes(this);
    }

}
