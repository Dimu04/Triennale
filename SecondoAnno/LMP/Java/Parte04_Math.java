/*Java parte 4 -Math class 
alcuni metodi; abs, min, max, pow, sqrt

-ABS sta per absolute quindi valore assoluto valore sempre positivo
-MIN ci aiuta a trovare il minimo
-MAX ci aiuta a trovare il valore massimo
-POW è la potenza come scritto sotto (5,3) lo legge come 5 alla terza
-SQRT ovvero square root o radice quadrata

atributi :PI sta per p greco 
*/

/*
public class Parte4 {
    public static void main(String[] args){

        //System.out.println(Math.abs(-55));
        //System.out.println(Math.min(55,21));
        //System.out.println(Math.max(55,21));
        //System.out.println(Math.pow(5, 3)); 
        //System.out.println(Math.sqrt(25));
        //System.out.println(Math.PI);
        //
    
    }
}
*/

//--------------------------------------------------------------------------------------------------------

/*JAVA PARTE - Operatori di comparazione li usiamo per comparare i numeri 

Operatori:
>
>=
<
<=
==
!=


public class Parte4 {
    public static void main(String[] args){
        
       // boolean risultato = 3>10;
       // boolean risultato = 11>=10;
       // boolean risultato = 3<10;
       // boolean risultato = 10<=10;
       // boolean risultato = 10==10;
        boolean risultato = 9!=10;

        System.out.println(risultato);
    }
}

*/

//-----------------------------------------------------------------------------------------------------------------

/*Java PARTE - OPERATORI LOGICI

OPERATORI: AND OR NOT


*/

public class Parte4_Math {
    public static void main(String[] args){

        //boolean risultato = 3>10 && 10>5; //AND
        //boolean risultato = 3>10 || 10>5; //OR
        boolean risultato = !(3>10); //NOT

        System.out.println(risultato);
    }
}