package Services;

import Interfaces.OperacionesServices;
import Models.Cajero;
import Models.Empleado;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroServices implements OperacionesServices {

    private Empleado empleado;
    private Scanner sc;
    private Cajero cajero;
    private ArrayList<Empleado> listaEmpleados;

    public CajeroServices(){
        cajero = new Cajero();
        sc = new Scanner(System.in);
        listaEmpleados = new ArrayList<>();
    }

    @Override
    public void menu() {

        int opcion = -1;

        do {
            System.out.println("----------MENU CAJERO--------------");
            System.out.println("1.  Agregar Cajero");
            System.out.println("2. Modificar Cajero");
            System.out.println("3. Eliminar Cajero");
            System.out.println("4. Listar Cajero");
            System.out.println("0. Salir");

            System.out.println("ingrese una opcion del menu");
            try{
                opcion = sc.nextInt();

            }catch (InputMismatchException inputMismatchException){
                sc.next();
                System.out.println("ingrese solo valores numericos");
            }

            switch(opcion){
                case 1:
                    agregar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    listar();
                    break;
                case 0:
                    System.out.println("gracias por usar este Menu");
                default:
                    System.out.println("ingrese solo valores validos del menu");
            }

        }while (opcion != 0);

    }

    @Override
    public Empleado agregar() {
        System.out.println("ingrese el documento del Cajero");
        String documento = sc.next();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getDocumento().equals(documento)){
                System.out.println("el documento ya existe en la lista");
                System.out.println("Porfavor ingrese otro documento");
                agregar();
            }
        }

        System.out.println("ingrese la direccion del Cajero");
        String direccion = sc.next();

        System.out.println("ingrese el nombre del Cajero");
        String nombre = sc.next();

        System.out.println("ingrese el telefono del Cajero");
        String telefono = sc.next();

        double sueldoMensual = 0;
        int numeroCaja = 0;
        double ventaMensual = 0;

        try{
            System.out.println("ingrese el sueldo Mensual de Cajero");
            sueldoMensual = sc.nextDouble();

            System.out.println("ingrese el numero del Cajero");
            numeroCaja = sc.nextInt();

            System.out.println("ingrese la venta mensual del Cajero");
            ventaMensual = sc.nextDouble();


        }catch (InputMismatchException inputMismatchException){
            sc.next();
            System.out.println("ingrese solo valores numericos");

        }

        cajero = new Cajero(documento,direccion ,nombre,telefono, cajero.getSueldo(),sueldoMensual,numeroCaja,ventaMensual);
        listaEmpleados.add(cajero);
        return cajero;
    }

    @Override
    public Empleado modificar() {
        if (listaEmpleados.isEmpty()){
            System.out.println("no existen cajero para modificar");
        }

        System.out.println("-------MODIFICAR CAJERO---------------");
        System.out.println("ingrese el documento del cajero que desea Modificar");
        String Documento = sc.next();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getDocumento().equals(Documento)) {
                System.out.println("--------AGREGAR CAJERO MODIFICADO----------------");
                System.out.println("se encontro el cajero a modificar:  " + empleado);

                System.out.println("ingrese el nuevo documento del cajero");
                String documento = sc.next();
                cajero.setDocumento(documento);


                System.out.println("ingrese la nueva direccion del Cajero");
                String direccion = sc.next();
                cajero.setDireccion(direccion);

                System.out.println("ingrese el nuevo nombre del Cajero");
                String nombre = sc.next();
                cajero.setNombre(nombre);

                System.out.println("ingrese el nuevo telefono del Cajero");
                String telefono = sc.next();
                cajero.setTelefono(telefono);

                double sueldoMensual = 0;
                int numeroCaja = 0;
                double ventaMensual = 0;

                try{
                    System.out.println("ingrese el sueldo Mensual de Cajero");
                    sueldoMensual = sc.nextDouble();
                    cajero.setSueldo(sueldoMensual);

                    System.out.println("ingrese el numero del Cajero");
                    numeroCaja = sc.nextInt();
                    cajero.setNumeroCaja(numeroCaja);

                    System.out.println("ingrese la venta mensual del Cajero");
                    ventaMensual = sc.nextDouble();
                    cajero.setVentaMensual(ventaMensual);


                }catch (InputMismatchException inputMismatchException){
                    sc.next();
                    System.out.println("ingrese solo valores numericos");

                }


                System.out.println("el cajero se ha modificado correctamente");
                System.out.println(cajero);
                return cajero;


            }

        }
        System.out.println("no se ha encontrado el documento a modificar");
        return null;
    }

    @Override
    public void eliminar() {
        if (listaEmpleados.isEmpty()){
            System.out.println("no existen cajeros para eliminar");
        }

        System.out.println("-------ELIMINAR CAJERO--------------");
        System.out.println("ingrese el documento del cajero que desea eliminar");
        String Documento = sc.next();

        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getDocumento().equals(Documento)) {
                System.out.println("se encontro el cajero a eliminar: " + listaEmpleados.get(i));
                listaEmpleados.remove(i);
                System.out.println("se elimino correcramnete el cajero");
                return;
            }
        }
        System.out.println("no se encontro el cajero a eliminar");


    }

    @Override
    public void listar() {
        int indice = 0;
        if (listaEmpleados.isEmpty()){
            System.out.println("no existen cajero para modificar");
        }
        System.out.println("-----------LISTA DE CAJERO--------------");
        for (Empleado empleado : listaEmpleados) {
            indice++;
            System.out.println(indice + ". " + empleado);
        }
    }
}
