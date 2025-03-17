package com.manejoequipos;

public class RetosC {
    public static void promedioEdadJugadores(Liga liga){
        liga.getEquipos().forEach(equipos -> {
            double promedio = equipos.getPlayers().stream()
            .mapToInt(jugador::getAge)
            .average()
            .orElse(0);
        });
    }
}
