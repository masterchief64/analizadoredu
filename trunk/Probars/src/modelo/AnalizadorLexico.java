/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;
import java.util.List;

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
public class AnalizadorLexico {

    private List<Lexico> lexicos;
    private AFD afd;

    public AnalizadorLexico() {
        this.lexicos = new ArrayList<Lexico>();
        this.afd=new AFD();
    }

    public void crearTokens(String texto){
        this.afd.verificaTexto(texto, this);
        
    }

    public void addLexico(Lexico lexico){
        lexicos.add(lexico);
    }

    public List<Lexico> getLexicos() {
        return lexicos;
    }

    public void setLexicos(List<Lexico> lexicos) {
        this.lexicos = lexicos;
    }



}
