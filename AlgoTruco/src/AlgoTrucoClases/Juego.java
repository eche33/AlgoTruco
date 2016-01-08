package AlgoTrucoClases;

import java.util.Scanner;

public class Juego {


    private Partida partida;
    
    
    public Juego(){}
    
    public void crearPartida(Equipo equipo1, Equipo equipo2){
    	
    	this.partida = new Partida(equipo1,equipo2);
    	this.partida.iniciarPartida();
    }

	public Equipo obtenerEquipo(int i) {
		return partida.obtenerEquipo(i);
	}

}

