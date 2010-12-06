package modelo;


import java.io.File;
import javax.swing.filechooser.FileFilter;
/**
 *
 * @author edu
 *
 * Integrantes:
 *              EduardoLuis Lima Galarza
 *              Angel Alberto Valdez Masache
 *              Carlos Fabian Vivanco Tenorio
 *
 */
public class Filtro extends FileFilter{


    public boolean accept(File f){
        if (f.isDirectory()){
            return true;
        }

        String extension = f.getName();
        //podemos agregar mas extensiones
        if (extension.endsWith(".cmp")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        //es la descripcion que vemos
        return "Archivos de texto (.cmp)";
    }
}

