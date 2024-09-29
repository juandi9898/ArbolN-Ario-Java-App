/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.nario;

/**
 *
 * @author juand
 */
public class arbolNary {
Nodo raiz;  // Raíz del árbol

    // Constructor que inicializa el árbol con la raíz nula
    public arbolNary() {
        raiz = null;
    }

    // Método para asignar la raíz del árbol
    public void asignarRaiz(int valor) {
        raiz = new Nodo(valor);  // Crea un nodo raíz con el valor dado
    }
    
     // Método para agregar un hijo a un nodo existente
    public Nodo buscarNodo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }
        if (nodo.valor == valor) {
            return nodo;
        }
        for (Nodo hijo : nodo.hijos) {
            Nodo encontrado = buscarNodo(hijo, valor);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }
    
        public void agregarHijo(int padreValor, int hijoValor) {
        Nodo padre = buscarNodo(raiz, padreValor);
        if (padre != null) {
            padre.agregarHijo(new Nodo(hijoValor));
        } else {
            System.out.println("Nodo padre no encontrado.");
        }
    }

    // Método para recorrer el árbol en preorden
    public void recorridoPreorden() {
        recorridoPreordenRecursivo(raiz);  // Llama al método recursivo, empezando por la raíz
    }

    // Método recursivo para el recorrido en preorden
    private void recorridoPreordenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        // Imprime el valor del nodo actual
        System.out.print(nodo.valor + " ");

        // Recorre todos los hijos del nodo actual
        for (Nodo hijo : nodo.hijos) {
            recorridoPreordenRecursivo(hijo);  // Llama recursivamente para cada hijo
        }
    }


    
    
    
    
}
