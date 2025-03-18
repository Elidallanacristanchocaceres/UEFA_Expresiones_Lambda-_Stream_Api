package com.manejoequipos.usecase;

import com.manejoequipos.domain.Liga;

public class RetosF {
    public static void totalGolesPorEquipo(Liga liga) {
        liga.getEquipos().forEach(equipo -> {
            int golesFavor = Integer.parseInt(equipo.getStatistics().get(0).getGf());
            System.out.println("Total de goles a favor de " + equipo.getName() + ": " + golesFavor);
        });
    }
}