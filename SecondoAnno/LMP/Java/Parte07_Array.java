/*
-Cosa sono gli array 
-Creare un array vuoto
-Associare elementi
-Array.tostring
-Lunghezza array
-Modificare elementi
-Ciclare array con for e  foreach
*/

/* -Gli array sono collezioni di dati che sono correlati tra di loro
 
    -Gli indici ovvero [] indicano la posizione degli elementi nell'array 

    -La lenght o lunguezza ci da semplicemente il valore in int, ed è
         la quantità degli elementi effettiva nell'array.
    
    




*/
public class Parte7_Array {
    
    public static void main (String[] args){
        //come creare un array?

        /* 
        int[] numeri =  {10,20,30,40};
        System.out.println(numeri.length); //mandiamo a schermo la lunghezza effettiva dell'array 
        System.out.println(numeri[1]); //abbiamo stampato la posizione 1 
        System.out.println(numeri[numeri.length -1]);
        */

        //possiamo anche stampare numeri a ritrovo usando i numeri negativi 
        //Usiamo System.out.println(numeri[numeri.length -1]);

        //come ciclare gli elementi in un array 
        int [] numeri = {10,20,30,40};
        for(int i = 0; i < numeri.length; i++){
            System.out.println(numeri[i]);
        }
    }
    
    /*for each sintassi 
        for(int numero: numeri){
            System.out.println(numero);
        }
    */
}
