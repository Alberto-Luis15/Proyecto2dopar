package proyecto2dopar;

/**
 *
 * @author Luis Alberto Lorenzo Gonzalez
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author drago
 */
public class Leerweb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       leer();
       
	}
 
   
 
    public static void leer(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
 
        try {
			
			archivo = new File ("COVID-19 por municipio.html");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
 
			// Lectura del fichero
			System.out.println("Leyendo el contendio del archivo web");
			String linea;
                        
			while((linea=br.readLine())!=null)
				System.out.println(linea);
        }               
        catch(Exception e){
           e.printStackTrace();
        }finally{
           
           try{
              if( null != fr ){
                 fr.close();
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }
        System.out.println("Se leyo el archivo web");
    }

    void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
