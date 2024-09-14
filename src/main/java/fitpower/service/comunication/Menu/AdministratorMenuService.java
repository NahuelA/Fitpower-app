package fitpower.service.comunication.Menu;

import fitpower.model.user.Admin;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AdministratorMenuService {

    Scanner scan = new Scanner(System.in);
    String opt = "";

    public void admin(Admin admin) {
        System.out.println("Sistema de gestión para gimnasio - Fitpower");
        System.out.println();
        System.out.println();

        System.out.println("Bienvenido administrador");
        System.out.println();
        System.out.println("a -> Gestión de clientes");
        System.out.println("b -> Gestión de entrenadores");
        System.out.println("c -> Gestión de nutricionistas");
        System.out.println("d -> Registro de profesionales");
        System.out.println("e -> Asignación de profesionales");

        System.out.print("-> ");
        opt = scan.next();

        switch (opt){
            case "a":
                customerManagement();
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

    public void customerManagement(){

        while (!opt.equals("exit")){
            System.out.println();
            System.out.println("Menu para gestión de clientes:");
            System.out.println();
            System.out.println("a -> Ver perfil de clientes");
            System.out.println("b -> Buscar cliente");
            System.out.println("c -> Remover cliente");
            System.out.println(". -> Atrás");

            System.out.print("-> ");
            opt = scan.next();

            switch (opt){
                case "a":
                    break;
                case "b":
                    //
                    break;
                case "c":
                    //
                    break;
                case ".":
                    admin(new Admin());
                    break;
                default:
                    System.out.println("Ingrese una opción válida...");
                    break;
            }
        }
    }
}
