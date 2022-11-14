import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Ingrese el nombre de su mascota: ");
        String namePet=input.nextLine();

        System.out.print("Ingrese la edad de su mascota: ");
        Integer agePet=input.nextInt();
        input.nextLine();

        System.out.print("Ingrese el tipo de mascota: ");
        String typePet= input.nextLine();

        System.out.print("Ingrese su nombre completo: ");
        String name= input.nextLine();

        System.out.println(namePet+" es un(a) " + typePet + ", el cual, tiene " + agePet + " años de edad y " +name + " es actualmente su dueño(a).");
    }
}
