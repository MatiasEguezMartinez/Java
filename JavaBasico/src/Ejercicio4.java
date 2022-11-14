import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Ingrese un país ");
        String pais = input.next();
        System.out.print("Ingrese una ciudad capital ");
        String ciudad =input.next();

        System.out.println("La ciudad "+ciudad+" es capital del país "+pais+".");
    }
}
