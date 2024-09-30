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
        int totalNodosPermitidos = 0; // Número de nodos permitidos
        int nodosIngresados = 0;      // Contador de nodos ingresados

        // Preguntar cuántos nodos desea ingresar
        System.out.print("¿Cuántos nodos deseas ingresar?: ");
        totalNodosPermitidos = scanner.nextInt();

        do {
            System.out.println("================================");
            System.out.println("Opciones disponibles:");
            System.out.println("[1] Definir la raíz");
            System.out.println("[2] Añadir un hijo a un nodo existente");
            System.out.println("[3] Mostrar el árbol en preorden");
            System.out.println("[4] Terminar el programa");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (nodosIngresados < totalNodosPermitidos) {
                        System.out.print("Escribe el valor para la raíz: ");
                        int valorRaiz = scanner.nextInt();
                        arbol.asignarRaiz(valorRaiz);
                        nodosIngresados++; // Incrementar el contador de nodos
                        System.out.println("Raíz definida correctamente.");
                    } else {
                        System.out.println("No puedes agregar más nodos. Se alcanzó el límite permitido.");
                    }
                    break;
                case 2:
                    if (nodosIngresados < totalNodosPermitidos) {
                        if (arbol.raiz == null) {
                            System.out.println("Por favor, define primero la raíz del árbol.");
                        } else {
                            System.out.print("Escribe el valor del nodo padre: ");
                            int valorPadre = scanner.nextInt();
                            // Verificar si el nodo padre existe
                            Nodo padre = arbol.buscarNodo(arbol.raiz, valorPadre);
                            if (padre != null) {
                                System.out.print("Escribe el valor del nuevo hijo: ");
                                int valorHijo = scanner.nextInt();
                                arbol.agregarHijo(valorPadre, valorHijo);
                                nodosIngresados++; // Incrementar el contador de nodos
                            } else {
                                System.out.println("El nodo padre con valor " + valorPadre + " no existe.");
                            }
                        }
                    } else {
                        System.out.println("No puedes agregar más nodos. Se alcanzó el límite permitido.");
                    }
                    break;
                case 3:
                    if (arbol.raiz == null) {
                        System.out.println("El árbol no tiene nodos definidos.");
                    } else {
                        System.out.println("Recorrido preorden del árbol:");
                        arbol.recorridoPreorden();
                    }
                    break;
                case 4:
                    System.out.println("Cerrando la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no reconocida, por favor intenta de nuevo.");
            }

            // Comprobar si ya se han ingresado todos los nodos permitidos
            if (nodosIngresados >= totalNodosPermitidos) {
                System.out.println("-------------------------------------------");
                System.out.println("Has ingresado todos los nodos permitidos.");
                System.out.println("-------------------------------------------");
                System.out.println("No se permiten más nodos. Terminando la ejecución...");
                System.out.println("-------------------------------------------");
                System.out.println("Recorrido en Preorder");
                arbol.recorridoPreorden();  // Mostrar el árbol en preorden
                System.out.println("");
                break; // Salir del ciclo y finalizar el programa
            }
        } while (opcion != 4);

        scanner.close();
    }
}
