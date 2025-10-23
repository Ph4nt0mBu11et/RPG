package Entity;

import javax.swing.ImageIcon;

import Items.Items;
import Map.Color;
import Map.Mapa;

public class Enemigo extends Personaje {
	final static int TICK = 1;
	
	private int agro;
	private double moveSpeed;
	private double turn;
	private int dropExp;
	private int dropGold;
	private Items dropItem;
	private int dropCantidad;
	private String rutaIco;
	private ImageIcon icon;

    private Enemigo(String nombre, int x, int y, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaF, int defensaM, int agro, double moveSpeed) {
        super(nombre, x, y, representacion, fuerza, inteligencia, destreza, velocidad, salud, defensaF, defensaM);
        this.agro = agro;
        this.moveSpeed = moveSpeed;
        
        this.nivel = 1;
    }
    
    private Enemigo(String nombre, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaF, int defensaM, int agro, double moveSpeed) {
        super(nombre, representacion, fuerza, inteligencia, destreza, velocidad, salud, defensaF, defensaM);
        this.agro = agro;
        this.moveSpeed = moveSpeed;
        
        this.nivel = 1;
    }
    
    private Enemigo(String nombre, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaF, int defensaM, int agro, double moveSpeed, int nivel, int exp, int gold,Items item, int cantidad, String ruta) {
    	this(nombre, representacion, fuerza, inteligencia, destreza, velocidad, salud, defensaF, defensaM, agro, moveSpeed);
        this.nivel = nivel;
        this.dropExp = exp;
        this.dropGold = gold;
        this.dropItem = item;
        this.dropCantidad = cantidad;
        this.rutaIco = ruta;
        this.icon = new ImageIcon(this.rutaIco);
    }
    
    private Enemigo(String nombre, int x, int y, String representacion, int fuerza, int inteligencia, int destreza, int velocidad, int salud, int defensaF, int defensaM, int agro, double moveSpeed, int nivel, int exp, int gold,Items item, int cantidad, String ruta) {
        this(nombre, x, y, representacion, fuerza, inteligencia, destreza, velocidad, salud, defensaF, defensaM, agro, moveSpeed);
        this.nivel = nivel;
        this.dropExp = exp;
        this.dropGold = gold;
        this.dropItem = item;
        this.dropCantidad = cantidad;
        this.rutaIco = ruta;
        this.icon = new ImageIcon(this.rutaIco);
    }

	/**
     * Calcula y retorna el daño que causa
     * @return double daño calculado
     */
    public double calcularDmg() {
    	double dmg;
    	int critRate = 1;
    	dmg = this.fuerza;
    	critRate += (this.destreza * 0.5);
    	if ((int)(Math.random() * 100) + 1 < critRate) {
    		dmg *= 2;
    	}
    	return Math.round(dmg * 100) / 100;
    }

	/**
	 * Movimiento que intenta acercarse al jugador si esta dentro del area
	 * @param objetivo
	 * @param map
	 */
    public void mover(Personaje objetivo, Mapa map) {
    	if (this.getSalud() > 0) {

        	
        	boolean move = false;
        	
        	turn += moveSpeed;
        	
        	if (turn >= TICK) {
        		turn -= TICK;
        		move = true;
        	}
        	
        	
        	
        	
        	boolean inSight = false;

        	if (this.posicionX == objetivo.posicionX && (Math.abs(this.posicionY - objetivo.posicionY) <= this.agro)) {
        		inSight = true;
        	}
        	
        	if (this.posicionY == objetivo.posicionY && (Math.abs(this.posicionX - objetivo.posicionX) <= this.agro)) {
        		inSight = true;
        	}
        	
        	if (this.posicionX != objetivo.posicionX && (Math.abs(posicionY - objetivo.posicionY) <= agro-1) && this.posicionY != objetivo.posicionY && (Math.abs(posicionX - objetivo.posicionX) <= agro-1)) {
        		inSight = true;
        	}
        	
        	if (inSight && move) {
        		//movimiento agresivo
        	       if (this.posicionX > objetivo.posicionX) {
        	    	   //mover a la izquierda
        	    	   moverIzquierda(map);
        	       } else if (this.posicionX < objetivo.posicionX) {
        	    	   //mover a la derecha
        	    	   moverDerecha(map);
        	       } else if (this.posicionY < objetivo.posicionY) {
        	    	   //mover abajo
        	    	   moverAbajo(map);
        	       } else if (this.posicionY > objetivo.posicionY) {
        	    	   //mover arriba
        	    	   moverArriba(map);
        	       }
        	}
        
    	}
    }

	public int getDropExp() {
		return dropExp;
	}

	public int getDropGold() {
		return dropGold;
	}

	public void setDropExp(int dropExp) {
		this.dropExp = dropExp;
	}

	public void setDropGold(int dropGold) {
		this.dropGold = dropGold;
	}

	public Items getDropItem() {
		return dropItem;
	}
	
	public String getDropItemName() {
		String dropName;
		if (this.dropItem == null) {
			dropName = "";
		} else {
			dropName = this.dropItem.getNombre();
		}
		return dropName;
	}

	public int getDropCantidad() {
		return dropCantidad;
	}

	public void setDropCantidad(int dropCantidad) {
		this.dropCantidad = dropCantidad;
	}
	
	public static Enemigo crearEnemigo(String tipo) {
        switch (tipo) {
            case "SERPIENTE":
                return new Enemigo(
                    "Serpiente", Color.ROJO + "S" + Color.RESET, 8, 5, 6, 7, 50, 3, 3, 3, 0.5, 3, 6, 5, Items.PIEL_SERPIENTE, 2, "img/sprite/entity/enemy/snake.png"
                );
            case "GOBLIN":
                return new Enemigo(
                    "Goblin", Color.VERDE + "G" + Color.RESET, 10, 6, 8, 10, 50, 4, 4, 3, 1, 5, 8, 6, Items.OREJA_GOBLIN, 1, "img/sprite/entity/enemy/goblin.png"
                );
            case "KING_GOBLIN":
                return new Enemigo(
                    "King Goblin", Color.VERDE + "K" + Color.RESET, 20, 8, 8, 5, 70, 7, 4, 2, 0.5, 15, 20, 13, Items.CORONA_GOBLIN, 1, "img/sprite/entity/enemy/kingGoblin.png"
                );
            case "ESQUELETO":
                return new Enemigo(
                    "Esqueleto", Color.BLANCO + "H" + Color.RESET, 5, 2, 2, 6, 25, 3, 3, 3, 1, 3, 5, 4, Items.HUESOS, 2, "img/sprite/entity/enemy/skeleton.png"
                );
            case "SLIME":
                return new Enemigo(
                    "Slime", Color.AZUL + "O" + Color.RESET, 3, 1, 1, 1, 25, 20, 1, 2, 0.5, 5, 6, 2, Items.ORBE_SLIME, 1, "img/sprite/entity/enemy/slime.png"
                );
            case "BANDIDO":
                return new Enemigo(
                    "Bandido", Color.MORADO + "B" + Color.RESET, 12, 10, 9, 8, 60, 5, 5, 3, 1, 12, 10, 15, Items.TAG_BANDIDO, 1, "img/sprite/entity/enemy/"
                );
            case "LOBO":
                return new Enemigo(
                    "Lobo", Color.NEGRO + "L" + Color.RESET, 9, 6, 5, 10, 50, 5, 5, 3, 1, 5, 7, 5, Items.PIEL_LOBO, 2, "img/sprite/entity/enemy/wolf.png"
                );
            case "DEMONIO":
                return new Enemigo(
                    "Demonio", Color.ROJO + "D" + Color.RESET, 17, 10, 10, 10, 75, 10, 20, 3, 1, 20, 30, 23, Items.CUERNO_DEMONIO, 1, "img/sprite/entity/enemy/demon.png"
                );
            case "GENERAL_DEMONIO":
                return new Enemigo(
                    "General Demonio", Color.ROJO + "G" + Color.RESET, 25, 20, 15, 20, 85, 20, 30, 2, 0.5, 30, 40, 30, Items.CUERNO_GRANDE_DEMONIO, 1, "img/sprite/entity/enemy/general.png"
                );
            case "REY_DEMONIO":
                return new Enemigo(
                    "Rey Demonio", Color.AZUL + "K" + Color.RESET, 40, 35, 30, 37, 100, 30, 30, 0, 1, 70, 1000, 10000, Items.CORONA_DEMONIO, 1, "img/sprite/entity/enemy/demonKing.png"
                );
            default:
                return null;  // Enemigo no reconocido, devolvemos null
        }
    }

	public String getRutaIco() {
		return rutaIco;
	}

	public void setRutaIco(String rutaIco) {
		this.rutaIco = rutaIco;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
//    private static final Enemigo SERPIENTE = new Enemigo(
//    		"Serpiente",//nombre
//    		Color.ROJO + "S" + Color.RESET,
//    		8,
//    		5,
//    		6,
//    		7,
//    		50,
//    		3,
//    		3,
//    		3,
//    		0.5,
//    		3,
//    		6,
//    		5,
//    		Items.PIEL_SERPIENTE,
//    		2);
//    
//    private static final Enemigo GOBLIN = new Enemigo(
//    	    "Goblin", // nombre
//    	    Color.VERDE + "G" + Color.RESET,
//    	    10,
//    	    6,
//    	    8,
//    	    10,
//    	    50,
//    	    4,
//    	    4,
//    	    3,
//    	    1,
//    	    5,
//    	    8,
//    	    6,
//    	    Items.OREJA_GOBLIN, // Items
//    	    1 // Otros
//    	);
//
//    	private static final Enemigo KING_GOBLIN = new Enemigo(
//    	    "King Goblin", // nombre
//    	    Color.VERDE + "K" + Color.RESET,
//    	    20,
//    	    8,
//    	    8,
//    	    5,
//    	    70,
//    	    7,
//    	    4,
//    	    2,
//    	    0.5,
//    	    15,
//    	    20,
//    	    13,
//    	    Items.CORONA_GOBLIN, // Items
//    	    1 // Otros
//    	);
//
//    	private static final Enemigo ESQUELETO = new Enemigo(
//    	    "Esqueleto", // nombre
//    	    Color.BLANCO + "H" + Color.RESET,
//    	    5,
//    	    2,
//    	    2,
//    	    6,
//    	    25,
//    	    3,
//    	    3,
//    	    3,
//    	    1,
//    	    3,
//    	    5,
//    	    4,
//    	    Items.HUESOS, // Items
//    	    2 // Otros
//    	);
//
//    	private static final Enemigo SLIME = new Enemigo(
//    	    "Slime", // nombre
//    	    Color.AZUL + "O" + Color.RESET,
//    	    3,
//    	    1,
//    	    1,
//    	    1,
//    	    25,
//    	    20,
//    	    1,
//    	    2,
//    	    0.5,
//    	    5,
//    	    6,
//    	    2,
//    	    Items.ORBE_SLIME, // Items
//    	    1 // Otros
//    	);
//
//    	private static final Enemigo BANDIDO = new Enemigo(
//    	    "Bandido", // nombre
//    	    Color.MORADO + "B" + Color.RESET,
//    	    12,
//    	    10,
//    	    9,
//    	    8,
//    	    60,
//    	    5,
//    	    5,
//    	    3,
//    	    1,
//    	    12,
//    	    10,
//    	    15,
//    	    Items.TAG_BANDIDO, // Items
//    	    1 // Otros
//    	);
//
//    	private static final Enemigo LOBO = new Enemigo(
//    	    "Lobo", // nombre
//    	    Color.NEGRO + "L" + Color.RESET,
//    	    9,
//    	    6,
//    	    5,
//    	    10,
//    	    50,
//    	    5,
//    	    5,
//    	    3,
//    	    1,
//    	    5,
//    	    7,
//    	    5,
//    	    Items.PIEL_LOBO, // Items
//    	    2 // Otros
//    	);
//
//    	private static final Enemigo DEMONIO = new Enemigo(
//    	    "Demonio", // nombre
//    	    Color.ROJO + "D" + Color.RESET,
//    	    17,
//    	    10,
//    	    10,
//    	    10,
//    	    75,
//    	    10,
//    	    20,
//    	    3,
//    	    1,
//    	    20,
//    	    30,
//    	    23,
//    	    Items.CUERNO_DEMONIO, // Items
//    	    1 // Otros
//    	);
//
//    	private static final Enemigo GENERAL_DEMONIO = new Enemigo(
//    	    "General Demonio", // nombre
//    	    Color.ROJO + "G" + Color.RESET,
//    	    25,
//    	    20,
//    	    15,
//    	    20,
//    	    85,
//    	    20,
//    	    30,
//    	    2,
//    	    0.5,
//    	    30,
//    	    40,
//    	    30,
//    	    Items.CUERNO_GRANDE_DEMONIO, // Items
//    	    1 // Otros
//    	);
//
//    	private static final Enemigo REY_DEMONIO = new Enemigo(
//    	    "Rey Demonio", // nombre
//    	    Color.MORADO + "K" + Color.RESET,
//    	    40,
//    	    35,
//    	    30,
//    	    37,
//    	    100,
//    	    30,
//    	    30,
//    	    0,
//    	    1,
//    	    70,
//    	    1000,
//    	    10000,
//    	    Items.CORONA_DEMONIO, // Items
//    	    1 // Otros
//    	);
//    
//    public static Enemigo getSerpiente() {
//		return SERPIENTE;
//	}
//
//	public static Enemigo getGoblin() {
//		return GOBLIN;
//	}
//
//	public static Enemigo getKingGoblin() {
//		return KING_GOBLIN;
//	}
//
//	public static Enemigo getEsqueleto() {
//		return ESQUELETO;
//	}
//
//	public static Enemigo getSlime() {
//		return SLIME;
//	}
//
//	public static Enemigo getBandido() {
//		return BANDIDO;
//	}
//
//	public static Enemigo getLobo() {
//		return LOBO;
//	}
//
//	public static Enemigo getDemonio() {
//		return DEMONIO;
//	}
//
//	public static Enemigo getGeneralDemonio() {
//		return GENERAL_DEMONIO;
//	}
//
//	public static Enemigo getReyDemonio() {
//		return REY_DEMONIO;
//	}
    
    
}
