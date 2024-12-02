package Models;

public class Cajero extends Empleado{


    private double sueldoMensual;
    private int numeroCaja;
    private double ventaMensual;

    public Cajero() {
    }

    public Cajero(double sueldoMensual, int numeroCaja, double ventaMensual) {
        this.sueldoMensual = sueldoMensual;
        this.numeroCaja = numeroCaja;
        this.ventaMensual = ventaMensual;
    }

    public Cajero(String documento, String direccion, String nombre, String telefono, double sueldo, double sueldoMensual, int numeroCaja, double ventaMensual) {
        super(documento, direccion, nombre, telefono, sueldo);
        this.sueldoMensual = sueldoMensual;
        this.numeroCaja = numeroCaja;
        this.ventaMensual = ventaMensual;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }

    public double getVentaMensual() {
        return ventaMensual;
    }

    public void setVentaMensual(double ventaMensual) {
        this.ventaMensual = ventaMensual;
    }

    @Override
    public String toString() {
        return "Cajero{" +
                "documento='" + getDocumento() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", sueldo='" + getSueldo()  + '\'' +
                "sueldoMensual=" + sueldoMensual +
                ", numeroCaja=" + numeroCaja +
                ", ventaMensual=" + ventaMensual +
                '}';
    }

    @Override
    public void calcularSueldo() {
        setSueldo(sueldoMensual);
    }
}
