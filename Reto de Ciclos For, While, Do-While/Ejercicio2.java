import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        boolean continuar=true;
        Integer opcion;
        while (continuar){
            System.out.print("\nSeleccione una opción:\n1 - Agregar.\n2 - Modificar.\n3 - Aliminar.\nDigite otro número para salir.\n");
            opcion=input.nextInt();
            switch (opcion) {
                case 1: System.out.println("Usted agregó."); break;
                case 2: System.out.println("Usted modificó."); break;
                case 3: System.out.println("Usted eliminó"); break;
                default: System.out.print("¡Hasta luego!\n"); continuar=false; break;
            }
        }

    }
}
