package com.manejoequipos.usecase;

import java.util.List;
import java.util.stream.Collectors;
import com.manejoequipos.domain.Liga;

public class RetosD {
    public static void equiposMasDe20Victorias(Liga liga){
        List<String> equipos = liga.getEquipos().stream()
        .filter(e -> Integer.parseInt(e.getStatistics().get(0).getPg()) > 20)
        .map(e -> e.getName())
        .collect(Collectors.toList());

        System.out.println("Equipos con mas de 20 victorias: " + equipos);
    }
}