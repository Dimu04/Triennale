
 /*Java 3 - Operazioni aritmetiche
    operazioni aritmetiche + - / * %
    shorthand
    incremento e decremento 
    esempi di espressioni
 */


//basi basi
/* 
public class Parte3 {
        public static void main(String[] args){
            int x = 10;
            int y = 3;
            int z = x + y;  //ovviamente al posto di più possiamo mettere qualsiasi altro segno (a parte per il modulo che ci printa il resto)
                            // come trovare un numero pari ? il modulo diviso altro è 0  

            System.out.println(z);
           // System.out.println(x+y);

        }
}
*/

/* 
//Shorthand 
public class Parte3 {
        public static void main(String[] args){
            int x = 10;
            x += 3; //shorthand abbiamo semplicemente incrementato esiste anche, -=, *=, /=,

            System.out.println(x);
        }
    }
*/

//INCREMENTO E DECREMENTO
/*
public class Parte3{
    public static void main(String[] args){
        int x = 11;
        x++; //incremento di 1 e x-- decremento di 1 la useremo spesso nei cicli

        System.out.println(x);
    }       
}
*/

//Espressioni 

public class Parte3{
    public static void main(String[] args){
        int x = 11;
        int y = 3;
        int z = 9;
        int risultato = ((3+ x) *y +(4-2)) * z;
        System.out.println(risultato);
    }
    
}