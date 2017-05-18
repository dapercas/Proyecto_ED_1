public class Primos {
	public static void main(String[] args) {

        
 
        for (int i = 1; i <= 100000; i++) {
        	
        	boolean esPrimo = true;
        	
            for (int j = 2; j < i && esPrimo && j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    esPrimo = false;
                }
            }
 
            if (esPrimo) {
                System.out.println(i);
            }
        }
        System.out.println("terminado");
    }
}
