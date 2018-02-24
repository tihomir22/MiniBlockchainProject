/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniblockchain;

import java.util.Scanner;

/**
 *
 * @author sportak
 */
public class MiniBlockchain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion;
        Scanner teclado = new Scanner(System.in);
        Exchange binance = new Exchange();
        Usuario usuario1 = null;
        String nombre, dni, correo, telefono;
        double inversion;
        boolean documentacion;

        do {
            mostrarMenu();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    binance.mostrarExchange();
                    break;
                case 2:
                    //Se le permite al usuario elegir dos opciones, el usuario automatico siempre será el mismo, util para detectar repeticiones de usuarios
                    System.out.println("1 Prefiere introducir manualmente o 2 usuarios de forma automatica?");
                    opcion = teclado.nextInt();
                    //Opcion 1 para introduccion manual y opcion 2 para introduccion automatica
                    if (opcion == 1) {
                        System.out.println("Introduzca nombre del  usuario");
                        teclado.nextLine();
                        nombre = teclado.nextLine();
                        System.out.println("Introduzca dni");
                        dni = teclado.nextLine();
                        System.out.println("Introduzca correo");
                        correo = teclado.nextLine();
                        System.out.println("Introduzca telefono");
                        telefono = teclado.nextLine();
                        System.out.println("Introduzca inversion");
                        inversion = teclado.nextDouble();
                        usuario1 = new Usuario(nombre, dni, correo, false, telefono, inversion);
                        //Antes de añadir un usuario se comprueba si este existe, si existe devuelve un mensaje de error al usuario y no se añade
                        binance.añadirUsuario(usuario1);

                    }
                    if (opcion == 2) {
                        usuario1 = new Usuario("Tihomir", "X5514136R", "tihomir_alcudia3@hotmail.com", false, "603680594", 1000);
                        //Antes de añadir un usuario se comprueba si este existe, si existe devuelve un mensaje de error al usuario y no se añade
                        binance.añadirUsuario(usuario1);

                    }
                    break;

            }

        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("1.-Mostrar informacion sobre el exchange");
        System.out.println("2.-Dar de alta al usuario");

    }

}
