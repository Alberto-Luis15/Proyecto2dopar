package proyecto2dopar;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import java.io.*;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.awt.Color;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import static javax.print.DocFlavor.BYTE_ARRAY.PDF;
/**
 *
 * @author Luis Alberto Lorenzo Gonzalez
 */
public class Crearunpdf {
    public static final String DEST="luis.pdf";
    public static final String imagen="fut.jpg";
    public static void main(String[] args) throws IOException {
        new Crearunpdf().crearPdf(DEST);
    }
    public void crearPdf(String dest)throws IOException{
        PdfWriter write=new PdfWriter(dest);
        PdfDocument pdf=new PdfDocument(write);
        Document documento=new Document(pdf);
        PdfFont font1 =PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont font2 =PdfFontFactory.createFont(FontConstants.HELVETICA); 
        
        Image pasatiempo=new Image(ImageDataFactory.create(imagen)); 
        List lista =new List().setSymbolIndent(4).setListSymbol("\n2050").setFont(font1);   
        lista.add(new ListItem("Nombre: Luis Alberto Lorenzo Gonzalez"));
        documento.add(lista)
                .add(new Paragraph("Fecha de nacimiento: 29 de diciembre de 1997").setFont(font1))
                .add(new Paragraph("Dirección: San Pablo Malacatepec, Villa de Allende, Edo. de México").setFont(font1))
                .add(new Paragraph("Ocupación: Estudiante").setFont(font1))
                .add(new Paragraph("Carrera: Lic. en Ingeniería en Computación").setFont(font1))
                .add(new Paragraph("Escuela: Centro Universitario UAEM Atlacomulco").setFont(font1))
                .add(new Paragraph("Mi pasatiempo favorito: Jugar futbool soccer y más a lado de mi mejor amigo").setFont(font2));
         documento.add(pasatiempo);  
        documento.close();
    }
}
    

