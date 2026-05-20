
### I Mattoni della Memoria (Slide 4-13)

- **Circuiti Sequenziali** : Scrivi solo che, a differenza dei combinatori, l'uscita dipende dallo **stato precedente (S)**.

- **SR LATCH**: Usa l'immagine delle porte NOR retroazionate. Punti chiave S=1 (Set) mette l'uscita a 1, R=1 (Reset) a 0.**Importante** : cita lo stato instabile quando S=R=1.

- **D-Latch & Flip Flop** : Qui è fondamentale la distinzione sulla temporizzazione :
	- *Latch* : Level-triggered (attivo finché il clock è alto).
	- *Flip-Flop* : Edge-triggered (attivo solo sul fronte, salita o discesa).

1) $\text {Il problema dell'ambiguità nel Latch SR}$:
	Nello schema del Latch(Slide 5-6), nota bene lo stato in cui entrambi gli ingressi sono a 1 (S=1, R=1).
	
	- Nelle slide viene indicato come **stato non ammesso** o instabile.
	
	- **Perché è importante?** : Se entrambi i segnali tornano a 0 contemporaneamente, l'uscita del circuito diventa imprevedibile (non sappiamo se "vincerà" il Set o il Reset).

2) $\text {L'evoluzione: Dal Latch SR al Latch D}$ :
	Nelle slide vedrai che viene aggiunto un *inverter* (PORTA NOT) tra i due ingressi (Slide 8-9).
	
	- **Lo scopo** :Serve proprio a eliminare lo stato instabile visto sopra.
	
	- In questo modo, S e R non potranno mai essere 1 contemporaneamente : Se D=1 allora S=1 e R=0, Se D= 0 allora S = 0 e R = 1.
	
3) $\text {Il concetto di Abilitazione (Gated Latch)}$ :
	 Nello schema del **Gated D-Latch**, compare un terzo ingresso chiamato spesso **Clock (CLK)**.
	 
	- Le slide mostrano che l'uscita l'Q cambia solo quando questo segnale è **ALTO**.
	
	- Se il Clock è a 0, il circuito è "bloccato" e mantiene il valore precedente, ignorando quello che succede sull'ingresso D.
	
4) $\text {Il Flip-Flop D (Edge-Triggered)}$
	 Nelle slide finali di questo blocco (12-13), noterai che il simbolo grafico cambia leggermente: compare un **triangolino** sull'ingresso del clock.
	- Questo indica che il circuito non guarda più se il clock è "alto" (livello), ma reagisce solo nell'istante in cui il segnale **passa da 0 a 1** (fronte di salita).
	
	- È la differenza fondamentale tra il "Latch" (sensibile al livello) e il "Flip-Flop" (sensibile al fronte) citata nelle slide.

In sintesi, per l'esame focalizzati su queste 3 differenze visive negli schemi :
1) **SR** : Due ingressi separati (rischio stato instabile).
2)  **D-Latch** : Un ingresso solo + segnale del Clock (trasparente quando il Clock è 1). 
3) **D-Flip-Flop** : Uguale al D-Latch, ma lavora solo sul "fronte" (simbolo col triangolino).


![[Pasted image 20260503104107.png|432]]

![[Pasted image 20260503104127.png|433]]

![[Pasted image 20260503104147.png|435]]

---
### 2. Organizzazione e Chip (Slide 14-23)

- **Matrice di Memoria**: Usa lo schema della memoria a 12- bit per spiegare i segnali di controllo:  **CS** (Chip Select), **RD** (Read/Write), **OE** (Output Enable).

- **Buffer Tri-state** : Spiega che serve a evitare cortocircuiti quando più uscite sono collegate allo stesso bus, introducendo lo stato di **Alta impedenza**.

- **Indirizzamento RAS/CAS** : Non serve descrivere tutto il diagramma, basta dire che dividere l'indirizzo in Riga (RAS) e Colonna (CAS) riduce il numero di pin necessari sul chip, anche se lo rende un po più lento.

In questo secondo blocco ci si sposta dalla logica del singolo bit all'organizzazione di un intero **chip di memoria** e al modo in cui comunica con l'esterno.

1) $\text {Organizzazione della Memoria}$ 
	 Le slide mostrano come i singoli bit vengono raggruppati per formare una **matrice**.
	 
	- **Indirizzamento**: Per selezionare una specifica "cella" o parola, viene usato un **Decodificatore di Indirizzi**.
	
	- **Bus di Dati** : Viene mostrato come i bit escano in parallelo (es 8 o 16 but alla volta).
	- **Segnali di Controllo** : Compaiono tre segnali fondamentali che devi conoscere: 
		- **CS (Chip Select)** : Attiva l'intero chip.
		- **RD/WR (ReaD/Write)** : Decide se stiamo leggendo o scrivendo.
		- **OE (Output Enable)** : Abilita il passaggio dei dati verso il bus esterno.

2) $\text {Il Buffer Tri-state}$
	 Questo è un concetto tecnico cruciale presente nelle slide per spiegare come più componenti convivo sullo stesso filo.
	 
	- Oltre agli stati *0* e *1*, esiste il terzo stato:  **Alta Impedenza (Z)**.
	
	- **Funzione**: Quando un chip non è selezionato (CS = 0), la sua uscita va in Alta impedenza, comportandosi come un interruttore aperto.
	
	- **Utilità** : Impedisce che due chip diversi provino a inviare dati contemporaneamente sullo stesso bus, evitando cortocircuiti.
	
3) $\text {Memorie ad alta densità: RAS e CAS}$
	 Nelle slide si analizza lo schema di una memoria più grande (es. DRAM) dove, per risparmiare pin sul chip, l'indirizzo viene diviso in due parti 
	- **RAS (Row Address Strobe)** : Serve a selezionare la *riga* della matrice di memoria.
	
	- **CAS (Column Address Srobe)** : Serve a selezionare la *colonna*.
	
	- **Multiplexing** :Questo sistema permette di usare metà dei fili per gli indirizzi, inviando prima la riga e poi la colonna in sequenza temporale.

4) $\text {Parametri Temporali}$ 
	 Le slide concludono il blocco con i diagrammi temporali (timing).
	 
	 - **Access Time  (Tempo di Accesso)**: Il tempo che intercorre tra quando la CPU invia l'indirizzo e quando il dato è effettivamente disponibile sul bus.
	 -  **Cycle Time (Tempo di Ciclo)**: Il tempo minimo che deve passare tra due operazioni successive (spesso più lungo del tempo di accesso perché la memoria deve "riposare" o ricaricarsi).

![[Pasted image 20260503104224.png|418]]

![[Pasted image 20260503104241.png|418]]



---
### 3 RAM, ROM e Non-Volatili (Slide 24-27)

1) $\text {RAM (Random Access Memory) - Volatili}$
	Le slide si concentrano sulla distinzione tra le due tecnologie principali:
	
	- **SRAM (Static RAM)**: 
		- Costruite con Flip-Flop (solitamente 6 transistor per cella).
		- Mantengono il dato finché c'è corrente.
		- Sono molto **veloci** ma costose e occupano molto spazio sul chip.
		
	- **DRAM (Dynamic RAM)**:
		- Costruite con un condensatore e un transistor.
		- Il dato è memorizzato come carica elettrica nel condensatore.
		- Poiché la carica "perde", hanno bisogno del **Refresh** (riscrittura periodica del dato).
		- Sono più lente della SRAM ma molto più **dense** (più memoria in meno spazio) ed economiche.
		
2) $\text {ROM (Read Only Memory) - Non Volatili}$
	Le slide presentano l'evoluzione delle memorie che mantengono i dati anche da spente: 
	- **ROM** : Scritte in fase di fabbricazione, non modificabili.
	- **PROM** : Scrivibili una sola volta dall'utente tramite un programma.
	- **EPROM** : Cancellabili tramite esposizione a **raggi UV** e poi riscrivibili.
	- **EEPROM** Cancellabili e riscrivibili elettricamente, ma molto più lente della RAM.
	- **Flash Memory** : Una variante della EEPROM, più veloce e ad alta capacità, usata per chiavette USB e SSD.
	
3) $\text {Tabella Riassuntiva (slide 27)}$
	Questa slide è fondamentale perché mette a confronto i parametri chiave che devi conoscere :
	- **Volatilità** : RAM sì, ROM no.
	- **Metodo di scrittura** : Elettrico per quasi tutte, tranne le ROM/PROM
	- **Cancellabilità** : Indica se e come puoi eliminare i dati (UV per EPROM, elettrico per  EEPROM/Flash).

![[Pasted image 20260430174551.png|466]]

---

### 4 Il BUS e la CPU (Slide 28-40)
Ora descriveremo come i componenti "parlano" tra di loro attraverso il **BUS**. 
Nelle slide 28-40, i concetti chiave sono divisi tra architettura fisica e protocolli di comunicazione.

1) $\text {Il BUS: Definizione e Struttura (Slide 28-30)}$

	Il bus è l'insieme di collegamenti condivisi tra CPU, Memoria e I/O. Si divide in tre parti logiche: 

- *Bus dati* : Porta l'informazione vera e propria 
- *Bus Indirizzi* : Specifica a quale cella di memoria o dispositivo inviare il dato.
- *Bus di Controllo* : Gestisce i segnali di sincronizzazione.

2) $\text {Il Ciclo di Bus (Slide 31-32)}$

	Descrive l'operazione elementare di lettura o scrittura:
	
	1) La CPU (master) mette l'indirizzo sul bus.
	2) Attiva il segnale di controllo.
	3) Il dispositivo (Slave) risponde mettendo o prelevando il dato.

3)  $\text {Bus Sincroni (Slide 33-35)}$

	Nelle slide viene mostrato il diagramma temporale basato sul **Clock**

	- Tutte le operazioni avvengono in corrispondenza degli impulsi del clock.
	- *Vantaggio* : Molto semplice da progettare.
	- *Svantaggio* : "Spreca" tempo perché deve aspettare il ciclo di clock successivo anche se il dispositivo ha già finito. Inoltre, la velocità è limitata dal dispositivo più lento.

4) $\text {Bus Asincroni e l'Handshake (Slide 36-38)}$

	Questo è il concetto più importante del blocco. Non c'è un clock, ma si usano segnali di  "stretta di mano" (Handshake).

	- *MSYN* (Master Sync) : La CPU dice "I dati/indirizzi sono pronti".
	- *SSYN* (Slave Sync) : Il dispositivo risponde "Ho ricevuto/finito".
	- *Flessibilità* : Il bus si adatta automaticamente alla velocità del dispositivo; se un componente è veloce, il ciclo finisce subito.

	
5) $\text {Il problema del "Bus Skew" (Slide 39.40)}$

	Viene citato come limite fisico:
	- I segnali elettrici viaggiano a velocità diverse su fili diversi.
	- Questo può causare errori se un segnale di controllo arriva "prima" che i dati si siano stabilizzati su tutti i fili del bus.


![[Pasted image 20260503104403.png]]

![[Pasted image 20260503104411.png|417]]
### 5 Arbitraggio e Interrupt (Slide 41-48)

In quest'ultimo blocco (41-48) il tema è la gestione dell'ordine: come si decide chi usa il bus e come i dispostivi esterni "chiamano" la CPU quando hanno bisogno di aiuto.

1) $\text {Arbitraggio del Bus (Slide 41-44)}$
	Poiché il bus è una risorsa condivisa, serve un meccanismo per decidere chi lo usa se due o più dispostivi lo richiedono contemporaneamente. Le slide mostrano due metodi principali :
	
	- *Arbitraggio Centralizzato (Daisy Chain)* :
		- C'è un unico controllore (Arbitro).
		- Il segnale di concessione del bus (**Bus Grant**) passa attraverso i dispositivi uno dopo l'altro in una catena fisica.
		- **Punto chiave** : La priorità è determinata dalla **Posizione fisica**; il dispositivo più vicino all'arbitro è quello con la priorità più alta perché ricevere il segnale per primo.
		
	- *Arbitraggio Decentralizzato* : 
		- Non c'è un arbitro centrale
		- Ogni dispositivo ha una propria logica di priorità.
		
2) $\text {Gestione degli Interrupt (Slide 45-47)}$
	Quando un dispositivo di Input/Output (I/O) ha finito un compito o ha un dato pronto, deve avvisare la CPU.

	- *Segnale INT (Interrupt Request)*: Il dispositivo invia una richiesta alla CPU
	- *Segnale INTA (Interrupt Acknowledge)* : La CPU risponde confermando di aver ricevuto la richiesta.
	- *Salvataggio dello Stato* : Nelle slide viene citato che, prima di gestire l'interrupt, la CPU deve salvare il proprio stato (Program Counter e Registri) per poter riprendere il lavoro originale una volta finito.

3)  $\text{Il Controller delle Interruzioni Slide(48)}$
	Le slide chiudono citando un componente storico come esempio : L' Intel 8259A
	- Questo chip fa da "vigile urbano" : riceve molteplici richieste di interrupt dai vari dispostivi, le ordina in base alla priorità e ne invia una sola alla volta alla CPU tramite il pin *INTR*.


![[Pasted image 20260503155818.png|422]]

![[Pasted image 20260503155838.png|419]]