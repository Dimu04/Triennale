/*
Java - Metodi stringhe

equals, equalsIgnoreCase, lenght, charAt
indexOf, isEmpty, toUpperCase, toLowerCase
trim, replace 
*/



public class Parte10_MetodiStringhe {
    public static void main(String[] args){

        String nome = "Leonardo";

        //boolean risultato = nome.equals("Leonardo"); //nome è uguale a "Leonardo" ? 
          //nome.equalsIgnoreCase ci ignora se minuscolo  o maiuscolo

        //int risultato = nome.length();

        //char risultato = nome.charAt(7); ci stampa la lettera in una determinata posizione 

        //int risultato =nome.indexOf("a"); ci stampa l'indice in intero di una determinata lettera 

        //boolean risultato = nome.isEmpty(); 

        //String risultato = nome.toUpperCase(); ci scrive tutto in maiuscolo

        //String risultato = nome.toLowerCase(); //ci scrive tutto in minuscolo
        
        //String risultato = nome.trim(); //toglie lo spazio in automatico ci aiuta a pulire    
                   // String nome = "   Leonardo   ";
        
        String risultato = nome.replace('o', 'D');


        System.out.println(risultato);
    }
}
