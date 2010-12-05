/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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
public class AnalizadorSintactico {

    private List<Lexico> lexicos;

    public AnalizadorSintactico(List<Lexico> lexicos){
        this.lexicos=lexicos;
    }

    public boolean comprobarSintaxis(){
        boolean correcto=true;
        int opc=0;
        for(Lexico lex:lexicos){

            switch(opc){
                case 0:
                    if(lex.getToken()==AFD.TOKEN.TOKEN_RESERVADA){
                        opc=1;
                        correcto=false;
                    }else{
                        opc=-1;
                        correcto=false;
                    }
                    break;
                case 1:
                    if(lex.getToken().equals(AFD.TOKEN.TOKEN_OPERADOR)&&lex.getLexema().equals("(")){
                        opc=2;
                        correcto=false;
                    }else{
                        opc=-1;
                        correcto=false;
                    }
                    break;
                case 2:
                    if(lex.getToken().equals(AFD.TOKEN.TOKEN_NUMERO)||
                            lex.getToken().equals(AFD.TOKEN.TOKEN_IDENTIFICADOR)){
                        opc=3;
                        correcto=false;
                    }else{
                        opc=-1;
                        correcto=false;
                    }
                    break;
                case 3:
                    if(lex.getToken().equals(AFD.TOKEN.TOKEN_NUMERO)||
                            lex.getToken().equals(AFD.TOKEN.TOKEN_IDENTIFICADOR)){
                        opc=4;
                        correcto=false;
                    }else{
                        opc=-1;
                        correcto=false;
                    }
                    break;
                case 4:
                    if(lex.getToken().equals(AFD.TOKEN.TOKEN_OPERADOR)&&
                            lex.getLexema().equals(")")){
                        opc=5;
                        correcto=false;
                    }else{
                        opc=-1;
                        correcto=false;
                    }
                    break;
                case 5:
                    if(lex.getToken().equals(AFD.TOKEN.TOKEN_SEPARADOR_SENTENCIA)){
                        opc=6;
                        correcto=true;
                    }else{
                        opc=-1;
                        correcto=false;
                    }
                    break;
                case 6:
                    if(lex.getToken()==AFD.TOKEN.TOKEN_RESERVADA){
                        opc=1;
                        correcto=false;
                    }else{
                        opc=-1;
                        correcto=false;
                    }
                    break;
                    default:correcto=false;
            }
        }
        return correcto;
    }

}
