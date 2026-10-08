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