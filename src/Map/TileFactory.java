package Map;

public class TileFactory {
	 private static final Tile CESPED = new Tile(",", Color.VERDE, Color.FONDO_VERDE, false);
	 public static final Tile AGUA = new Tile("~", Color.AZUL, Color.FONDO_CYAN, true);
	 public static final Tile PUENTE = new Tile("=", Color.AMARILLO_BOLD, Color.FONDO_CYAN, false);
	 public static final Tile ARBOL = new Tile("🌲", Color.NEGRO, Color.FONDO_VERDE, true);
	 public static final Tile EMOJI_SPACE = new Tile("", Color.RESET, Color.RESET, true);
	 public static final Tile DEFAULT = new Tile("?", Color.RESET, Color.RESET, true);
	 public static final Tile CASTILLO = new Tile("🏰", Color.NEGRO, Color.FONDO_VERDE, false);
	 public static final Tile ARBOL2 = new Tile("🌳", Color.NEGRO, Color.FONDO_VERDE, false);
	 public static final Tile PUEBLO = new Tile("🛖", Color.NEGRO, Color.FONDO_VERDE, false);
	 public static final Tile CASTILLO2 = new Tile("🏯", Color.ROJO, Color.FONDO_VERDE, false);
	 public static final Tile TEMPLO = new Tile("🏛", Color.NEGRO, Color.FONDO_VERDE, false);
	 public static final Tile CAMINO1 = new Tile("-", Color.AMARILLO, Color.FONDO_VERDE, false);
	 public static final Tile CAMINO2 = new Tile("|", Color.AMARILLO, Color.FONDO_VERDE, false);
	 public static final Tile CUEVA = new Tile("A", Color.NEGRO, Color.FONDO_VERDE, true);
	 public static final Tile MURO_PIEDRA = new Tile("#", Color.NEGRO, Color.FONDO_BLANCO, true);
	 public static final Tile ROJO = new Tile("·", Color.AMARILLO, Color.FONDO_ROJO, false);
	 public static final Tile MORADO = new Tile("·", Color.AMARILLO, Color.FONDO_MORADO, false);
	 public static final Tile BLANCO = new Tile("·", Color.AMARILLO, Color.FONDO_BLANCO, false);
	 public static final Tile IGLESIA = new Tile("⛪", Color.NEGRO, Color.FONDO_VERDE, false);
	 public static final Tile CASA = new Tile("🏠", Color.NEGRO, Color.FONDO_VERDE, false);
	 public static final Tile CAMINO = new Tile(" ", Color.AMARILLO, Color.FONDO_AMARILLO, false);
	 public static final Tile CASINO = new Tile("🎰", Color.NEGRO, Color.FONDO_VERDE, false);
	 public static final Tile AMARILLO = new Tile("#", Color.BLANCO, Color.FONDO_AMARILLO, false);
	 public static final Tile ESPADA = new Tile("🗡️", Color.AMARILLO, Color.FONDO_NEGRO, false);
	 public static final Tile INTERACT = new Tile("*", Color.MORADO, Color.FONDO_AMARILLO, false);
	 
	 
	 public static Tile getTile(String tipo) {
	        switch (tipo) {
	            case ",":
	                return CESPED;
	            case "~":
	                return AGUA;
	            case "=":
	                return PUENTE;
	            case "T":
	                return ARBOL;
	            case "M":
	            	return CASTILLO;
	            case "7":
	            	return ARBOL2;
	            case "m":
	            	return PUEBLO;
	            case "1":
	            	return CASTILLO2;
	            case "2":
	            	return TEMPLO;
	            case "-":
	            	return CAMINO1;
	            case "|":
	            	return CAMINO2;
	            case "A":
	            	return CUEVA;
	            case "3":
	            	return MURO_PIEDRA;
	            case "4":
	            	return ROJO;
	            case ".":
	            	return BLANCO;
	            case "t":
	            	return EMOJI_SPACE;
	            case "5":
	            	return IGLESIA;
	            case "6":
	            	return CASA;
	            case "!":
	            	return CAMINO;
	            case "c":
	            	return CASINO;
	            case "w":
	            	return AMARILLO;
	            case "+":
	            	return MORADO;
	            case "*":
	            	return INTERACT;
	            default:
	                return DEFAULT; // Default
	        }
	    }
	 
	 
}
