package Items;

import Entity.Jugador;

public class Pecho extends Armadura{

	public Pecho(String nombre, int defensaF, int defensaM, int velocidad, int inteligencia) {
		super(nombre, defensaF, defensaM, velocidad, inteligencia);
		// TODO Auto-generated constructor stub
	}
	
	public static final Pecho VACIO = new Pecho("Vacío", 0, 0, 0, 0);
	public static final Pecho ARMADURA_CUERO = new Pecho("Armadura de cuero", 14, 5, 10, 0);
	public static final Pecho ARMADURA_HIERRO = new Pecho("Armadura de hierro", 30, 3, -10, 0);
	public static final Pecho BATA_MAGO = new Pecho("Bata de mago", 5, 15, 10, 30);

	public void usar(Jugador jugador) {
    	jugador.setPecho(this);
    }
}
