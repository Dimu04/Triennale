#archittettura 
# Processori

-Cos'è la *CPU* , è il  *Central Processing Unit* ed è il cervello del computer.
#### Cosa contiene la *CPU* ? 

- L'*Unità di Controllo (CU)* 
- L'*Unità Aritmetica e Logica (ALU)*
- E contiene anche alcuni registri (piccolissime unità di memoria)
 
- I due più importanti sono il :
 -*Program Counter (PC)* che "punta" alla prossima istruzione da prelevare (FETCH) per l'esecuzione,  
 -*L' Instruciont Register (IR)*  ha il compito di mantenere l'istruzione corrente in fase di esecuzione 

-Ogni componente viene collegato da un *BUS* ovvero dei cavi paralleli che trasferiscono indirizzi, dati e segnali di controllo 

![[Screenshot 2026-03-04 170621.png]]


---


# Organizzazione della CPU

-Una tipica cpu di *von Neumann* (grande matematico e fisico che propose di trattare i dati e le istruzioni allo stesso modo) contiene il *datapath* o percorso dati (*si intende l'insieme di tutti i componenti fisici che manipolano trasformano e trasportano dati*) costruito da 1 a 32 registri, l'ALU e vari bus di collegamento.

-L'*ALU* esegue su dei registri di input (A e B), addizioni e sottrazioni e altre operazioni semplici il risultato è posto nel registro di uscita.

-Il risultato nel registro di uscita può essere memorizzato nei registri e successivamente nella memoria 
-Le operazioni possono essere: *registro-memoria*  o *register-register*

![[Screenshot 2026-03-04 170629.png]]


---

# Esecuzioni delle istruzioni

Esiste il ciclo *fetch-decode-execute*  cooridinato dall'*Unità di Controllo* è fondamentale per l'esecuzione delle istruzioni ed è composto dai seguenti passaggi:

1) Preleva la successiva istruzione (*Fetch*)dalla memoria e la inserisce nell'IR (ricordiamo che ha il compito di mantenere in esecuzione l'istruzione corrente).

 2) Aggiorna il *Program counter* è un registro speciale che contiene l'indirizzo di memoria della prossima istruzione.

 3) Decodifica l'istruzione in IR (ovvero trasforma i bit in segnali elettrici).
 
 4)  Esecuzione (*EXECUTE*)  e (Accesso alla memoria) La cpu segue l'operazione logico matematica,  se l'istruzione referenzia/richiede una parola (dato) esterno  la CPU  sospende il calcolo per cercare la *"parola"* in memoria una volta trovata l'esecuzione è completa e il risultato viene salvato.

 5) *Memory Access (Load)* Se necessario preleva la parola dalla memoria e la inserisce in un registro della CPU.
 
 6) (*Store*) Esegue l'istruzione ovvero il dato esce dal registro e va verso la memoria : Cosa succede al Punto 6 (Esecuzione)

- **Se l'istruzione è una Somma/Calcolo (ALU):** I dati passano dai registri di input all'ALU, vengono elaborati e il risultato viene messo in un registro di uscita.
    
- **Se l'istruzione è uno STORE:** Il dato esce da un registro della CPU e viene inviato al bus dati per essere scritto in un indirizzo specifico della memoria RAM.
    
- **Se l'istruzione è un LOAD:** Tecnicamente l'esecuzione si è conclusa con il **punto 5**, quando il dato è stato inserito nel registro.
 
 7) Riparti dal punto 1 per eseguire la prossima istruzione 


---

# Strategie di progettazione delle CPU

- In un'architettura *CISC*  (Complex Istruction Set Computer), la CPU capisce istruzioni molto "ricche". Una singola istruzione potrebbe fare i punti 4,5,6(**calcola indirizzo, preleva dato e somma**) tutto insieme  è comodo per scrivere programmi, ma rende l'hardware complesso.

- *RISC* (Reduced Istruction Set Computer): Qui le istruzioni sono poche e semplicissime se vuoi sommare un dato della memoria, devo creare  *tre istruzioni separate*: una per **caricare il dato** (punto 5), **una per sommare** e **l'altra per salvare**.

- *Approccio Ibrido (Intel)*: A partire dal processore dal x486, Intel ha unito due mondi. Usa un "cuore" *RISC* per le operazioni veloci di tutti i giorni (che girano in un solo ciclo) e una modalità *CISC* per quelle più pesanti.

---

# Principi di progettazione dei calcolatori 

I progettisti di CPU tentano di seguire un insieme di principi denominati *principi di progettazione RISC*.

1) ==Esecuzione diretta dall'Hardware
	- Le istruzioni non dovrebbero essere "interpretate" (un processo lento), ma eseguite immediatamente dai circuiti
	- *Il trucco per le CPU CISC*: Se un'istruzione è troppo complessa la CPU la spezza in *MICROISTRUZIONI* più piccole e semplici che l'Hardware può gestire velocemente in sequenza.

2) ==Massimizzare la frequenza di emissione:
	- L'obiettivo è far uscire quante più istruzioni completate possibili nell'unità di tempo.
	
	- Per farlo, si usa il *parallelismo* la CPU non aspetta di aver finito un'istruzione prima di iniziare la successiva.


3) ==Le istruzioni devono essere semplici da decodificare:
	- Ovvero lunghezza predefinita, struttura regolare e poche variabili
	
4) ==Load/Store: Solo le istruzioni di *LOAD* e *STORE* possono toccare la memoria:
    -   Tutte le altre istruzioni dovrebbero operare sui registri della CPU 
    
5) ==Le CPU dovrebbero poter disporre di un elevato numeri di registri:
    - Una volta prelevata una "parola" (*word*) dalla memoria, la si può tenere in un registro finché serve

---

# Parallelismo: di più istruzioni nell'unità di tempo 

- Il punto di partenza è un limite fisico non si può aumentare la frequenza di *clock* (i Ghz) all'infinito perché il processore scalderebbe troppo.  Con *parallelismo* si intende  di  far eseguire alla CPU più istruzioni contemporaneamente per aumentare la performance.

[Il Clock: È il "battito cardiaco" del computer. È un segnale elettrico che sincronizza tutte le operazioni.]

[Hertz (Hz): Indica "quante volte al secondo" avviene questo battito].

[Gigahertz (GHz): Significa **miliardi di volte al secondo**. Se il tuo PC va a 3.0 GHz, significa che il suo "cuore" batte 3 miliardi di volte ogni secondo. In ogni battito, il processore può compiere un pezzettino di un'operazione].

- Il *parallelismo* si ottiene in 2 modi:

    1) *Parallelismo a livello di istruzioni*:  Si sfrutta la struttura interna delle singole istruzioni  per sovrapporne l'esecuzione. Per ottenere un maggior numero di istruzioni completate al secondo
     (*ESEMPIO*) : Mentre l'istruzione A è in fase di execute l'istruzione B è già in fase di Decode e così via.
     
    2) *Parallelismo a livello di Processore*: Non lavora più una sola CPU, ma più CPU (*o core*) collaborano insieme i vantaggi sono diversi come ad esempio il carico di lavoro viene diviso 


---

# Parallelismo a livello di istruzione  pipelining: 

Introduciamo il concetto di **Pipelining** (è una tecnica che permette alla CPU di lavorare **su più istruzioni contemporaneamente**) 

- **Il problema**: *"Il collo di bottiglia" del fetch* :
	 -Il limite principale è la fase di prelievo (**FETCH**) dell'istruzione dalla memoria. La RAM è molto più lenta della CPU e aspettare l'istruzione ogni ciclo spreca tempo 

- **Prima Soluzione**: *Il Prefetch Buffer* : 
	 -per ridurre i tempi morti si è pensato di usare dei registri speciali chiamati **PREFETCH BUFFER** 

   - **Come funziona**?
	Mentre la CPU sta ancora eseguendo l'istruzione attuale l'unità di controllo porta avanti il lavoro e ==precarica le istruzioni successive== dalla memoria in questo buffer.
	
	**ABBREVIAZIONE**
	("il problema del parallelismo o della pipelining è la fetch, ovvero la fase di prelievo dati dalla memoria per via della ram più lenta della cpu che fa aspettare l'istruzione ogni ciclo).

-  **SOLUZIONE DEFINITIVA** : *Il Pipeline* spinge questa logica al massimo, l'esecuzione di un'istruzione viene divisa in molti passaggi o *stage*(fasi) che vengono eseguite contemporaneamente.


![[Screenshot 2026-03-07 102820.png|494]]


	S1) Unità di fetch dell'istruzione
	S2) Unità di decodifica dell'istruzione 
	S3) Unità di fetch degli operandi 
	S4) Unità di esecuzione dell'istruzione 
	S5) Unità di memorizzazione del risultato  
	
---

# INCREMENTO DELLA BANDA DEL PROCESSORE 

Con l'uso della *pipelining* la CPU non diventa più veloce, ma diventa più brava a "sfornare" tante cose contemporaneamente.

*LATENZA* vs *BANDA*
- **LATENZA** : è il tempo che ci mette *una singola istruzione* a fare tutto il giro, dall'inizio alla fine.
- **BANDA** : è la quantità di istruzioni che la CPU finisce in un secondo (viene misurata in **MIPS** ovvero milioni di istruzioni al secondo)

**FORMULE** : Nel caso avessi  una CPU con una pipeline a p *stadi*, e ogni stadio dura T *nanosecondi*:

 - *Latenza totale = p * T* :
	  -Il tempo totale per una singola istruzione è la durata di un pezzetto moltiplicato per il numero di pezzi.
 
 - *Banda = p volte superiore*:
	  -La velocità con cui le istruzioni escono è p *volte più alta* rispetto alla CPU senza pipeline che avesse la stessa lentezza totale.

---

# Processori con più pipeline 

- *Duplicazione*: Averne due che lavorano in parallelo è meglio per raddoppiare la velocità.

- *Limitazione*:
	-1)*Dipendenze* :
	 Un'istruzione potrebbe dover aspettare il risultato di quella precedente 
	-2)*Costi* : 
	Servono troppi componenti hardware e  diventa difficile sincronizzarli tutti. 
 **ESEMPIO** 
 ![[Pasted image 20260307120802.png|578]]

---

# Parallelismo a livello di processore 

- *Pipelining e Superscalare* : 
  -Usando le tecniche viste prima (Pipeline), un processore moderno migliora la sua prestazione di circa 5/10 volte oltre non può per via della complessità fisica del chip.

- *Il salto di qualità (Multi-CPU)* /*Superscalare*
	-Per ottenere velocità incredibili (incrementi di 50/100  o più volte)  servono sistemi che collegano tra loro **molte CPU**.
	- **I 3 MODI PER "Lavorare insieme"**
		1) *Computer con parallelismo sui dati* :
			Esempio schiarire 1 milione di pixel di una foto  invece che farlo 1 alla volta do lo stesso ordine a 1000 piccoli processori che lo fanno contemporaneamente.
		2) *Multiprocessori* :
			Ci sono più CPU che condividono la **la stessa memoria RAM** di conseguenza vedono tutti gli stessi dati 
	
		3) *Multicomputer* :
			Qui parliamo di reti di computer, ovvero che ogni computer ha la sua CPU e la sua RAM, per collaborare si scambiano messaggi via rete, più difficile da programmare ma permette di collegare migliaia di macchine 

---

# CLASSIFICAZIONE DI FLYNN 

-  È un metodo che cataloga i computer in base a come gestiscono le *istruzioni* e i *dati* .

 ![[Pasted image 20260308130703.png]]

**SINTESI**
1) *SISD (Single Instruction, Single Data):

	- *Cos'è* : Un'unica istruzione lavora su un unico dato alla volta.
	- *Esempio* : Il modello classico di **Von Neumann**
	- *In pratica* : Il computer esegue un compito dopo l'altro in sequenza 
	
2) *SIMD (Single Instruction, Multi Data)*:

	- *Cos'è* : Un'unica istruzioni impartita a molti processori, che poi applicano su dati diversi.
	- *Esempio* : Supercomputer vettoriali /schede video moderne (GPU)
	- *In pratica* : Istruzione singola assegnata a dati multipli 
	
3) *MISD (Multi Instruction, Single Data*)

	- *Cos'è* : Più istruzioni diverse lavorano contemporaneamente.
	- *Esempio* : Usata quasi solo in sistemi ad altissima sicurezza (come i controlli di volo degli aerei) dove più computer controllano lo stesso dato per evitare errori. 
	
4) *MIMD (Multi Instrucion, Multi Data)
	- *Cos'è* : Più istruzioni indipendenti lavorano su più dati diversi contemporaneamente. 
	- *Esempio* : *Multiprocessori* e *Multicomputer*.
	- *In pratica* : È il massimo del parallelismo. Più CPU autonome fanno cose diverse su dati diversi. 

 ![[Screenshot 2026-03-08 133627.png|552]]
- Lo schema espande la *Classificazione di Flynn*, il grafico parte dai quattro gruppi fondamentali, **(SISD,SIMD, MISD, MIMD)** 
- Il punto più importante + la divisione della categoria *MIMD*

	1) Multiprocessore :  Le CPU *condividono la stessa memoria RAM* 
	- **UMA** :(Uniform Memory Access): Ogni CPU accede alla memoria con la stessa velocità tramite i *BUS*.
	
	- **NUMA / COMA** : L'accesso alla memoria può essere +/- veloce in base a dove si trova fisicamente (gerarchia memoria) il dato rispetto alla CPU.

	1)  Multicomputer : Ogni computer è indipendente e ha la sua memoria privata per collaborare devono scambiarsi messaggi 
	- **MPP** (Massively Parallel Processors): Supercomputer collegati con reti a griglia o ipercubo.
	- **COW** (Cluster of Workstations) : Una rete di normali pc che lavorano insieme.

---

# Multiprocessori 

-  **Definizione**: 
	 -È un'architettura formata da più CPU che condividono la *stessa memoria* (RAM)

- **Il problema della Sincronizzazione** :
	-Poiché ogni CPU può leggere o scrivere in qualsiasi punto della  memoria condivisa, c'è il rischio che si "scontrino". Per evitare che due CPU modifichino lo stesso dato contemporaneamente, devono *sincronizzarsi tramite software*.
	
- **Sitstema "Tightly Coupled" (Fortemente accoppiati)**: 
	-Poiché le CPU devono interagire continuamente e in modo molto veloce per scambiare i dati attraverso la RAM, questi sistemi sono definiti *Fortemente accoppiati*.
	
	![[Pasted image 20260309094535.png|556]]

---

# Multicomputer 

- **Il limite dei multiprocessori** :
	-Quando superi le *256 CPU*, diventa fisicamente impossibile collegarle tutte alla stessa memoria RAM senza creare ingorghi. 
	
- **La soluzione** :
	-Si abbandona l'idea della memoria condivisa. Ogni CPU riceve la sua *memoria privata* personale.
	
- *Accoppiamento Lasco (Loosely Coupled)*:
	-Poiché le CPU non devono più coordinarsi su ogni singolo byte di RAM, il sistema è meno "rigido" e viene detto *debolmente accoppiato*.

- **Comunicazione** : 
	-Per lavorare insieme, le CPU si scambiano *messaggi* (invio/ricezione di dati via rete).

- **Topologie di rete** (MPP): 
	-In sintesi, non potendo collegare ogni CPU con tutte le altre. Si usano schemi geometrici come le *griglie, l'albero o l'anello*,*l'ipercubo* (ha più dimensioni) per far viaggiare i messaggi. 


---
# ==INDIRIZZI DI MEMORIA==

###### Questa slide spiega come la *RAM* organizza i dati per poterli recuperare velocemente, usando l'analogia di un grande armadio a cassetti.	
- *Le Celle (o locazioni)* : La memoria non è un ammasso disordinato, ma è divisa in piccole unità chiamate **CELLE**.

- *L'Indirizzo*: Ogni cella è identificata da un numero univoco, chiamato **INDIRIZZO**, che ne indica la posizione esatta 

- *Contenuto Standard* : In ogni cella viene memorizzata sempre la stessa quantità di informazione, misurata in byte

- *Unità Minima* : La cella è l'elemento più piccolo a cui il processore può fare riferimento diretto (Unità minima indirizzabile). 

- *Le Parole (Word)* : Per gestire dati più grandi, i byte possono essere raggruppati in strutture chiamate **parole**. 

![[Pasted image 20260311100307.png]]

---

# Memoria Principale (Le basi)

$\text {Nuovo argomento}$ [come sono fatti i dati "dentro" le RAM]

- **BIT (BInary digiT)** :
	-È l'unità di base, una variabile che può essere solo  **0 (aperto) e 
	1 (chiuso)**
	
- **Linguaggio macchina** :
	-Il computer non capisce le parole, ma interpreta solo  sequenze di bit (Es. 00101100)

- **Byte** : 
	-Per convenzione (Semplificazione), *1 byte è composto da 8 bit*
	- Definizione di *byte* l'unità standard 
	
	 

	![[Pasted image 20260309101411.png|402]]
---
## ==Ordinamento dei byte== 
###### Quando una "parola" (word) è composta da più byte (ad esempio 4 byte per una word a 32 bit), il computer deve decidere in quale ordine scriverli nelle celle di memoria. Esistono due standard opposti:

- *Big Endian (Da sinistra a destra)* :
	-I byte vengono scritti partendo dal più significativo (quello "più a sinistra" nel numero) verso il meno significativo.
	
	-È l'ordine più naturale per noi umani: se hai il numero ==0A1F==, scrivi prima ==0A==  e poi ==1F==
	
- *Little Endian (Da destra a sinistra* ):
	-I byte vengono scritti partendo dal meno significativo (quello "più a destra") verso il più significativo.
	
	-Nell'esempio della slide, il numero ==0A1F== verrebbe memorizzato come ==1F0A==.
	![[Pasted image 20260311101702.png]]
	
---

## Codice di correzione di errore 
- È la tecnica che permette al computer di capire se un dato è stato danneggiato (ad esempio da un'interferenza elettrica).
#### Punti chiave :
- **Codeword** (Parola di codice) : È l'unione dei dati reali *(m bit)*  e dei bit di controllo *(r bit)*. La formula è n = m + r.

- **Distanza di Hamming** : È il parametro che misura quanto sono "diverse" due parole di codice. Rappresenta il numero di bit che bisogna cambiare per trasformare una parola in un'altra.
	- *Come si calcola?* : Si esegue un'operazione di **EXOR bit-a-bit** tra le due parole e si sommano i risultati.

- **Percentuale di Overhead** : È lo "spreco" di spazio causato dai bit di controllo.
	- *Regola importante* : Più la parola è lunga, meno i bit di controllo pesano su totale (L'overhead diminuisce) Ad esempio con una parola di 8 bit l'overhead è del 50% ma con 512 bit scende a 2%.
	
![[Pasted image 20260312095011.png|454]]
	

---
# Codice di HAMMING 
###### Cos'è? : 
 [È un sistema che usa bit di parità in posizione strategiche (potenze di 2) per monitorare gruppi di bit sovrapposti. Grazie a questa "mappa" di controlli incrociati, il computer può capire esattamente quale bit si è invertito per errore e correggerlo istantaneamente.]
	
-*Sintesi sistema che permettere di identificare errori in base al controllo dei bit*

- **Posizionamento dei bit di parità**: I bit di controllo non sono messi a caso, ma occupano posizione che sono *potenze di 2 * (1,2,4,6,8,18...)

- **Logica di controllo** : Ogni bit di parità controlla un gruppo specifico di bit della parola:
	- Il **bit 1** controlla tutti i bit in posizione dispari ($1, 3, 5, 7, \dots$).
    
	- Il **bit 2** controlla i bit $2, 3, 6, 7, 10, 11, \dots$.
    
	- Il **bit 4** controlla i bit dal $4$ al $7$, dal $12$ al $15$, e così via.

-  **Esempio visivo** : Nello schema in basso vedi una parola di memoria di 21 bit dove i quadratini indicano i *Parity bits* (bit di controllo) posizionati esattamente all'inizio dei loro rispettivi intervalli di competenza 

- **Efficienza (Overhead)**: Allungando la parola di dati, la "tassa" di bit extra che dobbiamo pagare (*Overhead*) diventa proporzionalmente più piccola.


![[Pasted image 20260312100041.png]]

--- 
# Memorie cache

###### Cos'è la Memoria Cache?:  
[ Una memoria piccola e velocissima interposta tra CPU e RAM. Serve a "colmare il buco" di velocità, evitando che il processore resti inattivo in attesta di dati provenienti dalla memoria principale, che è lenta ma capiente]

**Memorie Cache : Il problema della velocità** : La cache nasce per risolvere un'inefficienza strutturale dei computer : la *differenza di velocità* tra CPU e RAM. 

- **Sbilanciamento tecnologico** : Le CPU sono estremamente più veloci delle memorie principali (RAM). Mentre i processori raddoppiano la velocità rapidamente, i progettisti di memorie si concentrano sull'aumentare la *capacità* (quanti dati stanno dentro) piuttosto che la *velocità*  (quanto tempo ci vuole a leggerli).

- **Tempi d'attesa (Idle)** : Poiché la RAM è lenta, la CPU è spesso costretta ad aspettare molti cicli macchina prima di ricevere i dati necessari per continuare  a lavorare. Questa spreca potenza di calcolo.

- **Il compromesso ingegneristico**: Sarebbe troppo costoso e tecnicamente difficile inserire memorie grandi e velocissime direttamente dentro il chip della CPU. Farlo aumenterebbe drasticamente sia la dimensione fisica del chip che il suo prezzo. 
---
# Memoria Cache

[La strategia utilizzata dal computer per decidere quali dati tenere nella cache per andare più veloce]
- *Il Principio di Località* : Si basa sull'osservazione che i programmi non accedono alla memoria in modo casuale. Esistono due tipi: 

	- **Località Temporale** : Se un dato è stato usato adesso, è molto probabile che verrà riutilizzato a breve
	
	- **Località Spaziale** : Se un dato è stato usato adesso, è molto probabile che verranno usati presto anche i dati che si trovano "vicini" a lui in memoria  
	
- **La Soluzione** : Per sfruttare questo comportamento si inserisce una *Memoria cache* (piccola e veloce) tra la CPU e la RAM.

- *Funzionamento* : La cache memorizza piccole porzioni di dati usati di frequente. Quando la CPU deve leggere una "parola", controlla *prima nella cache* :se il dato è lì, lo ottiene subito; se non c'è, deve andare a prenderlo nella memoria centrale che è più lenta.
![[Pasted image 20260313100729.png]]

---

# Gerarchie di memorie 

[Il sistema di memoria è organizzato come una piramide per gestire il fatto che le memorie più veloci sono anche le più costose e piccole.]

-  *Tempo di accesso (Velocità)* : Diminuisce man mano che si sale verso il vertice
	- I *Registri* sono più veloci (circa 1nsec)
	- Seguono la *Cache* (2 nsec) e la *Memoria Principale/RAM* (10 nsec).
	- I supporti magnetici (Dischi e Nastri) sono molto più lenti (da millisecondi a secondi).
- *Capacità Tipica* : Aumenta drasticamente man mano che si scende verso la base 
	- Mentre i registri contano meno di 1kb, i dischi magnetici arrivano a centinaia di GB.
	
- *Logica della Gerarchia* : L'obiettivo è creare l'illusione di una memoria che sia allo stesso tempo *velocissima* (come i registri) e *vastissima* (come un hard disk) a un costo contenuto.

![[Pasted image 20260313095023.png|558]]

**Piramide della Memoria:** 
1) *Registri/Cache* : Alta velocità, bassa capacità, costo elevato.

2) *Main Memory* (RAM) : Il punto di equilibrio,

3) *Dischi/Nastri* : Bassa velocità, altissima capacità, costo ridotto, il processore cerca i dati prima in alto; se non li trova, scende ai livelli successivi.

---
# Assemblaggio e tipi di memoria 
[Questa slide descrive come i singoli chip di memoria vengono fisicamente raggruppati e montati per essere installati sulla scheda madre del computer]

- *Composizione fisica*: I chip di memoria (integrati) non vengono venduti singolarmente, ma montati in gruppi (solitamente 8 o 16) su un piccolo circuito stampato che costituisce un'unica unità rimovibile.
- **SIMM vs DIMM** :

	- *Simm (Single Inline Memory Module)* :Ha una sola fila di connettori su un lato della scheda. Riesce a trasferire *32bit* per ciclo di clock.
	
	- *Dimm (Dual Inline Memory Module*) : È l'evoluzione della SIMM. Ha due righe di connettori su entrambi i lati, permettendo di trasferire il doppio dei dati, ovvero *64 bit*.
	
- **Esempio di struttura (SIMM da 256 MB): 
	-  Utilizza *8 chip dati*, ognuno dei quali contiene 32 MB (8 x 32 = 256MB) 
	
	- Include *due chip di controllo* aggiuntivi per gestire il flusso dei dati e la logica della scheda stessa.


![[Pasted image 20260314130018.png|402]]




---

# ==PARTE MENO IMPORTANTE==
### I sistemi di numerazione 

[Introduzione alla matematica dei computer]
- **Definizione** : Un sistema di numerazione è un linguaggio per scrivere i numeri 
- **Alfabeto** : È l'insieme dei simboli che puoi usare (es. nel nostro sitema decimale è 0-9)
- **Grammatica** : Sono le regole per comporre i numeri (*sintassi*) e per capirne il valore (*semantica*).

---

#### Sistema di numerazione romano 

- Viene usato come esempio di sistema "vecchio" per capire la differenza con quello dei computer 
	- *Sistema Additivo* : Il valore del numero è dato semplicemente dalla **somma** dei valori dei simboli  XVII = 10+5+1+1 = 17 
	
	- *Il grande limite* : In questo sistema **non esiste lo zero**, il che rendeva i calcoli complessi molti difficili.

---

#### Sistema di numerazione posizione

-Questo è il sistema che usiamo noi (decimale) e che usano i computer (Binario) 
- *La Base* : È il numero di simboli  diversi usati dal sistema

- *Importanza della posizione* : Il valore di una cifra cambia a seconda di "dove" si trova nel numero.

- *Potenza della base* : Ad ogni posizione corrisponde una potenza della base (es nel numero 321, il valore "3" vale 300 perché è nella posizione delle centinaia, ovvero 3 per 10^2).
	*La formula generale è: $$N_{b} = \sum_{j=0}^{k} c_{j} b^{j}$$

---
#### Sistemi di numerazione posizionali 

![[Pasted image 20260311092634.png|470]]


#### Esempi di rappresentazione numeriche 

![[Pasted image 20260311092721.png|446]]

---

#### Conversione base 10 a base 16 

![[Pasted image 20260311092908.png|415]]

- *Il procedimento* : Si divide il numero decimale per 16 finché il quoziente non diventa 0
- *I resti* : A ogni passaggio si annota il resto della divisione 
- *Il Risultato* : Il numero convertito si ottiene leggendo i resti **dal basso verso l'alto** 
- Esempio = 500:16 = 31 resto 4, 31:16 = 1 resto 15 1:16 = 0 con resto 1 

#### Conversione : base generica a base 10 
![[Pasted image 20260311093507.png|478]]


####  Metodo semplificato : base 10 a base 2 

-  Dividere per 2 corrisponde a stabilire se un numero è pari o dispari

 ![[Pasted image 20260311093736.png]]

---
#### Metodo semplificato : Base 2 a Base 10 

- In una somma i bit a zero possono essere esclusi, possiamo sommare le sole potenze di due dove troviamo un uno 
![[Pasted image 20260311093907.png]]


#### Basi potenza l'una dell'altra

### *Conversione Rapida 2 a 8*: Sfrutta la relazione 2^3= 8

- *Da Binario a Ottale* Raggruppo i bit 3 a 3 da destra e converto ogni gruppo in una cifra (0-7).
- *Da Ottale a Binario*: Sostituisco ogni cifra con il suo equivalente a 3 bit 
		![[Pasted image 20260311094943.png]]
	


#### Conversione Rapida 2 a 16 : Sfrutta la relazione 2^4 = 16
- *Binario*  -> *Esadecimale* : Raggruppa i bit a 4 a 4 da destra e converti ogni gruppo (es 4 -> 0100 )
- *Esadecimale -> Binario* : Sostituisci ogni cifra con il suo equivalente a 4 bit (4 -> 0100)
 ![[Pasted image 20260311095458.png]]

#### Tabella 
![[Pasted image 20260311095642.png]]

---


