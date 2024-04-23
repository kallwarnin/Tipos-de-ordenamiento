/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Package1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1062076461
 */
public class ordenamientoPorSeleccion {

    private static ArrayList<Atleta> atletas = new ArrayList();
    static Scanner lec = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Escribir el numero de tiempos a ingresar ");
        int input = lec.nextInt();
        for (int i = 0; i < input; i++) {
            System.out.println("Digite el tiempo del Atleta numero: " + (i + 1));
            double tiempoAtleta = lec.nextDouble();
            registrarTiempos(tiempoAtleta);

        }
        System.out.println("Listado de los tiempos");
        mostrarTiempos();

        int option = 0;
        do {
            System.out.println("1. ordenar por seleccion");
            System.out.println("2. salir");
            System.out.println("ingrese la opcion");
            option = lec.nextInt();
            switch (option) {
                case 1:
                    ordenarPorSeleccion();
                    mostrarTiempos();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("opción no valida");
                    break;
            }
        } while (option != 2);
    }

    public static void registrarTiempos(double tiempo) {
        Atleta nuevoTiempo = new Atleta(tiempo);
        atletas.add(nuevoTiempo);
    }

    public static void mostrarTiempos() {
        for (Atleta a : atletas) {
            System.out.println(a.getTiempo());
        }
    }

    public static void ordenarPorSeleccion() {
        for (int i = 0; i < atletas.size() - 1; i++) {

            Atleta menor = atletas.get(i);
            int posMenor = i;
            for (int j = i + 1; j < atletas.size(); j++) {
                Atleta actual = atletas.get(j);
                if (actual.getTiempo() < menor.getTiempo()) {
                    menor = actual;
                    posMenor = j;
                }
            }
            Atleta temp = atletas.get(i);
            atletas.set(i, menor);
            atletas.set(posMenor, temp);
        }
    }

}
