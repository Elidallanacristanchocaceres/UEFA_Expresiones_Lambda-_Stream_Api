package com.manejoequipos.usecase;

import java.util.List;
import java.util.function.BiConsumer;
import com.manejoequipos.domain.Liga;
import com.manejoequipos.domain.equipos;
import com.manejoequipos.domain.jugador;

public class RetosC {

    // BiConsumer para calcular el promedio de edad de los jugadores de un equipo
    public static final BiConsumer<equipos, List<jugador>> calcularPromedioEdad = (equipo, jugadores) -> {
        double promedio = jugadores.stream()
            .mapToInt(jugador -> Integer.parseInt(jugador.getAge())) // Convertir la edad a entero
            .average() // Calcular el promedio
            .orElse(0.0); // Si no hay jugadores, el promedio es 0.0

        System.out.println("Promedio de edad de jugadores en " + equipo.getName() + ": " + promedio);
    };

    // Método para mostrar el promedio de edad de los jugadores de todos los equipos en la liga
    public static void promedioEdadJugadores(Liga liga) {
        liga.getEquipos().forEach(equipo -> {
            calcularPromedioEdad.accept(equipo, equipo.getPlayers());
        });
    }
}