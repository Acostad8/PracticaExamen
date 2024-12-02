package Models;

import Interfaces.PagoEmpleado;

public abstract class Empleado implements PagoEmpleado {
    private String documento;
    private String direccion;
    private String nombre;
    private String telefono;
    private double sueldo;


    public Empleado() {
    }

    public Empleado(String documento, String direccion, String nombre, String telefono, double sueldo) {
        this.documento = documento;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.sueldo = sueldo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "documento='" + documento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", sueldo='" + sueldo + '\'' +
                '}';
    }
}
