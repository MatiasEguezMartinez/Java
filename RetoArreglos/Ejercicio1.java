import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String mensaje="";
        Integer[] arr=new Integer[5];
        Integer num;
        for (int i=0;i<arr.length;i++) {
            System.out.print("Ingrese el valor que desea guardar para el índice " + i+" ");
            num=input.nextInt();
            mensaje+="["+i+"] = "+num+"\n";
        }
        System.out.print("\n"+mensaje);
    }
}
