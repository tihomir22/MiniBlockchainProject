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
public class Wallet {

    private String clavePrivada;
    private String clavePublica;
    private int balanceDolares;
    public Usuario dueño;

    public ArrayList<Criptomonedas> monedas = new ArrayList();
    public ArrayList<Transaccion> listaTransW = new ArrayList();

    public Wallet(String clavePrivada, String clavePublica, int balanceDolares, Usuario dueño) {
        this.clavePrivada = clavePrivada;
        this.clavePublica = clavePublica;
        this.balanceDolares = balanceDolares;
        this.dueño = dueño;
    }

    Wallet() {

    }

    public ArrayList<Criptomonedas> getMonedas() {
        return monedas;
    }

    public void setMonedas(ArrayList<Criptomonedas> monedas) {
        this.monedas = monedas;
    }

    public ArrayList<Transaccion> getListaTransW() {
        return listaTransW;
    }

    public void setListaTransW(ArrayList<Transaccion> listaTransW) {
        this.listaTransW = listaTransW;
    }

    public Usuario getDueño() {
        return dueño;
    }

    public void setDueño(Usuario dueño) {
        this.dueño = dueño;
    }

    public String getClavePrivada() {
        return clavePrivada;
    }

    public void setClavePrivada(String clavePrivada) {
        this.clavePrivada = clavePrivada;
    }

    public String getClavePublica() {
        return clavePublica;
    }

    public void setClavePublica(String clavePublica) {
        this.clavePublica = clavePublica;
    }

    public int getBalanceDolares() {
        return balanceDolares;
    }

    public void setBalanceDolares(int balanceDolares) {
        this.balanceDolares = balanceDolares;
    }

    public String generarCPublica(Usuario activo) {
        String clave;
        clave = "DSSWH" + activo.getDni().substring(1, 3) + activo.getNumTel().substring(3, 6);
        return clave;

    }

    public String generarCPrivada(Usuario activo) {
        String clave;
        int numAle = (int) (Math.random() * 100);
        int numAle2 = (int) (Math.random() * 100);
        int numAle3 = (int) (Math.random() * 100);
        clave = numAle + "LOEFF" + activo.getDni().substring(1, 3) + activo.getNumTel().substring(3, 6) + numAle2 + "CP" + activo.getDni().substring(1, 3) + activo.getDni().substring(5, 7) + numAle3;
        return clave;

    }

    public void añadirCriptomoneda(Criptomonedas c) {
        this.monedas.add(c);

    }

}
