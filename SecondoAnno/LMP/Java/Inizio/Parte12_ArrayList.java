/*

Le arraylist sono array ridimendionabili, accettano però solo reference 
Creare un ArrayList
Aggiungere elementi add()
Mandare a schermo elemnti get()
Modificare elementi set()
Rimuovere elementi remove(), clear()
Arraylist 2D



*/



/* 

import java.util.ArrayList;

public class Parte12_ArrayList {
    public static void main (String[] args){
        ArrayList<String> persone = new ArrayList<String>();
        persone.add("Luca");
        persone.add("Dimu");
        persone.add("Anna");
        

        //modificare gli elementi
        //Primo valore nella parentesi prende l'indice o la posizione dell'elemento da modificare 

        persone.set(2, "Irene");
        persone.remove(0);
        //persone.clear(); //rimuove tutti






        for(int i= 0; i< persone.size(); i++){

            System.out.println(persone.get(i));
        }
    }
}


*/

//PROVA CON GLI INT
/* 
import java.util.ArrayList;

public class Parte12_ArrayList {

    public static void  main(String[] args){
        ArrayList<Integer> persone = new ArrayList<Integer>();
        persone.add(1);
        persone.add(100);
        persone.add(1000);
    
        for(int i = 0; i < persone.size();i++){
            System.out.println(persone.get(i));
        }
    }
}
*/

import java.util.ArrayList;

public class Parte12_ArrayList {

    public static  void  main (String[] args){
        
        ArrayList<ArrayList<String>> classi = new ArrayList<>();

        ArrayList<String> classe1 = new ArrayList<String>();

        classe1.add("Luca");
        classe1.add("Giacomo");

         ArrayList<String> classe2 = new ArrayList<String>();

        classe2.add("Anna");
        classe2.add("Mario");

        classi.add(classe1);
        classi.add(classe2);

        for(int i = 0; i < classi.size();i++){
            System.out.println();
            for(int j = 0; j<classi.get(i).size(); j++){
                System.out.println(classi.get(i).get(j) + " ");
            }
        }

    }
}