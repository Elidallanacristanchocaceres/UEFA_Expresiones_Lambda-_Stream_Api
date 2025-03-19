package com.manejoequipos.filtros;

import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.equipos;

import java.util.function.Predicate;

//Retos que utilizan principalmente la interfaz funcional Predicate
 
public class RetosPredicates {

    //1. Listar equipos con más de 15 puntos en la fase de liga
    
    public static void equiposConMasDe15Puntos(Liga liga) {
        System.out.println("\n--- Equipos con más de 15 puntos ---");
        
        // Predicate para filtrar equipos con más de 15 puntos
        Predicate<equipos> masDe15Puntos = equipo -> 
            Integer.parseInt(equipo.getStatistics().get(0).getTp()) > 15;
        
        // Aplicar Stream API con el Predicate
        liga.getEquipos().stream()
            .filter(masDe15Puntos)
            .forEach(equipo -> System.out.println(equipo.getName() + " - " + 
                equipo.getStatistics().get(0).getTp() + " puntos"));
    }

    //9. Filtrar los equipos cuyo entrenador tiene más de 10 caracteres en su nombre
    
    public static void equiposConEntrenadorNombreLargo(Liga liga) {
        System.out.println("\n--- Equipos con entrenador de nombre largo (>10 caracteres) ---");
        
        // Predicate para filtrar equipos con entrenador de nombre largo
        Predicate<equipos> entrenadorNombreLargo = equipo -> 
            equipo.getCoach().length() > 10;
        
        // Filtrar equipos y mostrar resultados
        liga.getEquipos().stream()
            .filter(entrenadorNombreLargo)
            .forEach(equipo -> System.out.println(
                equipo.getName() + " - Entrenador: " + equipo.getCoach() + 
                " (" + equipo.getCoach().length() + " caracteres)"
            ));
    }

    //10. Determinar si algún equipo tiene más de 25 puntos
    
    public static void algunEquipoConMasDe25Puntos(Liga liga) {
        System.out.println("\n--- ¿Algún equipo tiene más de 25 puntos? ---");
        
        // Predicate para verificar si un equipo tiene más de 25 puntos
        Predicate<equipos> masDe25Puntos = equipo -> 
            Integer.parseInt(equipo.getStatistics().get(0).getTp()) > 25;
        
        // Verificar usando anyMatch
        boolean hayEquipoConMasDe25Puntos = liga.getEquipos().stream()
            .anyMatch(masDe25Puntos);
        
        System.out.println("¿Hay algún equipo con más de 25 puntos? " + 
            (hayEquipoConMasDe25Puntos ? "Sí" : "No"));
        
        // Si hay alguno, mostrar cuáles son
        if (hayEquipoConMasDe25Puntos) {
            System.out.println("Equipos con más de 25 puntos:");
            liga.getEquipos().stream()
                .filter(masDe25Puntos)
                .forEach(equipo -> System.out.println(
                    equipo.getName() + " - " + 
                    equipo.getStatistics().get(0).getTp() + " puntos"
                ));
        }
    }
}