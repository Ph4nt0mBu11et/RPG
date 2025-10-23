package Map;

import Entity.Entidad;
import Entity.Personaje;

public class Mapa {
	private int tamaño;
    private Tile[][] mapa;
    private Tile[][] mapaEntidades;
    private int ancho;
    private int alto;
    

    private Mapa(int tamaño) {
    	this.tamaño = tamaño;
    	this.ancho  = tamaño * 2;
    	this.alto = tamaño;
    	this.mapaEntidades = new Tile[alto][ancho];
        this.mapa = new Tile[alto][ancho];
    }
    
    private Mapa(int tamaño, String mapString) {
    	this.tamaño = tamaño;
    	this.ancho  = tamaño * 2;
    	this.alto = tamaño;
    	this.mapa = new Tile[alto][ancho];
    	this.mapaEntidades = new Tile[alto][ancho];
    	this.llenarMapa(mapString);
    }
    
    //Mapa de testing
    private static final Mapa testMap = new Mapa(10, 
    		",,,,,,,,,,,,,,,Tt,,," + 
			",,,,,,,,,Tt,,,,,,,,," + 
			",,,,,,,,,,,,,Tt,,Tt," + 
			",,,,,,,,,,,,,,,,,,,," + 
			",,,,,,,,,,,,,,,,,,,," + 
			",,,,,,~~~~~~~~~~~~~~" +
			"~~==~~~~~~~~~~~~~~~~" + 
			"~~==~~~~,,,,,,,,,,,," + 
			",,,,,,,,,,,,,,,,,,,," + 
			",,,,,,,,,,,,,,,,,,,,");
    
    private static final Mapa WORLD = new Mapa(10, 
    		",,,,,,,,,,,,,,,,,,,," + 
			",,,,,,,,,,,,,,Mt,,,," + 
			",,7t,,,,,,,,,,|,,,,," + 
			",,|------mt---|,,,,," + 
			",,,|,,,|,,,,,,|--,,," + 
			",,,|,,,2t,,,,,,,|,,," +
			"~~~=~~,,,,,,,,,,|,,," + 
			",,,|,~~~~,,,,,,,A,,," + 
			",,,1t,,,~~~~~,,,,,,," + 
			",,,,,,,,~~~~,,,,,,,,");
    
    private static final Mapa CASTILLO = new Mapa(10, 
    		",,,33333333333333,,," + 
			",,,34444444444443,,," + 
			",,,34444444444443,,," + 
			",333444444444444333," + 
			",3......4444......3," + 
			",3......4444......3," +
			",3......4444......3," + 
			",3......4444......3," + 
			",3......4444......3," + 
			",333333344443333333,");
    
    private static final Mapa PUEBLO = new Mapa(10, 
    		",,,,,,,,,,,,,,,,,,,," + 
			",,,,,,,,,,,,,,,,,,,," + 
			",,,,,,5t,,,,,,,,,,6t" + 
			",,,,,,!!!!!!!!!!!!!," + 
			",,,,,,!,,,,,6t,,,,,," + 
			",6t!!!!!!,,,,,,,,,,," +
			",,,,,tc!,,,,,,,,,,,," + 
			",,,,,,,,!!!!!!!6t,,," + 
			",,t6!!!!!,,,,,,,,,,," + 
			",,,,,,,,,,,,,,,,,,,,");
    
    private static final Mapa BOSQUE = new Mapa(10, 
    		",,,,,,,,Tt,,,,,,,,,," + 
			",,,,,,,,,,,,,,,Tt,,," + 
			",,,Tt,,,,,,,,,,,,,,," + 
			",,,,,,,,,,Tt,,,,,,,," + 
			",,,,,,Tt,,,,,,,,,,,," + 
			",,,,,,,,,,,,,,,Tt,,," +
			",,Tt,,,,,,,,,,,,,,,," + 
			",,,,,,,,,,,,Tt,,,,,," + 
			",,,,,,,,,,,,,,,,,,,," + 
			",,,,,,,,,*,,,,,,,,,,");
    
    private static final Mapa CUEVA = new Mapa(10, 
    		"wwwwwwwwwwwwwwwwwwww" + 
    		"wwwwwwwwwwwwwwwwwwww" +
    		"wwwwwwwwwwwwwwwwwwww" +
    		"wwwwwwwwwwwwwwwwwwww" +
    		"wwwwwwwwwwwwwwwwwwww" + 
    		"wwwwwwwwwwwwwwwwwwww" +
    		"wwwwwwwwwwwwwwwwwwww" + 
    		"wwwwwwwwwwwwwwwwwwww" + 
    		"wwwwwwwwwwwwwwwwwwww" + 
    		"wwwwwwwww*wwwwwwwwww");
    
    private static final Mapa TEMPLO = new Mapa(10, 
    		",,,,,,,,,,,,,,,,,,,," + 
			",,,,,,,,,33,,,,,,,,," + 
			",,,,,3,,,,,,,,3,,,,," + 
			",,,,,,,,,,,,,,,,,,,," + 
			",,,3,,,,,,,,,,,,3,,," + 
			",,,,,,,,,,,,,,,,,,,," +
			",,,3,,,,,,,,,,,,3,,," + 
			",,,,,,,,,,,,,,,,,,,," + 
			",,,,,3,,,,,,,,3,,,,," + 
			",,,,,,,,,*,,,,,,,,,,");
    
    private static final Mapa CASTILLO_DEMONIO = new Mapa(10, 
    		"33333333333333333333" + 
    	    "3wwwwwww++++wwwwwww3" +
    	    "3wwwwwww++++wwwwwww3" +
    	    "3wwwwwwww++wwwwwwww3" +
    	    "3wwwwwwww++wwwwwwww3" + 
    	    "3wwwwwwww++wwwwwwww3" +
    	    "3wwwwwwww++wwwwwwww3" + 
    	   	"3wwwwwwwww+wwwwwwww3" + 
    	    "3wwwwwwwwwwwwwwwwww3" + 
    	    "333333333*w333333333");

	public static Mapa getTestmap() {
		return testMap;
	}

	public static Mapa getWorld() {
		return WORLD;
	}

	public static Mapa getCastillo() {
		return CASTILLO;
	}

	public static Mapa getPueblo() {
		return PUEBLO;
	}

	public static Mapa getBosque() {
		return BOSQUE;
	}

	public static Mapa getCueva() {
		return CUEVA;
	}

	public static Mapa getTemplo() {
		return TEMPLO;
	}

	public static Mapa getCastilloDemonio() {
		return CASTILLO_DEMONIO;
	}

	/**
	 * Método que llena el mapa con los caracteres del string
	 * @param mapaString
	 */
    public void llenarMapa(String mapaString) {
        // Asegurarse de que el mapaString tiene los caracteres necesarios
        if (mapaString.length() < tamaño*(tamaño*2)) {
            throw new IllegalArgumentException("El mapString debe tener " + tamaño*(tamaño*2) + " caracteres. Hay " + mapaString.length() + "caracteres");
        }

        // Variable para llevar el índice del string
        int index = 0;

        // Recorrer el array 2D (filas y columnas)
        for (int i = 0; i < tamaño; i++) {  // Recorre las filas
            for (int j = 0; j < tamaño*2; j++) {  // Recorre las columnas
                // Asigna el carácter del string al mapa en la posición correspondiente
            	mapa[i][j] = TileFactory.getTile(String.valueOf(mapaString.charAt(index)));
                index++;
            }
        }
    }
    /**
     * Restaura el mapa al estado original
     */
    public void resetMap() {
    	for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño * 2; j++) {
                this.mapaEntidades[i][j] = this.mapa[i][j];
            }
        }
    }
    /**
     * Coloca a la entidad en el mapa
     * @param entidad
     */
    public void posicionarEntidad(Entidad entidad) {
        int x = entidad.getPosicionX();
        int y = entidad.getPosicionY();

        // Verificar que la posición esté dentro de los límites del mapa
        if (x >= 0 && x < this.tamaño*2 && y >= 0 && y < this.tamaño) {
        	this.mapaEntidades[y][x] = crearCasillaEntidad(this.mapa[y][x], entidad);
        } else {
        	throw new IndexOutOfBoundsException("La posición del personaje está fuera del mapa.");
        }
    }
    /**
     * Coloca al personaje en el mapa
     * @param personaje
     */
    public void posicionarPersonaje(Personaje personaje) {
        int x = personaje.getPosicionX();
        int y = personaje.getPosicionY();

        // Verificar que la posición esté dentro de los límites del mapa y esté vivo
        if (personaje.isEstaVivo()) {
        	if (x >= 0 && x < this.tamaño*2 && y >= 0 && y < this.tamaño) {
        		this.mapaEntidades[y][x] = crearCasillaEntidad(this.mapa[y][x], personaje);
        	} else {
        		throw new IndexOutOfBoundsException("La posición del personaje está fuera del mapa.");
        	}
        }
    }
    /**
     * Coloca una lista de personajes en el mapa
     * @param lista
     */
    public void posicionarPersonaje(Personaje[] lista) {
    	for(int i = 0; i < lista.length; i++) {
    		posicionarPersonaje(lista[i]);
    	}
    }
    /**
     * Crea la casilla que mostrara a la entidad en el mapa
     * @param casillaOg
     * @param entidad
     * @return Tile casilla con la entidad
     */
    public Tile crearCasillaEntidad(Tile casillaOg, Entidad entidad) {
    	Tile casillaConEntidad = new Tile(entidad.getRepresentacion(), casillaOg.color, casillaOg.fondo, false);
    	return casillaConEntidad;
    }

    /**
     * Método para mostrar el mapa
     */
    public void mostrarMapa() {

        for (int i = 0; i < this.tamaño; i++) {
            for (int j = 0; j < this.tamaño*2; j++) {
                this.mapaEntidades[i][j].printTile();
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }
    
    /**
     * Mostrar mapa original sin entidades
     */
    public void mostrarMapaSinEntidades() {
    	for (int i = 0; i < this.tamaño; i++) {
            for (int j = 0; j < this.tamaño*2; j++) {
                this.mapa[i][j].printTile();
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }
    

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
    
	public boolean esTransitable(int posX, int posY) {
		return !this.mapa[posY][posX].isBlock();
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
}
