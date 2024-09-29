/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.nario;

import java.util.Scanner;

/**
 *
 * @author juand
 */
public class Nario {

   public static void main(String[] args) {
        arbolNary arbol = new arbolNary();  // Crear el árbol N-ario
        Scanner scanner = new Scanner(System.in);
 int opcion;

        do {
            System.out.println("================================");
            System.out.println("Menu:");
            System.out.println("1. Asignar raiz");
            System.out.println("2. Agregar hijo a un nodo");
            System.out.println("3. Mostrar recorrido en preorden");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el valor de la raíz: ");
                    int valorRaiz = scanner.nextInt();
                    arbol.asignarRaiz(valorRaiz);
                    System.out.println("Raíz asignada.");
                    break;
                case 2:
                    if (arbol.raiz == null) {
                        System.out.println("Primero debes asignar una raíz.");
                    } else {
                        System.out.print("Introduce el valor del nodo padre: ");
                        int valorPadre = scanner.nextInt();
                        System.out.print("Introduce el valor del nuevo hijo: ");
                        int valorHijo = scanner.nextInt();
                        arbol.agregarHijo(valorPadre, valorHijo);
                    }
                    break;
                case 3:
                    if (arbol.raiz == null) {
                        System.out.println("El árbol está vacío.");
                    } else {
                        System.out.println("Recorrido en preorden:");
                        arbol.recorridoPreorden();
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
