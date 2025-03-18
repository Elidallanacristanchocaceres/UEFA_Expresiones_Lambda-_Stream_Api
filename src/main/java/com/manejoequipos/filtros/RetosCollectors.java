package com.manejoequipos.filtros;

import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.equipos;
import com.manejoequipos.domain.jugador;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Retos que utilizan principalmente operaciones de recolección (Collectors)
 
public class RetosCollectors {

    //5. Contar cuántos jugadores son delanteros en toda la UEFA Champions League
     
    public static void contarDelanteros(Liga liga) {
        System.out.println("\n--- Cantidad de delanteros en la UEFA Champions League ---");
        
        // Predicate para filtrar jugadores delanteros
        Predicate<jugador> esDelantero = jugador -> 
            jugador.getPosition().equalsIgnoreCase("Delantero");
        
        // Contar delanteros usando flatMap y filter
        long cantidadDelanteros = liga.getEquipos().stream()
            .flatMap(equipo -> equipo.getPlayers().stream())
            .filter(esDelantero)
            .count();
        
        System.out.println("Total de delanteros: " + cantidadDelanteros);
    }

    //6. Obtener los nombres de los entrenadores de los equipos que han empatado al menos un partido
     
    public static void entrenadoresEquiposConEmpates(Liga liga) {
        System.out.println("\n--- Entrenadores de equipos con al menos un empate ---");
        
        // Predicate para filtrar equipos con al menos un empate
        Predicate<equipos> tieneEmpates = equipo -> 
            Integer.parseInt(equipo.getStatistics().get(0).getPe()) > 0;
        
        // Obtener lista de entrenadores
        List<String> entrenadores = liga.getEquipos().stream()
            .filter(tieneEmpates)
            .map(equipos::getCoach)
            .collect(Collectors.toList());
        
        System.out.println("Entrenadores: " + entrenadores);
    }

    //11. Agrupar los jugadores por posición y contar cuántos hay en cada una
     
    public static void jugadoresPorPosicion(Liga liga) {
        System.out.println("\n--- Cantidad de jugadores por posición ---");
        
        // Agrupar jugadores por posición y contar
        Map<String, Long> jugadoresPorPosicion = liga.getEquipos().stream()
            .flatMap(equipo -> equipo.getPlayers().stream())
            .collect(Collectors.groupingBy(
                jugador::getPosition,
                Collectors.counting()
            ));
        
        // Imprimir resultados
        jugadoresPorPosicion.forEach((posicion, cantidad) -> 
            System.out.println(posicion + ": " + cantidad + " jugadores")
        );
    }
}