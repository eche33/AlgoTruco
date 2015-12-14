package AlgoTrucoClases;

import java.util.Scanner;

public class Truco {

    private Partida partida;
    private int jugadoresPorEquipo;
    
    public Truco(){}
    
    public void crearPartida(){
    	Equipo equipo1 = new Equipo();
    	Equipo equipo2 = new Equipo();
    	
    	for (int i = 1; i <= jugadoresPorEquipo; i++)
    		equipo1.agregarJugadorAEquipo(new Jugador(this.obtenerNombreDeJugador(1)));
    	
    	for (int i = 1; i <= jugadoresPorEquipo; i++)
    		equipo2.agregarJugadorAEquipo(new Jugador(this.obtenerNombreDeJugador(2)));

    	this.partida = new Partida(equipo1,equipo2);
    	this.partida.iniciarPartida();
    }


public String obtenerNombreDeJugador(int equipo) {
	
	System.out.println ("Por favor, introduzca el nombre del jugador del equipo"+equipo+": ");
    String entradaTeclado = "";
    Scanner entradaEscaner = new Scanner (System.in); 
    entradaTeclado = entradaEscaner.nextLine ();
	return entradaTeclado;
}

}
