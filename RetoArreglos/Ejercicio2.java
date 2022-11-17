import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer[] arr=new Integer[20];
        String pares="Números pares: ", impares="Números impares: ";

        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int) (Math.random()*100)+1;
        }

        for (Integer item : arr) {
            if(item%2==0)
                pares+= item+", ";
            else impares+=item+", ";
        }

        System.out.print(pares.substring(1,pares.length()-2)+"\n"+impares.substring(1,impares.length()-2));
    }
}
