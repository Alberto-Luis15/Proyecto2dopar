/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2dopar;

import java.io.IOException;
import java.util.Scanner;
import static proyecto2dopar.Crearunpdf.DEST;


/**
 *
 * @author LENOVO
 */
public class Proyecto2dopar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
       int opcion; //Guardaremos la opcion del usuario
       
       while(!salir){
           
           System.out.println("Bienvenido, elige la opcion que desees");
           System.out.println("1. Leer y crear Excel");
           System.out.println("2. Crear PDF");
           System.out.println("3. Leer archivo web");
           System.out.println("4. Salir");
            
           
           opcion = sn.nextInt();
           
           switch (opcion){
               case 1: 
                   System.out.println("Leer y Crear Excel");
                   CrearExcel aplicacion = new CrearExcel();
                    aplicacion.EscribirEXCEL();
                    aplicacion.LeerEXCEL();
                    aplicacion.agregarDatos();   
                   break;
               
               case 2: 
                   System.out.println("Crear pdf");
                   Crearunpdf aplicacion1 = new Crearunpdf();
                   aplicacion1.crearPdf(DEST);
                break;
               
               case 3:
                   System.out.println("Leer archivo web");
                    Leerweb aplicacion2 = new Leerweb();
                    aplicacion2.leer();
                   
                break;
                   
               case 4:
                   salir=true;
                   System.out.println("Vuelve pronto");
                   break;
               default:
                   System.out.println("Escribe solo numeros de 1 a 3");
           }
       }
    
    }
}
