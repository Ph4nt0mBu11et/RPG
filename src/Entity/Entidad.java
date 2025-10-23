package Entity;

public class Entidad {
	
    protected int posicionX;
    protected int posicionY;
    protected String representacion;
    
    public Entidad(String rep) {
    	this.representacion = rep;
    }
	
    public Entidad(int x, int y, String rep) {
    	this.posicionX = x;
    	this.posicionY = y;
    	this.representacion = rep;
    }
    
    
    
    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
    public void setPosicion(int x, int y) {
    	this.posicionX = x;
    	this.posicionY = y;
    }

    public String getRepresentacion() {
        return representacion;
    }

    public void setRepresentacion(String representacion) {
        this.representacion = representacion;
    }
}
