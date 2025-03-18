package com.manejoequipos.usecase;

import com.manejoequipos.domain.Liga;

public class RetosC {
    public static void promedioEdadJugadores(Liga liga){
        liga.getEquipos().forEach(equipos -> {
            double promedio = equipos.getPlayers().stream()
            .mapToInt(jugador -> Integer.parseInt(jugador.getAge()))
            .average()
            .orElse(0);
            
            System.out.println("Promedio de edad de jugadores en " + equipos.getName() + ": " + promedio);
        });
    }
}