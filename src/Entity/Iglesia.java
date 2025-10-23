package Entity;

import javax.swing.JOptionPane;

public class Iglesia extends Entidad{

	public Iglesia(int x, int y, String rep) {
		super(x, y, rep);
		
	}
	
	public static Iglesia IGLESIA = new Iglesia(0, 0, "⛪");
	
	public void menu(Jugador jugador) {
		Object[] options = { "Descansar", "Cancelar" };

        // Mostrar el JOptionPane con las opciones
        int seleccion = JOptionPane.showOptionDialog(
                null,  // Componente padre (null para centrarlo en la pantalla)
                "Bienvenido a la iglesia héroe. \n ¿Deseas descansar?",  // Mensaje
                "Iglesia",  // Título de la ventana
                JOptionPane.DEFAULT_OPTION,  // Tipo de opción (DEFAULT)
                JOptionPane.QUESTION_MESSAGE,  // Tipo de mensaje (pregunta)
                null,  // Icono (null para el icono predeterminado)
                options,  // Las opciones del botón
                options[0]  // Opción por defecto (en este caso "Descansar")
        );

        // Manejar la selección del usuario
        if (seleccion == 0) {
            JOptionPane.showMessageDialog(null, "Descansas hasta recuperarte por completo");
            jugador.curar(1000);
            jugador.setStamina(jugador.getMaxStamina());
            jugador.setMana(jugador.getMaxMana());
            // Aquí puedes agregar lo que debe suceder cuando elige descansar
        } else {
        	JOptionPane.showMessageDialog(null, "Te vas de la iglesia.");
            // Aquí puedes agregar lo que debe suceder cuando elige cancelar
        }
	}

}
