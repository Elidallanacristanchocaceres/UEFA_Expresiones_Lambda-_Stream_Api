package com.manejoequipos.ui;

import java.util.Scanner;
import com.manejoequipos.domain.Liga;
import com.manejoequipos.usecase.*;
import com.manejoequipos.filtros.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Liga liga;

    // Constructor que recibe la liga ya cargada
    public Menu(Liga liga) {
        this.liga = liga;
    }

    public void mostrarMenuPrincipal() {
        // Lógica del menú
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("==============================================");
            System.out.println("      GESTIÓN DE EQUIPOS UEFA CHAMPIONS      ");
            System.out.println("==============================================");
            System.out.println("1. Retos Básicos");
            System.out.println("2. Retos con Predicates");
            System.out.println("3. Retos con Consumers");
            System.out.println("4. Retos con Functions");
            System.out.println("5. Retos con Collectors");
            System.out.println("6. Retos con Comparadores");
            System.out.println("7. Ejecutar todos los retos");
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        mostrarMenuRetosBasicos();
                        break;
                    case 2:
                        mostrarMenuRetosPredicates();
                        break;
                    case 3:
                        mostrarMenuRetosConsumers();
                        break;
                    case 4:
                        mostrarMenuRetosFunctions();
                        break;
                    case 5:
                        mostrarMenuRetosCollectors();
                        break;
                    case 6:
                        mostrarMenuRetosComparadores();
                        break;
                    case 7:
                        ejecutarTodosLosRetos();
                        break;
                    case 0:
                        System.out.println("\nSaliendo de la aplicación...");
                        scanner.close(); // Cerrar el scanner al salir
                        break;
                    default:
                        System.out.println("\nOpción no válida. Presione Enter para continuar...");
                        scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor, ingrese un número válido. Presione Enter para continuar...");
                scanner.nextLine();
                opcion = -1;
            }
            
        } while (opcion != 0);
    }

    private void mostrarMenuRetosBasicos() {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("==============================================");
            System.out.println("              RETOS BÁSICOS                  ");
            System.out.println("==============================================");
            System.out.println("1. Equipos fundados después del 2000");
            System.out.println("2. Imprimir entrenadores");
            System.out.println("3. Promedio de edad de jugadores");
            System.out.println("4. Equipos con más de 20 victorias");
            System.out.println("5. Jugador más alto por equipo");
            System.out.println("6. Total de goles por equipo");
            System.out.println("0. Volver al menú principal");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        ejecutarReto(() -> RetosA.equiposDespuesDel2000(liga));
                        break;
                    case 2:
                        ejecutarReto(() -> RetosB.imprimirEntrenadores(liga));
                        break;
                    case 3:
                        ejecutarReto(() -> RetosC.promedioEdadJugadores(liga));
                        break;
                    case 4:
                        ejecutarReto(() -> RetosD.equiposMasDe20Victorias(liga));
                        break;
                    case 5:
                        ejecutarReto(() -> RetosE.jugadorMasAltoPorEquipo(liga));
                        break;
                    case 6:
                        ejecutarReto(() -> RetosF.totalGolesPorEquipo(liga));
                        break;
                    case 0:
                        // Volver al menú principal
                        break;
                    default:
                        System.out.println("\nOpción no válida. Presione Enter para continuar...");
                        scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor, ingrese un número válido. Presione Enter para continuar...");
                scanner.nextLine();
                opcion = -1;
            }
            
        } while (opcion != 0);
    }

    private void mostrarMenuRetosPredicates() {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("==============================================");
            System.out.println("           RETOS CON PREDICATES              ");
            System.out.println("==============================================");
            System.out.println("1. Equipos con más de 15 puntos");
            System.out.println("2. Equipos con entrenador de nombre largo");
            System.out.println("3. Verificar si hay equipos con más de 25 puntos");
            System.out.println("0. Volver al menú principal");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        ejecutarReto(() -> RetosPredicates.equiposConMasDe15Puntos(liga));
                        break;
                    case 2:
                        ejecutarReto(() -> RetosPredicates.equiposConEntrenadorNombreLargo(liga));
                        break;
                    case 3:
                        ejecutarReto(() -> RetosPredicates.algunEquipoConMasDe25Puntos(liga));
                        break;
                    case 0:
                        // Volver al menú principal
                        break;
                    default:
                        System.out.println("\nOpción no válida. Presione Enter para continuar...");
                        scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor, ingrese un número válido. Presione Enter para continuar...");
                scanner.nextLine();
                opcion = -1;
            }
            
        } while (opcion != 0);
    }

    private void mostrarMenuRetosConsumers() {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("==============================================");
            System.out.println("           RETOS CON CONSUMERS               ");
            System.out.println("==============================================");
            System.out.println("1. Map de equipos y sus goles a favor");
            System.out.println("0. Volver al menú principal");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        ejecutarReto(() -> RetosConsumers.mapEquiposGoles(liga));
                        break;
                    case 0:
                        // Volver al menú principal
                        break;
                    default:
                        System.out.println("\nOpción no válida. Presione Enter para continuar...");
                        scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor, ingrese un número válido. Presione Enter para continuar...");
                scanner.nextLine();
                opcion = -1;
            }
            
        } while (opcion != 0);
    }

    private void mostrarMenuRetosFunctions() {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("==============================================");
            System.out.println("           RETOS CON FUNCTIONS               ");
            System.out.println("==============================================");
            System.out.println("1. Promedio de goles a favor por equipo");
            System.out.println("0. Volver al menú principal");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        ejecutarReto(() -> RetosFunctions.promedioGolesAFavor(liga));
                        break;
                    case 0:
                        // Volver al menú principal
                        break;
                    default:
                        System.out.println("\nOpción no válida. Presione Enter para continuar...");
                        scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor, ingrese un número válido. Presione Enter para continuar...");
                scanner.nextLine();
                opcion = -1;
            }
            
        } while (opcion != 0);
    }

    private void mostrarMenuRetosCollectors() {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("==============================================");
            System.out.println("           RETOS CON COLLECTORS              ");
            System.out.println("==============================================");
            System.out.println("1. Contar delanteros en la UEFA Champions League");
            System.out.println("2. Entrenadores de equipos con al menos un empate");
            System.out.println("3. Jugadores por posición");
            System.out.println("0. Volver al menú principal");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        ejecutarReto(() -> RetosCollectors.contarDelanteros(liga));
                        break;
                    case 2:
                        ejecutarReto(() -> RetosCollectors.entrenadoresEquiposConEmpates(liga));
                        break;
                    case 3:
                        ejecutarReto(() -> RetosCollectors.jugadoresPorPosicion(liga));
                        break;
                    case 0:
                        // Volver al menú principal
                        break;
                    default:
                        System.out.println("\nOpción no válida. Presione Enter para continuar...");
                        scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor, ingrese un número válido. Presione Enter para continuar...");
                scanner.nextLine();
                opcion = -1;
            }
            
        } while (opcion != 0);
    }

    private void mostrarMenuRetosComparadores() {
        int opcion;
        do {
            limpiarPantalla();
            System.out.println("==============================================");
            System.out.println("          RETOS CON COMPARADORES             ");
            System.out.println("==============================================");
            System.out.println("1. Equipo con más victorias");
            System.out.println("2. Jugador más alto de todos los equipos");
            System.out.println("3. Jugadores brasileños ordenados por edad");
            System.out.println("4. Equipos con más de 20 goles ordenados");
            System.out.println("0. Volver al menú principal");
            System.out.println("==============================================");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        ejecutarReto(() -> RetosComparadores.equipoConMasVictorias(liga));
                        break;
                    case 2:
                        ejecutarReto(() -> RetosComparadores.jugadorMasAlto(liga));
                        break;
                    case 3:
                        ejecutarReto(() -> RetosComparadores.jugadoresBrasilenosPorEdad(liga));
                        break;
                    case 4:
                        ejecutarReto(() -> RetosComparadores.equiposConMasDe20GolesOrdenados(liga));
                        break;
                    case 0:
                        // Volver al menú principal
                        break;
                    default:
                        System.out.println("\nOpción no válida. Presione Enter para continuar...");
                        scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println("\nPor favor, ingrese un número válido. Presione Enter para continuar...");
                scanner.nextLine();
                opcion = -1;
            }
            
        } while (opcion != 0);
    }

    private void ejecutarTodosLosRetos() {
        limpiarPantalla();
        System.out.println("==============================================");
        System.out.println("          EJECUTANDO TODOS LOS RETOS          ");
        System.out.println("==============================================\n");
        
        // Retos básicos
        System.out.println("\n=== RETOS BÁSICOS ===");
        RetosA.equiposDespuesDel2000(liga);
        RetosB.imprimirEntrenadores(liga);
        RetosC.promedioEdadJugadores(liga);
        RetosD.equiposMasDe20Victorias(liga);
        RetosE.jugadorMasAltoPorEquipo(liga);
        RetosF.totalGolesPorEquipo(liga);
        
        // Retos adicionales
        System.out.println("\n=== RETOS ADICIONALES ===");
        RetosAdicionales.ejecutarTodosLosRetos(liga);
        
        System.out.println("\nPresione Enter para volver al menú principal...");
        scanner.nextLine();
    }

    private void ejecutarReto(Runnable reto) {
        limpiarPantalla();
        System.out.println("==============================================");
        System.out.println("             EJECUTANDO RETO                  ");
        System.out.println("==============================================\n");
        
        reto.run();
        
        System.out.println("\nPresione Enter para volver al menú anterior...");
        scanner.nextLine();
    }

    private void limpiarPantalla() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    @FunctionalInterface
    interface Reto {
        void ejecutar();
    }
}