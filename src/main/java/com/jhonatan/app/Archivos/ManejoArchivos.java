package com.jhonatan.app.Archivos;

import com.jhonatan.app.Arboles.Arbol;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jhonatan
 */
public class ManejoArchivos {

    public void guardar(JFrame panel, Arbol a) {
        javax.swing.filechooser.FileFilter filtro = new FileNameExtensionFilter("Arhivo de arboles (.tree)", "tree");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filtro);

        int seleccion = fileChooser.showSaveDialog(panel);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            guardarEnArchivo(fichero.getAbsolutePath(), a);
        }
    }

    public void guardarEnArchivo(String archivo, Arbol a) {

        try {
            FileOutputStream fileOut = new FileOutputStream(archivo + ".tree");
            try {
                ObjectOutputStream salida = new ObjectOutputStream(fileOut);
                salida.writeObject(a);
                salida.close();
            } catch (IOException e) {
                System.out.println("Error en guardar archivo: " + e.toString());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error en guardar archivo: " + ex.toString());
        }
    }


    public Arbol abrir(JFrame panel){
        javax.swing.filechooser.FileFilter filtro = new FileNameExtensionFilter("Archivo de Arboles (.tree)", "tree");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filtro);
        
        int seleccion = fileChooser.showOpenDialog(panel);
        if (seleccion == fileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            return abrir(fichero.getAbsolutePath());
        }
        return null;
    }
}
