/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniblockchain;

/**
 *
 * @author sportak
 */
public class Criptomonedas {

    private String nombre;
    private double precioDolares;
    private boolean minable;
    private double capMerca;

    public Criptomonedas(String nombre, double precioDolares, boolean minable, double capMerca) {
        this.nombre = nombre;
        this.precioDolares = precioDolares;
        this.minable = minable;
        this.capMerca = capMerca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioDolares() {
        return precioDolares;
    }

    public void setPrecioDolares(double precioDolares) {
        this.precioDolares = precioDolares;
    }

    public boolean isMinable() {
        return minable;
    }

    public void setMinable(boolean minable) {
        this.minable = minable;
    }

    public double getCapMerca() {
        return capMerca;
    }

    public void setCapMerca(double capMerca) {
        this.capMerca = capMerca;
    }
    
}
