package org.generation.util.banco;

public class CuentaDebito extends Cuenta{
    private double montoMinimo;
    private double saldo;
    
	public CuentaDebito(double montoMinimo, double saldo) {
		super();
		this.montoMinimo = montoMinimo;
		this.saldo = saldo;
	}

	public double getMontoMinimo() {
		return montoMinimo;
	}//getMontoMinimo

	public void setMontoMinimo(double montoMinimo) {
		this.montoMinimo = montoMinimo;
	}//setMontoMinimo

	public double getSaldo() {
		return saldo;
	}

	public double retiro(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser mayor a $100");
            return saldo;
        }//if
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso: " + cantidad);
        } else {
            System.out.println("Saldo insuficiente");
        }//else
        return saldo;
    }//retiro
	
	public double deposito(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a depositar debe ser mayor a cero.");
            return saldo;
        }//if
        saldo += cantidad;
        System.out.println("Depósito exitoso: " + cantidad);
        return saldo;
    }//deposito
	
	public String toString() {
		return "Cuenta Débito [" + super.toString() + 
				", Monto mínimo=" + montoMinimo + "]";
	}//toString
	
}//class
