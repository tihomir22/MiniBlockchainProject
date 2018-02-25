/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniblockchain;

import java.util.ArrayList;

/**
 *
 * @author sportak
 */
public class Exchange {

    private String nombre;
    private String domicilio;
    private double patrimonioNet;
    public ArrayList<Usuario> usuarios = new ArrayList();

    public Exchange(String nombre, String domicilio, double patrimonioNet) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.patrimonioNet = patrimonioNet;
        this.usuarios = null;
    }

    Exchange() {
        this.nombre = "Binance";
        this.domicilio = "Islas Caiman";
        this.patrimonioNet = 30000;

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public double getPatrimonioNet() {
        return patrimonioNet;
    }

    public void setPatrimonioNet(double patrimonioNet) {
        this.patrimonioNet = patrimonioNet;
    }

    public void mostrarExchange() {
        System.out.println("NOMBRE" + "\t" + "DOMICILIO" + "\t" + "PATRIMONIO" + "\t" + "NUM USUARIOS");
        System.out.println(this.nombre + "\t" + this.domicilio + "\t" + this.patrimonioNet + "€" + "\t" + this.usuarios.size());

    }

    public void añadirUsuario(Usuario t) {
        int i;
        boolean encontrado;

        if (!this.usuarios.isEmpty()) {
            encontrado = false;
            i = 0;
            do {

                if (t.getDni().equalsIgnoreCase(this.usuarios.get(i).getDni())) { //comproibamos que no existan dos usuarios iguales
                    System.out.println("Usted ya tiene una cuenta registrada!");
                    encontrado = true;
                }
                i++;

            } while (i < this.usuarios.size() && encontrado == false);
            if (encontrado == false) {
                System.out.println("Añadido exitosamente1");
                this.usuarios.add(t);
            }

        } else {
            System.out.println("Añadido exitosamente2");
            this.usuarios.add(t);
        }

    }

    public Usuario buscarUsuario(String dni) {
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).getDni().equalsIgnoreCase(dni)) {
                return this.usuarios.get(i);

            }

        }
        return null;
    }

   

}
