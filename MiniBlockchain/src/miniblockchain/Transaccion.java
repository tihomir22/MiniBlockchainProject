/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniblockchain;

import java.util.Calendar;

/**
 *
 * @author sportak
 */
public class Transaccion {

    private Calendar fecha;
    private double importeDolar;
    public Wallet destinatario;
    public Wallet emisor;

    public Transaccion(Calendar fecha, double importeDolar, Wallet destinatario, Wallet emisor) {
        this.fecha = fecha;
        this.importeDolar = importeDolar;
        this.destinatario = destinatario;
        this.emisor = emisor;
    }

    public Transaccion() {

    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public double getImporteDolar() {
        return importeDolar;
    }

    public void setImporteDolar(double importeDolar) {
        this.importeDolar = importeDolar;
    }

    public Wallet getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Wallet destinatario) {
        this.destinatario = destinatario;
    }

    public Wallet getEmisor() {
        return emisor;
    }

    public void setEmisor(Wallet emisor) {
        this.emisor = emisor;
    }

}
