/*
public class Parte1 {
   public static void main(String[] args){
        System.out.println("ciao da Dimu");
        System.out.print("prova 2\n");
        System.out.print("prova 3");

    }
}
*/
//println quel ln sta per newline, un altro metodo di newline è \n

//PARTE 2 
//Variabili in java 

/* 
 public  class Parte1 {

        public static void  main(String[] args){
            int x;  //dichiarazione
            x = 45; //assegnazione

            //diverse tipologie di dato
            int y = 34; //inizializzazione 
            double w = 9.56; 
            String c = "ciao"; //quando sta tra le apici è SEMPRE una stringa ricorda 

        }
}
*/

/* 
    public class Parte1 {
        
        public  static void main(String[] args) {
            int x; //dichiarazione
            x = 45; //assegnazione
            int y = 42;
            System.out.println(x); 
            System.out.println(y);
        }      
    }  
*/


//Altri esempi di DICHIARAZIONE E ASSEGNAZIONE
/* 
public class Parte1 {

    public static void  main (String[] args){
        //dichiarazione
        int x; 
        String nome; 
        double temperatura; 

        //assegnazione
        x = 22;
        nome = "Dimu";
        temperatura =34.00;
        //stampo
        System.out.println(x);
        System.out.println(nome);
        System.out.println(temperatura);
    }
*/


// Tipi di dati Primitivi 

/*
    -Boolean = True and False occupa 1bit
    -Byte = lo usiamo per salvare dei numeri da meno| -128 a 127| (contiamo lo 0) e occupa un Byte 
    -Short = va da |-32768 a 32767| e occupa 2 byte
    -Int = va da meno |-2 miliardi a 2 miliardi| e occupa 4 byte
    -Long = va da |-9 quintilioni a 9 quintilioni| e occupa 8 byte e bisogna sempre aggiungere una L alla fine

    -Float = è composto da 6-7 cifre decimali 5.123456f sono i numeri con la virgola  e bisogna aggiungere la f alla fine occupa 4 byte
    -Double = 5.12345678912345è un numero sempre con la virgola noi usiamo il punto per 
        scriverlo composto da 15 cifre decimali e occupa 8 byte

    - Char = lo scriviamo con singoli apici 'f' mentre "f" è una stringa
         è l'ultima primitiva che abbiamo è può contenere lettere, caratteri e Ascii e occupa 2 byte
 
    -Stringa = Sequenza di caratteri "ciao sono Dimu" è una variabile


    -DIFFERENZA tra PRIMITIVE e REFERENCE 
    Le primitive: sono i dati che ci vengono fortini da java così e iniziano tutti con la minuscola 
        Esempio int,char,boolean

    Le reference: Iniziano con la Maiuscola e sono tipi di dati più complessi e vengono create da noi Esempio String
        le reference portano con se una serie di attributi e metodi che possiamo utilizzare scrivi laStringa.
 */



/* 
public class Parte1 {

    public static  void main(String[] args){
        boolean ilBoolean = true;
        byte ilByte = 127;
        short loShort = -32768;
        int ilInt = 2_000_000_000;
        long ilLong = 893123124123L;

        float ilFloat = 5.123123f;
        double ilDouble = 5.3123124243;


        char ilChar = 'f';
        String laStringa = "Ciao sono Dimu";

        // laStringa. un esempio è: laStringa.toUpperCase()
    
        System.out.println(laStringa.toUpperCase());
        System.out.println(laStringa);
        System.out.println(ilBoolean);

    }
}

*/


/* NOTE: La riga public static void main(String[] args)  viene usata
         come porta d'ingresso di qualsiasi programma di java è il punto
         esatto da cui la Java Virtuall Machine (JVM) inizia a eseguire il tuo codice


         -- Significato delle parole: 
        1) Public (Modificatore di accesso)

             Dice a java che questo metodo è **PUBBLICO**, cioè visibile e accessibile da chiunque
             all'estenro. La JVM ha bisogno che sia public per poterlo trovare e avviare 
             dall'esterno della classe.

        2) Static (Metodo di classe)

             Significa che il metodo appartiene alla classe stessa (Parte1) e non richide la creazione 
             di un oggetto per essere. La JVM può quindi lanciarlo subito senza 
             dover fare "strani giri" di creazione in memoria.
        
        3)Void (Tipo di ritorno)
            
             Indica il tipo di dato che il metodo restituisce alla fine della sua esecuzione.
             Void significa letteralmente "vuoto/nulla": il main esegue le sue istruzioni
             fa il suo lavoro e non deve restituire alcun valore indietro.

             
        4)Main (nome del metodo) 
             
             È semplicemente il nome identificativo che Java cerca
             per convenzione. Quando premi "Run", Java cerca esattamente 
             una funzione chiamta "main".

        5)String[] args (parametro di ingresso) 

             Sono i dati che puoi passare al programma dell'avvio da riga 
             comando (terminale):
                - String[]: indica una array (una lista) di testi/stringhe
                - args: è il nome della variabile (abbreviato di arguments)

    Esempio:
        Se avviassimo il programma da termianle scrivendo java Parte 2 Ciao 123, dentro args
        troveresti le stringhe "Ciao" e "123". Siccome di solito si avviano i programmi da VS Code 
        senza argomenti, l'array rimarra semplicemente vuoto, ma la sintassi va messa comunque.

            
*/      

