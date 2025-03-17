package com.manejoequipos;

import java.util.List;
import java.util.stream.Collectors;

public class RetosA {
    public static void equiposDespuesDel2000(Liga liga) {
        List<String> equipos = liga.getEquipos().stream()
            .filter(e -> Integer.parseInt(e.getYearfoundation()) > 2000) // Convertir a int
            .map(e -> e.getName())
            .collect(Collectors.toList());
        System.out.println("Equipos fundados después del 2000: " + equipos);
    }
}