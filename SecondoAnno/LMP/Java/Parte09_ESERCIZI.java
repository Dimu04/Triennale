/*
Esercizi mirati su Cicli e Array

1. Il Gioco "Indovina il Numero" (while)

    Come funziona: Il programma genera un numero segreto (puoi sceglierne uno fisso per ora, es. 42, o usare la classe Random).
    Con un ciclo while, chiedi continuamente all'utente di indovinare il numero tramite Scanner.

    Cosa impari: Gestire la condizione di uscita dal ciclo 
    e dare suggerimenti ("Il numero segreto è più alto" o "più basso").

*/


/* 
import java.util.Random;
import java.util.Scanner;

public class Parte9_ESERCIZI {
    public static  void main(String[] args){

        Random random = new  Random();
        Scanner scanner = new Scanner(System.in);   
        int prova = 0;
        
        int numero = random.nextInt(100)+ 1; //genera un numero da 1 a 100

            
        while (prova != numero) {
            System.out.println("Indovina il numero da 1 a 100");
            prova =scanner.nextInt(); //SENZA int davanti! Stiamo solo aggiornando la scatola che già esiste

            //avendo una grossa lista di numeri ci serve un if per orientarci e capire anche se il gioco è finito.
            if (prova == numero) {
                System.out.println("Bravo hai indovinato");
            
            }else if (prova < numero) {
                System.out.println("Devi aumentare stai basso");
                
            }else{
                System.out.println("Devi abbassare stai troppo alto!");
            }
         }

    }
}
*/

//----------------------------------------------------------------------------------

/*
2 Ricerca in un Array (Array Monodimenionali)
    -Cosa usare: For, if, gestione degli indici
    -L'esercizio: Crea un array di numeri interi (ES. int[] numeri = {12,45,7,89,23}) e
        chiedi all'utente tramite scanner quale numero vuole cercare. Il programma deve
        scorrere l'array e dire se il numero è presente e in quale indice si trova, oppure se non esiste 

*/

/* 

import java.util.Scanner;

public class Parte9_ESERCIZI {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] numeri = {12,45,7,89,23};
        int cerca = 0;

        System.out.print("Quale nuemero vuoi cercare ? ");
        cerca =scanner.nextInt();

        int posizione_numero = -1;

        for(int i = 0; i < numeri.length; i++){
            if (cerca == numeri[i]) {
                System.out.println("Bravo hai trovato " + cerca + " e sta in posizione " + i);
                posizione_numero = i;
            }
        }
        if (posizione_numero == -1 ) {
            System.out.println("Non c'è");
        }
       
            
        
    }  
}   
*/

/*
APPUNTO: La variabile posizione numero possiede -1 perché è un valore "nullo" che viene aggiornato
         unicamente se trova il numero dentro l'array. Se quest'ultimo rimane meno 1 vuol dire che 
         non abbiamo trovato una coincidenza nella variabile cerca e all'array di base.

        

Esercizio 3: come usare for,if, variabili fuori dal ciclo   
    -La consegna: crea un array di interi a tua scelta(es int numeri = {34, 8, 71, 15, 19, 3}

    -Trova il valore max e posizione e trova il min e posizione


*/
   /* 
public class Parte9_ESERCIZI {

    public static void main(String[] args){
        int Lista[] = {-5,-2,-9,40,-32,60}; //{34,8,71,15,90,3,56,-3};
        int max = Lista[0];
        int min = Lista[0];
        int indicemax = 0;
        int indicemin = 0;

        for(int i= 0; i < Lista.length; i++){

            if (Lista[i] > max) {
                max = Lista[i];
                indicemax = i;
            }
            
            if (Lista[i] < min ) {
                min = Lista[i];
                indicemin = i;
            }
            
        }
        System.out.println("Bene il max è " + max + " e l'indice è " + indicemax);
        System.out.println("Bene il min è " + min + " e l'indice è " + indicemin);
        
    }

}
*/



/*ESERCIZIO 3 
    -Leggi con Scanner altezza e larghezza, poi stampa un rettangolo di 
    asterischi con due for annidati. Prima fai la versione piena poi
    la cornice vuota dentro.


*/

import  java.util.Scanner;

public class Parte9_ESERCIZI {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int altezza = 0;
        System.out.println("Inserisci l'altezza " );
        altezza = scanner.nextInt();
        
        int larghezza = 0;
        System.out.println("Inserisci la larghezza ");
        larghezza = scanner.nextInt();


        for(int riga = 0; riga < altezza; riga++){
 
            
            for(int colonna = 0; colonna < larghezza; colonna++){
                if(altezza-1 == riga || larghezza-1 == colonna || riga == 0 || colonna== 0 ){
                    
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                    
                }
    

            }
        
            
            System.out.println();


        }
    }
}


/*Ecco il codice in sintesi, in ordine di esecuzione.

1. Input. Con Scanner leggi due numeri: altezza (quante righe) e larghezza (quante colonne).

2. Ciclo esterno (riga). Gira da 0 a altezza - 1, un giro per ogni riga della figura.

3. Ciclo interno (colonna). Dentro ogni riga gira da 0 a larghezza - 1, un giro per ogni casella. Riparte da 0 a ogni nuova riga.

4. La decisione per ogni casella. L’if controlla se la casella è sul bordo, cioè se vale almeno una di queste quattro condizioni:

riga == 0: prima riga
altezza - 1 == riga: ultima riga
colonna == 0: prima colonna
larghezza - 1 == colonna: ultima colonna

Se almeno una è vera (il || significa “oppure”), stampi " * ". Altrimenti, nell’else, stampi tre spazi, della stessa larghezza dell’asterisco così le colonne restano allineate.

5. L’a capo. Il println() sta nel ciclo esterno, dopo quello interno, quindi viene eseguito una volta per riga, quando la riga è finita.

Il risultato è un rettangolo con solo il perimetro riempito. 
Si tratta dello schema base di tutti i cicli annidati: il ciclo esterno sceglie la riga, quello interno scorre le colonne, 
e dentro il corpo decidi cosa fare per ogni casella. Con le matrici cambierà solo quello che fai in quel punto.
 */
