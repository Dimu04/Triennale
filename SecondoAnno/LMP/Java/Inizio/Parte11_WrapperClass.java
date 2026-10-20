/*
Le wrapper class permettono di usare dati primitivi come reference 
boolean -> Boolean
char -> Character
int -> integer
double -> Double


La differenza sta in cosa contiene la variabile.

Primitivi (int, double, char, boolean, e gli altri quattro: byte, short, long, float). 
    La variabile contiene direttamente il valore.

Reference (tutto il resto: String, array, oggetti delle classi, ecc.). 
    La variabile contiene un riferimento, cioè una specie di indirizzo, a un oggetto che sta altrove in memoria.


Le wrapper class sono classi che “avvolgono” un tipo primitivo in un oggetto (int diventa Integer, double diventa Double, e così via).
 Danno accesso a dei metodi utili, ma sono più lente dei primitivi. Le scriviamo come un tipo di dato diverso perché per Java sono dei veri reference, cioè oggetti. 
 Java però ci aiuta con l’autoboxing: quando assegniamo un primitivo a una wrapper, lo impacchetta in automatico,
 e quando ci facciamo dei calcoli lo spacchetta (unboxing) e usa il valore come primitivo. 
 Questo continuo impacchettare e spacchettare, insieme alla creazione dell’oggetto in memoria, 
 è il motivo per cui sono più lente.
   

*/


/* 
public class Parte11_WrapperClass {

    public static void main(String[] args) {
        
        Boolean vero = true;

        boolean falso = true; //primitiva
    
        Character carattere = 'a';

        Integer numero = 5;

        Double virgola = 5.23;

        String stringa = "Bel corso";

        //grazie alla wrapper class sono diventate reference

        boolean a = true;
        char b = 'a';
        int c = 5;
        double d = 5.23;
        
        if (vero == a) {
            System.out.println("prova");
            
        }
    }

   
    
}
*/