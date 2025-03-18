package com.manejoequipos.usecase;

import com.manejoequipos.domain.Liga;

public class RetosB {
    public static void imprimirEntrenadores(Liga liga) {
        liga.getEquipos().forEach(e -> System.out.println("Entrenador: " + e.getCoach())); 
    }
}