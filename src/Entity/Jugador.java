package Entity;

import java.util.Arrays;

import javax.swing.JOptionPane;

import Items.Arma;
import Items.Botas;
import Items.Cabeza;
import Items.Consumibles;
import Items.Guantes;
import Items.Items;
import Items.Pecho;
import Map.Color;
import Map.Mapa;
import Skills.Habilidades;

public class Jugador extends Personaje {
	
	private Cabeza cabeza;
	private Botas botas;
	private Guantes guantes;
	private Pecho pecho;
	private Arma arma;
	
	private int totalDefensaFisica;
	private int totalDefensaMagica;
	private int totalFuerza;
	private int totalInteligencia;
	private int totalDestreza;
	private int totalVelocidad;
	private int maxStamina;
	private int maxMana;
	private int stamina;
	private int mana;
	private Habilidades[] habilidades = new Habilidades[10];
	private int gold = 0;
	private Consumibles efecto;
	private int duracionEfecto = 0;
	private boolean interactuable = true;

	Items[] inventarioConsumible = new Items[0]; //Inventario de tamaño 10
	Items[] inventarioItemsComun = new Items[0]; //TODO
	int[] inventarioCantidad = new int[0];

    private Jugador(String nombre, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaFisica, int defensaMagica) {
        super(nombre, representacion, fuerza, inteligencia, destreza, velocidad, salud, defensaFisica, defensaMagica);
        
        this.exp = 0;
        this.nivel = 1;
        
        this.maxStamina = 100;
        this.maxMana = 100;
        this.mana = 100;
        this.stamina = 100;
        
        this.totalDefensaFisica = defensaFisica;
        this.totalDefensaMagica = defensaMagica;
        this.totalFuerza = fuerza;
        this.totalInteligencia = inteligencia;
        this.totalDestreza = destreza;
        this.totalVelocidad = velocidad;
        
        this.cabeza = Cabeza.VACIO;
        this.botas = Botas.VACIO;
        this.guantes = Guantes.VACIO;
        this.pecho = Pecho.VACIO;
        this.arma = Arma.VACIO;
        
        Arrays.fill(habilidades, Habilidades.VACIO);
        
        this.recibirItemConsumible(Arma.getEspadaVieja());
        this.recibirItemConsumible(Consumibles.getPocionM());
    }
    
    public static final Jugador JUGADOR = new Jugador("Héroe", Color.NEGRO + "@" + Color.RESET, 5, 4, 3, 5, 100, 5, 5);
    
    public static Jugador getJugador() {
		return JUGADOR;
	}

	/**
     * Metodo para dar exp al jugador
     * @param cantidad de exp (int)
     */
    public void recibirExp(int cantidad) {
    	this.exp += cantidad;
    	do {
    		if (this.exp >= LEVEL_UP_CAP) {
    			this.levelUp();
    			this.exp -= LEVEL_UP_CAP;
    		}
    	} while (this.exp >= LEVEL_UP_CAP);
    }

    /**
     * Metodo para cuando sube de nivel
     */
    public void levelUp() {
    	this.nivel++;
    	this.fuerza += (nivel*0.5);
    	this.inteligencia += (nivel*0.5);
    	this.destreza += (nivel*0.5);
    	this.velocidad += (nivel*0.5);
    	this.defensaFisico += (nivel*0.5);
    	this.defensaMagica += (nivel*0.5);
    	
    	refreshStats();
    	
    	this.recibirSkills();
    }
    
    /**
     * Metodo que da habilidades al jugador si cumple las condiciones.
     */
    private void recibirSkills() {
    	// Habilidad Finta (Nivel 3)
        if (this.nivel >= 3 && !yaTieneSkill(Habilidades.getFINTA())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getFINTA();
            }
        }

        // Habilidad Llamarada (Nivel 5)
        if (this.nivel >= 5 && !yaTieneSkill(Habilidades.getFUEGO())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getFUEGO();
            }
        }

        // Habilidad Corte rápido (Nivel 7)
        if (this.nivel >= 7 && !yaTieneSkill(Habilidades.getCORTE())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getCORTE();
            }
        }

        // Habilidad Disparo certero (Nivel 10)
        if (this.nivel >= 10 && !yaTieneSkill(Habilidades.getDISPARO())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getDISPARO();
            }
        }

        // Habilidad Bola de energía (Nivel 12)
        if (this.nivel >= 12 && !yaTieneSkill(Habilidades.getBOLA())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getBOLA();
            }
        }

        // Habilidad Golpe contundente (Nivel 15)
        if (this.nivel >= 15 && !yaTieneSkill(Habilidades.getGOLPE())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getGOLPE();
            }
        }

        // Habilidad Corte brutal (Nivel 18)
        if (this.nivel >= 18 && !yaTieneSkill(Habilidades.getCORTE_B())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getCORTE_B();
            }
        }

        // Habilidad Puño demoledor (Nivel 20)
        if (this.nivel >= 20 && !yaTieneSkill(Habilidades.getPUNO())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getPUNO();
            }
        }

        // Habilidad Estocada mortal (Nivel 25)
        if (this.nivel >= 25 && !yaTieneSkill(Habilidades.getESTOCADA())) {
            if (posicionSkill() != -1) {
                this.habilidades[posicionSkill()] = Habilidades.getESTOCADA();
            }
        }
    }
    
    /**
     * Da la primera posicion libre en la lista de habilidades
     * @return int Posicion libre, si no hay retorna -1
     */
    public int posicionSkill() {
        for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i] == Habilidades.VACIO) {
                return i; // Retorna el índice donde es vacio
            }
        }
        
        return -1; // Retorna -1 si no se encontró ninguna
    }

    /**
     * Comprueba si el jugador ya tiene la habilidad
     * @param skill habilidad que se va comprobar
     * @return Verdadero si ya lo tiene, falso si no lo tiene
     */
    public boolean yaTieneSkill(Habilidades skill) {
    	for (int i = 0; i < habilidades.length; i++) {
            if (habilidades[i] == skill) {
                return true; // Retorna el índice donde es vacio
            }
        }
    	return false;
    }
    
    /**
     * Recibe un item en el inventario consumible.
     * @param item
     */
    public void recibirItemConsumible(Items item) {
    	int tamano = this.inventarioConsumible.length;
    	Items[] temporal = new Items[tamano + 1];
    	for (int i = 0; i < tamano; i++) {
    		temporal[i] = this.inventarioConsumible[i];
        }
    	temporal[tamano] = item;
    	this.inventarioConsumible = temporal;
    }
    
    /**
     * Quita un item del inventario consumible.
     * @param item El item a quitar.
     * @return true si el item fue eliminado correctamente, false si no se encontraba en el inventario.
     */
    public boolean quitarItemConsumible(Items item) {
    	boolean eliminado = false;

    	// Usar el método buscarItem para encontrar la posición del item en inventarioConsumible
    	int posicion = this.buscarItem(this.inventarioConsumible, item);

    	// Si el item se encuentra en el inventario
    	if (posicion != -1) {
    		// Crear un nuevo array con un tamaño menor
    		Items[] nuevoInventario = new Items[this.inventarioConsumible.length - 1];

    		// Copiar los elementos anteriores al ítem eliminado
    		for (int i = 0; i < posicion; i++) {
    			nuevoInventario[i] = this.inventarioConsumible[i];
    		}

    		// Copiar los elementos posteriores al ítem eliminado
    		for (int i = posicion + 1; i < this.inventarioConsumible.length; i++) {
    			nuevoInventario[i - 1] = this.inventarioConsumible[i];
    		}

    		// Reemplazar el array original con el nuevo array sin el ítem eliminado
    		this.inventarioConsumible = nuevoInventario;

    		eliminado = true;
    	}

    	return eliminado;
    }
    

    /**
     * Calcula la cantidad de defensa fisica total
     * @return defensa fisica total
     */
    public int defensaFEquipada() {
    	int total;
    	total = this.defensaFisico + cabeza.getDefensa() + botas.getDefensa() + guantes.getDefensa() + pecho.getDefensa();
    	return total;
    }
    
    /**
    * Calcula la cantidad de defensa magica total
    * @return defensa magica total
    */
    public int defensaMEquipada() {
    	int total;
    	total = this.defensaMagica + cabeza.getDefensa() + botas.getDefensa() + guantes.getDefensa() + pecho.getDefensa();
    	return total;
    }
    
    /**
     * Calcula la cantidad de fuerza total
     * @return fuerza total
     */
    public int fuerzaEquipada() {
    	int total; 
    	total = this.fuerza + guantes.getFuerza();
    	return total;
    }
    
    /**
     * Calcula la cantidad de velocidad total
     * @return velocidad total
     */
    public int velocidadEquipada() {
    	int total;
    	total = this.velocidad + cabeza.getVelocidad() + botas.getVelocidad() + guantes.getVelocidad() + pecho.getVelocidad() + arma.getVelocidad();
    	return total;
    }
    
    /**
     * Calcula la cantidad de inteligencia total
     * @return inteligencia total
     */
    public int inteligenciaEquipada() {
    	int total;
    	total = this.inteligencia + cabeza.getInteligencia() + botas.getInteligencia() + guantes.getInteligencia() + pecho.getInteligencia() + arma.getInteligencia();
    	return total;
    }
    
    /**
     * Metodo que refresca las estadisticas necesarias del jugador
     */
    public void refreshStats() {
    	this.totalDefensaFisica = defensaFEquipada();
    	this.totalDefensaMagica = defensaMEquipada();
    	this.totalDestreza = this.destreza; //TODO
    	this.totalFuerza = fuerzaEquipada();
    	this.totalVelocidad = velocidadEquipada();
    	this.totalInteligencia = inteligenciaEquipada();
    }
    
    /**Muestra joption pane de lista de objetos
     * 
     * @return Retorna el objeto seleccionado
     */
    public boolean menuInventario(Items[] inventario) {
    	boolean accion = false;
    	if (inventario.length != 0) {
    		
        	String[] nombresItems = new String[inventario.length];
        	
        	//prepara una lista con los nombres de los items
        	for (int i = 0; i < inventario.length; i++) {
        		if (this.inventarioConsumible[i] != null) {
        			nombresItems[i] = this.inventarioConsumible[i].getNombre();
        		} else {
        			nombresItems[i] = Items.VACIO.getNombre();
        		}
        	}
        	
        	//Muestra un listado de los nombres del item
        	String seleccion = (String) JOptionPane.showInputDialog(
        			null,
        			"Selecciona un ítem:",
        			"Inventario",
        			JOptionPane.PLAIN_MESSAGE,
        			null,
        			nombresItems,
        			nombresItems[0]
        			);
        	
        	//Problema si hay varios items con el mismo nombre tomará el primero del inventario

        	//Si se ha seleccionado un item busca la posicion del inventario
        	if (seleccion != null) {
        		
        		boolean encontrado = false;
        		accion = false;
        		for (int i = 0; i < inventario.length && !encontrado; i++) {
        			if (nombresItems[i].equals(seleccion)) {
        				if (nombresItems[i].equals(Items.VACIO.getNombre())) {
        					accion = false;
        				} else {
        					accion = opcionItems(inventario[i], i);
        					encontrado = true;
        				}
        			}
        		}
        	} else {
        		accion = false;
        	}
        	
        	
    	} else {
    		JOptionPane.showMessageDialog(null, "Tienes los bolsillos vacíos.");
    	}
    	return accion;
    }
    
    /**
     * Recibe el item y pregunta al jugador que desea hacer con el item.
     * @param item
     */
    public boolean opcionItems(Items item, int posInventario) {
    	boolean accion;
    	if (item != null) {
    		// Opciones del JOptionPane
        	final int USAR = 0;
        	final int TIRAR = 1;
        	final int CANCEL = 2;
        	
        	String[] opciones = {"Usar", "Tirar", "Cancelar"};

        	// Mostrar el JOptionPane con las opciones
        	int eleccion = JOptionPane.showOptionDialog(
        			null,
        			"¿Qué deseas hacer con " + item.getNombre() + "?",
        			"Ítem",
        			JOptionPane.DEFAULT_OPTION,
        			JOptionPane.QUESTION_MESSAGE,
        			null,
        			opciones,
        			opciones[0] // Opción predeterminada seleccionada
        			);

        	switch (eleccion) {
        	case USAR:
        		item.usar(this);
        		this.refreshStats();
        		this.quitarItemConsumible(item);
        		accion = true;
        		break;
        	case TIRAR:
        		this.quitarItemConsumible(item);
        		accion = true;
        		break;
        	case CANCEL:
        		JOptionPane.showMessageDialog(null, "No se realizó ninguna acción. Caso a");
        		accion = false;
        		break;
        	case JOptionPane.CLOSED_OPTION: // Si cierran el cuadro
        		JOptionPane.showMessageDialog(null, "No se realizó ninguna acción. Caso b");
        		accion = false;
        		break;
        	default:
        		accion = false;
        		break;
        	}
        	
    	}
    	accion = false;
    	return accion;
    }
    
    /**
     * Metodo que muestra el menu de habilidades del jugador
     * @param objetivo Enemigo que se esta luchando
     * @return String Un mensaje que explica que ha realizado la habilidad
     */
    public String menuHabilidades(Personaje objetivo) { //TODO
    	String resultado = "";
        if (habilidades.length == 0) {
            JOptionPane.showMessageDialog(null, "No tienes habilidades disponibles.");
            resultado = "No se hizo nada.";
        } else {
        	// Crear un array de nombres de habilidades
            String[] nombresHabilidades = new String[habilidades.length];
            for (int i = 0; i < habilidades.length; i++) {
                nombresHabilidades[i] = habilidades[i].getNombre();
            }
            
            String textoSkills = "";
            for (int i = 0; i < habilidades.length; i++) {
            	textoSkills += habilidades[i].getNombre() + "\n";
            	textoSkills += habilidades[i].getDescripcion() + "\n\n";
            }
            

            // Mostrar el menú de habilidades en un JOptionPane
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecciona una habilidad: \n" + 
                    textoSkills,
                    "Menú de Habilidades",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    nombresHabilidades,
                    nombresHabilidades[0] // Selección predeterminada
            );
            
            // Si el usuario seleccionó una habilidad
            if (seleccion != null) {
                // Buscar la habilidad seleccionada y ejecutarla
                for (Habilidades habilidad : habilidades) {
                    if (habilidad.getNombre().equals(seleccion)) {
                        resultado = habilidad.realizarSkill(this, objetivo);
                        break;
                    }
                }
            } else {
            	resultado = "No se hizo nada.";
            } 
        }
        return resultado;
    }
    
    
    
    /**
     * Metodo que calcula el daño crudo del jugador
     * @return double Daño
     */
    public double calcularDmg() {
    	double dmg;
    	int critRate = 1;
    	dmg = this.arma.getDaño() + this.getTotalFuerza();
    	critRate += (this.destreza * 0.5);
    	if ((int)(Math.random() * 100) + 1 < critRate) {
    		dmg *= 2;
    	}
    	return Math.round(dmg * 100) / 100;
    }
    
    /**
     * Metodo para regenerar la estamina y el mana tras turnos
     */
    public void regenStaminaManaTurno() {
    	//TODO numeros magicos
    	this.mana += 10;
    	this.stamina += 15;
    	this.mana = Math.min(this.mana, this.maxMana);
    	this.stamina = Math.min(this.stamina, this.maxStamina);
    }
    
    /**
     * Metodo que calcula si el jugador es capaz de huir de batalla
     * @param enemigo Enemigo del que se quiere huir
     * @return True si es capaz de huir, False si no ha podido huir
     */
    public boolean puedeHuir(Enemigo enemigo) {
    	double oportunidadJugador;
    	double valorEnemigo;
    	oportunidadJugador = this.totalVelocidad + (this.totalDestreza / 2) + (this.totalInteligencia / 3);
    	valorEnemigo = (enemigo.velocidad + (enemigo.destreza / 2) + (enemigo.inteligencia / 3)) * (enemigo.getSalud()/enemigo.getMaxSalud());
    	
    	int oportunidad = (int)(Math.random() * (oportunidadJugador + valorEnemigo)) + 1;
    	
    	if (oportunidad < oportunidadJugador) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    /**
     * Busca el item en el inventario deseado
     * @param inventario
     * @param item
     * @return posicion dentro del array, -1 si no se encuentra
     */
    public int buscarItem(Items[] inventario, Items item) {
    	for (int i = 0; i < inventario.length; i++) {
            if (inventario[i].equals(item)) {
                return i;
            }
        }
    	return -1;
    }
    
    /**
     * Metodo para recibir un item comun
     * @param item
     * @param cantidad
     * @return True si se ha realizado correctamente False si no se ha realizado correctamente
     */
    public boolean recibirItemInventarioComun(Items item, int cantidad) {
        boolean agregado = false;
        
        // Buscar si el item ya está en el inventario
        int posicion = this.buscarItem(this.inventarioItemsComun, item);
        
        if (posicion != -1) {
            // Si el item ya está en el inventario, solo aumentamos su cantidad
            this.inventarioCantidad[posicion] += cantidad;
            agregado = true;
        } else {
            // Si el item no está en el inventario, agregarlo
            // Crear nuevo inventario de mayor tamaño
            Items[] nuevoInventarioItems = new Items[this.inventarioItemsComun.length + 1];
            int[] nuevoInventarioCantidad = new int[this.inventarioCantidad.length + 1];
            
            // Copiar los valores actuales al nuevo inventario
            for (int i = 0; i < this.inventarioItemsComun.length; i++) {
                nuevoInventarioItems[i] = this.inventarioItemsComun[i];
                nuevoInventarioCantidad[i] = this.inventarioCantidad[i];
            }
            
            // Agregar el nuevo item y su cantidad al final
            nuevoInventarioItems[this.inventarioItemsComun.length] = item;
            nuevoInventarioCantidad[this.inventarioCantidad.length] = cantidad;
            
            // Reemplazar los arrays originales con los nuevos
            this.inventarioItemsComun = nuevoInventarioItems;
            this.inventarioCantidad = nuevoInventarioCantidad;
            
            agregado = true;
        }
        
        return agregado;
    }
    
    /**
     * Quita la cantidad de un item del inventario comun
     * @param item
     * @param cantidad
     * @return true si se ha realizado, false si no se ha podido.
     */
    public boolean quitarItemInventarioComun(Items item, int cantidad) {
        boolean quitado = false;
        int posicion = this.buscarItem(this.inventarioItemsComun, item);
        
        if (posicion != -1) {
            if (this.inventarioCantidad[posicion] == cantidad) {
                // Si la cantidad que se quiere quitar es exactamente la cantidad existente
                this.inventarioCantidad[posicion] = 0;
                this.inventarioItemsComun[posicion] = null;
                quitado = true;
                
                // Reducir el tamaño del inventario
                // Crear nuevos arrays con un tamaño menor
                Items[] nuevoInventarioItems = new Items[this.inventarioItemsComun.length - 1];
                int[] nuevoInventarioCantidad = new int[this.inventarioCantidad.length - 1];
                
                // Copiar todos los elementos excepto el que se eliminó
                int j = 0;
                for (int i = 0; i < this.inventarioItemsComun.length; i++) {
                    if (i != posicion) {
                        nuevoInventarioItems[j] = this.inventarioItemsComun[i];
                        nuevoInventarioCantidad[j] = this.inventarioCantidad[i];
                        j++;
                    }
                }
                
                // Reemplazar los arrays originales con los nuevos
                this.inventarioItemsComun = nuevoInventarioItems;
                this.inventarioCantidad = nuevoInventarioCantidad;
            } else if (this.inventarioCantidad[posicion] > cantidad) {
                // Si solo se reduce la cantidad, no se elimina el item del inventario
                this.inventarioCantidad[posicion] -= cantidad;
                quitado = true;
            }
        }
        
        return quitado;
    }
    /**
     * Quitar oro
     * @param cantidad
     */
    public void quitarOro(int cantidad) {
    	this.gold -= cantidad;
    }
    /**
     * REcibe oro
     * @param cantidad
     */
    public void recibirOro(int cantidad) {
    	this.gold += cantidad;
    }
    
    /**
     * Recibe los efectos de un item
     * @param item
     */
    public void recibirEffecto(Consumibles item) {
    	this.efecto = item;
    	this.fuerza += item.getBoostAtk();
    	this.mana += item.getBoostMp();
    	this.mana = Math.min(this.mana, this.maxMana);
    	this.velocidad += item.getBoostSpd();
    	this.destreza += item.getBoostDxt();
    	this.inteligencia += item.getBoostInt();
    }
    
    /**
     * Para conteo del efecto de consumibles, elimina los efectos cuando alcanza la duracion
     */
    public void nuevoTurnoEfectos() {
    	if (this.duracionEfecto < this.efecto.getDuracion()) {
    		this.duracionEfecto++;
    	} else if (this.duracionEfecto >= this.efecto.getDuracion()) {
    		this.fuerza -= this.efecto.getBoostAtk();
        	this.velocidad -= this.efecto.getBoostSpd();
        	this.destreza -= this.efecto.getBoostDxt();
        	this.inteligencia -= this.efecto.getBoostInt();
        	this.efecto = Consumibles.getSinEfecto();
        	this.duracionEfecto = 0;
    	}
    }
    
    /**
	 * Metodo para mover al personaje arriba
	 * @param map
	 */
    @Override
	public void moverArriba(Mapa map) {
		if (this.posicionY != 0) {
			if (map.esTransitable(this.posicionX, this.posicionY-1)) {
				this.posicionY--;
			} else {
				JOptionPane.showMessageDialog(null, "Algo te bloquea el paso");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sientes que una energia misteriosa te impide moverte");
		}
	}
	
	/**
	 * Metodo para mover al personaje abajo
	 * @param map
	 */
    @Override
	public void moverAbajo(Mapa map) {
		if (this.posicionY+1 < map.getAlto()) {
			if (map.esTransitable(this.posicionX, this.posicionY+1)) {
				this.posicionY++;
			} else {
				JOptionPane.showMessageDialog(null, "Algo te bloquea el paso");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sientes que una energia misteriosa te impide moverte");
		}
	}
	
	/**
	 * Metodo para mover al personaje derecha
	 * @param map
	 */
    @Override
	public void moverDerecha(Mapa map) {
		if (this.posicionX+1 < map.getAncho()) {
			if (map.esTransitable(this.posicionX+1, this.posicionY)) {
				this.posicionX++;
			} else {
				JOptionPane.showMessageDialog(null, "Algo te bloquea el paso");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sientes que una energia misteriosa te impide moverte");
		}
	}
    
    /**
	 * Metodo para mover al personaje izquierda
	 * @param map
	 */
    @Override
	public void moverIzquierda(Mapa map) {
		if (this.posicionX != 0) {
			if (map.esTransitable(this.posicionX-1, this.posicionY) && this.posicionX != 0) {
				this.posicionX--;
			} else {
				JOptionPane.showMessageDialog(null, "Algo te bloquea el paso");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Sientes que una energia misteriosa te impide moverte");
		}
	}

	public int getTotalDefensaFisica() {
		return totalDefensaFisica;
	}

	public void setTotalDefensaFisica(int totalDefensa) {
		this.totalDefensaFisica = totalDefensa;
	}
	
	public int getTotalDefensaMagica() {
		return totalDefensaMagica;
	}

	public void setTotalDefensaMagica(int totalDefensa) {
		this.totalDefensaMagica = totalDefensa;
	}

	public int getTotalFuerza() {
		return totalFuerza;
	}

	public void setTotalFuerza(int totalFuerza) {
		this.totalFuerza = totalFuerza;
	}

	public int getTotalInteligencia() {
		return totalInteligencia;
	}

	public void setTotalInteligencia(int totalInteligencia) {
		this.totalInteligencia = totalInteligencia;
	}

	public int getTotalDestreza() {
		return totalDestreza;
	}

	public void setTotalDestreza(int totalDestreza) {
		this.totalDestreza = totalDestreza;
	}

	public int getTotalVelocidad() {
		return totalVelocidad;
	}

	public void setTotalVelocidad(int totalVelocidad) {
		this.totalVelocidad = totalVelocidad;
	}

	public Cabeza getCabeza() {
		return cabeza;
	}

	public void setCabeza(Cabeza cabeza) {
		this.cabeza = cabeza;
	}

	public Botas getBotas() {
		return botas;
	}

	public void setBotas(Botas botas) {
		this.botas = botas;
	}

	public Guantes getGuantes() {
		return guantes;
	}

	public void setGuantes(Guantes guantes) {
		this.guantes = guantes;
	}

	public Pecho getPecho() {
		return pecho;
	}

	public void setPecho(Pecho pecho) {
		this.pecho = pecho;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Items[] getInventarioConsumible() {
		return inventarioConsumible;
	}

	public Items[] getInventarioItemsComun() {
		return inventarioItemsComun;
	}

	public int[] getInventarioCantidad() {
		return inventarioCantidad;
	}

	public void setInventarioConsumible(Items[] inventarioConsumible) {
		this.inventarioConsumible = inventarioConsumible;
	}

	public void setInventarioItemsComun(Items[] inventarioItemsComun) {
		this.inventarioItemsComun = inventarioItemsComun;
	}

	public void setInventarioCantidad(int[] inventarioCantidad) {
		this.inventarioCantidad = inventarioCantidad;
	}

	public int getMaxStamina() {
		return maxStamina;
	}

	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public boolean isInteractuable() {
		return interactuable;
	}

	public void setInteractuable(boolean interactuable) {
		this.interactuable = interactuable;
	}
    
    
}
