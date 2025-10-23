package Quest;

import javax.swing.JOptionPane;

import Entity.Jugador;
import Items.*;

public class Mision {

	private String texto;
	private final int ID;
	private Items itemRequisito;
	private int cantidadRequisito;
	private Items recompensaItemConsumible;
	private int recompensaOro;
	private static int numDeMisiones = 0;
	private boolean completado = false;
	
	
	private Mision(String texto, Items itemRequisito, int cantidadRequisito, Items recompensaItem, int recompensaOro) {
        this.ID = numDeMisiones;  // Asignamos un ID único usando el contador
        numDeMisiones++;  // Incrementamos el contador para la siguiente misión
        this.texto = texto;
        this.itemRequisito = itemRequisito;
        this.cantidadRequisito = cantidadRequisito;
        this.recompensaItemConsumible = recompensaItem;
        this.recompensaOro = recompensaOro;
    }
	
	public final static Mision mision1 = new Mision(
			"Hola, necesito 5 de " + Items.PIEL_SERPIENTE.getNombre() + ", te pagaré adecuadamente.",
			Items.PIEL_SERPIENTE,
			5,
			null,
			20
			);
	
	public final static Mision mision2 = new Mision(
			"Hola, necesito que elimines algunos goblins de la cueva sureste, trae 5 de " + Items.OREJA_GOBLIN.getNombre() + " y a cambio te pagaré.",
			Items.OREJA_GOBLIN,
			5,
			null,
			50
			);
	
	public final static Mision mision3 = new Mision(
			"En la cueva sureste se encuentra un rey goblin, si lo matas te recompensare. " + Items.CORONA_GOBLIN.getNombre() + " x1",
			Items.CORONA_GOBLIN,
			1,
			null,
			100
			);
	
	public final static Mision mision4 = new Mision(
			"He escuchado que el hueso en polvo es bueno para los cultivos. \n Podrias traerme 5 de " + Items.HUESOS.getNombre() + ", te pagaré adecuadamente.",
			Items.HUESOS,
			5,
			null,
			50
			);
	
	public final static Mision mision5 = new Mision(
			"Ultimamente hay escasez de agua para los cultivos. Si me traes 5 de " + Items.ORBE_SLIME.getNombre() + ", te pagaré adecuadamente.",
			Items.ORBE_SLIME,
			5,
			null,
			20
			);
	
	public final static Mision mision6 = new Mision(
			"Los bandidos del bosque estan causando problemas, necesito que elimines al menos 5 de ellos. " + Items.TAG_BANDIDO.getNombre() + " x5",
			Items.TAG_BANDIDO,
			5,
			null,
			200
			);
	
	public final static Mision mision7 = new Mision(
			"Los lobos acechan a mis gallinas por las noches, ¿podrias hacer algo? " + Items.PIEL_LOBO.getNombre() + " x5",
			Items.PIEL_LOBO,
			5,
			null,
			70
			);
	
	public final static Mision mision8 = new Mision(
			"Si tienes 5 de " + Items.CUERNO_DEMONIO.getNombre() + " te puedo ofrecer 300g por ello.",
			Items.CUERNO_DEMONIO,
			5,
			null,
			300
			);
	
	public final static Mision mision9 = new Mision(
			"He escuchado que los generales demonio tienen cuernos muy robustos, si me traes uno te puedo forjar un arma. " + Items.CUERNO_GRANDE_DEMONIO.getNombre() + " x1",
			Items.CUERNO_GRANDE_DEMONIO,
			1,
			Arma.ESPADA_ROBUSTA,
			0
			);
	
	public final static Mision misionFinal = new Mision(
			"El rey demonio ha vuelto a surgir, solo tú el elegido tienes la capacidad de derrotarlo y salvar nuestro mundo. \n Si me traes su corona como prueba el reino pagará por tus hazañas. " + Items.CORONA_DEMONIO.getNombre() + " x1",
			Items.CORONA_DEMONIO,
			1,
			null,
			100000
			);
	
	
	/**
	 * Muestra una ventana con la mision
	 * @param jugador
	 */
	public void mostrarMision(Jugador jugador) {
        // Crear el mensaje con toda la información de la misión
        String mensaje = this.texto + "\n\n" +
                         "Requisito: " + itemRequisito.getNombre() + " x" + cantidadRequisito + "\n" +
                         "Recompensa: " + (recompensaItemConsumible != null ? recompensaItemConsumible.getNombre() : "Ninguna") + "\n" +
                         "Oro: " + recompensaOro + " monedas de oro";

        // Usar JOptionPane para mostrar el mensaje con opciones
        int opcion = JOptionPane.showOptionDialog(null, 
                                                  mensaje, 
                                                  "Misión", 
                                                  JOptionPane.DEFAULT_OPTION, 
                                                  JOptionPane.INFORMATION_MESSAGE, 
                                                  null, 
                                                  new String[]{"Completar", "Cerrar"}, 
                                                  "Cerrar");

        // Lógica según la opción seleccionada
        if (opcion == 0) {
        	if (jugador.quitarItemInventarioComun(this.itemRequisito, this.cantidadRequisito)) {
        		JOptionPane.showMessageDialog(null, "¡Misión completada!");	
        		recompensaMision(jugador);
        	} else {
        		JOptionPane.showMessageDialog(null, "No cumples con los requisitos aún.");	
        	}
            // Si el usuario elige "Completar"
            //TODO si es completado eliminar mision. Es posible que sea mejor añadir booleano para sabe si se ha completado o no.
        	completado = true;
        } else if (opcion == 1) {
            // Si el usuario elige "Cerrar"
            JOptionPane.showMessageDialog(null, "Misión cerrada.");
        }
	}
	/**
	 * Da las recompensas al jugador
	 * @param jugador
	 */
	private void recompensaMision(Jugador jugador) {
		jugador.setGold(jugador.getGold() + this.recompensaOro);
		jugador.recibirItemConsumible(this.recompensaItemConsumible);
	}

	public Items getItemRequisito() {
		return itemRequisito;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setItemRequisito(Items itemRequisito) {
		this.itemRequisito = itemRequisito;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}
}
