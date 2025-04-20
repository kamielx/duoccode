/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaduoc;

import java.util.ArrayList;
import java.util.Scanner;

public class TeatroMoro {

    static int totalIngresos = 0;
    static int totalEntradasVendidas = 0;
    static int precioEntrada = 5000;

    String ubicacion;
    int cantidadEntradas;
    boolean confirmada;
    int precioFinal;

    
    static ArrayList<TeatroMoro> reservas = new ArrayList<>();

    public TeatroMoro(String ubicacion, int cantidadEntradas) {
        this.ubicacion = ubicacion;
        this.cantidadEntradas = cantidadEntradas;
        this.confirmada = false;
        this.precioFinal = cantidadEntradas * precioEntrada;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("...:::MENÚ TEATRO MORO:::...");
            System.out.println("1. Reservar Entradas");
            System.out.println("2. Comprar Entradas");
            System.out.println("3. Modificar Reserva Existente");
            System.out.println("4. Imprimir Boletas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> reservarEntradas(scanner);
                case 2 -> comprarEntradas(scanner);
                case 3 -> modificarReserva(scanner);
                case 4 -> imprimirBoletas();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }


    public static void reservarEntradas(Scanner scanner) {
        System.out.print("Ingrese ubicación (Ej: Platea Alta, Platea Baja): ");
        String ubicacion = scanner.nextLine();

        System.out.print("Ingrese cantidad de entradas: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        TeatroMoro reserva = new TeatroMoro(ubicacion, cantidad);
        reservas.add(reserva);

        System.out.println("[DEBUG] Reserva creada: " + cantidad + " entradas en " + ubicacion);

        System.out.println("Reserva realizada correctamente.");
    }


    public static void comprarEntradas(Scanner scanner) {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas para confirmar.");
            return;
        }

        for (int i = 0; i < reservas.size(); i++) {
            TeatroMoro r = reservas.get(i);
            String estado = r.confirmada ? "Confirmada" : "Sin confirmar";
            System.out.println((i+1) + ". " + r.cantidadEntradas + " entradas en " + r.ubicacion + "[" + estado + "]");
        }

        System.out.print("Selecciona el número de reserva a confirmar: ");
        int seleccion = scanner.nextInt();
        int posicion = seleccion - 1; 

        if (posicion < 0 || posicion >= reservas.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        TeatroMoro reserva = reservas.get(posicion);
        if (reserva.confirmada) {
            System.out.println(" Ya ha sido confirmada.");
        } else {
            reserva.confirmada = true;
            totalIngresos += reserva.precioFinal;
            totalEntradasVendidas += reserva.cantidadEntradas;

        
            System.out.println("Reserva confirmada. Ingresos actualizados: $" + totalIngresos);

            System.out.println("Compra confirmada exitosamente.");
        }
    }


    public static void modificarReserva(Scanner scanner) {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas.");
            return;
        }

        System.out.print("Ingrese número de reserva a modificar: ");
        for (int i = 0; i < reservas.size(); i++) {
            TeatroMoro r = reservas.get(i);
            String estado = r.confirmada ? "confirmada" : "sin confirmar";
            System.out.println((i+1) + ". " + r.cantidadEntradas + " entradas en " + r.ubicacion + "[" + estado + "]");
        }

        int seleccion = scanner.nextLine();
        scanner.nextLine();
        int posicion = seleccion - 1;

        if (posicion < 0 || posicion >= reservas.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        TeatroMoro reserva = reservas.get(posicion);

        System.out.print("Nueva ubicación: ");
        reserva.ubicacion = scanner.nextLine();

        System.out.print("Nueva cantidad de entradas: ");
        reserva.cantidadEntradas = scanner.nextInt();
        scanner.nextLine();

        reserva.precioFinal = reserva.cantidadEntradas * precioEntrada;

        
        System.out.println("[DEBUG] Reserva modificada. Precio actualizado: $" + reserva.precioFinal);

        System.out.println(" Reserva modificada.");
    }


    public static void imprimirBoletas() {
        System.out.println("BOLETAS GENERADAS:");

        for (TeatroMoro r : reservas) {
            if (r.confirmada) {
                System.out.println("----------------------------");
                System.out.println(" Boleta de Compra");
                System.out.println("Ubicación: " + r.ubicacion);
                System.out.println("Cantidad: " + r.cantidadEntradas);
                System.out.println("Total: $" + r.precioFinal);
                System.out.println("----------------------------");

       
                System.out.println("[DEBUG] Boleta generada para " + r.cantidadEntradas + " entradas.");
            }
        }

        if (reservas.stream().noneMatch(r -> r.confirmada)) {
            System.out.println("No hay boletas disponibles. Realice una compra.");
        }
    }
}