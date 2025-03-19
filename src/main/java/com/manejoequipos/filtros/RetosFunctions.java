package com.manejoequipos.filtros;

import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.equipos;

import java.util.function.Function;
import java.util.stream.Collectors;

//Retos que utilizan principalmente la interfaz funcional Function
 
public class RetosFunctions {

    //2. Obtener el promedio de goles a favor por equipo
    
    public static void promedioGolesAFavor(Liga liga) {
        System.out.println("\n--- Promedio de goles a favor por equipo ---");
        
        // Function para extraer los goles a favor como entero
        Function<equipos, Integer> extraerGoles = equipo -> 
            Integer.parseInt(equipo.getStatistics().get(0).getGf());
        
        // Calcular promedio usando Collectors.averagingInt()
        double promedio = liga.getEquipos().stream()
            .collect(Collectors.averagingInt(extraerGoles::apply));
        
        System.out.println("El promedio de goles a favor por equipo es: " + promedio);
    }
}