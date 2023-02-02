import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CreaFichero {
    public static void main(String[] args) {
        String ruta= JOptionPane.showInputDialog("Introduce la ruta del fichero");
        String texto=JOptionPane.showInputDialog("Introduce el texto que quieras poner en el fichero");
        escribirFichero(ruta, texto);
        mostrarFichero(ruta);
    }
    public static void escribirFichero (String ruta, String texto){
        try (FileWriter fw=new FileWriter(ruta);)
        {
         fw.write(texto);
        }catch (IOException e){
            System.out.println("Ha habido problemas de escritura en el fichero");
        }
    }
    public static void mostrarFichero(String ruta){
        try (FileReader fr=new FileReader(ruta)){
            int valor=fr.read();
            while (valor!=-1){
                //Solo cambiaremos el caracter si es minúscula o mayúscula
                char caracter=(char)valor;
                if (caracter>=97 && caracter<=122){
                    caracter-=32;
                }else if(caracter>=65 && caracter<=90){
                    caracter+=32;
                }
                System.out.println(caracter);
                valor=fr.read();
            }
        }catch (IOException e){
            System.out.println("Problema con la entrada y salida de datos"+e);
        }
    }
}
