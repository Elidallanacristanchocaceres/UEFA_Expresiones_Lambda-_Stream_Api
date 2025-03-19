package com.manejoequipos.usecase;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.equipos;

public class RetosD {

    //filtrar equipos con más de 20 victorias
    public static final Predicate<equipos> masDe20Victorias = equipo -> {
        int partidosGanados = Integer.parseInt(equipo.getStatistics().get(0).getPg());
        return partidosGanados > 20;
    };

    // Obtener y mostrar equipos con más de 20 victorias
    public static void equiposMasDe20Victorias(Liga liga) {
        List<String> equipos = liga.getEquipos().stream()
            .filter(masDe20Victorias) // Aplicar el Predicate
            .map(equipo -> equipo.getName()) // Obtener el nombre del equipo
            .collect(Collectors.toList()); // Recopilar los nombres en una lista

        System.out.println("Equipos con más de 20 victorias: " + equipos);
    }
}