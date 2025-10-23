import Entity.Enemigo;
import Entity.Jugador;
import Entity.Npc;
import Entity.Tienda;
import Map.Mapa;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Mapa mapa1 = Mapa.getTestmap();
		
		Jugador JUGADOR = Jugador.getJugador();
		JUGADOR.setPosicionX(8);
		JUGADOR.setPosicionY(4);
		Enemigo SERPIENTE = Enemigo.crearEnemigo("SERPIENTE");
		SERPIENTE.setPosicionX(3);
		SERPIENTE.setPosicionY(5);
		Npc VIEJO = Npc.crearNpc("VIEJO");
		VIEJO.setPosicionX(2);
		VIEJO.setPosicionY(3);
		//Tienda SHOP = Tienda.tiendaArmas;
		//Tienda SHOP = Tienda.tiendaArmadura;
		Tienda SHOP = Tienda.tiendaConsumibles;
		SHOP.setPosicionX(5);
		SHOP.setPosicionY(0);
		



		
		boolean closeGame;
		
		

		do {
			System.out.print("\n----------------------------\n");
			mapa1.resetMap();
			//Posicionar los personajes en el mapa
			mapa1.posicionarPersonaje(JUGADOR);
			mapa1.posicionarPersonaje(SERPIENTE);
			mapa1.posicionarPersonaje(VIEJO);
			mapa1.posicionarEntidad(SHOP);

			mapa1.mostrarMapa();
			
			//JUGADOR.setSalud(70);

			if (Utils.menuAcciones(JUGADOR, mapa1).equals("cerrar")) {
				closeGame = true;
			} else {
				closeGame = false;
			}
			SERPIENTE.mover(JUGADOR, mapa1);
			
			//JUGADOR.recibirExp(501);
			
			//iniciarBatalla(JUGADOR, SERPIENTE);
			
			if (Utils.estaInteractuando(JUGADOR, SERPIENTE)) {
				Utils.iniciarBatalla(JUGADOR, SERPIENTE);
			}
			
			if (Utils.estaInteractuando(JUGADOR, VIEJO)) {
				
			}
			
			if (Utils.estaInteractuando(JUGADOR, SHOP)) {
				SHOP.mostrarTienda(JUGADOR);
			}
			
		} while (!closeGame);
	}
}
