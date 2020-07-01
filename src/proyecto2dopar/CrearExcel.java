/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2dopar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Luis Alberto Lorenzo Gonzalez
 */
public class CrearExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                      
        EscribirEXCEL();
        LeerEXCEL();
        agregarDatos();        
    }
    
    static void LeerEXCEL() {
        
        String nombreArchivo = "ListaUsuarios.xlsx";
        String hoja = "Usuarios";
        
        try(FileInputStream file = new FileInputStream(new File(nombreArchivo))){
            //Leer archivo de Excel
            XSSFWorkbook libro = new XSSFWorkbook(file);
            // Obtener la hoja que se va a leer
            XSSFSheet sheet = libro.getSheetAt(0);
            // Obtener todas las filas de la hoja de Excel
            Iterator<Row> rowIterator = sheet.iterator();
            
            Row row;
            // Se recorre cada fila hasta el final
            while(rowIterator.hasNext()) {
                row = rowIterator.next();
                // Se obtienen las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                // Se recorre cada celda
                while(cellIterator.hasNext()) {
                    // Se obtiene la celda en especifico y se imprime
                    cell = cellIterator.next();
                    System.out.print(cell.getStringCellValue()+ " - ");
                }
                System.out.println(" ");
            }
            
        } catch(Exception e) {
            e.getMessage();
        }
    }
    
    static void EscribirEXCEL() {
        
        String nombreArchivo = "ListaUsuarios.xlsx";
        
        String hoja = "Usuarios";
        
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        
        // Cabecera de la hoja de excel
        String[] header = new String[] {"ID", "NOMBRE", "SLUG"};
        
        // Contenido de la hoja de excel
        String[][] document = new String[][] {
            {"1", "Abarth", "abarth"},
            {"2", "Alfa Romero", "alfa-romero"},
            {"3", "Aro", "aro"},
            {"4", "Asia", "asia"},
            {"5", "Asia Motors", "asia-motors"},
            {"6", "Aston Martin", "aston-martin"},
            {"7", "Audi", "audi"},
            {"8", "Austin", "austin"},
            {"9", "Auverland", "auverland"},
            {"10", "Bentley", "bentley"},
            {"11", "Bertone", "bertone"},
            {"12", "BMW", "bmw"},
            {"13", "Casilac", "cadilac"},
            {"14", "Chevrolet", "chevrolet"},
            {"15", "Chrysler", "chrysler"},
            {"16", "Citroen", "citroen"},
            {"17", "Corvette", "corvette"},
            {"18", "Dacia", "dacia"},
            {"19", "Daewoo", "daewoo"},
            {"20", "Daf", "daf"},
            {"21", "Daihatsu", "daihatsu"},
            {"22", "Daimler", "daimler"},
            {"23", "Dodge", "dodge"},
            {"24", "Ferrari", "ferrari"},
            {"25", "Fiat", "fiat"},
            {"26", "Ford", "ford"},
            {"27", "Galloper", "galloper"},
            {"28", "Gmc", "gmc"},
            {"29", "Honda", "honda"},
            {"30", "Hummer", "hummer"},
            {"31", "Hyundai", "hyundai"},
            {"32", "Infiniti", "infiniti"},
            {"33", "Innocenti", "innocenti"},
            {"34", "Isuzu", "isuzu"},
            {"35", "Iveco", "iveci"},
            {"36", "Iveco-pegaso", "iveco-pegaso"},
            {"37", "Jaguar", "jaguar"},
            {"38", "Jeep", "jeep"},
            {"39", "Kia", "kia"},
            {"40", "Lada", "lada"},
            {"41", "Lamborghini", "lamborghini"},
            {"42", "Lancia", "lancia"},
            {"43", "Land-rover", "land-rover"},
            {"44", "Ldv", "ldv"},
            {"45", "Lexus", "lexus"},
            {"46", "Lotus", "lotus"},
            {"47", "Mahindra", "mahindra"},
            {"48", "Maserati", "maserati"},
            {"49", "Maybach", "maybach"},
            {"50", "Mazda", "mazda"},
            {"51", "Mercedes-benz", "mercedez-benz"},
            {"52", "Mg", "mg"},
            {"53", "Mini", "mini"},
            {"54", "Mitsubishi", "mitsubishi"},
            {"55", "Morgan", "morgan"},
            {"56", "Nissan", "nissan"},
            {"57", "Opel", "opel"},
            {"58", "Peugeot", "peugeot"},
            {"59", "Pontiac", "pontiac"},
            {"60", "Porsche", "porsche"},
            {"61", "Renault", "renault"},
            {"62", "Rolls-royce", "rolls-royce"},
            {"63", "Rover", "rover"},
            {"64", "Saab", "saab"},
            {"65", "Santana", "santana"},
            {"66", "Seat", "seat"},
            {"67", "Skoda", "skoda"},
            {"68", "Smart", "smart"},
            {"69", "Ssangyong", "ssangyong"},
            {"70", "Subaru", "subaru"},
            {"71", "Suzuki", "suzuki"},
            {"72", "Talbot", "talbot"},
            {"73", "Tata", "tata"},
            {"74", "Toyota", "toyota"},
            {"75", "Umm", "umm"},
            {"76", "Vaz", "vaz"},
            {"77", "Volkswagen", "volskwagen"},
            {"78", "Volvo", "volvo"},
            {"79", "Wartburg", "wartburg"}
        };
        
        // Poner en negrita la cabecera
        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);
        
        // Generar los datos para el documento
        for(int i = 0 ; i <= document.length ; i++) {
            XSSFRow row = hoja1.createRow(i); // Se crea la fila
            for(int j = 0 ; j < header.length ; j++) {
                if(i == 0) { // Para la cabecera
                    XSSFCell cell = row.createCell(j); // Se crean las celdas pra la cabecera
                    cell.setCellValue(header[j]); // Se añade el contenido
                } else {
                    XSSFCell cell = row.createCell(j); // Se crean las celdas para el contenido
                    cell.setCellValue(document[i - 1][j]); // Se añade el contenido
                }
            }
        }
        
        // Crear el archivo
        try (OutputStream fileOut = new FileOutputStream(nombreArchivo)){
            System.out.println("SE CREO EL EXCEL");
            libro.write(fileOut);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    static void agregarDatos(){
        
        System.out.println("Agrega Los Datos");
        String nombreArchivo = "Agredado.xlsx";
        String hoja = "Hoja1";
        String marca = "", submarca = "", color = "", modelo = "";
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja1 = libro.createSheet(hoja);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Insertar marca:");
        marca = (teclado.next());
        System.out.println("Insertar submarca:");
        submarca = (teclado.next());
        System.out.println("Insertar color:");
        color = (teclado.next());
        System.out.println("Insertar Modelo:");
        modelo = (teclado.next());
        
        // Cabecera de la hoja de excel
        String[] header = new String[]{"MARCA", "SUBMARCA", "COLOR", "MODELO"};
        
      

        // Contenido de la hoja de excel
        String[][] document = new String[][]{
            {marca, submarca, color, modelo}
        };

            
            
        
        // Poner en negrita la cabecera
            CellStyle style = libro.createCellStyle();
            Font font = libro.createFont();
            font.setBold(true);
            style.setFont(font);
        
        // Generar los datos para el documento
            for(int i = 0 ; i <= document.length ; i++) {
                XSSFRow row = hoja1.createRow(i); // Se crea la fila
                for(int j = 0 ; j < header.length ; j++) {
                    if(i == 0) { // Para la cabecera
                        XSSFCell cell = row.createCell(j); // Se crean las celdas pra la cabecera
                        cell.setCellValue(header[j]); // Se añade el contenido
                    } else {
                        XSSFCell cell = row.createCell(j); // Se crean las celdas para el contenido
                        cell.setCellValue(document[i - 1][j]); // Se añade el contenido
                    }
                }
            }
        
        // Crear el archivo
            try (OutputStream fileOut = new FileOutputStream(nombreArchivo)){
                System.out.println("SE CREO EL EXCEL");
                libro.write(fileOut);
                fileOut.close();
            } catch(IOException e) {
                e.printStackTrace();
        }
             
    } 
     
    
}