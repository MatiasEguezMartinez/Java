import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);/*Objeto de la clase Scanner*/
        System.out.print("Digite su nombre: ");
        String nombre = input.next();
        System.out.print("Digite su apellido: ");
        String apellido = input.next();
        System.out.print("Escriba el nombre de su padre ");
        String nombrePadre = input.next();
        System.out.print("Escriba su apellido de su padre ");
        String apellidoPadre = input.next();
        System.out.print("Escriba el nombre de su madre ");
        String nombreMadre = input.next();
        System.out.print("Escriba su apellido de su madre ");
        String apellidoMadre = input.next();
        System.out.print("Yo "+nombre +" "+ apellido+ ", soy hijo de "+nombreMadre+" "+apellidoMadre +" y "+nombrePadre+" "+apellidoPadre+".");
    }
}
