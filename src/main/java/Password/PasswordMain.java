package Password;

import java.io.IOException;
import java.util.*;

public class PasswordMain {

    public static void main(String[] args) throws IOException {

        PasswordCriteria[] criterios = {
            new ValidatePasswordLength(),
            new ValidatePasswordNumber(),
            new ValidatePasswordCapitalLetter(),
            new ValidatePasswordSpecialCharacter(),
            new ValidatePasswordDictionary()
        };

        ValidatePassword validatePassword = new ValidatePassword();
        validatePassword.addCriterios(Arrays.asList(criterios));

        // Para el menu
        Scanner sc = new Scanner(System.in);
        Boolean exit = false;
        int selec;
        String psw;

        // Empieza
        while (!exit) {
            System.out.print("\n1. Registrar contraseña\n");
            System.out.print("2. Salir\n");

            try {
                System.out.print("Opcion: ");
                selec = sc.nextInt();
                sc.nextLine(); // El nextInt() no consume el cambio de linea. Lo consumo aca sino el proximo nextLine() en case 1 no funcionaria pues agarraria este barra n que dejo el nextInt()

                switch (selec) {
                    case 1:
                        System.out.print("\tIngrese una password: ");
                        psw = sc.nextLine();
                        Boolean resultado = validatePassword.validatePassword(psw);
                        darVeredcito(resultado);
                        break;
                    case 2:
                        exit = true;
                        break;
                    default:
                        System.out.print("El numero ingresado debe ser 1 o 2\n");
                }
            } catch (InputMismatchException e) { // esto es por si ingresa algo que no tenga un int
                System.out.print("Debe ingresar un caracter numerico\n");
                sc.next(); //para evitar que entre en un bucle
            }
        }
    }

    public static void darVeredcito(Boolean resultado){
        System.out.print("\nResultado final: ");
        if(resultado){
            System.out.println("OK");
        }
        else {
            System.out.println("NOT OK");
        }
    }
}
