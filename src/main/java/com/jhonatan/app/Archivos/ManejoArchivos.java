package com.jhonatan.app.Archivos;

import com.jhonatan.app.Arboles.Arbol;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Jhonatan
 */
public class ManejoArchivos {
    public void guardar(JFrame panel,Arbol a){
        javax.swing.filechooser.FileFilter filtro = new FileNameExtensionFilter("Arhivo de arboles (.tree)", "tree");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filtro);
        
        int seleccion = fileChooser.showSaveDialog(panel);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            guardarEnArchivo(fichero.getAbsolutePath());
        }
    }
}
