/*
Java - Metodi

    Cosa sono i metodi ?
    Creiamo un semplice metodo void 
    Parametri dei metodi 
    Il return.

    Di base i Metodi sono Funzioni sono blocchi di codici che vengono richiami ogni volta 
    che dobbiamo fare qualcosa 


 */

//Creiamo un semplice metodo void 
    /* 
    public class parte13_Metodi {

        public  static void main(String[] args){
            faiPasta();
        }

        static void faiPasta(){
            System.out.println("sto cuciando la pasta");
        }
    }
    */

//Parametri dei metodi  sono dati in entrata nella funzione 

  /* 
    public class parte13_Metodi {

        public  static void main(String[] args){
           cucinaPranzo("carne");


        }

        static void cucinaPranzo(String cibo){
            System.out.println("sto cucinando " + cibo);
        }
    }
    */
       public class Parte13_Metodi {

        public  static void main(String[] args){

            addizione(102,3);

            int totaleSpeso = addizione(102,3);
            System.out.println(totaleSpeso);

            int prova = addizione(50,90);
            System.out.println(prova);

        }
        /*essendo void ovvero vuoto vuol dire che la funzione non ritorna nulla 
            esegue qualcosa ma non ritorna un dato o un valore il dato si perde 
            quindi usiamo RETURN risultato cambiamo il void con INT
            dico che mi ritorno un interno non vuoto 
        */ 
        static int addizione(int a, int b ){

            int risultato = a + b;

           return risultato;
        }
    }
