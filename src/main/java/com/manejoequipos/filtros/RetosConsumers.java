package com.manejoequipos.filtros;

import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.equipos;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

//Retos que utilizan principalmente las interfaces funcionales Consumer y BiConsumer

public class RetosConsumers {

    //7. Crear un Map con los nombres de los equipos como clave y la cantidad total de goles a favor como valor

    public static void mapEquiposGoles(Liga liga) {
        System.out.println("\n--- Map de equipos y sus goles a favor ---");
        
        // Function para extraer el nombre del equipo
        Function<equipos, String> extraerNombre = equipos::getName;
        
        // Function para extraer los goles a favor
        Function<equipos, Integer> extraerGoles = equipo -> 
            Integer.parseInt(equipo.getStatistics().get(0).getGf());
        
        // Crear Map usando Collectors.toMap()
        Map<String, Integer> equiposGoles = liga.getEquipos().stream()
            .collect(Collectors.toMap(
                extraerNombre,
                extraerGoles
            ));
        
        // BiConsumer para imprimir cada entrada del Map
        BiConsumer<String, Integer> imprimirEntrada = (equipo, goles) -> 
            System.out.println(equipo + ": " + goles + " goles");
        
        // Imprimir el Map
        equiposGoles.forEach(imprimirEntrada);
    }
}