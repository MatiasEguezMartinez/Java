
public class Ejercicio3 {
    public static void main(String[] args) {
        String resultado="Los números primos entre 1 y 1000 son: ";
        Boolean primo;
        for (int i = 2; i<1000; i++){
            primo=true;
            for (int n=2; n<i;n++)
                if (i%n==0) {
                    primo=false;
                    break;
                }
            if (primo) resultado+=i+", ";
        }
        System.out.print(resultado);
    }
}
