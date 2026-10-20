/*
    Cosa sono?
    Creiamo diversi metodi con num param differenti

    Creiamo diversi metodi con tipi dato differenti

*/

public class Parte14_MetodiOverloaded {
    public  static void main (String[] args){

        int doppioInt = addizione(2,3);
        int triploInt = addizione(2,3,5);
        double doppioDouble = addizione(2.5, 4.5);

        System.out.println(doppioInt);
        System.out.println(triploInt);
        System.out.println(doppioDouble);
    }

    static int addizione(int a, int b){
        int risultato = a + b;
        return  risultato;

    }
    static int addizione(int a, int b, int c){
        int risultato = a + b + c;
        return risultato;

    }
    static double addizione(double a, double b){
        double risultato = a + b;
        return  risultato;
    }
}