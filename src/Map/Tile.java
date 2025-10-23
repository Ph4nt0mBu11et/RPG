package Map;

public class Tile{
	
	String tile;
	String color;
	String fondo;
	boolean block;

	public Tile(String representacion, String color, String fondo, boolean block) {
		// TODO Auto-generated constructor stub
		this.tile = representacion;
		this.color = color;
		this.fondo = fondo;
		this.block = block;
	}
	
	public void printTile() {
		System.out.print(color + fondo + tile + Color.RESET);
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

}
