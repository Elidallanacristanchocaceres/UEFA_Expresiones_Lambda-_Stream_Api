package com.manejoequipos;

public class RetosB {
    public static void imprimirEntrenadores(Liga liga) {
        liga.getEquipos().forEach(e -> System.out.println("Entrenador: " + e.getCoach())); 
    }
}