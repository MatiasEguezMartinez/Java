import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite su nombre: ");
        String nombre = input.next();
        input.nextLine();
        System.out.print("Digite su apellido: ");
        String apellido = input.nextLine();
        System.out.print("Escriba su edad ");
        Integer edad = input.nextInt();
        System.out.print("Escriba su estatura ");
        Float estatura = input.nextFloat();
    }
}
