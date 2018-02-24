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
public class Usuario {

    private String nombre;
    private String dni;
    private String correo;
    private boolean documentacion;
    private String numTel;
    private double inversion;
    private ArrayList<Transaccion> listaTransU = new ArrayList();

    public Usuario(String nombre, String dni, String correo, boolean documentacion, String numTel, double inversion) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.documentacion = documentacion;
        this.numTel = numTel;
        this.inversion = inversion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(boolean documentacion) {
        this.documentacion = documentacion;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public double getInversion() {
        return inversion;
    }

    public void setInversion(double inversion) {
        this.inversion = inversion;
    }

    public ArrayList<Transaccion> getListaTransU() {
        return listaTransU;
    }

    public void setListaTransU(ArrayList<Transaccion> listaTransU) {
        this.listaTransU = listaTransU;
    }

}
