package Items;

import Entity.Jugador;

public class Arma extends Items {
    private int daño;
    private int velocidad;
    private int inteligencia;
    private int tipo;
    
    public final static int TIPO_ESPADA = 0;
    public final static int TIPO_ARCO = 1;
    public final static int TIPO_CETRO = 2;
    public final static int TIPO_MAZA = 3;
    public final static int TIPO_HACHA = 4;
    public final static int TIPO_MANO = 5;
    public final static int  TIPO_LANZA = 6;

    private Arma(String nombre, int daño, int velocidad, int inteligencia, int tipo) {
        super(nombre);
        this.daño = daño;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
        this.tipo = tipo;
    }
    
    public static final Arma VACIO = new Arma("Vacío", 0, 0, 0, TIPO_MANO);
    public static final Arma ESPADA_VIEJA = new Arma("Espada vieja", 5, 3, 0, TIPO_ESPADA);
    public static final Arma ESPADA_HIERRO = new Arma("Espada hierro", 7, 3, 0, TIPO_ESPADA);
    public static final Arma ESPADA_ROBUSTA = new Arma("Espada robusta", 14, 2, 0, TIPO_ESPADA);
    public static final Arma ESTOQUE = new Arma("Estoque", 6, 6, 0, TIPO_ESPADA);
    public static final Arma ESPADA_SAGRADA = new Arma("Espada sagrada", 30, 10, 10, TIPO_ESPADA);
    public static final Arma BALLISTA = new Arma("Ballesta", 8, 2, 1, TIPO_ARCO);
    public static final Arma ARCO = new Arma("Arco", 7, 5, 2, TIPO_ARCO);
    public static final Arma ARCO_COMPUESTO = new Arma("Arco compuesto", 9, 6, 2, TIPO_ARCO);
    public static final Arma CETRO_MADERA = new Arma("Cetro de madera", 3, 7, 13, TIPO_CETRO);
    public static final Arma CETRO_SAGRADO = new Arma("Cetro sagrado", 5, 6, 23, TIPO_CETRO);
    public static final Arma MAZA = new Arma("Maza", 13, 1, 0, TIPO_MAZA);
    public static final Arma MAZA_GRANDE = new Arma("Maza grande", 15, 1, 0, TIPO_MAZA);
    public static final Arma HACHUELA = new Arma("Hachuela", 6, 4, 0, TIPO_HACHA);
    public static final Arma HACHA_GUERRA = new Arma("Hacha de guerra", 15, 3, 0, TIPO_HACHA);
    public static final Arma PUNO_HIERRO = new Arma("Puño de hierro", 7, 15, 3, TIPO_MANO);
    public static final Arma LANZA_MADERA = new Arma("Lanza de madera", 9, 5, 0, TIPO_LANZA);
    public static final Arma LANZA_HIERRO = new Arma("Lanza de hierro", 11, 4, 0, TIPO_LANZA);

    
    public static Arma getEspadaVieja() {
        return ESPADA_VIEJA;
    }

	public static Arma getVacio() {
		return VACIO;
	}

	public static Arma getEspadaHierro() {
		return ESPADA_HIERRO;
	}

	public static Arma getEspadaRobusta() {
		return ESPADA_ROBUSTA;
	}

	public static Arma getEstoque() {
		return ESTOQUE;
	}

	public static Arma getBallista() {
		return BALLISTA;
	}

	public static Arma getArco() {
		return ARCO;
	}

	public static Arma getArcoCompuesto() {
		return ARCO_COMPUESTO;
	}

	public static Arma getCetroMadera() {
		return CETRO_MADERA;
	}

	public static Arma getCetroSagrado() {
		return CETRO_SAGRADO;
	}

	public static Arma getMaza() {
		return MAZA;
	}

	public static Arma getMazaGrande() {
		return MAZA_GRANDE;
	}

	public static Arma getHachuela() {
		return HACHUELA;
	}

	public static Arma getHachaGuerra() {
		return HACHA_GUERRA;
	}

	public static Arma getPunoHierro() {
		return PUNO_HIERRO;
	}

	public static Arma getLanzaMadera() {
		return LANZA_MADERA;
	}

	public static Arma getLanzaHierro() {
		return LANZA_HIERRO;
	}

	@Override
    public void usar(Jugador jugador) {
    	jugador.setArma(this);
    }

    public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getMagia() {
        return inteligencia;
    }

    public void setMagia(int magia) {
        this.inteligencia = magia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
