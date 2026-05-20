
1)  $\text {Le Basi: Algebra di Boole e Porte Logiche (Slide 1-15)}$

	 In questo blocco si stabilisce il legame tra matematica e circuiti elettrici 
	 - *Il Dominio Digitale (Slide 1-5)* : Si spiega perché il computer è binario. La scelta non è filosofica ma tecnica: è più facile distinguere tra "acceso" e "spento" che tra dieci livelli di tensione diversi.
	 
	 - *Tabella di Verità e Funzioni (Slide 6-10)* :Ogni circuito viene prima progettato su carta come una funzione matematica. Viene introdotto il concetto che con n variabili di ingresso, la tabella deve coprire 2^n combinazioni.
	 
	 - *Le Porte Fisiche (Slide 11-15)* : Vengono presentati i simboli di AND, OR e NOT.
		 - *Punto chiave* : La *porta NAND* (o NOR) è definita "universale" perché, combinandola opportunamente, può sostituire qualsiasi altra porta, semplificando la produzione dei chip.


2) $\text {Circuiti Combinatori: MUX e Decoder (Slide 16-25)}$
	Qui studiamo i componenti che non hanno memoria, ma che "smistano" i segnali.
	- *Il Multiplexer - MUX (Slide 16-20)*
		- *Struttura:* Molti ingressi, una sola uscita e linee di selezione.
		- *Logica* : Le linee di selezione decidono quale binario d'ingresso viene collegato all'uscita.
		
	- *Il Decoder (Slide 21-23)* :
		- *Struttura* : n ingressi e 2^n uscite.
		- *Ruolo* : Prende un numero binario (indirizzo) e "accende" solo la linea corrispondente. È il componente che permette alla CPU di scegliere una specifica cella di memoria tra milioni disponibili.
		
	- *Comparatore e Shifter (Slide 24-25)* :
		- Il *Comparatore* emette 1 solo se due sequenze di bit sono identiche.
		- Lo *Shifter* sposta i bit a destra o sinistra, operazioni fondamentale per calcoli veloci e manipolazione di dati.
		


 3)  $\text {Aritmetica e il Cuore del Calcolo (Slide 26-34)}$
	 Come si passa dai bit ai numeri e alle operazioni.
	 - *Sommatori (Slide 26-30)*.
		 - *Half Adder*: Gestisce solo due bit.
		 - *Full Adder*: Il "mattoncino" reale. Accetta un bit di riposto in ingresso ($C_{in}$), permettendo di collegare più sommatori in serie per sommare numeri a 32 o 64 bit.
	
	 - *ALU* - *Arithmetic Logic Unit* *(Slide 31-34)*.
		 - È un grande circuito combinatorio che racchiude tutte le operaizoni precedenti (somma, AND, OR, ecc).
		  - *Segnali di Controllo* : La CPU invia un codice alla ALU per dirle quale operazione attivare sui dati presenti in ingresso.
		  
4) $\text {Circuiti Sequenziali e Memoria (Slide 35-45)}$
	Il passaggio più difficile : come fa un circuito a "ricordare" ? 
	- *Il Latch SR (Slide 35-38)* :
		- Viene mostrato come "incrociando" due porte logiche (retroazione) l'uscita dipenda non solo dall'ingresso attuale, ma anche dal valore che l'uscita aveva un istante prima.
		
	- *Clock e Sincronizzazione (Slide 39-40)* :
		- Si introduce il *Clock* il metronomo del sistema che garantisce che tutti i componenti cambino stato nello stesso momento, evitando errori di lettura.
		
	- *Flip-Flop D Slide (41-43)*
		- È l'evoluzione del latch. Memorizza il dato in ingresso solo quando il clock glielo ordina (solitamente sul fronte di salita). È l'unità base di ogni memoria RAM.
		
	- *Registri (Slide 44-45)* 
		- Semplicemente un gruppo  Flip-Flop F che lavorano insieme per memorizzare una parola intera (es 64bit).
		
5)  $\text {Organizzazione della Memoria}$
	Come i registri diventano un sistema complesso.
	- *Indirizzamento* : Le slide mostrano come combinare un Decodcer con una griglia di Flip-Flop.
	- *Efficienza* : Si spiega che organizzare la memoria in una matrice (righe e colonne) permette di gestire enormi quantità di dati usando meno fili elettrici.