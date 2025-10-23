package Entity;

import Map.Mapa;

public class Personaje extends Entidad{
	final int SIZE = 10;
	public final int LEVEL_UP_CAP = 50;
	
	private String nombre;
    protected int fuerza;
    protected int inteligencia;
    protected int destreza;
    protected int velocidad;
    private int maxSalud;
    private double salud;
    protected int defensaFisico;
    protected int defensaMagica;
    protected boolean estaVivo;
    
    protected int exp;
    protected int nivel; //TODO implementar incremento de estadisticas con el nivel

    // Constructor
    public Personaje(String nombre, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaF, int defensaM) {
    	super(representacion);
    	this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.destreza = destreza;
        this.velocidad = velocidad;
        this.maxSalud = salud;
        this.salud = salud;
        this.defensaFisico = defensaF;
        this.defensaMagica = defensaM;
        this.estaVivo = true;
    }
    
    public Personaje(String nombre, int x, int y, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaF, int defensaM) {
    	super(x, y, representacion);
    	this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.destreza = destreza;
        this.velocidad = velocidad;
        this.maxSalud = salud;
        this.salud = salud;
        this.defensaFisico = defensaF;
        this.defensaMagica = defensaM;
        this.estaVivo = true;
    }
    
    /**
     * Metodo para recibir daño fisico
     * @param dmg 
     * @return Double Retorna la cantidad de daño recibido
     */
    public double recibirAtaqueFisico(double dmg) {
    	double dmgFinal = dmg * (1 - (double)this.defensaFisico * 0.01);
    	dmgFinal = Math.round(dmgFinal * 100.0) / 100.0;
    	this.salud -= Math.max(dmgFinal, 0);
    	this.salud = Math.round(this.salud * 100.0) / 100.0;
    	return Math.max(dmgFinal, 0);
    }
    
    /**
     * Metodo para recibir daño magico
     * @param dmg 
     * @return Double Retorna la cantidad de daño recibido
     */
    public double recibirAtaqueMagico(double dmg) {
    	double dmgFinal = dmg * (1 - (double)this.defensaMagica * 0.01);
    	dmgFinal = Math.round(dmgFinal * 100.0) / 100.0;
    	this.salud -= Math.max(dmgFinal, 0);
    	this.salud = Math.round(this.salud * 100.0) / 100.0;
    	return Math.max(dmgFinal, 0);
    }

    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }

	public double getSalud() {
		return this.salud;
	}

	public void setSalud(double salud) {
		this.salud = salud;
	}
	
	public int getMaxSalud() {
		return maxSalud;
	}

	public void setMaxSalud(int maxSalud) {
		this.maxSalud = maxSalud;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public boolean isEstaVivo() {
		if (this.salud <= 0) {
			this.estaVivo = false;
		}
		return estaVivo;
	}

	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}


	public int getFuerza() {
		return fuerza;
	}


	public int getInteligencia() {
		return inteligencia;
	}


	public int getDestreza() {
		return destreza;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public int getDefensaFisico() {
		return defensaFisico;
	}


	public int getDefensaMagica() {
		return defensaMagica;
	}


	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}


	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}


	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	public void setDefensaFisico(int defensaFisico) {
		this.defensaFisico = defensaFisico;
	}


	public void setDefensaMagica(int defensaMagica) {
		this.defensaMagica = defensaMagica;
	}


	public void curar(double cantidad) {
		this.salud += cantidad;
		
		if (this.salud > this.maxSalud) {
			this.salud = this.maxSalud;
		}
	}
	
	/**
	 * Muestra una barra de salud que esta representado por "=" entre antebarras cuyo tamaño varia respecto a su vidaMaxima.
	 * @return String de la barra.
	 */
	public String barraSalud() {
    	// /====================/
		String barra = "/";
		if (this.salud > 0) {
			final double LONGITUD = 20;
	    	double valor = (double)this.maxSalud/LONGITUD;
	    	double numDeBarras = this.salud / valor;
	    	for (int i = 0; i < numDeBarras; i++) {
	    		barra += "=";
	    	}
	    	
	    	for (int i = 0; i < Math.floor(LONGITUD-numDeBarras); i++) {
	    		barra += "_";
	    	}
	    	barra += "/";
		} else {
			barra += "____________________/";
		}
    	
    	return barra;
    	
    }
	
	/**
	 * Muestra una barra de salud que esta representado por "*" entre antebarras cuyo tamaño varia respecto a su LEVEL_UP_CAP.
	 * @return String de la barra.
	 */
	public String barraExp() {
    	// /******************/
		String barra = "/";
		if (this.exp > 0) {
			final double LONGITUD = 20;
	    	double valor = (double)this.LEVEL_UP_CAP/LONGITUD;
	    	double numDeCaracteres = this.exp / valor;
	    	for (int i = 0; i < numDeCaracteres; i++) {
	    		barra += "*";
	    	}
	    	
	    	for (int i = 0; i < Math.floor(LONGITUD-numDeCaracteres); i++) {
	    		barra += "  ";
	    	}
	    	barra += "/";
		} else {
			barra += "                                        /";
		}
    	
    	return barra;
    	
    }
	
	/**
	 * Metodo para mover al personaje arriba
	 * @param map
	 */
	public void moverArriba(Mapa map) {
		if (this.posicionY != 0) {
			if (map.esTransitable(this.posicionX, this.posicionY-1)) {
				this.posicionY--;
			}
		}
	}
	
	/**
	 * Metodo para mover al personaje abajo
	 * @param map
	 */
	public void moverAbajo(Mapa map) {
		if (this.posicionY+1 < map.getAlto()) {
			if (map.esTransitable(this.posicionX, this.posicionY+1)) {
				this.posicionY++;
			}
		}
	}
	
	/**
	 * Metodo para mover al personaje derecha
	 * @param map
	 */
	public void moverDerecha(Mapa map) {
		if (this.posicionX+1 < map.getAncho()) {
			if (map.esTransitable(this.posicionX+1, this.posicionY)) {
				this.posicionX++;
			}
		}
	}
	
	/**
	 * Metodo para mover al personaje izquierda
	 * @param map
	 */
	public void moverIzquierda(Mapa map) {
		if (this.posicionX != 0) {
			if (map.esTransitable(this.posicionX-1, this.posicionY) && this.posicionX != 0) {
				this.posicionX--;
			}
		}
	}
	
	/**
	 * Metodo que transporta al jugador a las coordenadas
	 * @param posicionX int
	 * @param posicionY int
	 */
	public void tp(int posicionX, int posicionY) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
}
