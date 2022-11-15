import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        double num;
        do {
            System.out.print("Ingrese un número. ");
            num=input.nextDouble();
        }while(num<=500);
        System.out.println("\n¡Hasta luego!");
    }
}
