import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        String movie,dato="";

        System.out.print("Ingrese 1 para alquilar película.\nIngrese 2 para consultar películas disponibles.\nIngrese 3 para hacer una devolución.\nIngrese otro caracter para salir.\n");
        Integer opcion=input.nextInt();
        input.nextLine();


        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre de la película a alquilar. ");
                movie=input.nextLine();
                System.out.println("Película '"+movie+"' fue alquilada con éxito.");
                break;
            case 2:
                System.out.print("Las peliculas disponibles son;\n'Logan'\n'El efecto mariposa'\n'¡Shazam!'\n'Fragmentado'\n");
                break;
            case 3:
                System.out.println("Ingrese el nombre de la pelicula que desea devolver. ");
                movie=input.nextLine();
                System.out.println("¿Desea ingresar algún tipo de detalle? SI/NO ");
                if ("SI".equals(input.nextLine().trim().toUpperCase())) {
                    System.out.print("Ingrese el detalle: ");
                    dato = input.nextLine();
                    System.out.print("La película " + movie + " con el detalle '" + dato + "' fue devuelta con éxito.");
                }
                else System.out.print("La película " + movie + " fue devuelta con éxito.");
                break;
            default: System.out.print("¡Esperamos vuelva pronto!.");
        }
    }
}
