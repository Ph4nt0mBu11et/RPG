import Entity.*;

public class barraTest {

	public static void main(String[] args) {
		Enemigo test = Enemigo.crearEnemigo("SERPIENTE");
		//Enemigo test2 = new Enemigo("Serpiente", 2, 3, Color.ROJO + "S" + Color.RESET, 8, 5, 6, 7, 70, 3, 3, 0.5, 3);
		Jugador test3 = Jugador.getJugador();
		//test2.setSalud(5);
		test3.setSalud(70);
		
		System.out.println(test.barraSalud());
		//System.out.println(test2.barraSalud());
		System.out.println(test3.barraSalud());
		
	}

}
