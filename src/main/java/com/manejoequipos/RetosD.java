package com.manejoequipos;

import java.util.List;
import java.util.stream.Collectors;

public class RetosD {
    public static void equiposMasDe20Victorias(Liga liga){
        List<String> equipos = liga.getEquipos().stream()
        .filter(e -> e.getStatistics().get(0).getPg() > 20)
        .map(equipos::getName)
        .collect(Collectors.toList());

        System.out.println("Equipos con mas de 20 victorias: " + equipos);
    }
}
