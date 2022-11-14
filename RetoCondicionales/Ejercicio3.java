import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String producto;

        System.out.print("\nDroguería Mi Salud\n");

        System.out.print("Ingrese 1 para comprar.\nIngrese 2 para consultar precios.\nIngrese 3 para hacer una devolución.\nIngrese otro caracter para salir.\n");
        Integer opcion=input.nextInt();
        input.nextLine();

        switch (opcion){
            case 1:
                System.out.print("Ingrese el número de producto que desea.");
                System.out.print("\n1 - Alcohol en gel.\n2 - Jabón liquido.\n3 - Agua desionizada.\n");
                opcion=input.nextInt();
                if (1==opcion)
                    System.out.println("Usted compró Alcohol en gel.");
                else if (2==opcion)
                    System.out.println("Usted compró Jabón liquido");
                else if (3==opcion) System.out.println("Usted compró Agua desionizada");
                else System.out.println("Opción incorrecta.");
                break;
            case 2:
                System.out.println("Los precios son; \n$100 - Alcohol en gel.\n$50 - Jabón liquido.\n$500 - Agua desionizada.\n");
                break;
            case  3:
                System.out.print("Ingrese el nombre del producto que desea devolver. ");
                producto=input.nextLine();
                System.out.println("El producto " + producto + " fue devuelta con éxito.");
                break;
            default: System.out.println("¡Esperamos vuelva pronto!.");
        }
    }
}