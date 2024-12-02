package Interfaces;

import Models.Empleado;

public interface OperacionesServices {
    void menu();
    Empleado agregar();
    Empleado modificar();
    void eliminar();
    void listar();
}
