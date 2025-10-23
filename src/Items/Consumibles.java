package Items;

import Entity.Jugador;

public class Consumibles extends Items {

    private int heal;
    private int boostAtk;
    private int boostMp;
    private int boostSpd;
    private int boostDxt;
    private int boostInt;
    private int duracion;
    
    // Constructor
    public Consumibles(String nombre, int heal, int atk, int mp, int spd, int dxt, int intel, int duracion) {
        super(nombre);
        this.heal = heal;
        this.boostAtk = atk;
        this.boostMp = mp;
        this.boostSpd = spd;
        this.boostDxt = dxt;
        this.boostInt = intel;
        
    }
    
    private static final Consumibles SIN_EFECTO = new Consumibles("Sin ningun efecto", 0, 0, 0, 0, 0, 0, 0);
    private static final Consumibles POCION_S = new Consumibles("Poción de Vida (S)", 25, 0, 0, 0, 0, 0, 0);
    private static final Consumibles POCION_M = new Consumibles("Poción de Vida (M)", 50, 0, 0, 0, 0, 0, 0);
    private static final Consumibles POCION_L = new Consumibles("Poción de Vida (L)", 100, 0, 0, 0, 0, 0, 0);
    private static final Consumibles POCION_MANA_S = new Consumibles("Poción de Mana (S)", 0, 0, 25, 0, 0, 0, 0);
    private static final Consumibles POCION_MANA_M = new Consumibles("Poción de Mana (M)", 0, 0, 50, 0, 0, 0, 0);
    private static final Consumibles POCION_MANA_L = new Consumibles("Poción de Mana (L)", 0, 0, 100, 0, 0, 0, 0);
    private static final Consumibles NUCLEO_IRA = new Consumibles("Nucleo de ira", -10, 20, 20, 10, -5, -5, 0);
    private static final Consumibles PERGAMINO = new Consumibles("Pergamino", 0, 0, 20, 0, 10, 25, 0);
    private static final Consumibles ORBE_SERENIDAD = new Consumibles("Orbe de serenidad", 10, 0, 20, 0, 25, 10, 0);
    private static final Consumibles CRONOMETRO = new Consumibles("Cronómetro", 0, 0, -10, 50, 0, 0, 0);

	public static Consumibles getSinEfecto() {
		return SIN_EFECTO;
	}

	public static Consumibles getPocionM() {
		return POCION_M;
	}

	public static Consumibles getPocionS() {
		return POCION_S;
	}

	public static Consumibles getPocionL() {
		return POCION_L;
	}

	public static Consumibles getPocionManaS() {
		return POCION_MANA_S;
	}

	public static Consumibles getPocionManaM() {
		return POCION_MANA_M;
	}

	public static Consumibles getPocionManaL() {
		return POCION_MANA_L;
	}

	public static Consumibles getNucleoIra() {
		return NUCLEO_IRA;
	}

	public static Consumibles getPergamino() {
		return PERGAMINO;
	}

	public static Consumibles getOrbeSerenidad() {
		return ORBE_SERENIDAD;
	}

	public static Consumibles getCronometro() {
		return CRONOMETRO;
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public int getBoostAtk() {
		return boostAtk;
	}

	public void setBoostAtk(int boostAtk) {
		this.boostAtk = boostAtk;
	}

	public int getBoostMp() {
		return boostMp;
	}

	public void setBoostMp(int boostMp) {
		this.boostMp = boostMp;
	}

	public int getBoostSpd() {
		return boostSpd;
	}

	public void setBoostSpd(int boostSpd) {
		this.boostSpd = boostSpd;
	}

	public int getBoostDxt() {
		return boostDxt;
	}

	public void setBoostDxt(int boostDxt) {
		this.boostDxt = boostDxt;
	}

	public int getBoostInt() {
		return boostInt;
	}

	public void setBoostInt(int boostInt) {
		this.boostInt = boostInt;
	}
	
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public void usar(Jugador jugador) {
		jugador.curar(this.heal);
		jugador.recibirEffecto(this);
		//TODO other stats
	}
}
