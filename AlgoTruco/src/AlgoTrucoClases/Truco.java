package AlgoTrucoClases;

import java.util.Scanner;

public class Truco {

    private Partida partida;
    
    public Truco(){}
    
    
 // Hay que definir partida si es Singleton, por su invocación.
	/* Posible código de Truco */
    public void crearPartida(){
    	/*Estos datos seguro se obtengan con la interfaz. Guardamos y generamos las instancias necesarias*/
    	String jugador1equipo1 = this.obtenerNombreDeJugador();
    	String jugador2equipo1 = this.obtenerNombreDeJugador();
    	String jugador1equipo2 = this.obtenerNombreDeJugador();
    	String jugador2equipo2 = this.obtenerNombreDeJugador();
        Equipo equipo1 = new Equipo(new Jugador(jugador1equipo1),new Jugador(jugador2equipo1));
        Equipo equipo2 = new Equipo(new Jugador(jugador1equipo2),new Jugador(jugador2equipo2));
    	this.partida = new Partida(equipo1,equipo2);
    	this.partida.iniciarPartida();
    }


public String obtenerNombreDeJugador() {
	/*Hay que programarlo para que con la interfaz nos muestre los cuadritos para completar. En principío, lo dejo
	 * andando así.*/
	
	System.out.println ("Por favor introduzca el nombre del jugador:");
    String entradaTeclado = "";
    Scanner entradaEscaner = new Scanner (System.in); 
    entradaTeclado = entradaEscaner.nextLine ();
	return entradaTeclado;
}

}
