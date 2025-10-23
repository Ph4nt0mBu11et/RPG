package Items;
public class Armadura extends Items {
    private int defensaF;
    private int defensaM;
    private int velocidad;
    private int inteligencia;

    
    public Armadura(String nombre, int defensaF, int defensaM, int velocidad, int inteligencia) {
        super(nombre);
        this.defensaF = defensaF;
        this.defensaM = defensaM;
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
    }
    
    public static final Armadura VACIO = new Armadura("Vacío", 0, 0, 0, 0);

    public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

    public int getDefensa() {
        return defensaF;
    }

    public void setDefensa(int defensa) {
        this.defensaF = defensa;
    }

    public int getDefensaM() {
		return defensaM;
	}

	public void setDefensaM(int defensaM) {
		this.defensaM = defensaM;
	}

	public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + 
               "\nDefensa: " + defensaF + 
               "\nVelocidad: " + velocidad;
    }
}
