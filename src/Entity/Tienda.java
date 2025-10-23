package Entity;

import javax.swing.JOptionPane;

import Items.*;
import Map.Color;

public class Tienda extends Entidad{
	String icon;
	Items[] BASICO = {Consumibles.getPocionS(), Consumibles.getPocionM(), Consumibles.getPocionL(), Consumibles.getPocionManaS(), Consumibles.getPocionManaM(), Consumibles.getPocionManaL(), Consumibles.getNucleoIra(), Consumibles.getPergamino(), Consumibles.getOrbeSerenidad(), Consumibles.getCronometro()};
	int[] PRECIO_BASICO = {3, 5, 8, 4, 6, 9, 15, 20, 15, 30};
	Items[] itemsEspeciales;
	int[] precio;
	
	public Tienda(Items[] itemsEspeciales, int[] precio) {
		super(Color.AMARILLO + "$" + Color.RESET);
		this.itemsEspeciales = itemsEspeciales;
		this.precio = precio;
	}
	
	public Tienda(Items[] itemsEspeciales, String icon, int[] precio) {
		super(Color.AMARILLO + "$" + Color.RESET);
		this.itemsEspeciales = itemsEspeciales;
		this.precio = precio;
	}

	//TODO
	public final static Tienda tiendaConsumibles = new Tienda(new Items[]{
			Arma.getEspadaVieja(),
			},
			new int[] {
			10,
			});
	
	public final static Tienda tiendaArmas = new Tienda(new Items[]{
			Arma.ESPADA_VIEJA, Arma.ESPADA_HIERRO, Arma.ESPADA_ROBUSTA, Arma.ESTOQUE, Arma.ESPADA_SAGRADA, Arma.BALLISTA, Arma.ARCO, Arma.ARCO_COMPUESTO, Arma.CETRO_MADERA, Arma.CETRO_SAGRADO, Arma.MAZA, Arma.MAZA_GRANDE, Arma.HACHUELA, Arma.HACHA_GUERRA, Arma.PUNO_HIERRO, Arma.LANZA_MADERA, Arma.LANZA_HIERRO
			},
			new int[] {
			25, 40, 60, 35, 90, 50, 30, 55, 15, 70, 45, 85, 20, 75, 80, 60
			});
	
	public final static Tienda tiendaArmadura = new Tienda(new Items[]{
			Botas.BOTAS_CUERO, Botas.BOTAS_METAL, Botas.BOTAS_MAGO, Cabeza.CASCO_CUERO, Cabeza.CASCO_HIERRO, Cabeza.SOMBRERO_MAGO, Guantes.GUANTES_CUERO, Guantes.GUANTES_HIERRO, Guantes.GUANTES_ARCANOS, Pecho.ARMADURA_CUERO, Pecho.ARMADURA_HIERRO, Pecho.BATA_MAGO
			},
			new int[] {
			30, 60, 90, 35, 70, 55, 20, 50, 100, 40, 80, 110
			});
	
	/**
	 * Metodo que muestra menu de la tienda
	 * @param jugador
	 */
    public void mostrarTienda(Jugador jugador) {
        int longitudTotal = BASICO.length + itemsEspeciales.length;
        String[] opciones = new String[longitudTotal];

        // Copiar los elementos de BASICO al array opciones
        for (int i = 0; i < BASICO.length; i++) {
            opciones[i] = BASICO[i].getNombre();
        }

        // Copiar los elementos de itemsEspeciales al array opciones
        for (int i = 0; i < itemsEspeciales.length; i++) {
            opciones[BASICO.length + i] = itemsEspeciales[i].getNombre();
        }

        // Crear el mensaje
        String mensaje = "Bienvenido a la tienda! Elige un objeto para comprar:\n\n";

        for (int i = 0; i < BASICO.length; i++) {
            mensaje += BASICO[i].getNombre() + "   " + PRECIO_BASICO[i] + " g\n";
        }

        for (int i = 0; i < itemsEspeciales.length; i++) {
            mensaje += itemsEspeciales[i].getNombre() + "   " + this.precio[i] + " g\n";
        }
        
        String seleccion = (String) JOptionPane.showInputDialog(
                null, 
                mensaje,
                "Tienda",
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                opciones,
                opciones[0]);

        
        if (seleccion != null) {
        	int comprar = JOptionPane.showConfirmDialog(null, "¿Desea comprar " + seleccion + " ?");
            boolean encontrado = false;
            int pos = -1;
    		for (int i = 0; i < opciones.length && !encontrado; i++) {
    			if (opciones[i].equals(seleccion)) {
    				pos = i;
    				break;
    			}
    		}
    		
    		
    		if (pos < this.PRECIO_BASICO.length && pos != -1) {
    			if (comprar == JOptionPane.YES_OPTION) {
    				if (checkOro(jugador, this.PRECIO_BASICO[pos]))  {
    					jugador.recibirItemConsumible(this.BASICO[pos]);
    					jugador.quitarOro(this.PRECIO_BASICO[pos]);
    				} else {
        				JOptionPane.showMessageDialog(null, "No tienes suficiente oro");
        			}
    			} 
    		} else if (pos >= this.PRECIO_BASICO.length){
    			pos -= this.PRECIO_BASICO.length;
    			if (pos < this.precio.length && pos != (-1 - pos)) {
    				if (comprar == JOptionPane.YES_OPTION) {
        				if (checkOro(jugador, this.precio[pos]))  {
        					jugador.recibirItemConsumible(this.itemsEspeciales[pos]);
        					jugador.quitarOro(this.precio[pos]);
        				} else {
            				JOptionPane.showMessageDialog(null, "No tienes suficiente oro");
            			}
        			}	
    			}
    		}
        }
    }
    /**
     * Comprueba si tiene una cantidad de oro superior o igual
     * @param jugador quien posee el oro
     * @param cantidad a comprobar
     * @return
     */
    public boolean checkOro(Jugador jugador, int cantidad) {
    	boolean tieneOro;
    	if (jugador.getGold() < cantidad) {
    		tieneOro = false;
    	} else {
    		tieneOro = true;
    	}
    	return tieneOro;
    }
    
    /**
     * Busca el item en el inventario deseado
     * @param inventario
     * @param item
     * @return posicion dentro del array, -1 si no se encuentra
     */
    public int buscarItem(Items[] inventario, Items item) {
    	for (int i = 0; i < inventario.length; i++) {
            if (inventario[i].equals(item)) {
                return i;
            }
        }
    	return -1;
    }
	
}
