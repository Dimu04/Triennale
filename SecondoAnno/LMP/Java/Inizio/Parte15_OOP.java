/*
    Java - Introduzione OOP

    -Cos'è la programmazione ad oggetti
    -classi, metodi e attributi
    -cosa sono gli oggetti e le istanze di classe 
    -usare attributi e metodi 


    1) La programmazione ad oggetti è una programmazione che si prefissa di suddivedere il nostro programma
        secondo diversi tipi di oggetti, andiamo a creare delle entità che esistono nella vita reale ma li andiamo 
        a trattare come se fossero oggetti nella programmazione. Ad esempio il mio mouse ha delle caratteristiche 
        come il mio computer, dimensione, schede grafiche, colori ecc ecc, perfino persino persone e animali li possiamo
        chiamare oggetti in programmazione, oggetto = persone, caratteristiche = età, nome, cognome ecc, mentre i 
        metodi e funzioni saranno tipo camminare, pensare e altro, il concetto è prendere roba che esiste nella vita 
        reale e trasformarla in oggetti 

*/

/* 

public class Parte15_OOP {


    //dobbiamo creare un istanza della classe
   public static void main(String[] args) {
    

    Persona16_OOP persona1 = new Persona16_OOP(); 

    Persona16_OOP persona2 = new Persona16_OOP();

    //Entrambi questi oggetti di tipo persona sono istanze della classe persona   sono derivate dallo stampino Persona16_OOP

    //scrivendo persona1. ottendiamo tutti i metodi
    
    persona1.saluta();
    persona1.cammina();

    System.out.println(persona1.nome);

    System.out.print(persona2.nome);
   }
    

}

*/

//-----------------------------------------------------------------------------------------------------------


//ESEMPIO di uso di this.



public class Parte15_OOP {

    public static void  main(String[] args){

        Parte15_Persona persona1 = new Parte15_Persona("Luca", "Rossi", 25, "blu");    
        Parte15_Persona persona2 = new Parte15_Persona("Marco", "Giano", 13, "rosso");     


        System.out.println(persona1.nome);
        System.out.println(persona2.nome);
    }
}


//-----------------------------------------------------------------------------------------------------------