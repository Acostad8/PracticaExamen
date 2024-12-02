package Services;

import Interfaces.OperacionesServices;
import Models.Empleado;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmpleadoServices  {
    private Empleado empleado;
    private DomiciliarioServices domiciliarioServices;
    private CajeroServices cajeroServices;
    private Scanner sc;
    private ArrayList<Empleado> listaempleados;



    public EmpleadoServices() {
        cajeroServices = new CajeroServices();
        domiciliarioServices = new DomiciliarioServices();
        sc = new Scanner(System.in);
        listaempleados = new ArrayList<>();
    }

    public void menu(){

        int opcion = 0;
        do {
            System.out.println("-----------MENU DE OPCIONES-----------------");
            System.out.println("1. agregar Domiciliario");
            System.out.println("2. agregar Cajero");
            System.out.println("0. salir");
            System.out.println("Ingrese un opcion de menu");
            try{
                opcion = sc.nextInt();
            }catch (InputMismatchException inputMismatchException){
                sc.next();
                System.out.println("ingrese solo valores numericos");
                menu();
            }
            switch(opcion){
                case 1:
                    domiciliarioServices.menu();
                    break;
                case 2:
                    cajeroServices.menu();
                    break;
                case 0:
                    System.out.println("gracias por usar este menu");
                default:
                    System.out.println("ingrese valores validos del menu");
                    break;
            }
        }while (opcion != 0);
    }




}
