import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
        String nombre, apellidos;
        Integer edad;
        Scanner input= new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        nombre=input.nextLine();

        System.out.print("Ingrese sus apellidos: ");
        apellidos=input.nextLine();

        System.out.print("Ingrese su edad: ");
        edad=input.nextInt();

        if (edad>=18)
            System.out.println(nombre+" "+apellidos+" usted es mayor de edad, por lo tanto, puede entrar a la fiesta.");
        else
            System.out.println(nombre+" "+apellidos+" usted es menor de edad, por lo tanto, no puede entrar a la fiesta, por favor devuélvase a su casa.");
    }
}
