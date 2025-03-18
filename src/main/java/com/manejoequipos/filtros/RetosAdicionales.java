package com.manejoequipos.filtros;

import com.manejoequipos.domain.Liga;

/**
 * Clase coordinadora que ejecuta todos los retos adicionales
 */
public class RetosAdicionales {
    
    /**
     * Método para ejecutar todos los retos adicionales
     */
    public static void ejecutarTodosLosRetos(Liga liga) {
        // Retos con Predicates
        RetosPredicates.equiposConMasDe15Puntos(liga);
        RetosPredicates.algunEquipoConMasDe25Puntos(liga);
        RetosPredicates.equiposConEntrenadorNombreLargo(liga);
        
        // Retos con Consumerm
        RetosConsumers.mapEquiposGoles(liga);
        
        // Retos con Functions
        RetosFunctions.promedioGolesAFavor(liga);
        
        // Retos con Collectors
        RetosCollectors.jugadoresPorPosicion(liga);
        RetosCollectors.entrenadoresEquiposConEmpates(liga);
        RetosCollectors.contarDelanteros(liga);
        
        // Retos con Comparadores
        RetosComparadores.equipoConMasVictorias(liga);
        RetosComparadores.jugadorMasAlto(liga);
        RetosComparadores.jugadoresBrasilenosPorEdad(liga);
        RetosComparadores.equiposConMasDe20GolesOrdenados(liga);
    }
}