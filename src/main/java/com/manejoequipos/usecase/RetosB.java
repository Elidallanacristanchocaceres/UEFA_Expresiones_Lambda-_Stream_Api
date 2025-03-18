package com.manejoequipos.usecase;

import java.util.function.Consumer;

import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.equipos;

public class RetosB {
    @SuppressWarnings("unused")
    private static final Consumer<equipos> imprimirEntrenadores = equipos -> 
        Integer.parseInt(equipos.getCoach());
    public static void imprimirEntrenadores(Liga liga) {
        liga.getEquipos().forEach(e -> System.out.println("Entrenador: " + e.getCoach())); 
    }
}