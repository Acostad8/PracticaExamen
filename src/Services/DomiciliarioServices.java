package Services;

import Interfaces.OperacionesServices;
import Models.Domiciliario;
import Models.Empleado;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DomiciliarioServices implements OperacionesServices {

    private  Empleado empleado;
    private Scanner sc;
    private Domiciliario domiciliario;
    private ArrayList<Empleado> listaEmpleado;

    public DomiciliarioServices(){
        sc = new Scanner(System.in);
        domiciliario = new Domiciliario();
        listaEmpleado = new ArrayList<>();
    }


    @Override
    public void menu() {

        int opcion = -1;

        do {

            System.out.println("------------MENU DOMICILIARIO---------------");
            System.out.println("1. agregar domiciliario");
            System.out.println("2. modificar domiciliario");
            System.out.println("3. eliminar domiciliario");
            System.out.println("4. listar domiciliario");
            System.out.println("0. salir");

            System.out.println("ingrese una opcion del menu");

            try{
                opcion = sc.nextInt();

            }catch (InputMismatchException inputMismatchException){
                sc.next();
                System.out.println("ingrese solo valores numericos");
            }


            switch (opcion){
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
                    System.out.println("gracias por usar este menu");
                    break;
                default:
                    System.out.println("ingrese valores validos del menu");
                    break;
            }
        }while(opcion != 0);
    }

    @Override
    public Empleado agregar() {
        System.out.println("--------------AGREGAR DOMICILIARIO-------------");
        System.out.println("ingrese direccion del domiciliario");
        String direccion = sc.next();

        System.out.println("ingrese documento del domiciliario");
        String documento = sc.next();
        for (Empleado empleado : listaEmpleado) {
            if (empleado.getDocumento().equals(documento)){
                System.out.println("el documento ya existe en la lista");
                System.out.println("porfavor un ingrese un nuevo documento");
                agregar();

            }

        }


        System.out.println("ingrese el nombre del domiciliario");
        String nombre = sc.next();

        System.out.println("ingrese el telefono del domiciliario");
        String telefono = sc.next();

        int cantidadDomicilios = 0;
        double valorDomicilio = 0;

        try {
            System.out.println("ingrese la cantidad de domicilios");
            cantidadDomicilios = sc.nextInt();

            System.out.println("ingrese el valor del domicilio");
            valorDomicilio = sc.nextDouble();

        }catch (InputMismatchException inputMismatchException){
            sc.next();
            System.out.println("ingrese valores numericos");
            agregar();
        }
        System.out.println("ingrese la placa del vehiculo");
        String placaVehiculo = sc.next();

        domiciliario = new Domiciliario(documento,direccion,nombre,telefono,domiciliario.getSueldo(),cantidadDomicilios,valorDomicilio,placaVehiculo);
        listaEmpleado.add(domiciliario);
        return domiciliario;
    }

    @Override
    public Empleado modificar() {
        if (listaEmpleado.isEmpty()){
            System.out.println("no hay domiciliarios para modificar");
            menu();
        }

        System.out.println("------------------MODIFICAR DOMICILIARIO--------------------------");
        System.out.println("ingrese el documento del domiciliario que desea modificar");
        String Documento = sc.next();

        for (Empleado empleado : listaEmpleado){
            if(empleado.getDocumento().equals(Documento)){
                System.out.println("ingrese nuevo documento del domiciliario");
                String documento = sc.next();
                domiciliario.setDocumento(documento);

                System.out.println("ingrese el nuevo nombre del domiciliario");
                String nombre = sc.next();
                domiciliario.setNombre(nombre);

                System.out.println("ingrese el nuevo telefono del domiciliario");
                String telefono = sc.next();
                domiciliario.setTelefono(telefono);

                int cantidadDomicilios = 0;
                double valorDomicilio = 0;

                try {
                    System.out.println("ingrese la nueva cantidad de domicilios");
                    cantidadDomicilios = sc.nextInt();
                    domiciliario.setCantidadDomicilio(cantidadDomicilios);

                    System.out.println("ingrese el nuevo valor del domicilio");
                    valorDomicilio = sc.nextDouble();
                    domiciliario.setValorDomicilio(valorDomicilio);

                }catch (InputMismatchException inputMismatchException){
                    sc.next();
                    System.out.println("ingrese valores numericos");
                    agregar();
                }
                System.out.println("ingrese la placa del vehiculo");
                String placaVehiculo = sc.next();
                domiciliario.setPlacaVehiculo(placaVehiculo);

                System.out.println("se ha modificado correctamente el domiciliario");
                System.out.println(domiciliario);

                return domiciliario;
            }
        }
        System.out.println("no se encontro el documento del usuario a modificar");
        return null;
    }

    @Override
    public void eliminar() {
        if (listaEmpleado.isEmpty()) {
            System.out.println("no hay domiciliarios para modificar");
            return;
        }

        System.out.println("---------------ELIMINAR DOMICILIARIO--------------------");
        System.out.println("ingrese el documento del domiciliario que desea eliminar");
        String Documento = sc.next();

        for (int i = 0; i < listaEmpleado.size(); i++) {
            if (listaEmpleado.get(i).getDocumento().equals(Documento)){
                System.out.println("se ha encontrado el domiciliario a eliminar" + listaEmpleado.get(i));
                listaEmpleado.remove(i);
                System.out.println("se ha eliminado correctamente el domiciliario");
                return;
            }
        }
        System.out.println("no se encontro el domiciliario a eliminar");
    }

    @Override
    public void listar() {

        if (listaEmpleado.isEmpty()){
            System.out.println("no existen domiciliarios para mostrar");
            return;
        }

        System.out.println("------------LISTA DE DOMICILIARIOS------------------");
        for (int i = 0; i < listaEmpleado.size(); i++) {
            System.out.println(i + "." + listaEmpleado.get(i));
        }
    }
}
