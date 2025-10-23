package Skills;

import Entity.Personaje;
import Entity.Jugador;
import Items.Arma;

public class Habilidades {
	String nombre;
	String descripcion;
	final int ID_HABILIDAD;
	static int numDeHabilidades;
	
	private Habilidades(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ID_HABILIDAD = numDeHabilidades;
		numDeHabilidades++;
	}
	
	public static Habilidades VACIO = new Habilidades(
		"-----------",
		"------------------------------------------------------------------------------------"
	);
	
	private static Habilidades FINTA = new Habilidades(
		"Finta",
		"Ataca al enemigo con una elegante finta dificil de esquivar. (espada)(15 stamina)");
	
	private static Habilidades FUEGO = new Habilidades(
		"Llamarada",
		"Invoca fuego sobre el enemigo. (bastón)(20 mana)"
	);
	
	private static Habilidades CORTE = new Habilidades(
	    "Corte rápido", // nombre
	    "Realiza un corte veloz que puede dañar al enemigo con gran precisión. (espada)(10 stamina)"
	);

	// Habilidad para arco
	private static Habilidades DISPARO = new Habilidades(
	    "Disparo certero", // nombre
	    "Dispara una flecha con gran precisión, aumentando el daño en función de la distancia. (arco)(15 stamina)"
	);

	// Habilidad para magia
	private static Habilidades BOLA = new Habilidades(
	    "Bola de energía", // nombre
	    "Lanza una bola de energía mágica que inflige daño a todos los enemigos en su camino. (bastón)(25 mana)"
	);

	// Habilidad para maza
	private static Habilidades GOLPE = new Habilidades(
	    "Golpe contundente", // nombre
	    "Realiza un golpe fuerte que derrumba al enemigo, reduciendo su defensa. (maza)(20 stamina)"
	);

	// Habilidad para hacha
	private static Habilidades CORTE_B = new Habilidades(
	    "Corte brutal", // nombre
	    "Un golpe poderoso con el hacha que corta incluso las defensas más fuertes. (hacha)(18 stamina)"
	);

	// Habilidad para mano (puños)
	private static Habilidades PUNO = new Habilidades(
	    "Puño demoledor", // nombre
	    "Un golpe poderoso con el puño, con posibilidad de aturdir al enemigo. (mano)(12 stamina)"
	);

	// Habilidad para lanza
	private static Habilidades ESTOCADA = new Habilidades(
	    "Estocada mortal", // nombre
	    "Lanza un ataque penetrante a gran distancia, causando daño directo. (lanza)(15 stamina)"
	);

	
	/**
	 * Metodo para realizar una habilidad/skill
	 * @param jugador quien realiza la habilidad
	 * @param objetivo quien recibe la habilidad
	 * @return String mensaje de que ha realizado el jugador.
	 */
	//TODO valores de daño de las habilidades pueden estar muy desbalaceados (sin testear)
	public String realizarSkill(Jugador jugador, Personaje objetivo) {
		double dmg;
		String battleLog = "";
		if (this.ID_HABILIDAD == VACIO.ID_HABILIDAD) {
			battleLog += "No se hizo nada.";
		} else if (this.ID_HABILIDAD == FINTA.ID_HABILIDAD) {
			if (jugador.getArma().getTipo() == Arma.TIPO_ESPADA && jugador.getStamina() > 15) {
				dmg = jugador.getTotalFuerza() + jugador.getArma().getDaño() + (jugador.getTotalDestreza() / 1.7);
				jugador.setStamina(jugador.getStamina() - 15);
				battleLog += objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueFisico(dmg) + " de daño.\n";
			} else {
				//No cumples las condiciones para usar la habilidad
				battleLog += jugador.getNombre() + " intenta realizar una finta. Pero no ocurre nada.\n";
			}
		} else if (this.ID_HABILIDAD == FUEGO.ID_HABILIDAD) {
			if (jugador.getTotalInteligencia() >= 15 && jugador.getMana() > 20) {
				dmg = jugador.getTotalInteligencia() * 1.3;
				jugador.setMana(jugador.getMana() - 20);
				battleLog +=  objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueMagico(dmg) + " de daño.\n";
			} else {
				//No cumples las condiciones para usar la habilidad
				battleLog += jugador.getNombre() + " intenta invocar unas llamas. Pero no ocurre nada.\n";
			}
		}  else if (this.ID_HABILIDAD == CORTE.ID_HABILIDAD) {
	        // Habilidad para espada: "Corte rápido"
	        if (jugador.getArma().getTipo() == Arma.TIPO_ESPADA && jugador.getStamina() > 10) {
	            dmg = jugador.getTotalFuerza() + jugador.getArma().getDaño() + (jugador.getTotalDestreza() / 1.7);
	            jugador.setStamina(jugador.getStamina() - 10);
	            battleLog += objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueFisico(dmg) + " de daño.\n";
	        } else {
	            battleLog += jugador.getNombre() + " intenta realizar un corte rápido. Pero no ocurre nada.\n";
	        }
	    } else if (this.ID_HABILIDAD == DISPARO.ID_HABILIDAD) {
	        // Habilidad para arco: "Disparo certero"
	        if (jugador.getArma().getTipo() == Arma.TIPO_ARCO && jugador.getStamina() > 15) {
	            dmg = jugador.getTotalDestreza() + jugador.getArma().getDaño();
	            jugador.setStamina(jugador.getStamina() - 15);
	            battleLog += objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueFisico(dmg) + " de daño.\n";
	        } else {
	            battleLog += jugador.getNombre() + " intenta realizar un disparo certero. Pero no ocurre nada.\n";
	        }
	    } else if (this.ID_HABILIDAD == BOLA.ID_HABILIDAD) {
	        // Habilidad para magia: "Bola de energía"
	        if (jugador.getTotalInteligencia() >= 35 && jugador.getMana() > 25) {
	            dmg = jugador.getTotalInteligencia() * 2;
	            jugador.setMana(jugador.getMana() - 25);
	            battleLog += objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueMagico(dmg) + " de daño.\n";
	        } else {
	            battleLog += jugador.getNombre() + " intenta lanzar una bola de energía. Pero no ocurre nada.\n";
	        }
	    } else if (this.ID_HABILIDAD == GOLPE.ID_HABILIDAD) {
	        // Habilidad para maza: "Golpe contundente"
	        if (jugador.getArma().getTipo() == Arma.TIPO_MAZA && jugador.getStamina() > 20) {
	            dmg = jugador.getTotalFuerza() + jugador.getArma().getDaño();
	            jugador.setStamina(jugador.getStamina() - 20);
	            battleLog += objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueFisico(dmg) + " de daño y su defensa es reducida.\n";
	        } else {
	            battleLog += jugador.getNombre() + " intenta realizar un golpe contundente. Pero no ocurre nada.\n";
	        }
	    } else if (this.ID_HABILIDAD == CORTE_B.ID_HABILIDAD) {
	        // Habilidad para hacha: "Corte brutal"
	        if (jugador.getArma().getTipo() == Arma.TIPO_HACHA && jugador.getStamina() > 18) {
	            dmg = jugador.getTotalFuerza() + jugador.getArma().getDaño();
	            jugador.setStamina(jugador.getStamina() - 18);
	            battleLog += objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueFisico(dmg) + " de daño.\n";
	        } else {
	            battleLog += jugador.getNombre() + " intenta realizar un corte brutal. Pero no ocurre nada.\n";
	        }
	    } else if (this.ID_HABILIDAD == PUNO.ID_HABILIDAD) {
	        // Habilidad para mano: "Puño demoledor"
	        if (jugador.getArma().getTipo() == Arma.TIPO_MANO && jugador.getStamina() > 12) {
	            dmg = jugador.getTotalFuerza() * 1.2;
	            jugador.setStamina(jugador.getStamina() - 12);
	            // Podría tener un efecto adicional, como aturdir, pero aquí simplemente inflige daño.
	            battleLog += objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueFisico(dmg) + " de daño y podría ser aturdido.\n";
	        } else {
	            battleLog += jugador.getNombre() + " intenta realizar un puño demoledor. Pero no ocurre nada.\n";
	        }
	    } else if (this.ID_HABILIDAD == ESTOCADA.ID_HABILIDAD) {
	        // Habilidad para lanza: "Estocada mortal"
	        if (jugador.getArma().getTipo() == Arma.TIPO_LANZA && jugador.getStamina() > 15) {
	            dmg = jugador.getTotalFuerza() + jugador.getArma().getDaño();
	            jugador.setStamina(jugador.getStamina() - 15);
	            battleLog += objetivo.getNombre() + " recibe " + objetivo.recibirAtaqueFisico(dmg) + " de daño.\n";
	        } else {
	            battleLog += jugador.getNombre() + " intenta realizar una estocada mortal. Pero no ocurre nada.\n";
	        }
	    }
		
		return battleLog;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static Habilidades getFINTA() {
		return FINTA;
	}

	public static Habilidades getFUEGO() {
		return FUEGO;
	}

	public static Habilidades getCORTE() {
		return CORTE;
	}

	public static Habilidades getDISPARO() {
		return DISPARO;
	}

	public static Habilidades getBOLA() {
		return BOLA;
	}

	public static Habilidades getGOLPE() {
		return GOLPE;
	}

	public static Habilidades getCORTE_B() {
		return CORTE_B;
	}

	public static Habilidades getPUNO() {
		return PUNO;
	}

	public static Habilidades getESTOCADA() {
		return ESTOCADA;
	}
	
}
