package Items;

import Entity.Jugador;

public class Botas extends Armadura{

	public Botas(String nombre, int defensaF, int defensaM, int velocidad, int inteligencia) {
		super(nombre, defensaF, defensaM, velocidad, inteligencia);
		// TODO Auto-generated constructor stub
	}
	
	public static final Botas VACIO = new Botas("Vacío", 0, 0, 0, 0);
	public static final Botas BOTAS_CUERO = new Botas("Botas de cuero", 3, 2, 10, 2);
	public static final Botas BOTAS_METAL = new Botas("Botas de metal", 10, 2, 3, 1);
	public static final Botas BOTAS_MAGO = new Botas("Botas de mago", 5, 10, 10, 10);
	
	public void usar(Jugador jugador) {
    	jugador.setBotas(this);
    }

}
