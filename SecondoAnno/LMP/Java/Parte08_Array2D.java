/*
    Java - Array2D

  1  Cosa sono gli array 2?
  2  Creare un array 2D in entrambi i modi
  3  Accedere agli elementi degli array 
  4  Ciclare con for




    1) Sono array di array 
*/

/* 
 public class Parte8_Array2D {

    public static void main(String[] args){
        // int[] numeri = {12,23,45}; array normale

        String[][] classi = new String[3][3];

        classi[0][0] = "Luca";
        classi[0][1] = "Irene";
        classi[0][2] = "Dimu";

        classi[1][0] = "Alex";
        classi[1][1] = "Edoardo";
        classi[1][2] = "Robert";

        classi[2][0] = "Daniele";
        classi[2][1] = "Anna";
        classi[2][2] = "Francesca";

        System.out.println(classi[0][1]);

        //int riga = 0
        
        ovviamente ci serve un for perché sennò si fa troppo lunga

            VISUALIZZIAMO COME UNA TABELLA

                        0       1       2
            riga 0 -> Luca     Irene    Dimu
            riga 1 -> Alex     Edoardo  Robert
            riga 2 -> Daniele  Anna     Francesca
        
        
        for(int classe = 0; classe < classi.length; classe++){
            System.out.println();
            for(int studente = 0;studente < classi[classe].length;studente++){
                System.out.println(classi[classe][studente] + " ");
            }
        }
    }
 }
*/


//Possiamo riscriverlo in un'altra maniera (migliore)

public class Parte8_Array2D {

    public static void main(String[] arg){

        String[][] classi = {
                                {"Luca","Irene","Dimu"}, //classe specifica
                                {"Alex","Edoardo","Robert"},//classe specifica
                                {"Daniele","Anna","Francesca"}, //classe specifica

                            };

                        //queste graffe rappresentano l'array ovvero Le classi
                        //classe lenght vale 3 

                    /* 
                        VISUALIZZIAMO COME UNA TABELLA

                                    0       1       2
                        riga 0 -> Luca     Irene    Dimu
                        riga 1 -> Alex     Edoardo  Robert
                        riga 2 -> Daniele  Anna     Francesca
                    */
                        

        for(int classe = 0; classe <classi.length; classe++){

            System.out.println();

                                            //classi è il complesso mentre classe è la singola riga.lenght
            for(int stundete = 0; stundete < classi[classe].length; stundete++){

                System.out.print(classi[classe][stundete] + " ");
            }
        }  
        
        /*Lo potremmo creare anche con il for each:

            for(String[] classe: classi){
             System.out.println();

                for(String studente: classe){
                    System.out.println(studente + " ");
                }
            }


        */
    }
}