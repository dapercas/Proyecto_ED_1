/** 
* Clase que calcula el factorial de un número. 
* @author José Javier Pérez Lorente 
* @version 2017 
*/

public class Factorial {
    
	/** 
	Prueba
	 * Calcula el factorial de n. 
	 * N! = N * (n-1) * (n-2) * (n-3) * ... * 1 
	 * @param n es el número al que se calculará el factorial. 
	 * @return n! es el resultado del factorial de n 
	 */
	
	private static double compruebaNumero(double numero) {
		if (numero==0) {
			return 1;
		} else {
			double resultat = numero * factorial(numero-1);
			return resultat;
		}
	}

	public static double factorial (double numero) {     
		return compruebaNumero(numero);
	}		
     
	public static void main(String[] args) {
     
		System.out.println(factorial(5));
     
	}
     
}
