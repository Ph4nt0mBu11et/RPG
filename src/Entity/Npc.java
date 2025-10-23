package Entity;

import Map.Color;
import Quest.Mision;

public class Npc extends Personaje {
	
	private String dialogo;
	private Mision mision;

    private Npc(String nombre, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaF, int defensaM) {
        super(nombre, representacion, fuerza, inteligencia, destreza, velocidad, salud, defensaF, defensaM);
    }
    
    private Npc(String nombre, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaF, int defensaM, String dialogo, Mision mision) {
        super(nombre, representacion, fuerza, inteligencia, destreza, velocidad, salud, defensaF, defensaM);
        this.dialogo = dialogo;
        this.mision = mision;
    }
    
    public static Npc crearNpc(String nombre) {
    	switch (nombre.toUpperCase()) {
    	case "VIEJO":
    		return new Npc(
    				"Viejo",
    				Color.NEGRO + "8" + Color.RESET,
    				0,
    				10,
    				5,
    				5,
    				30,
    				2,
    				2,
    				"Yo solía ser un aventurero como tú, hasta que recibí una flecha en la rodilla...",
    				null
    				);
    	case "REY":
    		return new Npc(
    				"Rey",
    				Color.AMARILLO + "K" + Color.RESET,
    				15,
    				18,
    				12,
    				8,
    				100,
    				10,
    				10,
    				null,
    				null
    				);
    	case "REINA":
    		return new Npc(
    				"Reina",
    				Color.MORADO + "Q" + Color.RESET,
    				10,
    				20,
    				14,
    				9,
    				90,
    				8,
    				12,
    				"El reino está en deuda contigo.",
    				null
    				);
    	case "SOLDADO":
    		return new Npc(
    				"Soldado",
    				Color.NEGRO + "Y" + Color.RESET,
    				20,
    				8,
    				18,
    				7,
    				80,
    				15,
    				5,
    				null,
    				null
    				);
    	case "CIUDADANO":
    		return new Npc(
    				"Ciudadano",
    				Color.NEGRO + "O" + Color.RESET,
    				5,
    				10,
    				6,
    				6,
    				60,
    				4,
    				2,
    				"He escuchado rumores de que el rey demonio ha resurgido...",
    				null
    				);
    	case "CAZADOR":
    		return new Npc(
    				"Cazador",
    				Color.NEGRO + "X" + Color.RESET,
    				12,
    				14,
    				20,
    				10,
    				70,
    				8,
    				6,
    				null,
    				null
    				);
    	case "GRANJERO":
    		return new Npc(
    				"Granjero",
    				Color.NEGRO + "9" + Color.RESET,
    				8,
    				6,
    				10,
    				5,
    				70,
    				6,
    				3,
    				"Este año parece que la cosecha va bien.",
    				null
    				);
    	default:
    		return null; // Si no se encuentra el NPC, devolvemos null.
    	}
    }
    
//    public static final Npc VIEJO = new Npc(
//    		"Viejo",
//    		Color.NEGRO + "8" + Color.RESET,
//    		0,
//    		10,
//    		5,
//    		5,
//    		30,
//    		2,
//    		2,
//    		"Yo solia ser un aventurero como tú, hasta que recibi una flecha en la rodilla...",
//    		null);
//    
//    private static final Npc REY = new Npc(
//    	    "Rey", // nombre
//    	    Color.AMARILLO + "K" + Color.RESET, // representación (a definir)
//    	    15, // fuerza
//    	    18, // inteligencia
//    	    12, // destreza
//    	    8,  // velocidad
//    	    100, // salud
//    	    10, // defensa física
//    	    10, // defensa mágica
//    	    null, // diálogo (a definir)
//    	    null  // misión (a definir)
//    	);
//
//    	private static final Npc REINA = new Npc(
//    	    "Reina", // nombre
//    	    Color.MORADO + "Q" + Color.RESET, // representación (a definir)
//    	    10, // fuerza
//    	    20, // inteligencia
//    	    14, // destreza
//    	    9,  // velocidad
//    	    90, // salud
//    	    8,  // defensa física
//    	    12, // defensa mágica
//    	    "El reino esta en deuda contigo.", // diálogo (a definir)
//    	    null  // misión (a definir)
//    	);
//
//    	private static final Npc SOLDADO = new Npc(
//    	    "Soldado", // nombre
//    	    Color.NEGRO + "Y" + Color.RESET, // representación (a definir)
//    	    20, // fuerza
//    	    8,  // inteligencia
//    	    18, // destreza
//    	    7,  // velocidad
//    	    80, // salud
//    	    15, // defensa física
//    	    5,  // defensa mágica
//    	    null, // diálogo (a definir)
//    	    null  // misión (a definir)
//    	);
//
//    	private static final Npc CIUDADANO = new Npc(
//    	    "Ciudadano", // nombre
//    	    Color.NEGRO + "O" + Color.RESET, // representación (a definir)
//    	    5,  // fuerza
//    	    10, // inteligencia
//    	    6,  // destreza
//    	    6,  // velocidad
//    	    60, // salud
//    	    4,  // defensa física
//    	    2,  // defensa mágica
//    	    "He escuchado rumores de que el rey demonio ha resurgido...", // diálogo (a definir)
//    	    null  // misión (a definir)
//    	);
//
//    	private static final Npc CAZADOR = new Npc(
//    	    "Cazador", // nombre
//    	    Color.NEGRO + "X" + Color.RESET, // representación (a definir)
//    	    12, // fuerza
//    	    14, // inteligencia
//    	    20, // destreza
//    	    10, // velocidad
//    	    70, // salud
//    	    8,  // defensa física
//    	    6,  // defensa mágica
//    	    null, // diálogo (a definir)
//    	    null  // misión (a definir)
//    	);
//
//    	private static final Npc GRANJERO = new Npc(
//    	    "Granjero", // nombre
//    	    Color.NEGRO + "9" + Color.RESET, // representación (a definir)
//    	    8,  // fuerza
//    	    6,  // inteligencia
//    	    10, // destreza
//    	    5,  // velocidad
//    	    70, // salud
//    	    6,  // defensa física
//    	    3,  // defensa mágica
//    	    "Este año parece que la cosecha va bien.", // diálogo (a definir)
//    	    null  // misión (a definir)
//    	);

	public String getDialogo() {
		return dialogo;
	}

	public Mision getMision() {
		return mision;
	}

	public void setDialogo(String dialogo) {
		this.dialogo = dialogo;
	}

	public void setMision(Mision mision) {
		if (this.mision == null) {
			this.mision = mision;
		}
	}

//	public static Npc getViejo() {
//		return VIEJO;
//	}
//
//	public static Npc getRey() {
//		return REY;
//	}
//
//	public static Npc getReina() {
//		return REINA;
//	}
//
//	public static Npc getSoldado() {
//		return SOLDADO;
//	}
//
//	public static Npc getCiudadano() {
//		return CIUDADANO;
//	}
//
//	public static Npc getCazador() {
//		return CAZADOR;
//	}
//
//	public static Npc getGranjero() {
//		return GRANJERO;
//	}
}
