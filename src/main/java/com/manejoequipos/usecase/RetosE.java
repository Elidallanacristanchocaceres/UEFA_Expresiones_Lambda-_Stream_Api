package com.manejoequipos.usecase;

import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.jugador;
import java.util.Comparator;

public class RetosE {
    public static void jugadorMasAltoPorEquipo(Liga liga) {
        liga.getEquipos().forEach(equipo -> {
            jugador jugadorMasAlto = equipo.getPlayers().stream()
                .max(Comparator.comparing(j -> {
                    // Asumiendo que height está en formato "xxx cm"
                    String heightStr = j.getHeight().replaceAll("[^0-9]", "");
                    return Integer.parseInt(heightStr);
                }))
                .orElse(null);
                
            if (jugadorMasAlto != null) {
                System.out.println("Jugador más alto de " + equipo.getName() + ": " 
                    + jugadorMasAlto.getName() + " (" + jugadorMasAlto.getHeight() + ")");
            }
        });
    }
}