import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

//Programa de Calculadoras. Añado línea para comprobar Git.
public class Calculadoras {
	private static Text resultado;
	
	// Constantes 
	final int MAX_DIGITOS = 5;
	
	// Variables
	String operacion;
	int valor1;
	int valor2;
	boolean inicializar_resultado;

	void inicializar_variables() {
		operacion = "null"; 
		valor1 = 0; 
		valor2 = 0; 
		inicializar_resultado = true; 
		}
	
	void anadirOtroDigito(int digit){
		
		if (inicializar_resultado) ponerValorResultadoString("");
		
		String cadena = obtenerValorResultadoString(); 
		
		if (cadena.indexOf("0") == 0){ 
			cadena = cadena.substring(1);
			} 
		
		if ((!cadena.equals("0") || digit > 0) && cadena.length() < MAX_DIGITOS) {
			// Concatenamos lo anterior con lo nuevo
			ponerValorResultadoString(cadena + digit); 
			} 
		
		// Inicializo la caja a false porque ahora, si añaden dígitos, se deben añadir a lo ya introducido.
		inicializar_resultado = false;
	}
		
	
	int obtenerValorResultadoInteger() { 
		String cadena = resultado.getText(); 
		return Integer.parseInt(cadena); 
	}
	
	void ponerValorResultadoString(String s) { 
		resultado.setText(s); 
	}
	
	String obtenerValorResultadoString () { 
		return resultado.getText(); 
	}
	
	
	void ejecutarOperador(String nueva_operacion) {
		int solucion; 		
		if (operacion.equals("null")) { 
			// Para cuando acabamos de iniciar la calculadora o venimos del =
			valor1 = obtenerValorResultadoInteger(); 
			} 
		else { 
			// Para cuando tenemos una operación a medias y continuamos con otra
			valor2 = obtenerValorResultadoInteger();
			solucion = ejecutarOperacion();
			mostrarResultado(solucion);
			} 		
		// Para el caso en que empecemos a escribir un nuevo operando
		inicializar_resultado = true;
		
		operacion = nueva_operacion;
	}
	

	void ejecutarIgual() { 
		int resultado = 0; 
		
		// Cuando hacemos clic en igual, valor1 debiera tener valor
		valor2 = obtenerValorResultadoInteger();
			
		resultado = ejecutarOperacion();
			
		mostrarResultado(resultado);
			
		// Volvemos a inicializar operacion porque no hay operaciones pendientes
		operacion = "null"; 
	} 
	
	void mostrarResultado(int solucion) { 
		
		ponerValorResultadoString(Integer.toString(solucion)); 
		
		//Inicializo valor1 con el nuevo valor para futuras operaciones
		valor1 = solucion;
			
		// Inicializo el resultado a true de manera que si escriben dígitos, primero vaciemos el resultado
		inicializar_resultado = true; 
	}
	
	int ejecutarOperacion() {
		int solucion = 0; 
			
		if (operacion.equals("/")) { 
			if (valor2 == 0) { 
				} 
			else solucion = valor1 / valor2; 
			} 
			
		if (operacion.equals("*")) solucion = valor1 * valor2; 
			
		if (operacion.equals("-")) solucion = valor1 - valor2; 
			
		if (operacion.equals("+")) solucion = valor1 + valor2; 
			
		return solucion;
	}
	
	public Calculadoras() { 
		inicializar_variables(); 
		generaCalculadora(); 
	}

	void generaCalculadora(){
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btn1 = new Button(shell, SWT.NONE);
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(1);
			}
		});
		btn1.setBounds(10, 53, 62, 45);
		btn1.setText("1");
		
		Button btn2 = new Button(shell, SWT.NONE);
		btn2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(2);
			}
		});
		btn2.setBounds(91, 53, 62, 45);
		btn2.setText("2");
		
		Button btn3 = new Button(shell, SWT.NONE);
		btn3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(3);
			}
		});
		btn3.setBounds(172, 53, 62, 45);
		btn3.setText("3");
		
		Button btn4 = new Button(shell, SWT.NONE);
		btn4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(4);
			}
		});
		btn4.setBounds(10, 104, 62, 45);
		btn4.setText("4");
		
		Button btn5 = new Button(shell, SWT.NONE);
		btn5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(5);
			}
		});
		btn5.setBounds(91, 104, 62, 45);
		btn5.setText("5");
		
		Button btn6 = new Button(shell, SWT.NONE);
		btn6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(6);
			}
		});
		btn6.setBounds(172, 104, 62, 45);
		btn6.setText("6");
		
		Button btn7 = new Button(shell, SWT.NONE);
		btn7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(7);
			}
		});
		btn7.setBounds(10, 155, 62, 45);
		btn7.setText("7");
		
		Button btn8 = new Button(shell, SWT.NONE);
		btn8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(8);
			}
		});
		btn8.setBounds(91, 155, 62, 45);
		btn8.setText("8");
		
		Button btn9 = new Button(shell, SWT.NONE);
		btn9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(9);
			}
		});
		btn9.setBounds(172, 155, 62, 45);
		btn9.setText("9");
		
		Button btn0 = new Button(shell, SWT.NONE);
		btn0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				anadirOtroDigito(0);
			}
		});
		btn0.setBounds(10, 206, 143, 45);
		btn0.setText("0");
		
		Button btncoma = new Button(shell, SWT.NONE);
		btncoma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ejecutarOperador(",");
			}
		});
		btncoma.setBounds(172, 206, 62, 45);
		btncoma.setText(",");
		
		Button btnmultiplica = new Button(shell, SWT.NONE);
		btnmultiplica.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ejecutarOperador("*");
			}
		});
		btnmultiplica.setBounds(257, 104, 62, 45);
		btnmultiplica.setText("*");
		
		
		Button btndivide = new Button(shell, SWT.NONE);
		btndivide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ejecutarOperador("/");
			}
		});
		btndivide.setBounds(257, 53, 62, 45);
		btndivide.setText("/");
		
		Button btnsuma = new Button(shell, SWT.NONE);
		btnsuma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ejecutarOperador("+");
			}
		});
		btnsuma.setBounds(257, 155, 63, 45);
		btnsuma.setText("+");
		
		Button btnoff = new Button(shell, SWT.NONE);
		btnoff.setBounds(337, 53, 75, 45);
		btnoff.setText("OFF");
		
		Button btnresta = new Button(shell, SWT.NONE);
		btnresta.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ejecutarOperador("-");
			}
		});
		btnresta.setBounds(257, 206, 62, 45);
		btnresta.setText("-");
		
		Button btnborra = new Button(shell, SWT.NONE);
		btnborra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ejecutarOperador("C");
			}
		});
		btnborra.setBounds(337, 104, 75, 45);
		btnborra.setText("C");
		
		Button btnigual = new Button(shell, SWT.NONE);
		btnigual.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ejecutarIgual();
			}
		});		
		btnigual.setBounds(337, 155, 75, 96);
		btnigual.setText("=");
		
		resultado = new Text(shell, SWT.BORDER);
		resultado.setBounds(9, 10, 403, 40);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	public static void main(String[] args) {
		Calculadoras calculadora = new Calculadoras();
	}
}
