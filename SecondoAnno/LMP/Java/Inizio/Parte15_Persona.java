

/*
public class Parte15_Persona{


/* 
    //BLOCCATO = PRIMA PROVA DI CREAZIONE DI UNA CLASSE

    //Queste sotto elecante vengono considerati "CAMPI"
    String nome = "Luca";
    String cognome = "Rossi";
    int eta = 22;
    String colorePreferito = "Blu";

    //I metodi o funzioni scritte dentro le classi sono un metodo e vengono eseguite solo dalle classi

    //Qua sotto troviamo i METODI

    
    void saluta(){
        System.out.println("Ciao sono " + nome);

    }
    void cammina(){
        System.out.println("Sto camminando ...");
    }

    
    Riconosciamo un metodo per via delle parentesi tonde dopo il nome e 
    un blocco di codice tra graffe, mentre un campo è solo una variabile
    dichiarata senza parentesi.
    

    Riassunto : La classe è il PROGETTO, i campi sono i DATI dell'oggetto e 
                i metodi sono le cose CHE L'OGGETTO SA FARE.
    
    
                
}
*/


//COSTRUTTORE DI UNA CLASSE


    public class Parte15_Persona {

        String nome;
        String cognome;
        int eta;
        String colorePreferito;

        Parte15_Persona(String nome, String cognome, int eta, String colorePreferito){

            this.nome = nome;
            this.cognome= cognome;
            this.eta = eta;
            this.colorePreferito = colorePreferito;
        }
            /* 
              This è un riferimento all'oggetto che si sta usando in quel momento
            Si usa quando il nome di un parametro è uguale a quello di un campo
            this.nome è il campo dell'oggetto, mentre nome da solo è il parametro
            ricevuto dal costriuttore. Così this.nome = nome; significa 
            "Copia il valore ricevuto dentro il campo di questo oggetto"    


            This.nome è il CAMPO di String nome;
            */
 }



/* SCOPE delle variabilià

    Scope(Ambito di visibilità) è la porzione di codice in cui una variabile esiste 
    e può essere usata. Una variabile nasce quando la dichiari e muore alla chiusura
    del blocco di graffe {} in cui è stata dichiarata. Fuori da quel blocco il compilatore
    non la conosce più e dà errore. 

   Scope: la parte di codice in cui una variabile esiste.

    Campo (spesso detto “globale”):
        dichiarato nella classe, fuori dai metodi.Lo vedono tutti i metodi della classe.


    Locale: 
        dichiarata dentro un metodo o un blocco { } (anche un for o un if). Esiste solo lì e sparisce alla chiusura delle graffe.
*/


/*
    //ESEMPIO
    public class Parte15_Persona{

            String nome; //Scope globale 
            
            Persona16_OOP(String nome, String cognome, int eta, String colorePreferito){

                this.nome = nome;
            }

        void addizione (int a, int b ){

            int risultato = a + b; //Scope Locale

            System.out.println("Il risultato è " + risultato);

        }
        void qwerty(){
            System.out.println("Il risultato è " + this.nome);
        }
        

    }
        
*/


