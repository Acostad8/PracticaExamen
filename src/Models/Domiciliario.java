package Models;

public class Domiciliario  extends Empleado{
    private int cantidadDomicilio;
    private double valorDomicilio;
    private String placaVehiculo;


    public Domiciliario() {
    }

    public Domiciliario(int cantidadDomicilio, double valorDomicilio, String placaVehiculo) {
        this.cantidadDomicilio = cantidadDomicilio;
        this.valorDomicilio = valorDomicilio;
        this.placaVehiculo = placaVehiculo;
    }

    public Domiciliario(String documento, String direccion, String nombre, String telefono, double sueldo, int cantidadDomicilio, double valorDomicilio, String placaVehiculo) {
        super(documento, direccion, nombre, telefono, sueldo);
        this.cantidadDomicilio = cantidadDomicilio;
        this.valorDomicilio = valorDomicilio;
        this.placaVehiculo = placaVehiculo;
    }


    public int getCantidadDomicilio() {
        return cantidadDomicilio;
    }

    public void setCantidadDomicilio(int cantidadDomicilio) {
        this.cantidadDomicilio = cantidadDomicilio;
    }

    public double getValorDomicilio() {
        return valorDomicilio;
    }

    public void setValorDomicilio(double valorDomicilio) {
        this.valorDomicilio = valorDomicilio;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    @Override
    public String toString() {
        return "Domiciliario{" +
                "documento='" + getDocumento() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", sueldo='" + getSueldo() + '\'' +
                "cantidadDomicilio=" + cantidadDomicilio +
                ", valorDomicilio=" + valorDomicilio +
                ", placaVehiculo='" + placaVehiculo + '\'' +
                '}';
    }

    @Override
    public void calcularSueldo() {
        setSueldo(cantidadDomicilio * valorDomicilio);

    }
}
