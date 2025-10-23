package Items;

import Entity.Jugador;

public class Cabeza extends Armadura{

	private Cabeza(String nombre, int defensaF, int defensaM, int velocidad, int inteligencia) {
		super(nombre, defensaF, defensaM, velocidad, inteligencia);
		// TODO Auto-generated constructor stub
	}
	
	public static final Cabeza VACIO = new Cabeza("Vacío", 0, 0, 0, 0);
	public static final Cabeza CASCO_CUERO = new Cabeza("Casco de cuero", 6, 4, 13, 2);
	public static final Cabeza SOMBRERO_MAGO = new Cabeza("Sombrero de mago", 6, 20, 14, 20);
	public static final Cabeza CASCO_HIERRO = new Cabeza("Casco de Hierro", 20, 5, -2, -2);

	public void usar(Jugador jugador) {
    	jugador.setCabeza(this);
    }
	public static Cabeza getCascoHierro() {
		return CASCO_HIERRO;
	}
	
}
