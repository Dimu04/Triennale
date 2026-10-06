#Architettura 

## Memoria

E' un componente fondamentale per memorizzare DATI e ISTRUZIONI.

Per costruire un circuito che memorizza dati, è necessario utilizzare **CIRCUITI SEQUENZIALI** con Output = Input + Stato Circuito.

---
### Latch 

Il *Latch* è un Circuito Sequenziale realizzabile con 2 NOR oppure 2 NAND: 

![](../../../imm/image-208.png)


---
### SR-Latch

E' un circuito in grado di FISSARE gli 1 bit in output in base ai valori degli input e di MANTENERLI anche quando gli input tornano a 0.

Input: S,R 
Output: Q, not Q

![](../../../imm/image-209.png)


---
### SR-Latch Clocked

Ha un INPUT AGGIUNTIVO = *Clock* --> fa in modo che in passaggi di STATO accadano SOLO in SPECIFICI MOMENTI, quando il clk passa da 0 a 1.

![](../../../imm/image-210.png)

---
### D-Latch Temporizzato

Memoria ad 1 bit il cui valore memorizzato è sempre disponibile sulla linea Q; 
1 solo INPUT = D --> per caricarlo occorre spedire un impulso positivo sul clk.

![](../../../imm/image-211.png)

---

### Generatore di Impulsi

Dispositivo che PRODUCE IMPULSI ELETTRICI per studiare il comportamento dei CIRCUITI STRUTTURA: **AND** + **INVERTER** che ritarda il segnale di uno dei 2 ingressi.

![](../../../imm/image-212.png)

---

### Flip-Flop

Consente di campionare il valore di una certa linea in un particolare ISTANTE e MEMORIZZARLO.
La transizione di STATO si verifica quando il clk passa da 0 ad 1 e VICEVERSA.
Contiene un INVERTER (porta NOT) che modifica il valore di clk.

Da qui otteniamo:
### D-FlipFlop

E' un circuito costituito da 2 **D-Latch** in sequenza collegati ad 1 unico CLOK che:
- Entra negato nel Master.
- Entra asserito nello Slave.

D = Stato Attuale (input)
Q = Stato Futuro (output)

![623](../../../imm/image-213.png)

Durante il passaggio del CLK da 0 a 1, il FlipFlop fa passare il valore di D in Q.

---


### Organizzazione della memoria --> Registri

Per un **REGISTRO** ad 1 Byte si possono utiilizzare 8 *D-FlipFlop*.

Per le *memorie di grandi dimensioni*: 

- Si utilizza 1 Indirizzo per Cella, per localizzare.

- Ogni cella contiene lo stesso numero di bit.

- Il circuito usa: 
	- 2 BIT ($A_0$ , $A_1$) per indirizzare le celle.
	- 3 BIT ($I_0$ , $I_1$ , $I_2$ ) per l'ingresso della parola.
	- 3 BIT ($O_0$ , $O_1$ , $O_2$)  per l'uscita della parola.
	- 3 SEGNALI di CONTROLLO: 
		1.  *CS* (CHIP SELECTOR) per selezionare il circuito.
		2.  *RD* (READ) per specificare il tipo di operazione : RD = 1 legge, RD = 0 scrive.
		3.  *OE* (OUTPUT ENABLE) per abilitare le uscite.

![642](../../../imm/image-214.png)


La **Dimensione della Memoria** è $2^n * m$  bits con *n* = # linee di indirizzamento , *m* = # bit di informazione per ogni cella.

--- 

### Operazioni di connessione Input / Output

- Collegare più input non crea problemi 
- Collegare più output --> *Rischio Cortocircuito* (anche in scrittura poiché gli ingressi di I/O occupano le stesse linee).

$\Longrightarrow$ Per risolvere il problema esistono 2 soluzioni: 

1.  **Open Collector** : Porta logica che permette di collegare più uscite insieme. 

2. **Buffer Three-State** : Porta logica che si comporta come un' *interruttore*, Abilita (lettura) oppure Disabilita (scrittura) il passaggio del segnale.
  
 (*Buffer Three-State* = aggiunge un terzo stato speciale controllato da una linea di abilitazione spesso chiamato ENABLE o OE- Output Enable)



 ---

### Chip di Memoria

E' un circuito integrato che contiene milioni di TRANSISTOR e CONDENSATORI.

Hanno schemi <span style="color:rgb(0, 176, 240)">riutilizzabili</span> e <span style="color:rgb(0, 176, 240)">facilmente espandibili</span>. 
Per la *LEGGE di MOORE* "il # di bit che si può INSERIRE in 1 CHIP raddoppia all'incirca ogni 18 mesi".

Esistono 2 tipi di segnali: 
1. Logica Positiva --> Attivi quando sono ad Alto livello. 
2. Logica Negativa --> Attivi quando sono a Basso livello.

Un computer ha MOLTI CHIP  --> Bisogna definire *Segnali Fondamentali*.

- *CS* (CHIP SELECTOR) per selezionare il chip da attivare.
- *WE* (WRITE ENABLE) per determinare il tipo di operazione di accesso alla Memoria.
- *OE* (OUTPUT ENABLE) per fondere insieme gli output.


---

## RAM statica e dinamica (Volatili)

Le *RAM* (Random Access Memories) sono memorie **volatili** che hanno lo stesso tempo di accesso, perdono i dati senza corrente.

Esistono 2 tipi di RAM: 

1. **SRAM**  (Static RAM) -> Vengono costruite con circuiti simili ai *D-FlipFlop*, mantengono le informazioni finché sono alimentate.
   Sono molto veloci, vengono utilizzate per la *CACHE* L1/L2/L3.

2. **DRAM** (Dynamic RAM) -> Non utilizzano Flip-Flop ma un *ARRAY* di celle con un transistor e un condensatore, sono più complesse delle SRAM a livello hardware. (**RAM del PC**).


---

## Chip di Memoria NON Volatile

Esistono vari tipi di memorie non volatili:

**Memoria NON Volatile (es. SSD, Hard Disk, Chiavetta USB, Flash):** È come **scrivere con il gesso su una lavagna**. Una volta scritto, puoi spegnere le luci della stanza e andartene: quando torni domani e riaccendi la luce, la scritta è ancora lì.

1. **ROM**  (Read Only Memory) -> Sono memorie a *SOLA LETTURA*, il contenuto NON CAMBIA quando non c'è corrente.

2. **PROM**  (Programmable Rom) -> Rom programmabile una sola volta bruciando dei fusibili al suo interno.
   
3. **EPROM** (Erasable ROM) -> Prom riprogrammabile attraverso l'esposizione di raggi ultravioletti per 15 minuti. 
   
4.  **EEPROM** (Electrically Erasable ROM) -> EPROM riprogrammabile attraverso un impulso elettrico, vengono utilizzate per la *MEMORIA FLASH*.


---

## Chip della CPU 

Le CPU moderne sono contenute in 1 CHIP dotato di  **PIN**  con cui la CPU comunica con l'esterno.  

I *Pin* sono connessi agli altri componenti tramite il **BUS**. 
Inoltre sono divisi in 3 categorie:
-  **Indirizzo**.
-  **Dati**.
-  **Controllo**.

Il <span style="color:rgb(0, 176, 240)">processo di esecuzione</span> di un'<span style="color:rgb(0, 176, 240)">istruzione</span> dalla <span style="color:rgb(0, 176, 240)">CPU</span>:

 1.  Pone l'indirizzo di memoria sul *Bus Indirizzi*.
    
 2. La CPU informa la MEMORIA che vuole eseguire un'operazione di lettura tramite le linee di controllo.
    
 3. La MEMORIA risponde mettendo la parola sul *Bus Dati* e Asserisce un Segnale per avvisare che l'operazione è stata svolta.
    
 4. La CPU riceve il segnale, legge i DATI e si predispone per l'ESECUZIONE.

---

### Pin della CPU 

Le prestazioni di una CPU dipendono dal # di *PIN* per **INDIRIZZAMENTO** e **DATI**.

I *PIN* di **CONTROLLO** possono essere raggruppati in: 
- Interruzioni
- Arbitraggio Bus
- Controllo Bus
- Comunicazione con CoProcessore
- Stato 
- Altro

---
 
## Bus del Calcolatore

E' un <span style="color:rgb(0, 176, 240)">collegamento elettrico </span>COMUNE che unisce i vari dispositivi di un calcolatore.

Può essere **INTERNO** oppure **ESTERNO** alla CPU.

- **Interno** -> connette i registri alla ALU (lezione 2).
- **Esterno** -> connette la MEMORIA alle periferiche di I/O.


### Configurazione dei Bus Esterni

Alcuni dispositivi sono detti **ATTIVI** (MASTER) $\Rightarrow$ Possono iniziare il TRASFERIMENTO DATI sul Bus, altri sono detti **PASSIVI** (SLAVE) $\Rightarrow$ rimangono in attesa di richieste dal MASTER.

I **BUS DATI** sono dotati di <span style="color:rgb(0, 176, 240)">CHIP</span> <span style="color:rgb(0, 176, 240)">di</span> <span style="color:rgb(0, 176, 240)">INTERFACCIAMENTO</span> e per evitare il problema di connettere più uscite insieme vengono utilizzate porte logiche come *Buffer Three-State* oppure il collegamento di più porte *Open Collector*.

(Buffer Three-State = aggiunge un terzo stato speciale controllato da una linea di abilitazione spesso chiamato ENABLE o OE- Output Enable)
- Di  base avremmo stato 1(ALTO),Stato 2(BASSO) e lui aggiunge Stato ad Alta impedenza
 
Oltretutto esistono: 
- Bus **DRIVER** -> amplifica il segnale da Master a Slave.
- Bus **RECEIVER** -> collega più Slave ai Master.


### Differenza tra Ampiezza e Larghezza di Banda nei Bus

**Ampiezza del Bus** --> E' la capacità fisica del bus, descrive il # di bit dati trasferibili in 1 ciclo di clock e il # di linee fisiche che compongono il bus dati.
Se un Bus ha *n* linee di ADDRESS $\Rightarrow$ la CPU può indirizzare almeno $2^n$ locazioni di memoria.

**Larghezza di Banda** --> E' la velocità di trasferimento effettiva, indichiamo con u = MB/s, è la quantità massima di dati trasferibili nell'u di tempo.
Per incrementare la larghezza di banda possiamo: 
1. <span style="color:rgb(0, 176, 240)"> Ridurre il periodo di CLK del Bus</span>: 
	-  <span style="color:rgb(146, 208, 80)">Pro</span>: Bus più veloci.
	- <span style="color:rgb(255, 0, 0)">Contro</span>:  
		- *Disallineamento bus* --> segnali su linee diverse hanno velocità diverse.
		- *Perdita di retrocompatibilità* --> le schede progettate per bus più lenti non funzionano su quelle più veloci.
		- 
2.  <span style="color:rgb(0, 176, 240)">Incrementare l'ampiezza del bus DATI</span>:
	 Utilizzando il MULTIPLEXING delle linee per DATI e INDIRIZZI, rallentando il sistema.


### Temporizzazione del Bus

Esistono 2 approcci: 

-  **BUS SINCRONI** --> Utilizzano un clock che determina la temporizzazione delle attività sul bus (ciclo di clock): ogni operazione richiede un numero di periodi di clock per essere eseguita.
- Ad ogni singolo "ticchettio" (che in termine tecnico si chiama **Fronte di Clock** o _Clock Edge_), **tutti i dispositivi collegati al bus avanzano contemporaneamente allo step/operazione successivo.**

Operazioni: 

  1.  La CPU (Master) pone l' indirizzo di memoria sull' *address bus*.
  2. La CPU comunica al SISTEMA che vuole svolgere un'operazione con la MEMORIA.
  3. La CPU comunica che si tratta di un'operazione di LETTURA, allora la MEMORIA (Slave) deve fornire sul *data bus* il contenuto della cella indirizzata dall'*address bus*.
  4. La Memoria chiede un WAIT-STATE (memoria + lenta della CPU).
  5. Quando la Memoria è pronta, nega il segnale di WAIT, così la CPU può leggere.
  6. La CPU legge i dati.

- **BUS ASINCRONI** --> Non c'è un CLOCK principale, il ciclo può avere qualsiasi durata (+efficiente ma + difficile da eseguire). Utilizza una "tecnica" chiama *Handshaking* ovvero. Effettua queste 4 operazioni 

Operazioni:

Devono scambiarsi dei segnali di conferma espliciti (**Handshake a 4 fasi**):

1. **Master:** Metto l'indirizzo e attivo il segnale di richiesta (**`MSYN`** - _Master Sync_).
    
2. **Slave:** Vedo `MSYN`, prelevo il dato e attivo il segnale di risposta (**`SSYN`** - _Slave Sync_).
    
3. **Master:** Vedo `SSYN`, prelevo il dato e disattivo `MSYN`.
    
4. **Slave:** Vedo che `MSYN` si è spento e disattivo `SSYN`.

### Arbitraggio del Bus

Ogni dispositivo può diventare a turno MASTER del Bus.
--> L'arbitraggio del Bus impedisce che più dispositivi possano diventare Master contemporaneamente.

Esistono 2 tipi di Arbitraggio del bus: 

-  **Arbitraggio Centralizzato** --> Attraverso un <span style="color:rgb(0, 176, 240)">ARBITRO</span>, quando esso riceve una richiesta la concede: Asserendo una linea di *CONCESSIONE del Bus*. 
   Quando il dispositivo più vicino vede la concessione: 
	- Se la richiesta è stata inoltrata da lui, ogni altra linea viene negata.
	- Altrimenti mantiene la linea asserita.
	
	Nel caso uno o più dispositivi facessero richiesta, *vince il più vicino all'arbitro*: <span style="color:rgb(0, 176, 240)">PRIORITA' CABLATA</span>.
	Contrapposta all' <span style="color:rgb(0, 176, 240)">Arbitraggio con più Linee di Priorità</span>, in cui sono definiti dei livelli di priorità utilizzando diverse linee Richiesta-Concessione. L'arbitro concede la richiesta al disp. con *PRIORITA' più ALTA*.

(La foto ci mostra un arbitraggio centralizzato prorpio la DAISY-CHAINING)

![[Pasted image 20260926224744.png]]

- **Arbitraggio Decentralizzato** --> Ogni dispositivo ha una *propria linea di richiesta* e di *priorità* .
	-   Prima di richiedere il bus, ciascuno deve verificare che NON CI SIA una richiesta con PRIORITA' più ALTA.
	- Al termine dell'utilizzo del bus, la linea di richiesta deve essere negata.
	Lo svantaggio è di avere troppi collegamenti e linee.
	
	Uno **SCHEMA ALTERNATIVO** è caratterizzato da 3 linee: 
	
	1. Linea RICHIESTA del Bus.
	2. Linea BUSY.
	3. Linea Arbitraggio.
	Per ottenere un Bus, un dispositivo deve: 
	
	1.	 
		- Verificare che <span style="color:rgb(0, 176, 240)">BUSY</span> sia <span style="color:rgb(255, 0, 0)">negata</span>.
		- Verificare che <span style="color:rgb(0, 176, 240)">IN</span> sia <span style="color:rgb(146, 208, 80)">asserito</span>.
	1. 
		- Negare <span style="color:rgb(0, 176, 240)">OUT</span>.
		- Asserire <span style="color:rgb(0, 176, 240)">BUSY</span>.
		- Diventa <span style="color:rgb(0, 176, 240)">MASTER</span>.
	2. 
		- Asserire <span style="color:rgb(0, 176, 240)">OUT</span>.
		- Negare <span style="color:rgb(0, 176, 240)">BUSY</span>.


### Interrupt Handling

Esiste un CICLO di BUS dedicato alla **gestione degli INTERRUPT**.

La CPU ordina ad un Disp. di effettuare un'operazione, che viene terminata tramite un Bus che invia un *segnale di INTERRUPT*.

Il <span style="color:rgb(255, 0, 0)">PROBLEMA</span> che si pone è che più dispositivi richiedano di generare un *interrupt* contemporaneamente.
La <span style="color:rgb(146, 208, 80)">SOLUZIONE</span> prevede di assegnare PRIORITA' ai disp. mediante <span style="color:rgb(0, 176, 240)">ARBITRO CENTRALIZZATO</span>.

- Quando più dispositivi richiedono *INTERRUPT*, il controllore ASSERISCE il segnale <span style="color:rgb(0, 176, 240)">INT</span> alla CPU. 
- Se la CPU può gestire la richiesta, RISPONDE con il segnale <span style="color:rgb(0, 176, 240)">INTA</span>.
- Il CONTROLLORE pone sul <span style="color:rgb(0, 176, 240)">Data BUS</span> il # del Dispositivo richiedente l'INTERRUPT.
- La CPU utilizza il numero (#) per accedere al <span style="color:rgb(0, 176, 240)">VETTORE DI INTERRUZIONE</span> e trovare l'indirizzo della <span style="color:rgb(0, 176, 240)">ISR</span>.


### Differenza tra interrupt preciso e impreciso 
- **Interrupt Preciso:** La CPU completa tutte le istruzioni precedenti all'interrupt, annulla quelle successive già uscite nella pipeline e salva un Program Counter ($PC$) pulito. Il programma sospeso potrà **riprendere esattamente da dove si era fermato**.
    
- **Interrupt Impreciso:** A causa dell'esecuzione fuori ordine (_out-of-order_) o parallela nella pipeline, alcune istruzioni successive all'interrupt sono già state eseguite e hanno modificato i registri. **Il programma non può essere ripreso in modo sicuro** e viene solitamente terminato (crash


(Nota)
"Il **Bus DDR4** (Double Data Rate 4) è un bus di memoria di tipo **sincrono** a 64 bit che raddoppia l'efficienza del trasferimento dati trasmettendo informazioni **sia sul fronte di salita che sul fronte di discesa** del segnale di clock."


(domande fatte da me )
mentre per i chip della cpu diciamo che la cpu è contenuta dentro un chip dotato di PIN, pin che viene collegato ad altre componeneti come i 3 diversi bus nel sistema ovvero bus indirzzo, dati e di controllo e ciò permette alla cpu di comunicare all'esterno 

quindi se volessi fare un riassunto posso dire che l'arbitraggio centralizzato di basa su un chip chiamato arbiter o arbitro che sta al centro e gestisce le priorità in base a dove sono effettivamente collocate le richieste quindi se una richiesta è più vicina rispetto ad un'altra quest'ultima ha la priorità 

una domanda ma questo daisy chain non ha una grossa falla ? ceh se l'arbitro concede la priorità in base all'ubicazione del segnale se io ricevessi 2 segnali okay? segnale A è il più vicino subito dopo segnale B lontano in questo caso passa prima A e poi B ma se nel momento in cui passa A all'improvviso spunta fuori segnale C che è più vicino di B cosa accade ? passa ulteriormente in secondo piano B ? 


### Come si risolve questo problema nei sistemi moderni?

Proprio per evitare la _starvation_, nei computer moderni la Daisy Chain è stata quasi del tutto sostituita dall'**Arbitraggio a Richieste Indipendenti** con algoritmo **Round-Robin (a rotazione)**:

> Invece di dare sempre la precedenza a chi è più vicino, l'arbitro si segna chi ha appena usato il bus e lo sposta in fondo alla coda di priorità. In questo modo **tutti i dispositivi hanno la garanzia matematicamente certa di poter trasmettere**, a prescindere da dove si trovano fisicamente sulla scheda madre.