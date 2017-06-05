/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;

import java.util.Scanner;


public class Empleado {
	
	//SÍ, NO ES EL FACTORIAL, PERO TAMBIÉN VALE JAJA
	
	
    Scanner stdin = new Scanner(System.in);
    private float sueldo;
    private String nombre;
    
    public Empleado(){
    }
    
    public Empleado( String ininombre, float inisueldo){
        nombre = ininombre;
        sueldo = inisueldo;
    }

    public void pedirDatosEmpleado(){
        System.out.println("Como se llama el empleado?");
        nombre = stdin.nextLine();
        System.out.println("Cuanto cobra el empleado?");
        sueldo = stdin.nextFloat();
    }

    public void visuDatosEmpleado(){
        System.out.println("\nNombre: " + nombre + "\nSueldo: " + sueldo );
    }


    public void asignarSueldo(float s){
        sueldo = s;
    }


    public float devolverSueldo(){
        return sueldo;
    }
    
    
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado();
        empleado1.pedirDatosEmpleado();
        
        Empleado empleado2 = new Empleado("Tomas", 80);
        
        empleado1.visuDatosEmpleado();
        empleado2.visuDatosEmpleado();
                
        if ( empleado1.devolverSueldo() > empleado2.devolverSueldo()){
            System.out.println("El empleado que más gana es el empleado 1 con " + empleado1.devolverSueldo());
        } else {
            System.out.println("El empleado que más gana es el empleado 2 con " + empleado2.devolverSueldo());
        }
                
    }
    
}
