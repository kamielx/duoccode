/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ninao
 */

import java.util.Scanner;
import java.util.ArrayList;

public class teatromorolistas {

  private static ArrayList<String> asientosReservados = new ArrayList<>();
  private static ArrayList<String> asientosDisponibles = new ArrayList<>();
  private static ArrayList<String> ventas = new ArrayList<>();

  
  private static void completarasientos(){

    for (int i = 1; i < 34; i++) {

      asientosDisponibles.add("A" + i);
      asientosDisponibles.add("B" + i);
      asientosDisponibles.add("C" + i);
      asientosDisponibles.add("D" + i);
      asientosDisponibles.add("E" + i);
      asientosDisponibles.add("F" + i);
    }
  }
  
  private static void reservarAsientos(Scanner sc){

    System.out.println("..::: Reservar Asiento :::..");
    mostrardisponibilidad();
    System.out.println("Ingrese el Asiento que desea Reservar! ej A1, B5, etc.. hasta F33");
    String asiento = sc.nextLine().toUpperCase(); 

    if(asientosDisponibles.contains(asiento)){
      asientosReservados.add(asiento);
      asientosDisponibles.remove(asiento);
      System.out.println("Reserva ya realizada");

    }else{
      System.out.println("Asiento no disponible o inexistente");
    }
  }


  private static void mostrardisponibilidad(){
    System.out.println("... Asientos Disponibles ...");
    
    if(asientosDisponibles.isEmpty()){
      System.out.println("No hay asientos dispinibles");
    }else{

      for (int i = 1; i <= 33; i++) {
        String fila = "";

        for(char letra = 'A'; letra <= 'F'; letra++){
          String asiento = letra + String.valueOf(i);
          //A1, B1, C1, F33
          if(asientosDisponibles.contains(asiento)){
            if(i < 10){
            fila += "0"+asiento + " - ";
            }else{
            fila += asiento + " - ";
            }  
          }else{
            fila += "XXX - ";
          }
        }
        if(fila.endsWith(" - ")){
          fila = fila.substring(0, fila.length() - 3);
        }
        System.out.println(fila);
      }
    }
  }

   private static void pagarReserva(Scanner sc) {
    System.out.println("..::: Pagar Reserva :::..");
    System.out.print("Ingrese el asiento reservado a pagar: ");
    String asiento = sc.nextLine().toUpperCase();

    if (!asientosReservados.contains(asiento)) {
      System.out.println("No hay ninguna reserva con ese asiento.");
      return;
    }

    System.out.print("Ingrese su nombre: ");
    String nombre = sc.nextLine();

    System.out.print("¿Es estudiante? (s/n): ");
    String estudiante = sc.nextLine();

    System.out.print("Ingrese su edad: ");
    int edad = sc.nextInt();
    sc.nextLine(); // limpiar buffer

    double precioBase = 10000;
    double descuento = 0;

    if (estudiante.equalsIgnoreCase("s")) {
      descuento = 0.10;
    } else if (edad >= 60) {
      descuento = 0.15;
    }

    double precioFinal = precioBase * (1 - descuento);

    String boleta = "--- BOLETA ---" +
                    "Cliente: " + nombre + "" +
                    "Asiento: " + asiento + "" +
                    "Total pagado: $" + precioFinal + "" +
                    "";

    ventas.add(boleta);
    asientosReservados.remove(asiento);

    System.out.println("Pago realizado con éxito. Boleta generada:");
    System.out.println(boleta);
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int opcion;
    completarasientos();
    do {

      System.out.println("...:: Teatro Moro ::..");
      System.out.println("1.- Asientos Disponibles -->");
      System.out.println("2.- Reservar Asientos -->");
      System.out.println("3.- Pagar reserva -->");
      System.out.println("4.- Salir");
      System.out.println("Selecione una opcion:");
      opcion = sc.nextInt();
      sc.nextLine();

     
      switch (opcion) {

        case 1:
          mostrardisponibilidad();
          break;

        case 2:
          reservarAsientos(sc);
          break;

        case 3:
          pagarReserva(sc); 
          break;
          
        case 4:
          System.out.println("Gracias por usar el sistema Teatro Moro.");
          break;

        default:

          System.out.println("Opcion Invalida!");
      }

    } while (opcion != 4);

    sc.close();
  }
}

