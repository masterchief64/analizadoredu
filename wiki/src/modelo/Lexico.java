/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import modelo.AFD.TOKEN;

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
public class Lexico {

    private AFD.TOKEN token;
    private String lexema;

    public Lexico(TOKEN token, String lexema) {
        this.token = token;
        this.lexema = lexema;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public TOKEN getToken() {
        return token;
    }

    public void setToken(TOKEN token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token +": "+lexema;
    }


}
