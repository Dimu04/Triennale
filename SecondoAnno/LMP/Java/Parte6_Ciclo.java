/* Java PARTE 6 - CICLI
Ciclo while
Ciclo do while
Ciclo for
Ciclo for each  

Il ciclo ci permette di sostituire lunghi procedimenti a mano 
    e rendere il nostro codice più dinamico, ci permette di eseguire una o più
    volte un blocco di codice finché una condizione è vera.

    
   
 Il do while è il contrario  il while esegue solo se la condizione è vera mentre il Do while
  esegue almeno una volta il blocco di codice, poi verifica la condizione
*/


/* 
public class Parte6 {
    public static void main(String[] args){
        int i = 0; //i sta per iteratore.
        while(i < 0){
            System.out.println(i);
            i++;
            
        }
         do { // Qui esegue il blocco di codice almeno una volta
            System.out.println("dowhile " + i);
            i++;
       } while(i < 0); // qui verifica la condizione
    }
    
}

*/

//CICLO FOR

//Usiamo il for per ciclare gli array, per ciclare un numero di volte un blocco di codice, per ciclare una stringa ecc ecc

/* 
public class Parte6_Ciclo {
    public static void main(String[] args){

        for(int i = 0; i < 5; i++){    //si legge come "per ogni i che parte da 0 fino a 5 incrementando di 1"
            System.out.println("riga " + i);
            for(int j = 0; j <5; j++){
                System.out.println("colonna " + j);
            }  
        }
    }
}

               j  ++ ->
    i = 0 riga 0: 0 1 2 3 4
    i = 1 riga 1: 0 1 2 3 4
    i = 2 riga 2: 0 1 2 3 4

*/

//for enhanced/foreach lo usiamo esclusivamente negli array 
/* 
public class Parte6_Ciclo {

    public static void main(String[] args){
        
        int[] numeri = {10,20,30,40,50}; //insieme di valori
         for (int numero: numeri){
            System.out.println(numero);
         }
    }
}

*/

//Brake e Continue

public class Parte6_Ciclo {

    public  static void main(String[] args){
        for(int i=0; i <10; i++){
            if(i == 4){
                // break;
                //continue;
            }
        System.out.println(i);
        } 
    }
}