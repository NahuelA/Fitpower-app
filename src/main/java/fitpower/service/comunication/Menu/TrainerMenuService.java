package fitpower.service.comunication.Menu;

import fitpower.model.user.Trainer;

import java.util.Scanner;

public class TrainerMenuService {

    Scanner scan = new Scanner(System.in);

    public void trainer(Trainer trainer){

        System.out.println("Sistema de gestión para gimnasio - Fitpower");
        System.out.println();
        System.out.println();

        System.out.printf("Bienvenido entrenador %s%n", trainer);
        System.out.println();
        System.out.println("a -> Ver perfil de mis clientes");
        System.out.println("b -> Generar informe");
        System.out.println("c -> Ver mi perfil");

        String opt = scan.next();

        switch (opt){
            case "a":
//                customer();
                break;
            case "b":
                // Generar informe
                break;
            default:
                break;
        }
    }
}
