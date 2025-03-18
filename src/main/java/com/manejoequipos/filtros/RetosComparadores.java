package com.manejoequipos.filtros;

import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.equipos;
import com.manejoequipos.domain.jugador;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Retos que utilizan principalmente operaciones de comparación (Comparator)
 */
public class RetosComparadores {

    /**
     * 3. Mostrar el equipo con más victorias
     */
    public static void equipoConMasVictorias(Liga liga) {
        System.out.println("\n--- Equipo con más victorias ---");
        
        // Comparator para comparar por número de victorias
        Comparator<equipos> compararPorVictorias = Comparator.comparingInt(
            equipo -> Integer.parseInt(equipo.getStatistics().get(0).getPg())
        );
        
        // Encontrar el equipo con más victorias
        liga.getEquipos().stream()
            .max(compararPorVictorias)
            .ifPresent(equipo -> System.out.println(
                "Equipo con más victorias: " + equipo.getName() + 
                " (" + equipo.getStatistics().get(0).getPg() + " victorias)"
            ));
    }

    /**
     * 4. Encontrar el jugador más alto de todos los equipos
     */
    public static void jugadorMasAlto(Liga liga) {
        System.out.println("\n--- Jugador más alto de todos los equipos ---");
        
        // Function para extraer la altura como entero (asumiendo formato "xxx cm")
        Function<jugador, Integer> extraerAltura = jugador -> {
            String alturaStr = jugador.getHeight().replaceAll("[^0-9]", "");
            return Integer.parseInt(alturaStr);
        };
        
        // Comparator para comparar por altura
        Comparator<jugador> compararPorAltura = Comparator.comparing(extraerAltura);
        
        // Encontrar el jugador más alto usando flatMap
        liga.getEquipos().stream()
            .flatMap(equipo -> equipo.getPlayers().stream())
            .max(compararPorAltura)
            .ifPresent(jugador -> System.out.println(
                "Jugador más alto: " + jugador.getName() + 
                " (" + jugador.getHeight() + ") - " + 
                "Equipo: " + obtenerEquipoDeJugador(liga, jugador)
            ));
    }
    
    // Método auxiliar para obtener el equipo de un jugador
    private static String obtenerEquipoDeJugador(Liga liga, jugador jugador) {
        return liga.getEquipos().stream()
            .filter(equipo -> equipo.getPlayers().contains(jugador))
            .map(equipos::getName)
            .findFirst()
            .orElse("Desconocido");
    }

    /**
     * 8. Listar los jugadores de nacionalidad "Brasileño" y ordenarlos por edad
     */
    public static void jugadoresBrasilenosPorEdad(Liga liga) {
        System.out.println("\n--- Jugadores brasileños ordenados por edad ---");
        
        // Predicate para filtrar jugadores brasileños
        Predicate<jugador> esBrasileno = jugador -> 
            jugador.getNationality().equalsIgnoreCase("Brasileño");
        
        // Comparator para ordenar por edad
        Comparator<jugador> compararPorEdad = Comparator.comparingInt(
            jugador -> Integer.parseInt(jugador.getAge())
        );
        
        // Obtener jugadores brasileños ordenados por edad
        List<jugador> jugadoresBrasilenos = liga.getEquipos().stream()
            .flatMap(equipo -> equipo.getPlayers().stream())
            .filter(esBrasileno)
            .sorted(compararPorEdad)
            .collect(Collectors.toList());
        
        // Imprimir la lista
        jugadoresBrasilenos.forEach(jugador -> 
            System.out.println(jugador.getName() + " - " + jugador.getAge() + " años")
        );
    }

    /**
     * 12. Obtener los equipos con más de 20 goles a favor ordenados de mayor a menor
     */
    public static void equiposConMasDe20GolesOrdenados(Liga liga) {
        System.out.println("\n--- Equipos con más de 20 goles a favor (ordenados) ---");
        
        // Predicate para filtrar equipos con más de 20 goles
        Predicate<equipos> masDe20Goles = equipo -> 
            Integer.parseInt(equipo.getStatistics().get(0).getGf()) > 20;
        
        // Comparator para ordenar por goles (de mayor a menor)
        Comparator<equipos> compararPorGoles = Comparator.comparingInt(
            (equipos equipo) -> Integer.parseInt(equipo.getStatistics().get(0).getGf())
        ).reversed();
        
        // Filtrar, ordenar y mostrar resultados
        liga.getEquipos().stream()
            .filter(masDe20Goles)
            .sorted(compararPorGoles)
            .forEach(equipo -> System.out.println(
                equipo.getName() + " - " + 
                equipo.getStatistics().get(0).getGf() + " goles a favor"
            ));
    }
}