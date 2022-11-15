import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el número de la tabla que desea visualizar: ");
        Integer num=input.nextInt();
        for (int i=0;i<=10;i++){
            System.out.print("\n "+num+" x " +i+" = " +i*num);
        }
    }
}
