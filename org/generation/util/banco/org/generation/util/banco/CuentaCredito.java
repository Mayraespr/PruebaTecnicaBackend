package org.generation.util.banco;

import java.time.LocalDate;

public class CuentaCredito extends Cuenta{
    private double limite;
    private double tasa;
    private LocalDate fechaCorte;
    private LocalDate fechaLimitePago;
    private double saldo;
	
    public CuentaCredito(double limite, double tasa, LocalDate fechaCorte, LocalDate fechaLimitePago, double saldo) {
		super();
		this.limite = limite;
		this.tasa = tasa;
		this.fechaCorte = fechaCorte;
		this.fechaLimitePago = fechaLimitePago;
		this.saldo = saldo;
	}//constructor
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public double getTasa() {
		return tasa;
	}
	public void setTasa(double tasa) {
		this.tasa = tasa;
	}
	public LocalDate getFechaCorte() {
		return fechaCorte;
	}
	public void setFechaCorte(LocalDate fechaCorte) {
		this.fechaCorte = fechaCorte;
	}
	
	public double getSaldo() {
        saldo -= 3; // Comisión
        return saldo;
    }//getSaldo

    public double retiro (double cantidad) {
        if (cantidad <= 0) {
        System.out.println("La cantidad a retirar debe ser mayor que cero.");
        return saldo;
        }//if
    
     double creditoDisponible = limite - saldo;
        if (creditoDisponible >= cantidad) {
            double comision = cantidad * 0.05; // 5% comisión
            saldo += cantidad + comision;
            System.out.println("Retiro exitoso: " + cantidad + " con comisión de: " + comision);
        } else {
            saldo += 5;
            System.out.println("Saldo insuficiente, se cobra comisión de $5.");
        }//else

        return saldo;
    } //retiro
    
    public double deposito(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a depositar debe ser mayor a cero.");
            return saldo;
        }
        saldo -= cantidad;
        System.out.println("Depósito realizado de: " + cantidad);
        return saldo;
    }//deposito
    
	public String toString() {
		return "Cuenta Crédito [" + super.toString() +
				" Tasa=" + getTasa() + "%, Límite="
				+ getLimite() + "]";
	}//toString

    
}//class