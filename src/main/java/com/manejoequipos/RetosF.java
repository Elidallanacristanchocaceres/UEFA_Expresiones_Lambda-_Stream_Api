package com.manejoequipos;

public class RetosF {
    public static void totalGolesPorEquipo(Liga liga) {
        liga.getEquipos().forEach(equipo -> {
            int totalGoles = equipo.getStatistics().get(0).getGf();
            System.out.println("Equipo: " + equipo.getName() + " - Total de goles: " + totalGoles);
        });
    }
}