package com.manejoequipos;

import java.io.IOException;
import com.manejoequipos.domain.Liga;
import com.manejoequipos.repository.leerJson;
import com.manejoequipos.ui.Menu;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Cargando datos de la UEFA Champions League...");
            Liga liga = leerJson.leerJson("uefa.json");
            System.out.println("Datos cargados correctamente.\n");
            
            Menu menu = new Menu(liga);
            menu.mostrarMenuPrincipal();
            
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}