import java.util.Arrays;

import javax.swing.JOptionPane;

import Entity.Enemigo;
import Entity.Entidad;
import Entity.Iglesia;
import Entity.Jugador;
import Entity.Npc;
import Entity.Personaje;
import Entity.Tienda;
import Map.Mapa;
import Quest.Mision;

public class Demo {

	public static void main(String[] args) {
		final Mapa MUNDO = Mapa.getWorld();
		final Mapa CASTILLO = Mapa.getCastillo();
		final Mapa PUEBLO = Mapa.getPueblo();
		final Mapa BOSQUE = Mapa.getBosque();
		final Mapa CUEVA = Mapa.getCueva();
		final Mapa TEMPLO = Mapa.getTemplo();
		final Mapa CASTILLO_DEMONIO = Mapa.getCastilloDemonio();
		
		Npc rey = Npc.crearNpc("REY");
		Npc reina = Npc.crearNpc("REINA");
		Npc soldado01 = Npc.crearNpc("SOLDADO");
		Npc soldado02 = Npc.crearNpc("SOLDADO");
		Npc soldado03 = Npc.crearNpc("SOLDADO");
		Npc soldado04 = Npc.crearNpc("SOLDADO");
		Npc viejo1 = Npc.crearNpc("VIEJO");
		Npc viejo2 = Npc.crearNpc("VIEJO");
		Npc ciudadano1 = Npc.crearNpc("CIUDADANO");
		Npc ciudadano2 = Npc.crearNpc("CIUDADANO");
		Npc ciudadano3 = Npc.crearNpc("CIUDADANO");
		Npc cazador1 = Npc.crearNpc("CAZADOR");
		Npc cazador2 = Npc.crearNpc("CAZADOR");
		Npc cazador3 = Npc.crearNpc("CAZADOR");
		Npc granjero1 = Npc.crearNpc("GRANJERO");
		Npc granjero2 = Npc.crearNpc("GRANJERO");
		Npc granjero3 = Npc.crearNpc("GRANJERO");
		
		rey.setMision(Mision.misionFinal);
		soldado04.setMision(Mision.mision3);
		viejo1.setMision(Mision.mision1);
		ciudadano1.setMision(Mision.mision6);
		ciudadano1.setMision(Mision.mision9);
		cazador1.setMision(Mision.mision2);
		cazador2.setMision(Mision.mision8);
		granjero1.setMision(Mision.mision4);
		granjero2.setMision(Mision.mision5);
		granjero3.setMision(Mision.mision7);
		
		Enemigo snake1 = Enemigo.crearEnemigo("SERPIENTE");
        Enemigo snake2 = Enemigo.crearEnemigo("SERPIENTE");
        Enemigo snake3 = Enemigo.crearEnemigo("SERPIENTE");

        Enemigo goblin1 = Enemigo.crearEnemigo("GOBLIN");
        Enemigo goblin2 = Enemigo.crearEnemigo("GOBLIN");
        Enemigo goblin3 = Enemigo.crearEnemigo("GOBLIN");

        Enemigo kingGoblin1 = Enemigo.crearEnemigo("KING_GOBLIN");

        Enemigo esqueleto1 = Enemigo.crearEnemigo("ESQUELETO");
        Enemigo esqueleto2 = Enemigo.crearEnemigo("ESQUELETO");
        Enemigo esqueleto3 = Enemigo.crearEnemigo("ESQUELETO");

        Enemigo slime1 = Enemigo.crearEnemigo("SLIME");
        Enemigo slime2 = Enemigo.crearEnemigo("SLIME");
        Enemigo slime3 = Enemigo.crearEnemigo("SLIME");

        Enemigo bandido1 = Enemigo.crearEnemigo("BANDIDO");
        Enemigo bandido2 = Enemigo.crearEnemigo("BANDIDO");
        Enemigo bandido3 = Enemigo.crearEnemigo("BANDIDO");

        Enemigo lobo1 = Enemigo.crearEnemigo("LOBO");
        Enemigo lobo2 = Enemigo.crearEnemigo("LOBO");
        Enemigo lobo3 = Enemigo.crearEnemigo("LOBO");

        Enemigo demonio1 = Enemigo.crearEnemigo("DEMONIO");
        Enemigo demonio2 = Enemigo.crearEnemigo("DEMONIO");
        Enemigo demonio3 = Enemigo.crearEnemigo("DEMONIO");

        Enemigo generalDemonio1 = Enemigo.crearEnemigo("GENERAL_DEMONIO");

        Enemigo reyDemonio1 = Enemigo.crearEnemigo("REY_DEMONIO");
		
		Npc[] castilloNpc = {rey, reina, soldado01, soldado02, soldado03, soldado04};
		Npc[] puebloNpc = {viejo1, viejo2, ciudadano1, ciudadano2, ciudadano3, cazador1, cazador2, cazador3, granjero1, granjero2, granjero3};
		Enemigo[] bosqueEntidades = {snake1, snake2, snake3, bandido1, bandido2, bandido3, lobo1, lobo2, lobo3};
		Enemigo[] cuevaEntidades = {goblin1, goblin2, goblin3, kingGoblin1, esqueleto1, esqueleto2, esqueleto3, slime1, slime2, slime3};
		Entidad[] temploEntidades = {};
		Enemigo[] castilloDemonioEntidades = {demonio1, demonio2, demonio3, generalDemonio1, reyDemonio1};
		
		Tienda tiendaConsumible = Tienda.tiendaConsumibles;
		Tienda tiendaArmas = Tienda.tiendaArmas;
		Tienda tiendaArmadura = Tienda.tiendaArmadura;
		
		boolean closeGame = false;
		
		Jugador jugador = Jugador.JUGADOR;
		jugador.setPosicionX(9);
		jugador.setPosicionY(5);
		Mapa mapa = TEMPLO;
		
		boolean spawn = true;
		boolean mostrarEntidad;
		
		
		System.out.println( 
				" _______ _________ _        _______  __         _______   _       _______  __________ _________\n" +
				"(  ____ |___   __/( (    /|(  ___  )(  |        (  ___  )| |     /|(  ___/ (  ____  | |__   __/\n" +
				"| (         ) (   |  ||  ( || (   ) || (        | (   ) || )   ( || (      | (    |/     ) (   \n" +
				"| (__       | |   |   || | || (___) || |        | |   | || |   | || (__    | (_____      | |   \n" +
				"|  __)      | |   | (|| |) ||  ___  || |        | |   | || |   | ||  __)   (_____   )    | |   \n" +
				"| (         | |   | | ||   || (   ) || |        | | /|| || |   | || (             ) |    | |   \n" +
				"| )      ___) (___| )  ||  || )   ( || (____/|  | (_|| ||| (___) || (____/|/|_____) |    | |   \n" +
				"|/      |________/|/    )_)|/     |_|(_______/  (____||_)(_______)(_______/|________)    )_(   \n" +
				"                                                                                            "
);
		int opcion = JOptionPane.showConfirmDialog(null, "Bienvenido al mundo de Final Quest, tu misión como el héroe elegido es derrotar al Rey Demonio que planea destruir el mundo.");
		
		if (opcion == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Sientes una ligera brisa. \n Tras abrir los ojos te encuentras en medio de unas ruinas al aire libre. \n"
					+ "Notas que tienes una espada vieja en tu mochila.\n"
					+ "(Tú eres (@))");
			String nombre = JOptionPane.showInputDialog("Intentas recordar tu nombre:");
			if (nombre != null && !nombre.equals("")) {
				jugador.setNombre(nombre);
			}
			
			do {
			System.out.print("\n----------------------------\n");
			Utils.clearScreen();
			//Gestion de mapas
			mapa.resetMap();			

			mostrarEntidad = true;
			if (mapa == MUNDO) {
				spawn = true;
				if (jugador.getPosicionX() == 2 && jugador.getPosicionY() == 2) {
					mapa = BOSQUE;
					mapa.resetMap();
					jugador.setPosicion(9, 8);
				} else if (jugador.getPosicionX() == 14 && jugador.getPosicionY() == 1) {
					mapa = CASTILLO;
					mapa.resetMap();
					jugador.setPosicion(9, 8);
				} else if (jugador.getPosicionX() == 9 && jugador.getPosicionY() == 3) {
					mapa = PUEBLO;
					mapa.resetMap();
					jugador.setPosicion(9, 8);
				} else if (jugador.getPosicionX() == 7 && jugador.getPosicionY() == 5) {
					mapa = TEMPLO;
					mapa.resetMap();
					jugador.setPosicion(9, 8);
				} else if (jugador.getPosicionX() == 16 && jugador.getPosicionY() == 7) {
					mapa = CUEVA;
					mapa.resetMap();
					jugador.setPosicion(9, 8);
				} else if (jugador.getPosicionX() == 3 && jugador.getPosicionY() == 8) {
					mapa = CASTILLO_DEMONIO;
					mapa.resetMap();
					jugador.setPosicion(9, 8);
				}
			}
			if (mapa == CASTILLO) {
				if (jugador.getPosicionX() == 9 && jugador.getPosicionY() == 9) {
					mapa = MUNDO;
					mapa.resetMap();
					jugador.setPosicion(7, 4);
					mostrarEntidad = false;
				}
				if (spawn) {
					rey.setPosicion(7, 2);
					reina.setPosicion(12, 2);
					soldado01.setPosicion(8, 4);
					soldado02.setPosicion(11, 4);
					soldado03.setPosicion(8, 6);
					soldado04.setPosicion(11, 6);

					spawn = false;
				}
				if (mostrarEntidad) {
					mapa.posicionarPersonaje(castilloNpc);
					mostrarEntidad = true;
				}
			} else if (mapa == PUEBLO) {
				if (jugador.getPosicionX() == 9 && jugador.getPosicionY() == 9) {
					mapa = MUNDO;
					mapa.resetMap();
					jugador.setPosicion(8, 3);
					mostrarEntidad = false;
				}
				Iglesia iglesia = Iglesia.IGLESIA;
				if (spawn) {
					iglesia.setPosicion(6, 2);
					viejo1.setPosicion(5, 4);
					viejo2.setPosicion(7, 6);
					ciudadano1.setPosicion(10, 3);
					ciudadano2.setPosicion(12, 7);
					ciudadano3.setPosicion(5, 9);
					cazador1.setPosicion(8, 5);
					cazador2.setPosicion(13, 8);
					cazador3.setPosicion(3, 6);
					granjero1.setPosicion(9, 4);
					granjero2.setPosicion(10, 5);
					granjero3.setPosicion(8, 7);
					tiendaConsumible.setPosicion(5, 9);
					tiendaArmas.setPosicion(9, 2);
					tiendaArmadura.setPosicion(11, 2);
					//TODO
					spawn = false;
				}
				if (mostrarEntidad) {
					mapa.posicionarPersonaje(puebloNpc);
					mapa.posicionarEntidad(tiendaConsumible);
					if (Utils.estaInteractuando(jugador, tiendaConsumible)) {
						tiendaConsumible.mostrarTienda(jugador);
					}
					if (Utils.estaInteractuando(jugador, iglesia)) {
						iglesia.menu(jugador);
					}
					mostrarEntidad = true;
				} 
			} else if (mapa == BOSQUE) {
				if (jugador.getPosicionX() == 9 && jugador.getPosicionY() == 9) {
					mapa = MUNDO;
					mapa.resetMap();
					jugador.setPosicion(2, 3);
					mostrarEntidad = false;
				}
				if (spawn) {
					snake1.setPosicion(5, 0);
					snake2.setPosicion(12, 1);
					snake3.setPosicion(8, 5);

					bandido1.setPosicion(3, 2);
					bandido2.setPosicion(6, 6);
					bandido3.setPosicion(4, 8);

					lobo1.setPosicion(9, 3);
					lobo2.setPosicion(10, 7);
					lobo3.setPosicion(7, 9);

					spawn = false;
				}
				if (mostrarEntidad) {
					mapa.posicionarPersonaje(bosqueEntidades);
					mostrarEntidad = true;
				}
			} else if (mapa == CUEVA) {
				if (jugador.getPosicionX() == 9 && jugador.getPosicionY() == 9) {
					mapa = MUNDO;
					mapa.resetMap();
					jugador.setPosicion(16, 6);
					mostrarEntidad = false;
				}
				if (spawn) {
					kingGoblin1.setPosicion(10, 0);
					goblin1.setPosicion(9, 1);
					goblin2.setPosicion(11, 1);
					goblin3.setPosicion(8, 2);

					esqueleto1.setPosicion(5, 3);
					esqueleto2.setPosicion(6, 4);
					esqueleto3.setPosicion(7, 5);

					slime1.setPosicion(9, 7);
					slime2.setPosicion(8, 6);
					slime3.setPosicion(10, 8);

					spawn = false;
				}
				if (mostrarEntidad) {
					mapa.posicionarPersonaje(cuevaEntidades);
					mostrarEntidad = true;
				}
			} else if (mapa == TEMPLO) {
				if (jugador.getPosicionX() == 9 && jugador.getPosicionY() == 9) {
					mapa = MUNDO;
					mapa.resetMap();
					jugador.setPosicion(7, 4);
					mostrarEntidad = false;
				}
			} else if (mapa == CASTILLO_DEMONIO) {
				if (jugador.getPosicionX() == 9 && jugador.getPosicionY() == 9) {
					mapa = MUNDO;
					mapa.resetMap();
					jugador.setPosicion(3, 7);
					mostrarEntidad = false;
				}
				if (spawn) {
					reyDemonio1.setPosicion(9, 2);
					generalDemonio1.setPosicion(9, 4);
					demonio1.setPosicion(6, 2);
					demonio2.setPosicion(6, 6);
					demonio3.setPosicion(7, 7);

					spawn = false;
				}
				if (mostrarEntidad) {
					mapa.posicionarPersonaje(castilloDemonioEntidades);
					mostrarEntidad = true;
				}
			}
		
			
			mapa.posicionarPersonaje(jugador);

			mapa.mostrarMapa();
			
			if (Utils.menuAcciones(jugador, mapa).equals("cerrar")) {
				closeGame = true;
				break;
			} else {
				closeGame = false;
			}
			
			if (!closeGame) {
				if (mapa == CASTILLO) {
					for(int i = 0; i < castilloNpc.length; i++) {
						Utils.estaInteractuando(jugador, castilloNpc[i]);
					}
				} else if (mapa == PUEBLO) {
					for(int i = 0; i < puebloNpc.length; i++) {
						Utils.estaInteractuando(jugador, puebloNpc[i]);
					}
				} else if (mapa == BOSQUE) {
					for(int i = 0; i < bosqueEntidades.length; i++) {
						bosqueEntidades[i].mover(jugador, mapa);
						if (Utils.estaInteractuando(jugador, bosqueEntidades[i])) {
							if(Utils.iniciarBatalla(jugador, bosqueEntidades[i])) {
								 closeGame = true;
								 JOptionPane.showMessageDialog(null, "El héroe ha sido derrotado, el mundo se sume a un caos.", "GAMEOVER", JOptionPane.DEFAULT_OPTION, null);
							 }
						}
					}
				} else if (mapa == CUEVA) {
					for(int i = 0; i < cuevaEntidades.length; i++) {
						cuevaEntidades[i].mover(jugador, mapa);
						if (Utils.estaInteractuando(jugador, cuevaEntidades[i])) {
							 if(Utils.iniciarBatalla(jugador, cuevaEntidades[i])) {
								 closeGame = true;
								 JOptionPane.showMessageDialog(null, "El héroe ha sido derrotado, el mundo se sume a un caos.", "GAMEOVER", JOptionPane.DEFAULT_OPTION, null);
							 }
						}
					}
				} else if (mapa == TEMPLO) {

				} else if (mapa == CASTILLO_DEMONIO) {
					for(int i = 0; i < castilloDemonioEntidades.length; i++) {
						castilloDemonioEntidades[i].mover(jugador, mapa);
						if (Utils.estaInteractuando(jugador, castilloDemonioEntidades[i])) {
							 if(Utils.iniciarBatalla(jugador, castilloDemonioEntidades[i])) {
								 closeGame = true;
								 JOptionPane.showMessageDialog(null, "El héroe ha sido derrotado, el mundo se sume a un caos.", "GAMEOVER", JOptionPane.DEFAULT_OPTION, null);
							 }
						}
					}
				}
				
				if (!reyDemonio1.isEstaVivo()) {
					JOptionPane.showMessageDialog(null, "¡Enhorabuena has derrotado al rey demonio!, puedes sentir como el mundo entero regresa a la paz.");
					closeGame = true;
				}
			}

			//JUEGO
			} while (!closeGame);
		}
		JOptionPane.showMessageDialog(null, "Fin de juego.");
	}

}
