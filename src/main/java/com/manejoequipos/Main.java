package com.manejoequipos;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Liga liga = leerJson.leerJson("ruta/al/archivo.json"); // Cambia la ruta al archivo JSON
        System.out.println("Liga cargada: " + liga);

        RetosA.equiposDespuesDel2000(liga);
        RetosB.imprimirEntrenadores(liga);
        RetosC.promedioEdadJugadores(liga);
        RetosD.equiposMasDe20Victorias(liga);
        RetosE.jugadorMasAltoPorEquipo(liga);
        RetosF.totalGolesPorEquipo(liga);
    }
}