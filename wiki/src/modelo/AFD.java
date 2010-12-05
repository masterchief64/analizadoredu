/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.StringTokenizer;

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
public class AFD {

    public enum  TOKEN {TOKEN_RESERVADA,TOKEN_NUMERO,TOKEN_OPERADOR,TOKEN_IDENTIFICADOR,TOKEN_ERROR,TOKEN_SEPARADOR_SENTENCIA};

    public void verificaTexto(String texto, AnalizadorLexico lex){
        lex.getLexicos().clear();
        for (StringTokenizer stringTokenizer = new StringTokenizer(texto); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            lex.addLexico(new Lexico(validaToken(token), token));
        }
    }

    private static TOKEN validaReservada(String str){
        TOKEN token=TOKEN.TOKEN_ERROR;
        if(   str.equals("sumar")||str.equals("restar")||str.equals("multiplicar")||
                str.equals("dividir")||str.equals("potencia")){
            token=TOKEN.TOKEN_RESERVADA;
        }
        return token;
    }
    private static TOKEN validaNumero(String str){
          TOKEN token = TOKEN.TOKEN_ERROR;
        int estado=0;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            switch (estado) {
                case 0:
                    if(Character.isDigit(c)){
                        estado = 3;
                        token = TOKEN.TOKEN_NUMERO;
                    }else if(c.equals('-')){
                        estado = 1;
                        token = TOKEN.TOKEN_ERROR;
                    }else if(c.equals('.')){
                        estado=2;
                        token = TOKEN.TOKEN_ERROR;
                    }else{
                        estado = -1;
                        token = TOKEN.TOKEN_ERROR;
                    }
                    break;
                case 1:
                    if(Character.isDigit(c)){
                        estado = 3;
                        token = TOKEN.TOKEN_NUMERO;
                    }else if(c.equals('-')){
                        estado = 5;
                        token = TOKEN.TOKEN_ERROR;
                    }else if(c.equals('.')){
                        estado=2;
                        token = TOKEN.TOKEN_ERROR;
                    }else{
                        estado = -1;
                        token = TOKEN.TOKEN_ERROR;
                    }

                    break;
                case 2:
                    if(Character.isDigit(c)){
                        estado = 4;
                        token = TOKEN.TOKEN_NUMERO;
                    }else if(c.equals('-')){
                        estado = 5;
                        token = TOKEN.TOKEN_ERROR;
                    }else if(c.equals('.')){
                        estado=5;
                        token = TOKEN.TOKEN_ERROR;
                    }else{
                        estado = -1;
                        token = TOKEN.TOKEN_ERROR;
                    }

                    break;
                case 3:
                    if(Character.isDigit(c)){
                        estado = 3;
                        token = TOKEN.TOKEN_NUMERO;
                    }else if(c.equals('-')){
                        estado = 5;
                        token = TOKEN.TOKEN_ERROR;
                    }else if(c.equals('.')){
                        estado=2;
                        token = TOKEN.TOKEN_ERROR;
                    }else{
                        estado = -1;
                        token = TOKEN.TOKEN_ERROR;
                    }

                    break;
                case 4:
                    if(Character.isDigit(c)){
                        estado = 4;
                        token = TOKEN.TOKEN_NUMERO;
                    }else if(c.equals('-')){
                        estado = 5;
                        token = TOKEN.TOKEN_ERROR;
                    }else if(c.equals('.')){
                        estado=5;
                        token = TOKEN.TOKEN_ERROR;
                    }else{
                        estado = -1;
                        token = TOKEN.TOKEN_ERROR;
                    }

                    break;
                case 5:
                    if(Character.isDigit(c)){
                        estado = 5;
                        token = TOKEN.TOKEN_ERROR;
                    }else if(c.equals('-')){
                        estado = 5;
                        token = TOKEN.TOKEN_ERROR;
                    }else if(c.equals('.')){
                        estado=5;
                        token = TOKEN.TOKEN_ERROR;
                    }else{
                        estado = -1;
                        token = TOKEN.TOKEN_ERROR;
                    }

                    break;
                default:
                    token = TOKEN.TOKEN_ERROR;
            }


        }
        return token;
    }

//

    private static TOKEN validaOperador(String str){
        TOKEN token=TOKEN.TOKEN_ERROR;
        if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")
                ||str.equals("(")||str.equals(")")){
            token=TOKEN.TOKEN_OPERADOR;
        }

        return token;
    }


    private static TOKEN validaIdentificador(String str){
        TOKEN token=TOKEN.TOKEN_ERROR;
        int estado=0;
        for(Character c:str.toCharArray()){
            switch(estado){
                case 0:
                    if(Character.isLetter(c)||c.equals('_')){
                        estado=1;
                        token=TOKEN.TOKEN_IDENTIFICADOR;
                    }else
                        if(Character.isDigit(c)){
                            estado=2;
                            token=TOKEN.TOKEN_ERROR;
                        }else{
                        estado=-1;
                        token=TOKEN.TOKEN_ERROR;
                        }
                    break;
                case 1:
                    if(Character.isLetter(c)||Character.isDigit(c)||c.equals('_')){
                        estado=1;
                        token=TOKEN.TOKEN_IDENTIFICADOR;
                    }else{
                        estado=-1;
                        token=TOKEN.TOKEN_ERROR;
                    }
                    break;
                case 2:
                  if(Character.isLetter(c)||Character.isDigit(c)||c.equals('_')){
                        estado=2;
                        token=TOKEN.TOKEN_ERROR;
                    }else{
                        estado=-1;
                        token=TOKEN.TOKEN_ERROR;
                    }
                    break;
                default:token=TOKEN.TOKEN_ERROR;
            }
        }
        return token;
    }

    public static TOKEN validaToken(String str){
       TOKEN token = TOKEN.TOKEN_ERROR;
       token=validaReservada(str);
       if(token.equals(TOKEN.TOKEN_ERROR)){
           token=validaOperador(str);
           if(token.equals(TOKEN.TOKEN_ERROR)){
               token=validaIdentificador(str);
               if(token.equals(TOKEN.TOKEN_ERROR)){
                   token=validaNumero(str);
               }if(token.equals(TOKEN.TOKEN_ERROR)){
                   if(str.equals(";"))
                   token=TOKEN.TOKEN_SEPARADOR_SENTENCIA;
               }
           }
       }
       return token;
    }




}
