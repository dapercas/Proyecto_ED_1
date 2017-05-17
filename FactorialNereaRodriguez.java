/**
* Clase que calcula el factorial de un número.
* @author IES Juan de Garay
* @version 2017
*/
public class Factorial {

	/**
	* Calcula el factorial de n.
	* n! = n * (n-1) * (n-2) * (n-3) * ... * 1
	* Está implementado mediante una función recursiva.
	* @param n es el número para el que se calcula el factorial.
	* @return n! es el resultat del factorial de n.
	*/ 	
	public static double factorial (double numero) {
     
		if (numero==0) return 1;
    		else
    			{
    				double resultat = numero * factorial(numero-1);
    				return resultat;
    		}
    	}	
     
	public static void main(String[] args) {
	
		double n;
    		
		if (args.length > 1) { // si hay más de 1 parámetro
    			System.out.println("Demasiados parámetros. Proporcione un valor entero");
    		} else if (args.length == 0) { // si no hay parámetros      
    			System.out.println("Falta un valor entero");
    		} else {
    			n = Double.parseDouble(args[0]);
    			System.out.println("El factorial del número es: " + factorial(n));
    		}
    	}
}
