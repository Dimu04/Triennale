
public class Parte16_pizza {

    String impasto;
    String salsa;
    String formaggio;
    String extra;
    String extra2;

    //Costruttore
    
    /*
    -Questo è un chiaro esempio di Overloaded Costructors 
        notiamo anche come noi possiamo anche continuare ad aggiungerne altri
        a patto che non abbiamo la stessa forma come vediamo qua sotto.

    
    */

    Parte16_pizza(String impasto){

        this.impasto = impasto;
        System.out.println("Ingredienti: " + impasto);
    }

    /* 
    Parte16_pizza(String impasto){  //SE LO SCRIVESSIMO 2 VOLTE DI FILA DAREBBE ERRORE 
    
        this.impasto = impasto;

    }
    */
     

    Parte16_pizza(String impasto, String salsa, String formaggio){

        this.impasto = impasto;
        this.salsa = salsa;
        this.formaggio = formaggio;

        System.out.println("Ingredienti: " + impasto + "," + salsa + ", " + formaggio );
    }




    Parte16_pizza(String impasto, String salsa, String formaggio, String extra){

        this.impasto = impasto;
        this.salsa = salsa;
        this.formaggio = formaggio;
        this.extra = extra;

        System.out.println("Ingredienti: " + impasto + "," + salsa + ", " + formaggio + ", " + extra );
    }
   Parte16_pizza(String impasto, String salsa, String formaggio, String extra, String extra2){

        this.impasto = impasto;
        this.salsa = salsa;
        this.formaggio = formaggio;
        this.extra = extra;
        this.extra2 = extra2;

          System.out.println("Ingredienti: " + impasto + "," + salsa + ", " + formaggio + ", " + extra + ", " + extra2 );
    }

}


