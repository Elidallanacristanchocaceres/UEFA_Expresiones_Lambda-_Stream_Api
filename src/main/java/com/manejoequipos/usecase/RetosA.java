package com.manejoequipos.usecase;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.manejoequipos.domain.equipos;
import com.manejoequipos.domain.Liga;

public class RetosA {

    private static final Predicate<equipos> fundadoDespuesDel2000 = equipos -> 
        Integer.parseInt(equipos.getYearfoundation()) > 2000;

    public static void equiposDespuesDel2000(Liga liga) {
        List<String> equiposs = liga.getEquipos().stream()
                .filter(fundadoDespuesDel2000) 
                .map(equipos::getName)
                .collect(Collectors.toList());
        
        System.out.println("equiposs fundados después del 2000: " + equiposs);
    }
}