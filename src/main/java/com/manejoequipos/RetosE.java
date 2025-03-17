package com.manejoequipos;

public class RetosE {
        public static void jugadorMasAltoPorEquipo(Liga liga) {
            liga.getEquipos().forEach(equipo -> {
                Jugador masAlto = equipos.getPlayers().stream()
                    .max((j1, j2) -> Integer.compare(j1.getHeight(), j2.getHeight()))
                    .orElse(null);
                if (masAlto != null) {
                    System.out.println("Equipo: " + equipos.getName() + " - Jugador más alto: " + masAlto.getName());
                }
            });
        }
    }
