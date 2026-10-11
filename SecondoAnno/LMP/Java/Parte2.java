/*
Vedremo come accettare input dell'utente dal terminale.
Java-user input 
importare java.util.Scanner
creare oggetto scanner
creare domande per utente: nome, cognome, età, città
*/        
        

//ESEMPIO 1 
/* 
import java.util.Scanner;

public class Parte2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual è il tuo nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual è il tuo cognome?");
        String cognome = scanner.nextLine();

        
        System.out.println("Qual è la tua età?");
        int eta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("In che città vivi?");
        String citta = scanner.nextLine(); //nextInt non crea una nuova riga quindi lo aggiungiamo sotto
     

        System.out.println("Ciao " + nome + " " +  cognome);
        System.out.println("Hai " + eta + " anni");
        System.out.println("Vivi a "+ citta);
    }
    
}

*/

//ESEMPIO 2 

import java.util.Scanner; 
public class Parte2 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Come ti chiami?");
        String nome = scanner.nextLine();
        

        System.out.println("Pratichi qualche sport?" + " (true/false)");
        boolean sport = scanner.nextBoolean();
        scanner.nextLine();

        
        
        System.out.println("Quanto sei alto?");
        float altezza = scanner.nextFloat();
        scanner.nextLine();
        
        System.out.println("Ciao "+ nome);
        
        if (sport == true) {
            System.out.println("Visto che hai detto si cosa pratichi?" );
                String pratico = scanner.nextLine();
                    System.out.println("Figo quindi pratichi " + pratico);
            
        }  
        else {
            System.out.println("Ah peccato, non ti piace fare sport");
        }
        System.out.println("E sei alto " + altezza + "cm");

    }
}


/*
 1) Cos'è Import java.util.Scanner?
    
    Java ha tantissime funzionalità integrate, ma per evitare di appesantire i programmi
    caricando tutto subito in memoria, le organizza in "pacchetti" (librerie).

     -Scanner è uno strumento nel pacchetto java.util.

     -Scrivendo import java.util.Scanner; in cima al file, dici a java che usarei la classe
        Scanner e che quindi di andarla a prendere dal pacchetto.

     Se non mettessi l'import per usare lo scanner dovresti scrivere ogni
         volta java.util.Scanner scanner = new java.util.Scanner(System.in);


 2) Perché scriviamo "Scanner scanner = new Scanner(System.in)? 
    Questa riga serve a creare l'oggetto fisicamente in memoria per poterne usare i comandi (come .nextLine() o .nextInt()) ecc ecc.

     -Scanner (il primo): Indica il tipo di dato (stiamo dicendo a Java "voglio creare una variabile di tipo Scanner").

     -scanner(il secondo): è semplicemente il nome che hai scelto di dare allo strumento.

     -New : è la parola chiave che dice a java di allocare nuova memoria per creare questo oggetto.

     -Scanner(...):Richiama il costruttore dello Scanner.

     -System.in: è l'ingrediente che gli passa dentro. Gli sta dicendo "voglio che questo scanner
         legga dall'input di sistema"(ovvero dalla tastiera)


 3) 3. Perché c'è sempre la parola System (anche per printare)?
     In Java, System è una classe fondamentale predefinita che rappresenta il sistema operativo 
     su cui sta girando il tuo programma. Serve a mettere in comunicazione il tuo codice con il computer.

    System gestisce tre canali principali:

    System.out (Standard Output): Rappresenta lo schermo/console. Quando scrivi System.out.println(), stai dicendo: 
        "Sistema (System), prendi il canale di uscita (out) e stampa una riga (println)".

    System.in (Standard Input): Rappresenta la tastiera. Quando crei new Scanner(System.in), stai dicendo:
        "Crea uno Scanner collegato al canale di ingresso del sistema (System.in), cioè la tastiera".

    System.err (Standard Error): Un canale speciale usato per stampare gli errori (spesso in rosso nei terminali).
    In sintesi, usi sempre System perché è la "porta di comunicazione" tra il tuo programma Java e le periferiche del tuo computer (schermo e tastiera)!
 */