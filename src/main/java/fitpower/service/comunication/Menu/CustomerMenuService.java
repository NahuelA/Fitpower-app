package fitpower.service.comunication.Menu;

import fitpower.model.user.Customer;

import java.util.Scanner;

public class CustomerMenuService {

    Scanner scan = new Scanner(System.in);
    String opt = "";

    public void customer(Customer customer){
        System.out.println("Sistema de gestión para gimnasio - Fitpower");
        System.out.println();
        System.out.println();

        System.out.printf("Bienvenido cliente %s%n", customer.getFirstName());
        System.out.println();
        System.out.println("a -> Ver mi perfil");
        System.out.println("b -> Ver mis rutinas");
        System.out.println("c -> Ver mis planes nutricionales");
        System.out.println("d -> Registrar mi progreso físico diario");
        System.out.println("e -> Registrar mi consumo nutricional diario");

        System.out.print("-> ");
        opt = scan.next();

        switch (opt){
            case "a":
                //
                break;
            case "b":
                //
                break;
            case "c":
                //
                break;
            case "d":
                //
                break;
            case "e":
                //
                break;
            default:
                break;
        }
    }
}
