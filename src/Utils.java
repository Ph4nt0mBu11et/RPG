
import javax.swing.JOptionPane;

import Entity.Enemigo;
import Entity.Entidad;
import Entity.Personaje;
import Entity.Jugador;
import Entity.Npc;
import Map.Mapa;

public class Utils {
	
	/**
	 * Muestra menu de acciones del jugador.
	 * @param jugador
	 * @param mapa Mapa actual en la que esta el jugador.
	 * @return String "cerrar" si el jugador quiere cerrar el programa.
	 */
	public static String menuAcciones(Jugador jugador, Mapa mapa) {
		String ajustes = "";
		
		String[] opciones = {"Arriba", "Abajo", "Derecha", "Izquierda", "Objetos", "Descansar", "Ajustes"};
		final int ARRIBA = 0;
		final int ABAJO = 1;
		final int DERECHA = 2;
		final int IZQUIERDA = 3;
		final int OBJETOS = 4;
		final int DESCANSAR = 5;
		final int AJUSTES = 6;
		
		int eleccion;
		
		jugador.refreshStats();
		do {
			eleccion = JOptionPane.showOptionDialog(
					null,
					"Lvl: " + jugador.getNivel() + "\n" +
					jugador.barraExp() + "   Exp: " + jugador.getExp() + "/" + jugador.LEVEL_UP_CAP + "\n" +
					"HP: " + jugador.getSalud() + "/" + jugador.getMaxSalud() + "\n" +
					jugador.barraSalud() + "\n" +
					"Str:" + jugador.getTotalFuerza() + "\n" +
					"Int: " + jugador.getTotalInteligencia() + "\n" +
					"Dex: " + jugador.getTotalDestreza() + "\n" +
					"Spd: " + jugador.getTotalVelocidad() + "\n" +
					"Def: " + jugador.getTotalDefensaFisica() + "\n" +
					"Mag. Def: " + jugador.getTotalDefensaMagica() + "\n\n" +
					
					"Cabeza: " + jugador.getCabeza().getNombre() + "\n" +
					"Pecho: " + jugador.getPecho().getNombre() + "\n" +
					"Guantes: " + jugador.getGuantes().getNombre() + "\n" +
					"Botas: " + jugador.getBotas().getNombre() + "\n" +
					"Arma: " + jugador.getArma().getNombre() + "\n\n" +
					
					"Oro: " + jugador.getGold() + "\n" +
					"¿Qué va a hacer?", 
					jugador.getNombre(), 
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.INFORMATION_MESSAGE, 
					null, 
					opciones, 
					opciones[0]
					);

			switch (eleccion) {
			case ARRIBA: jugador.moverArriba(mapa);
			break;
			case ABAJO: jugador.moverAbajo(mapa);
			break;
			case DERECHA: jugador.moverDerecha(mapa);
			break;
			case IZQUIERDA: jugador.moverIzquierda(mapa);
			break;
			case OBJETOS: jugador.menuInventario(jugador.getInventarioConsumible());
			break;
			case DESCANSAR: jugador.curar(jugador.getMaxSalud() * 0.1);
			jugador.regenStaminaManaTurno();
			break;
			case AJUSTES: ajustes = ajustesMenu(jugador); break;
			}
		} while ((eleccion == AJUSTES || eleccion == OBJETOS) && !ajustes.equals("cerrar"));
		
		return ajustes;
	}
	
	
	/**
	 * Muestra menu de ajustes
	 * @param jugador
	 * @return
	 */
	public static String ajustesMenu(Jugador jugador) {
		String ajustes = "";
		
		final int CHEATS = 0;
		final int ATRAS = 1;
		final int CLOSE = 2;
		
		String[] opciones = {"Trampas/Debug", "Atrás", "Cerrar Juego"};
		int eleccion = JOptionPane.showOptionDialog(
	            null, 
	            "Selecciona una opción:", 
	            "Menú Opciones", 
	            JOptionPane.DEFAULT_OPTION, 
	            JOptionPane.QUESTION_MESSAGE, 
	            null, 
	            opciones, 
	            opciones[0]
	        );
		
		switch (eleccion) {
		case CHEATS:
			menuCheats(jugador);
			ajustes = "finTurno";
			break;
		case ATRAS:
			break;
		case CLOSE: ajustes = "cerrar";
			break;
		}
		
		jugador.setInteractuable(true);
		return ajustes;
	}
	
	/**
	 * Muestra menu de herramientas trampa / debug del juego.
	 * @param jugador
	 */
	public static void menuCheats(Jugador jugador) {
		String input;
		int cantidad;
		int posX;
		int posY;
		input = JOptionPane.showInputDialog("(Esto podria crashear el juego)\n"
				+ "Introduce el comando:");
		switch (input) {
		//TODO
		case "getGold": cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad:"));
			jugador.setGold(jugador.getGold() + cantidad);
			break;
		case "getExp": cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad:"));
			jugador.recibirExp(cantidad);
			break;
		case "getItem": input = JOptionPane.showInputDialog("Introduce el nombre del item:");
			//TODO crear una lista de items buscar en la lista y retornar / dar item
		break;
		case "heal": jugador.setSalud(jugador.getMaxSalud());
		break;
		case "godMode": jugador.setFuerza(99999);
			jugador.setDefensaFisico(99999);
			jugador.setDefensaMagica(99999);
			jugador.setInteligencia(99999);
			jugador.setDestreza(99999);
			jugador.setVelocidad(99999);
			jugador.refreshStats();
			jugador.setMaxSalud(99999);
			jugador.setSalud(jugador.getSalud());
		break;
		case "tp": posX = Integer.parseInt(JOptionPane.showInputDialog("Coordenadas X"));
			posY = Integer.parseInt(JOptionPane.showInputDialog("Coordenadas Y"));
			jugador.tp(posX, posY);
			break;
		//TODO
		
		}
	}

	/**
	 * Comprueba si jugador y objetivo esta en la misma casilla.
	 * @param jugador
	 * @param objetivo
	 * @return True si estan en la misma casilla, false si no lo están
	 */
	public static boolean estaInteractuando(Personaje jugador, Entidad objetivo){
		boolean interactuando;

		if (jugador.getPosicionX() == objetivo.getPosicionX() && jugador.getPosicionY() == objetivo.getPosicionY() && jugador.isEstaVivo()) {
			interactuando = true;
		} else {
			interactuando = false;
		}
		return interactuando;
	}
	
	/**
	 * Comprueba si jugador y objetivo esta en la misma casilla.
	 * @param jugador
	 * @param objetivo
	 * @return True si estan en la misma casilla, false si no lo están
	 */
	public static boolean estaInteractuando(Personaje jugador, Personaje objetivo){
		boolean interactuando;

		if (jugador.getPosicionX() == objetivo.getPosicionX() && jugador.getPosicionY() == objetivo.getPosicionY() && jugador.isEstaVivo() && objetivo.isEstaVivo()) {
			interactuando = true;
		} else {
			interactuando = false;
		}
		return interactuando;
	}
	
	/**
	 * Comprueba si jugador y objetivo esta en la misma casilla. E inicia la batalla.
	 * @param jugador
	 * @param objetivo
	 * @return True si estan en la misma casilla, false si no lo están
	 */
	public static boolean estaInteractuando(Jugador jugador, Enemigo objetivo){
		boolean interactuando;

		if (jugador.getPosicionX() == objetivo.getPosicionX() && jugador.getPosicionY() == objetivo.getPosicionY() && jugador.isEstaVivo() && objetivo.isEstaVivo()) {
			interactuando = true;
		} else {
			interactuando = false;
		}
		return interactuando;
	}
	
	/**
	 * Comprueba si jugador y objetivo esta en la misma casilla. Y interactua con el npc.
	 * @param jugador
	 * @param objetivo
	 * @return True si estan en la misma casilla, false si no lo están
	 */
	public static boolean estaInteractuando(Jugador jugador, Npc objetivo){
		boolean interactuando;

		if (jugador.getPosicionX() == objetivo.getPosicionX() && jugador.getPosicionY() == objetivo.getPosicionY() && jugador.isEstaVivo() && objetivo.isEstaVivo()) {
			if (objetivo.getMision() != null && !objetivo.getMision().isCompletado()) {
				objetivo.getMision().mostrarMision(jugador);
			} else if (objetivo.getDialogo() != null) {
				JOptionPane.showMessageDialog(null, objetivo.getNombre() + ": " + objetivo.getDialogo());
			} else
				JOptionPane.showMessageDialog(null, ". . .");
			interactuando = true;
		} else {
			interactuando = false;
		}
		return interactuando;
	}
	
	/**
	 * Metodo que inicia una batalla entre un jugador y un enemigo
	 * @param jugador
	 * @param enemigo
	 * @return True si jugador sigue vivo, false si jugador ha perdido
	 */
	public static boolean iniciarBatalla(Jugador jugador, Enemigo enemigo) {
		boolean gameOver = false;
		if (enemigo.isEstaVivo() && jugador.isEstaVivo() && jugador.isInteractuable()) {

			
			
			String[] opciones = {"Atacar", "Habilidades", "Objetos", "Huir"};

			final int ATACAR = 0;
			final int HABILIDADES = 1;
			final int OBJ = 2;
			final int HUIR = 3;
			
			String battleLog = "";
			boolean accionJugador;
			boolean huye = false;
			do {
				
				do {
					int eleccion = JOptionPane.showOptionDialog(
							null,
							"Jugador:" + "\n" +
							"Lvl" + jugador.getNivel() + "\n" +
							"Hp: " + jugador.getSalud() + "/" + jugador.getMaxSalud() + "\n" +
							jugador.barraSalud() + "\n\n" +
							
							enemigo.getNombre() + "\n" +
							"Lvl: " + enemigo.getNivel() + "\n" +
							"Hp: " + enemigo.getSalud() + "\n" +
							enemigo.barraSalud() +  "\n \n" +
							battleLog +
							"¿Qué va a hacer?"
							, 
							"Batalla", 
							JOptionPane.DEFAULT_OPTION, 
							JOptionPane.INFORMATION_MESSAGE, 
							enemigo.getIcon(), 
							opciones, 
							opciones[0]
					);

					switch (eleccion) {
					case ATACAR:
						battleLog += enemigo.getNombre() + " recibe " + enemigo.recibirAtaqueFisico(jugador.calcularDmg()) + " de daño. \n";
						accionJugador = true;
						break;
					case HABILIDADES:
						String habilidad;
						habilidad = jugador.menuHabilidades(enemigo);
						if (habilidad.equals("No se hizo nada.")) {
							accionJugador = false;
						} else {
							battleLog += habilidad;
							accionJugador = true;
						}
						break;
					case OBJ:
						accionJugador = jugador.menuInventario(jugador.getInventarioConsumible());
						break;
					case HUIR:
						if (jugador.puedeHuir(enemigo)) {
							huye = true;
						} else {
							battleLog += jugador.getNombre() + " intenta huir pero fracasa.\n";
							huye = false;
						}
						accionJugador = true;
						break;
					default: accionJugador = false;
					}
				} while (!accionJugador);
				
				
				if (enemigo.isEstaVivo() && jugador.isEstaVivo()) {
					battleLog += jugador.getNombre() + " recibe " + jugador.recibirAtaqueFisico(enemigo.calcularDmg()) + " de daño. \n";
				}
			} while (enemigo.isEstaVivo() && jugador.isEstaVivo() && !huye);
			
			if (huye) {
				JOptionPane.showMessageDialog(null, jugador.getNombre() + " consigue huir de " + enemigo.getNombre());
				jugador.setInteractuable(false);
			}
			
			if (!enemigo.isEstaVivo()) {
				JOptionPane.showMessageDialog(null, enemigo.getNombre() + " ha sido derrotado. \n"
						+ "+" + enemigo.getDropExp() + "exp    " + "+" + enemigo.getDropGold() + "oro\n"
						+ "Drops: x" + enemigo.getDropCantidad() + " " + enemigo.getDropItemName());
				enemigo.setEstaVivo(false);
				jugador.recibirOro(enemigo.getDropGold());
				jugador.recibirExp(enemigo.getDropExp());
				jugador.recibirItemInventarioComun(enemigo.getDropItem(), enemigo.getDropCantidad());
			}
			
			if (!jugador.isEstaVivo()) {
				gameOver = true;
			}
		
		}
		return gameOver;
	}
	
	/**
	 * Borra la consola (no funciona en IDEs ni en cmd)
	 */
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}

}
