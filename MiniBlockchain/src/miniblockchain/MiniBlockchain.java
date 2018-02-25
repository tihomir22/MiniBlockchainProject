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
        Usuario activo = null;
        Usuario destinatario = null;
        Wallet wallet1 = null;
        Wallet activoW = null;
        Criptomonedas bitcoin = null;
        Criptomonedas ethereum = null;
        Criptomonedas iota = null;
        Transaccion transaccion1 = null;
        String nombre, dni, correo, telefono;
        String clavepublica, claveprivada;
        double inversion;
        boolean documentacion;

        do {
            mostrarMenu();
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    binance.mostrarExchange();
                    mostrarBitcoin();
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
                case 3:
                    System.out.println("Introduzca dni del usuario");
                    teclado.nextLine();
                    dni = teclado.nextLine();
                    if (binance.buscarUsuario(dni) != null) {
                        System.out.println("Wallets creadas exitosamente");
                        activo = binance.buscarUsuario(dni);
                        wallet1 = new Wallet();
                        //Generacion de atributos de wallet, claves 
                        clavepublica = wallet1.generarCPublica(activo);
                        wallet1.setClavePublica(clavepublica);
                        claveprivada = wallet1.generarCPrivada(activo);
                        wallet1.setClavePrivada(claveprivada);
                        wallet1.setBalanceDolares(0);
                        //Se añaden al usuario, cada usuario puede tener mas de un wallet
                        activo.añadirWallet(wallet1);
                        activo.mostrarDatosUsuario();

                    } else {
                        System.out.println("No existe tal usuario");
                    }
                    break;

                case 4:
                    bitcoin = new Criptomonedas("Bitcoin", 10000, true, 161);
                    ethereum = new Criptomonedas("Ethereum", 860, true, 96);
                    iota = new Criptomonedas("IOTA", 2, false, 7);
                    System.out.println("Elige una moneda a comprar :");

                    break;

                case 5:
                    System.out.println("Introduzca dni del usuario destinatario"); // realmente para enviar una transaccion se deberia de introducir la Cpublica, pero seria muy engorroso...
                    teclado.nextLine();
                    dni = teclado.nextLine();
                    destinatario = binance.buscarUsuario(dni);
                    if (binance.buscarUsuario(dni) == activo) {
                        System.out.println("No puedes enviarte a ti mismo");
                        break;
                    }
                    if (destinatario == null) {
                        System.out.println("No existe el usuario destino");
                        break;
                    }

                    System.out.println("Desde que wallet quieres enviar fondos? ");
                    activo.mostrarWalletsUsuario();
                    clavepublica = teclado.nextLine();

                    //El usuario elige uno de sus muchos wallets para pagar la transaccion...
                    if (activo.buscarWallet(clavepublica) != null) {
                        activoW = activo.buscarWallet(clavepublica);
                        //Ya tenemos el usuario emisor y su wallet
                        if (binance.buscarUsuario(dni) != null && binance.buscarUsuario(dni) != activo) {
                            transaccion1 = new Transaccion();
                            transaccion1.setEmisor(activoW);
                            if (destinatario.wallets.size() >= 0) {
                                transaccion1.setDestinatario(destinatario.wallets.get(0));
                            } else {
                                System.out.println("El destino no tiene clave generada");
                            }
                        }
                        if (binance.buscarUsuario(dni) == activo) {
                            System.out.println("No puedes enviarte a ti mismo");
                        }
                        if (binance.buscarUsuario(dni) == null) {
                            System.out.println("No existe el usuario");
                        }
                    } else {
                        System.out.println("No existe ese wallet por lo que no se puede realizar la transaccion");
                    }

                    break;

            }

        } while (opcion != 0);
    }

    public static void mostrarMenu() {

        System.out.println("1.-Mostrar informacion sobre el exchange");
        System.out.println("2.-Dar de alta al usuario");
        System.out.println("3.-Seleccionar usuario y generar clave publica y privada de su wallet");
        System.out.println("4.-Recargar criptomonedas en cartera");
        System.out.println("5.-Enviar 1 BTC a la cartera de otro usuario");
        System.out.println("");
        System.out.println("****************************************************");
        System.out.println("Aclaracion, para crear las claves de la wallet se usan los strings de las variables del usuario junto a funciones de la Clase Math Random,  se deben introducir datos correctos para que se generen correctamente las claves");
        System.out.println("Los usuarios deben ser declarados y con sus claves generadas para realizar transacciones");

    }

    public static void mostrarBitcoin() {
        System.out.println(" .----------------.  .----------------.  .-----------------. .----------------.  .-----------------. .----------------.  .----------------. \n"
                + "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n"
                + "| |   ______     | || |     _____    | || | ____  _____  | || |      __      | || | ____  _____  | || |     ______   | || |  _________   | |\n"
                + "| |  |_   _ \\    | || |    |_   _|   | || ||_   \\|_   _| | || |     /  \\     | || ||_   \\|_   _| | || |   .' ___  |  | || | |_   ___  |  | |\n"
                + "| |    | |_) |   | || |      | |     | || |  |   \\ | |   | || |    / /\\ \\    | || |  |   \\ | |   | || |  / .'   \\_|  | || |   | |_  \\_|  | |\n"
                + "| |    |  __'.   | || |      | |     | || |  | |\\ \\| |   | || |   / ____ \\   | || |  | |\\ \\| |   | || |  | |         | || |   |  _|  _   | |\n"
                + "| |   _| |__) |  | || |     _| |_    | || | _| |_\\   |_  | || | _/ /    \\ \\_ | || | _| |_\\   |_  | || |  \\ `.___.'\\  | || |  _| |___/ |  | |\n"
                + "| |  |_______/   | || |    |_____|   | || ||_____|\\____| | || ||____|  |____|| || ||_____|\\____| | || |   `._____.'  | || | |_________|  | |\n"
                + "| |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n"
                + "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n"
                + " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' ");
    }

}
