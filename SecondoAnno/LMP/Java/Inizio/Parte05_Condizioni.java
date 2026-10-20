/* Java PARTE 5 - CONDIZIONI IF 
IF
ELSE
ELSE IF
if annidati
ternary operator
*/


/* 
public class Parte5{
    public static void main(String[] args){
        boolean isOnline = false;
    
        if(!isOnline){ //se non è online 
            System.out.println("Non è online");

        }else{
            System.out.println("È online"); // se l'if non viene soddisfatto, allora esegue l'else

        }
    }

}
*/
/* 
public class Parte5{
    public static void main(String[] args){
     String nome = "Anna";

     if(nome == "Luca"){
        System.out.println("È Luca");

     }else if (nome == "Marco"){
        System.out.println("È Marco");
     }else{
        System.out.println("È qualcun altro");
     }
 }
}
*/


/*JAVA TERNARY OPERATOR
Possiamo anche trovare un'alternativa all'if else, che è il ternary operator. è un modo semplice per fare un if 
affinché una variabile abbia un valore piuttosto che un altro 

 
public class Parte5{
    public static void main(String[] args){
        int numero = 10;
        String risultato = (numero > 5) ? "Maggiore di 5" : "Minore o uguale a 5";
        System.out.println(risultato);
    }
}
*/

/*
//Java IF annidati

public class Parte5{
    public static void main(String[] args){
        int numero = 3;

        if(numero < 10){
            System.out.println("È minore di 10");

            System.out.println("Il numero è positivo");
            
            if(numero % 2 == 0){
                System.out.println("Il numero è pari");
            }else{
                System.out.println("Il numero è dispari");
            }
        }else{
            System.out.println("Il numero è negativo o zero");
        }
    }
}
*/

/*
-Ci torna utile fare un if annidato quando vogliamo fare 2 operazioni diverse con 2 condizioni diverse,
    e vedere i passaggi step per step. 
   -Altrimenti un altro modo per fare un if annidato è usare gli operatori logici 
    come && (AND) e || (OR) per combinare le condizioni in un unico if.
    
    Esempio if(numero < 10 && è pari){
          System.out.println("Il numero è pari");

    }
*/


//JAVA Parte 5 - Switch

/*
Sono una sorta di if, ma la differenza è che  l'if è più un vero e falso 
*/

public class Parte5_Condizioni{

    public static void main(String[] args){
        String nome = "Luca";

        switch(nome){
            case "Luca":
                System.out.println("ciao Luca");
                break; //Break serve per rompere lo swtich per non andare oltre.
            case "Marco":
                System.out.println("ciao Marco");
                break;
            case "Anna":
                System.out.println("ciao Anna");
                break;
            default: //default serve per gestire il caso in cui nessuno dei case è soddisfatto
                System.out.println("Ciao chiunque tu sia");
        }
    }

}