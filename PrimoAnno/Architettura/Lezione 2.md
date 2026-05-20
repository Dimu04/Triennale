# Gerarchia di memoria 

- La slide illustra il compromesso fondamentale dell'informatica : *non esiste una memoria che sia allo stesso tempo infinita, velocissima ed economica.

1) **La regola d'oro**: Esiste un rapporto di proporzionalità inversa tra velocità e dimensione:
	- *Salendo la piramide*: La memoria diventa più **veloce** ma più **piccola** e **costosa** (Registri, Cache).
	
	- *Scendendo la piramide*: La memoria diventa più **lenta** ma molto più capiente ed **economica** (Dischi, Nastri).
	
2) **Il "Muro" (La linea verde)** : La linea verde segna il confine tra *Memoria Interna* (elettronica) e *Memoria Esterna* (magnetica/meccanica):

	- **Sopra la linea (Nanosecondi -10^-9s)**: I componenti sono integrati o vicino alla CPU. La velocità è altissima perché non ci sono parti meccaniche in movimento 
	
	- **Sotto la linea (Millisecondi - 10^-3s)**: Qui il salto temporale è enorme (1 milione di volte più lento). Accedere a un disco o a un nastro è l'operazione più "costosa" in termini di tempo per un computer.

3) **Il Principio di Località:** Perché la gerarchia funzioni, il sistema sposta i dati che usi spesso nei livelli alti.
	- **Obiettivo:** Far credere alla CPU di avere a disposizione memoria grande come un disco ma veloce come un registro.
	- **Il flusso:** I dati vengono "pescati" dal basso (Nastri/Dischi) e portati su verso la RAM e le Cache per essere lavorati dai registri. 


	![[Screenshot 2026-03-19 131615.png]]
---
# Dischi magnetici (Hard disk)

[Sono il tipico esempio di memoria secondaria. Il loro funzionamento è **meccanico**, il che li rende lenti ma capaci di conservare dati senza elettricità.]

**Com'è fatto?**
- *Piatti di alluminio*: Dischi che ruotano velocemente attorno a un centro. Sono rivestiti di materiale magnetizzabile.
-  *La Testina* : Un braccetto che si muove avanti e indietro.
- *Il Solenoide* : È il "cuore" della testina.  Usando la corrente elettrica, crea un campo magnetico che orienta le particelle sul disco per scrivere **0 o 1**

![[Pasted image 20260319133658.png|614]]
#### Organizzazione del Disco: Settori e Gap
Se la traccia è la "strada" circolare, il *settore* è il singolo "posto auto".

1) **Il Settore (l'unità minima)
	- Ogni traccia è divisa in spicchi chiamati **settori**.
	- Un settore ha solitamente una lunghezza fissa di **512 byte**.
	- **Importante:** Quando il computer legge dal disco, non legge mai un singolo bit, ma carica almeno un intero settore alla volta. 
	
2) **Intersector Gap (Lo spazio manovra)
	- Tra due settori adiacenti c'è un piccolo spazio vuoto chiamato **intersector gap**.
	- **A cosa serve?** Serve a dare tempo alla testina e all'elettronica di capire che un settore è finito e ne sta iniziando un altro. Senza questo gap i dati "sbatterebbero" l'uno contro l'altro 
	
3) **Geometria e Densità (Il paradosso del cerchio)**
	- Le tracce più vicine al centro sono fisicamente più corte di quelle esterne.
	- **Tuttavia**, contengono lo **stesso numero di bit** (stessa capacità informativa).
	- **Conseguenza:** I bit nelle tracce interne sono molto più "vicini" tra loro (maggiore densità) rispetto a quelli nelle tracce esterne. 

![[Pasted image 20260319150612.png|645]]

# Sicurezza e Correzione: Cosa c'è dentro una traccia?  (Hard disk)

[Oltre ai dati (0 e 1) che vogliamo salvare, ogni traccia contiene informazioni di servizio fondamentali.]
- *Preambolo:* Permette alla testina di sincronizzarsi con la velocità del disco prima di iniziare a leggere o scrivere.

- *ECC* **(Error Correction Code)**: Poiché i dischi sono magnetici e meccanici, gli errori capitano. Si usano codici matematici complessi (come il **codice di Hamming o il Reed Solomon**) per rilevare e correggere automaticamente i bit che si sono "corrotti".

### Evoluzione dei dischi 
1) *Dischi Vecchi (Geometria a spicchi)*:
	- Le tracce interne ed esterne hanno lo **lo stesso numero di settori**
	
	- **Problema**: Lo spazio nelle tracce esterne che sono più larghe viene sprecato perché i bit sono molto larghi e "comodi".
	
2) *Dischi Nuovi (Zoned Bit Recording)*: 
	- Il numero di settori **aumenta nelle zone esterne**.
	
	- **Vantaggio**: Si sfrutta tutta la superficie del disco. Più la traccia è lunga (esterna), più settori ci infiliamo. Questo è uno dei motivi per cui oggi abbiamo hard disk da molti Terabyte
	 ![[Pasted image 20260319153134.png]]
---
# Dischi magnetici 
- Introduciamo il cervello dell'hard disk : il **Disk Controller**. È un concetto fondamentale perché spiega chi è che materialmente dà gli ordini alla testina di cui parlavamo prima.
####  Disk Controller (Il "Cervello" del Drive)
- Ogni hard disk non è solo un insieme di piatti e  motori, ma ha a bordo una scheda elettronica dedicata chiamata **Disk Controller**. In alcuni casi, questa scheda è così complessa da contenere una vera e propria **CPU dedicata**

- **Cosa fa il controller?** [È l'intermediario tra il Sistema operativo e la meccanica del disco. I suoi compiti principali sono]: 

	1) **Interpretare i comandi:** Riceve ordini dal software (come READ,WRITE O FORMAT) e li traduce in movimenti fisici del braccio e impulsi elettrici delle testina.
	2) **Correzione Errori** :È lui che gestisce i codici **ECC** (Hamming/Reed-Solomon).
	3) **Bufferizzazione:** Poiché il disco è lento (sotto la linea verde) e la RAM è veloce il controller ha una sua piccola memoria interna **Buffer** dove parcheggia temporaneamente i dati per il trasferimento.
	4) **Pilotaggio**: Gestisce con precisione millimetrica i motori  che fanno ruotare i piatti e muovono la testina.
---
## Floppy Disk 

- Sono stati i primi supporti economici e rimovibili.

- **Le differenze chiave con l'Hard Disk (HDD):**
1) **Contatto fisico vs Volo:** 
	 - *Floppy* : La testina *tocca fisicamente* la superficie del disco. Questo causa attrito e usura, limitando la velocità a cui il disco può girare
	 
	 - **Hard Disk**: Come dicevano prima, le testine "sfiorano" (volano) sul supporto o sono immerse in un liquido/gas, permettendo rotazioni migliaia di volte più veloci.
	 
2) **Flessibilità**: 
	- Si chiama "Floppy" (flessibili) perché il disco interno è una sottile pellicola di plastica magnetizzata a differenza dei piatti rigidi in alluminio dell'HDD.

3) **Il ritardo del motore**:
	- Per risparmiare energie e non usare il disco, il motore di un floppy si ferma quando non serve.
	
	- **Risultato** : Ogni volta che chiedi un dato, devi aspettare almeno **mezzo secondo** (500ms) solo perché il motore riparta. Il floppy è 50 volte più lento dell'Hard Disk.

	![[Pasted image 20260320150956.png|342]]
		
---
## Hard disk 

- Gli Hard disk sono i "magazzini" del computer. Possono essere interni (fissi) o esterni (collegati via USB). 

- Esistono due tipi di categorie:

	1) **Dischi Magnetici (Meccanici - HDD)** : 
		- Sono quelli che abbiamo analizzato finora(Piatti, Testine, Rotazione).
		
		- *Caratteristiche* : Più economici e molto capienti, ma lenti a causa dei componenti meccanici.
	
	2) **Dischi a Stato Solido (Elettronico - SSD) :
		- Non hanno parti in movimento. Usano chip di memoria flash (simili alle chiavette USB ma molto più veloci e affidabili).
		
		- *Caratteristiche* : Molto più veloci degli HDD, resistenti agli urti e silenziosi. Di contro costano di più a parità di GB.
		
---
# Hard disk Magnetico 

[Un Hard Disk moderno non ha un solo piatto, ma una pila di dischi che ruotano tutti insieme attorno allo stesso asse. Ogni piatto ha due superfici (sopra e sotto) e ogni superfice ha la sua testina dedicata].

1) **Il concetto di Cilindro** : È l'insieme di tutte le *tracce* che si trovano alla stessa distanza dal centro su tutti i piatti della pila, tutte le testine si muovo insieme, se la testina 1 è sulla traccia 50 del disco 1, anche la 4 è sulla traccia 50 del disco 2.
2) *Cos'è la Track?*: È una singola *corsia circolare*, su un piatto del disco ci sono migliaia di esse 
	![[Pasted image 20260323105051.png|294]]
3) *Da cosa dipendono le Performance?* : I 3 fattori che determinano quanto tempo ci mette il disco a darti un dato sono:

	1) **Tempo medio di Seek (Ricerca)**: Il tempo necessario per spostare il braccio meccanico sul cilindro giusto.
	
	2) **Latenza Rotazionale** : Il tempo che bisogna aspettare affinché il settore giusto passi sotto la testina mentre il disco gira.
	
	3) **Tempo di trasferimento** : Il tempo effettivo in cui i dati passano dal disco alla memoria del computer

---
## Performance dei dischi magnetici

[Il tempo totale che la CPU deve aspettare per ricevere un dato dal disco è la somma di due componenti meccaniche principali.]

-  **Tempo Medio di Seek**: Che ha dei valori medi tra 5 e 10 MS, è la parte più lenta perché comporta lo spostamento fisico di un oggetto.

-  **Latenza Rotazionale** : Il valore dipende dalla velocità di rotazione (RPM -Giri al minuto)
	-Dischi standard (5400/7200 RPM) circa 3-6MS
	-Caso peggiore. Il settore ha appena superato la testina e bisogna aspettare un giro quasi completo 

- **Il Tempo di Trasferimento è trascurabile** : Trasferire un settore da 512 byte richiede solo 3,5 Microsecondi.

[In sintesi]
-Il Seek Time e la Latenza Rotazionale dominano completamente le performance del disco. Il tempo speso a muovere il braccio e aspettare la rotazione è migliaia di volte superiore al tempo necessario per trasmettere effettivamente i dati. Questo conferma che il limite dei *dischi magnetici è puramente meccanico*. 

---
# Dischi IDE (Integrated Drive Electronics)

[Prima degli anni 80, gestire un disco era un incubo per la CPU. Lo standard IDE ha cambiato tutto integrando l'elettronica di controllo direttamente sull'unità.]

- *Il Controller Integrato*: A differenza dei sistemi più vecchi, i dischi IDE il controller è a bordo del ==drive stesso==.

- *Capacità Storica* : Lo standard originale poteva gestire dischi fino a un massimo di **504MB**.

- *Ruolo del BIOS*: Per leggere o scrivere, il Sistema Operativo non parlava direttamente col disco, ma passava attraverso il *BIOS* (Basic Input Output System) salvato nella ROM del PC.

- *Velocità di Trasferimento:* Erano molto lenti per gli standard odierni, circa **4 MB/s**. Se facciamo il confronto con la slide precedente che segnava **150MB/s.** 
## L'evoluzione da IDE a EIDE.

[Lo standard IDE originale era limitato. L'EIDE (Extended IDE) ha risolto i due grandi limiti dei primi dischi: la capacità ridotta e la lentezza.] 

- **Indirizzamento LBA (Logical Block Addressing) e ATAPI**: È l'innovazione principale.
	- *Com'era prima*: Si usava il sistema **CHS** (Cilindro/Testina/Settore), obbligando la CPU a conoscere la meccanica del disco. Limite massimo **504 MB**.
	- *Con LBA*: Il controller nasconde la meccanica e mostra alla CPU il disco coma una **Lista lineare di blocchi numerati (0,1,2,3...)**.
	- *Vantaggi* : Gestione più semplice e capacità che schizza a **128 GB**.
	
- *Prestazioni* : La velocità di trasferimento sale a **16,67 MB/s.

- *Espandibilità*: Supporto fino a 4 dispositivi.
 ![[Pasted image 20260413181455.png|546]]

## Dall'EIDE al SATA (L'evoluzione delle Prestazioni)

[Avviene il cambio della tipologia di cavi con la quale venivano passate le istruzioni ATA E ATAPI.]

==ATA== = Advanced Technology Attachment = È il nome del "linguaggio" usato per collegare i dischi.

==ATAPI== = ATA Packet Interface = Un'estensione per far capire al pc che è collegato  un cd/dvd

1) *Il periodo "Parallelo"( ATA e ATAPI*)  
	Le istruzioni *ATA E ATAPI* viaggiano "tutte insieme" su 40 o 80 fili (pin)
		
2) **La rivoluzione seriale (SATA)**  
	Con lo standard **ATAPI-7** avviene il cambio tecnologico definitivo: nasce il *Serial ATA (SATA)* : Qui le stesse istruzioni ATA/ATAPI vengono messe in fila indiana e sparate velocissime. 

	- *Nuovo Connettore* :si passa dal *(EIDE 80-pin*) a un (*SATA 7-pin*)
	- *Velocità* : Salto immediato a *150 MB/s*
	- *Risparmio Energetico*.
	- *Vantaggio extra* : I cavi sottili permettono una migliore circolazione dell'aria, evitando che il PC si surriscaldi.
	
	
---
### SCSI Disk (Small Computer System Interface)

[Mentre l'IDE era semplice ed economico, lo SCSI (si pronuncia "scasi") nasce per essere POTENTE  e FLESSIBILE] 

1) Caratteristiche Principali :
	- **Multitasking** : I controller SCSI potevano gestire fino a 7 dispositivi contemporaneamente (non solo Hard Disk ma anche scanner stampanti e unità nastro).
	
	- *Indipendenza* : Lo SCSI è più "intelligente" dell'IDE. Può gestire il trasferimento dati tra due dispostivi senza disturbare troppo la CPU.
	
	- *Organizzazione*: Internamente i dischi sono simili agli IDE (piatti, tracce, settori), ma usano un linguaggio di comunicazione (interfaccia) molto più evoluto e veloce.
	
2) L'evoluzione della velocità (La Tabella)
	- Si è passati da *5MB/s* del primo SCSI-1 del 1986 ai *640 MB/sec* dell'Ultra5 SCSI.
	
	- Nota come raddoppiano i *Data bits* (da 8 a 16 bit) e la frequenza del *Bus MHz* :più la "strada" è larga e veloce, più dati passano.

![[Pasted image 20260324102414.png]]


---

# RAID (Redundant Array of Indipendent Disks)

[Strategia per migliorare prestazioni e sicurezza usando più dischi insieme. Si fa vedere al computer un insieme di dischi come se fosse un unico disco virtuale.]

- *Performance*: Più testine leggono parti diverse dello stesso file contemporaneamente.

- *Affidabilità*: Se un disco fallisce, il sistema continua a funzionare (grazie alla ridondanza).

- *SLED (Single Large Expensive Disk)*: Il termine opposto, che indica l'uso di un singolo disco (meno efficiente).
# RAID Livelli (0-1-2-3-4-5) Guida

- **RAID 0** (Striping - "Puro Sprint")
	- **Logica**:  Divide i dati in "Strisce" (strip) su più dischi (round-robin)
	
	- **Pro** : Velocità massima (Legge/scrive su 4 dischi insieme).
	
	- **Contro: Nessuna ridondanza**. Se un disco muore, perdi tutto. È meno affidabile di un disco singolo (SLED).
	- ![[Pasted image 20260324111023.png]]
---

- *RAID 1* (Mirroring - "La Fotocopia")
	- **Logica** :Duplica ogni dato su un disco di backup. Hai 2 dischi uguali.
	
	- **Pro** : Sicurezza eccellente. Se uno si rompe, usi l'altro. Lettura veloce(puoi leggere da entrambi).
	
	- **Contro** : Scrittura lenta (devi scrivere due volte) e spreco di spazio (metà dischi usati solo per copia).
- ![[Pasted image 20260324111252.png]]
---

- *RAID 2* (Hamming -"L'ingegnere")
	- **Logica** : Divide i dati a livello di **singolo bit**. Usa il codice di Hamming ( come nella RAM) per correggere gli errori.
	
	- **Nota** : Ormai non si usa quasi più, è molto complesso e richiede 7 dischi per funzionare bene 
	- ![[Pasted image 20260324111608.png]]
---
- *RAID 3* (Parità a Bit -"Sicronizzato")
	- **Logica** : Simile al 2, ma usa un solo disco dedicato alla **Parità** (un calcolo matematico per recuperare i dati).
	
	- *Nota* : Richiede che tutti i dischi girino in sincronia perfetta.
	
	- ![[Pasted image 20260324111851.png]]
	
--- 
- *RAID 4*(Parità a Strisce - "il Disco Sacrificato")
	- **Logica** : Come il RAID 0, ma aggiunge un *disco dedicato solo alla parità*.
	- **Problema** : Il disco di parità lavora tantissimo e diventa un "collo di bottiglia" (rallenta tutto).
	- ![[Pasted image 20260324112140.png]]
---

- *RAID 5* (Parità Distribuita - "Il Compromesso Perfetto")
	- **Logica** : La parità non sta su un disco solo, ma è spalmata su tutti i dischi.
	- **Pro** : Risolve il problema del RAID 4. Se un disco muore, ricostruisce i dati dagli altri.
	- **Contro** : Se si rompe un disco, ricostruirlo è un processo lungo e complesso per il sistema 
	- ![[Pasted image 20260324112545.png]]

Tabella di Sintesi :
[Livello]              [Nome Chiave]        [Obiettivo Principale] 
RAID 0                 Striping                     *Velocità* 
RAID 1                 Mirroring                  *Affidabilità*
RAID 2-3-4          Parità dedicata          *Correzione errori (Obsoleti)*
RAID 5                 Parità distribuita        *Correzione errori + Efficienza*

---

# Dischi a stato solido (SSD)
[A differenza degli Hard Disk (HDD), gli SSD non hanno parti in movimento. Sono fatti di chip (Transistor)].

1) **I Vantaggi (Perché sono meglio)**:
	
	- *Pro*: Tempo di seek è nullo non è presente la testina, è 3 volte più veloce rispetto ad HDD e gli urti non causerebbero danni o crash 
	
	
2) **Gli Svantaggi (Il "prezzo" da pagare)
	- *Usura* e *Costo* : Una SSD è molto cara e i transistor si usurano velocemente.
3) *Differenza chiave* :L'HDD è meccanico/magnetico, l'SSD è pura elettronico.

[Nota Transistor] 
-  **Il Transistor negli SSD**:

- **Funzione**: Agisce come una cella di memoria che conserva una carica elettrica.
    
- **Stato**: Presenza di carica = $0$ / Assenza di carica = $1$ (o viceversa a seconda della logica).
    
- **NAND Flash**: È il nome della tecnologia che mette insieme miliardi di questi transistor per creare lo spazio di archiviazione (es. i tuoi 128 GB o 1 TB).
    
- **Persistenza**: Grazie all'isolamento della celletta (Floating Gate), i dati non svaniscono senza corrente (a differenza della RAM)

---
# CD E DVD Memoria Secondaria di tipo OTTICA
#### CD-ROM (Compact Disc - Read Only Memory)

[Nato nel 1984 dalla collaborazione tra Philips e Sony è un supporto ottico usa la luce non il magnetismo.]

1) **Com'è fatto fisicamente** : 
	- Policarbonato = Base
	- Alluminio = Strato dove stanno i dati 
	- Vernice = Strato protettivo 

2) **Come vengono scritti i dati?** (Il CD usa la *superficie*):
	- Pit (buche) : Piccole depressioni incise sul disco.
	- Land (terre): Le aree piatte, non incise.
	- Il trucco : Il computer legge la transizione da un pit a un land (o viceversa) per capire se è il dato è un 0 o 1 
	
[Sintesi]
- *Meccanismo* : sfrutta la riflessione di un raggio laser
- *Struttura* : Dati incisi su alluminio protetto da policarbonato.
- *Lettura* : Si basa sul passaggio tra Pit e Land.
- *ROM* : Significa "Read Only", ovvero una volta stampato in fabbrica non può più essere modificato.
#### CD-ROM : La Geometria e il Laser 

[Mentre l'Hard Disk scrive su cerchi separati (tracce), il CD usa un approccio diverso, ereditato dai dischi in vinile.]
![[Pasted image 20260324164939.png|403]]

1) *La Spirale Infinita*: 
	- *Struttura dati* : Un'unica traccia a *spirale* che parte dal centro.
	
2) *Come avviene la lettura (Il Laser)*:
	Il computer non "tocca" mai il disco. Usa un *laser a bassa potenza*: 
	- Quando il laser colpisce un *Land* (superficie piatta), la luce torna indietro dritta (riflessione forte)
	- Quando il laser colpisce un *Pit* (buco), la luce si disperde o cambia fase.
	- Il sensore rileva il *cambiamento della riflessione*: è proprio la *transizione* (il salto tra buco e piano) che viene interpretata come il bit del dato.

	[Nozioni]
	CD-ROM (Lettura Ottica) :

	- *Vantaggio* : Nessun contatto fisico, quindi nessuna usura del supporto durante la lettura.
	- *Unità di misura* : I dati sono organizzati in blocchi da *2K* (2048 byte)

#### Formato di memorizzazione

[Per evitare errori di lettura (basta un granello di polvere per saltare un bit), il CD non scrive i byte "nudi e crudi", ma li protegge con una struttura a livelli].

1) **Dal Byte al Simbolo (Codificato 14-bit)**
	- Ogni *singolo byte* (8bit) viene trasformato in un *simbolo a 14 bit*. Per aggiungere ridondanza (Codice di Hamming). Se il laser legge male un pezzetto, il sistema può ricostruire il byte originale.
	
2) *La Gerarchia dei dati (La Matrioska)*.

	Ecco come si arriva al file finale :
	- *Simbolo* :14 bit (rappresenta 1 byte).
	- *Frame* : Un gruppi di 42 simboli consecutivi (588 bit totali).
	- *Settore (Sector)* :Un gruppo di *98 frame*.
	
![[Pasted image 20260415160244.png]]

---

#### I Settori dei CD-ROM

 Un CD non è solo un contenitore vuoto, ma organizza i dati in pacchetti precisi per garantire che siano leggibili.

*Punti chiave* :
1) **Le due Modalità (Modo 1 vs Modo 2)**: 
	Il CD-ROM deve gestire due tipi di contenuti diversi, e lo fa cambiando la struttura del settore: 
2) *Anatomia di un Settore* :
	 A) Il Preambolo (L'intestazione) = Serve al laser per capire dove si trova e contiene:
	   *12 byte fissi*.
	   *Numero del settore* : ovvero l'indirizzo del vagone e il modo ovvero specifica se è un settore di tipo 1 o 2.
	   *Il modo*: Specifica se è un settore di tipo 1(dati) o 2 (musica).
	B)*La Sezione dati (Il carico)*
		Nel **Modo 1** hai *2k(2048 byte)* di spazio per i tuoi file
		Nel **Modo 2** hai *2336 byte*
	C) *Il codice ECC* :Presente solo nel **Modo 1**, sono 288 byte di calcoli matematici che servono a ricostruire i dati se il disco è sporco o graffiato.
	 
*Modo 1 (Dati - Software)* : È usato per i programmi o i file di testo. Qui  l'integrità è fondamentale: se un bit è sbagliato, il programma crasha. Per questo viene aggiunto il codice *ECC (Error  Correction  Code)

*Modo 2 (Multimedia*): È usato per audio e video. Se un pixel di un fotogramma è leggermente diverso, l'occhio umano non lo nota nemmeno. Quindi si toglie la correzione d'errore per avere più spazio per i dati .

---

#### CD-Registrabili (CD-R)
- *Meccanismo* : Scrittura tramite laser infrarosso che brucia un pigmento organico.
- *Effetto* : Si creano zone oscure (pit) permanenti.
- *Struttura* : Policarbonato ->Pigmento -> Riflettente -> Vernice.
- *Curiosità*: La "scanalatura" guida il laser per mantenere la spirale perfetta durante la masterizzazione.

[La differenza tra CD-ROM E CD-R è che il primo ha dei pit fisici stampati meccanicamente mentre il secondo usa un laser per alterare chimicamente uno strato di pigmento e simulare quei pit].
![[Pasted image 20260415161748.png]]

---
#### CD-Riscrivibili (CD-RW)

- *Tecnologia*: Cambiamento di fase (Phase-change).
- *Stati*: Cristallino (riflette = 1) e Amorfo (non riflette = 0).
- *Laser*: Usa il calore per "ordinare" o "disordinare" gli atomi della lega metallica.
- *Limite*: Dopo circa 1000 cicli il materiale si "stanca" e non riesce più a cambiare stato correttamente

---
#### DVD (Digital Versatile Disk)

[La tecnologia di base è la stessa (PIT e LAND), ma il DVD è molto più "denso"].

- *Pit più piccoli*: $0.4\,\mu\text{m}$ (DVD) contro $0.8\,\mu\text{m}$ (CD). I "buchi" sono grandi la metà.
- *Tracce più strette*: La spirale è molto più fitta ($0.74\,\mu\text{m}$ contro $1.6\,\mu\text{m}$). C'è molto più filo su cui scrivere.
- *Laser Rosso* :Si usa un laser con una lunghezza d'onda minore ($0.65\,\mu\text{m}$), capace di leggere dettagli molto più piccoli.
- *Risultato* :La capacità passa da **650MB** a **4.7GB **.

Nascono 4 varianti di del DVD:
1) *Single-sided, Single layer* (4.7 GB): Il classico DVD.
2) *Single-sided, Dual layer* (8.5 GB): Un lato solo, ma co due stati di dati
3) *Double-sided, Single layer* (9.4 GB): Devi girare il disco sottosopra per leggere l'altra faccia.
4) *Double- sided, Dual layer* (17 GB): Il massimo della tecnologia due facce e due stati per ogni faccia.

---
# DISPOSITIVI INTERNI AL COMPUTER 

#### Scheda madre 

- *Cos'è la Scheda madre* : Piastra di bachelite o fibra di vetro, che fa 3 cose:

	- *Supporto fisico* :Tiene fermi i pezzi come CPU, RAM, Schede video.
	- *Alimentazione* :Distribuisce l'elettricità che arriva dall'alimentatore a tutti i componenti.
	- *Comunicazione (I BUS)* : È piena di minuscole piste di rame che collegano i componenti tra loro vengono chiamati **BUS**
	
- *Il concetto di I/O (Input/Output)* : 
	- *Input* : Tutto quello che manda dati verso la scheda madre (Tastiere, Mouse, Microfono).
	- *Output* :Tutto quello che riceve dati dalla scheda madre (Monitor, Casse, Stampante).
	
- *Analisi della Foto* e *Componenti Principali: 
1) Socket : Spazio dedicato al posizionamento della CPU
2) Slot : Per RAM (DIMM) e schede video (PCle).
3) Connettori : per la memoria secondaria (SATA/IDE).
4) (Chipset) : Diviso in NorthBridge e SouthBridge e decide chi  agisce per primo.
	
- ![[Pasted image 20260415164414.png]]
---
### BUS

- **Che cos'è**: 
	Il BUS Interno è il "sistema nervoso" del computer. È un canale di comunicazione condiviso che permette a tutte le componenti di scambiarsi dati, indirizzi e comandi.

- **Come funziona?** 
	1) *Struttura e Collegamenti*:
	
		- *Punto di incontro* : Collega la CPU, la Memoria centrale(RAM) e i Controller delle periferiche.
		- *I Controller* Ogni dispositivo (disco, tastiera, ecc) ha un'interfaccia chiamata Controller che fa da "ponte" tra il dispositivo e i bus 
		
	2)  *Le tre "Corise" del bus*: è composto da 3 gruppi di segnali SEPARATI
	
		- *Bus dati (Data bus)* : Trasporta i dati veri e propri (i bit che compongono un'immagine, un testo o un numero).
		- *Bus Indirizzi (Address Bus)* : Serve alla CPU per dire "con chi" vuole parlare. Specifica l'indirizzo della cella di memoria o del controller da contattare.
		- *Bus di Controllo (Control Bus)* :Trasporta i comandi (es; Leggi questo dato, Scrivi questo dato).
		
	3)  *Perché è fondamentale?* 
	
		- *Efficienza* : Riduce drasticamente il numero di fili necessari: senza il bus ogni componente dovrebbe avere un collegamento diretto con tutti gli altri.

---
# Esempi di lettura da disco


[Come avviene lo spostamento di un blocco di dati dal disco alla memoria centrale (RAM)? attraverso il bus.]

1) *Il ruolo del Controller* : Il dispositivo I/O (**l'hard disk**) non è "intelligente" abbastanza da gestire il bus da solo. Ha bisogno di un **Controller** che : 

	- Riceve i comandi dalla CPU
	- Legge fisicamente i dati dal supporto
	- Gestisce il passaggio dei dati sul bus
	
2) *Lettura senza DMA (Intervento della CPU)* :

	- La CPU invia un comando al controller per leggere un blocco. Il controller mette i dati sul *Bus Dati*, in seguito la CPU preleva i dati e li scrive in *Memoria*.
	
	- *Problema* : La CPU è impegnata in altre operazioni.
	
3) *Lettura con DMA (L'esempio principale)
	[Cos'è la DMA? ]: 
	- La CPU dà l'ordine d'inizio e poi torna a fare altro, il *Controller* legge il blocco di dati, che poi in seguito viene trasferito *direttamente nella memoria* (tramite Bus)
	
	- La CPU controllerà solo alla fine se il lavoro è terminato.

![[Pasted image 20260416160607.png|627]]
---
### DMA (Direct Memory Access)

[Quando il controller DMA finisce di spostare i dati non si limita a fermarsi. Invia un segnale di *Interrupt* alla CPU].

- *Cosa fa?* : "Interrompe" forzatamente il programma che la CPU sta eseguendo in quel momento.
- *Perché è necessario?* : La CPU deve sapere che i dati sono pronti per essere elaborati o che il trasferimento è andato a buon fine.

 [**Procedura speciale ISR (Interrupt Service Routine)**] : Non appena riceve il segnale, la CPU mette in pausa il suo lavoro e avvia un software specifico chiamato *ISR* (Conosciuto come interrupt handler). 
	
 - *ISR* ha due compiti fondamentali :
	1) *Verificare errori* 
	2) *Notifica al Sistema Operativo*
	
-  **Il ritorno**: Riprende l'esecuzione del programma precedente senza che l'utente si accorga di nulla.

##### [Chi comanda sul bus di sistema? ]

1) **Il bus come Risorsa Condivisa** : Sia la *CPU* che i *controller di I/O* hanno bisogno del bus per spostare dati. Il problema è che non possono usarlo contemporaneamente. 

	- *Priorità* : I controller di I/O hanno solitamente una priorità più alta rispetto alla CPU. Per quale motivo? perché i dispostivi esterni (come un disco che gira o una scheda di rete) spesso non possono aspettare se non muovono i dati subito, quei dati potrebbero andare persi.
	
2) **L'Arbitro del Bus (Bus Arbiter) **
	- Per evitare collisioni, esiste un chip dedicato chiamato *arbitro del bus* 
	- *Il suo ruolo* :Riceve le richieste da tutti i componenti e decide a chi dare il "pass" per usare il bus in quel preciso istante, basandosi su regole di priorità predefinite.
	
3) **Il "Furto di Cicli" (Cycle Stealing)** : Quando un controller DMA richiede il bus:  
	- L'arbitro gli concede sempre la precedenza.
	- La CPU, di conseguenza deve fermarsi e aspettare che il bus torni libero. 
	Questo fenomeno si chiama cycle stealing,  il DMA "ruba" ==dei cicli di clock alla CPU==.
	- *L'effetto* La CPU rallenta leggermente le sue prestazioni perché viene messa in pausa per brevi istanti.
	
	- *Il vantaggio* È comunque molto più efficiente che far fare tutto il lavoro alla CPU, che altrimenti resterebbe bloccata per l'intera durata del trasferimento.
---
#### BUS ISA

 [Il bus ISA (Industry Standard Architecture) rappresenta il punto di partenza dell'evoluzione dei sistemi di comunicazione nei primi PC]

1) $Il$ $limite$ $del$ $Bus$ $Condiviso$

	1.1)  Inizialmente l'utilizzo di un *solo bus condiviso* era una soluzione bilanciata per le prestazioni dei primi computer.
	
	1.2) Con il tempo l'aumento della velocità delle *CPU*, della *memoria* e del *numero di dispositivi* collegati ha trasformato il bus singolo in una *criticità* (collo di bottiglia).

2) $Caratteristiche$ $Tecniche$ ($ISA$ $ed$ $EISA)$

	2.1) BUS ISA : Era il bus singolo del primo PC
	- *Clock* :  $8,33$ **MHz**
	- *Banda* : $16,7$ **MB/sec**
	
	2.2) BUS EISA (Extended ISA) : Fu il successore diretto
	- *Banda* : Portò la velocità a $33,3$ **MB/Sec**
	
3) $L'avvento$ $del$ $Bus$ $PCI$ :
	Progettato da *Intel*, il bus **PCI (Peripheral Component Interconnect)** è diventato lo standard più popolare.
	-  *Clock:* $66$ **MHz**
    - *Banda:* $528$ **MB/sec** (un salto enorme rispetto all'ISA).
    
4) $La$ $strategia$ $di$ $Intel$ : 
	Per favorire la diffusione rapida del PCI sul mercato e tra i concorrenti, Intel scelse di rendere di *pubblico dominio tutti i brevetti* relativi a questa tecnologia.

$SINTESI$
- **ISA:** $16,7$ MB/sec.
    
- **EISA:** $33,3$ MB/sec (il doppio dell'ISA).
    
- **PCI:** $528$ MB/sec (circa 30 volte più veloce dell'ISA originale).
---

### Computer con due bus 
[L'architettura si è evoluta per gestire contemporaneamente periferiche di generazioni diverse (EISA e PCI)].

1) $Gerarchia$ $dei$ $bus$  :
	 Il sistema non usa più un'unica "strada", ma divide il traffico in base alla velocità :
	- *Linea dedicata CPU-Memoria* : CPU e memoria centrale comunicano tramite un bus dedicato ad *alta velocità*.
	
	- *Bus PCI* : Riservato ai *dispositivi veloci* 
	- *Bus ISA/EISA* : Utilizzato per i  *dispostivi più vecchi* o lenti
	
2) $Il$ $ruolo$ $dei$ $"Bridge"$ :
	Per far comunicare tra loro queste  diverse strade, vengono usati dei  componenti chiamati *Bridge*.
	- *PCI Bridge* : Collega la linea CPU/Memoria al bus PCI
	- *ISA Bridge* : Collega il bus PCI al bus ISA.
	
3) $Analisi$ $dello$ $Schema$ :
	Guardando il diagramma, notiamo la struttura a cascata : 
	- In alto : *CPU* e *Main Memory* sono connesse direttamente al *PCI Bridge*.
	- Al centro : Il *PCI bus* gestisce il traffico veloce (Video, Rete, SCSI)
	- In basso : Tramite l'*ISA bridge*, il segnale scende verso *l'ISA bus*, dove si trovano le periferiche più lente (scheda audio, stampante modem)
	![[Pasted image 20260416171028.png]]
---
### Bus PCIe (PCI Express)

- Il **PCIe** rappresenta l'evoluzione del bus PCI. Non è più un bus "condiviso", ma una *rete punto-punto*.

1) $Caratteristiche$ $Tecniche$
	- *Tecnologia* : Utilizza linee *seriali* di bit (invece che parallele).
	- *Trasmissione* : Funziona a *commutazione di pacchetto* (i dati vengono spediti come piccoli pacchetti, simile a come funziona internet).
	- *Prestazioni (PCIe 3.0)* : Raggiunge una larghezza di banda **17GB/sec** (rispetto ai 528MB/sec) del vecchio PCI è circa 32 volte più veloce.
	
2) $Architettura$ ($Analisi$ $dello$ $schema$): 
	 Il diagramma mostra una struttura molto più ramificata rispetto ai bus precedenti: 
	- *Root Complex* : È il "cuore" del sistema (integrato nel chipset o nella CPU). Collega la **CPU** E LA **Memoria** al resto della rete PCIe.
	
	- *Switch* : Agisce come un centralino intelligente. Riceve i dati dal Root Complex e li indirizza esattamente al dispositivo PCIe e di destinazione, permettendo a più dispositivi di comunicare senza interferire tra loro.
	
	- *Bridge PCI* : Per mantenere la compatibilità con il passato, un bridge permette ancora di collegare i vecchi **Dispositivi PCI**
	
3) $Differenza$ $chiave$: $Punto-Punto$ :
	A differenza del vecchio bus dove tutti i dispositivi "sentivano" i dati degli altri (bus condiviso) nel PCIe ogni dispostivo ha una *linea diretta e dedicata* verso il Root Complex o lo Swtich
	
	 ![[Pasted image 20260419210751.png]]

---
# Dispostivi di I/O (Input/Output)

[L'interazione con il mondo esterno è essenziale per permettere ai computer (macchine precise ma isolate) di ricevere un istruzione e fornire risultati in una forma comprensibile agli essere umani]

$Classificazione$ $delle$ $Periferiche$ : 

Le periferiche esterne si dividono in due categorie principali:

1) *Dispostivi di Input* : Servono per *inserire dati* dall'esterno all'interno del computer. Un esempio sono le Tastiere, mouse, scanner, microfono.

2) *Dispositivi di Output* : Servono per *fornire/mostrare dati* dal computer verso l'esterno. Un esempio sono i Monitor, stampanti.

---

### Tastiere 

$Cosa$ $dobbiamo$ $sapere$:

1) **Tecnologie varie** : Le tastiere si basano su diverse tecnologie per rilevare l'input (contatti meccanici, induzione elettromeccanica ecc).

2) **Primo Interrupt** : La pressione di un tasto genere un *Interrupt* immediato verso la CPU.

3) **Gestore dell'Interrupt** : Il Sistema Operativo cattura il segnale e avvia un software specifico il cui compito è leggere il *codice corrispondente* al tasto premuto.

4) **Secondo Interrupt** : Viene generato un altro segnale nel momento in cui il tasto viene *rilasciato*

### Monitor LCD (Liquid Crystal Display) (Output)

$Cosa$ $dobbiamo$ $sapere$:

1) **Composizione** : Lo schermo è composto da molecole organiche viscose. Queste hanno la particolarità di potersi muovere come un **liquido**, mantenendo però una struttura spaziale ordinata tipica di un cristallo.

2) **Funzionamento** L'applicazione di un *campo elettrico* modifica l'allineamento di queste molecole.

3) **Effetto Ottico** : Cambiando l'orientamento delle molecole, cambiano le loro proprietà ottiche, permettendo di regolare l'intensità della luce che le attraversa.

4) **Evoluzione e Diffusione** : Inizialmente scelti per i *Laptop* grazie allo spessore ridotto, oggi sono diventati lo standard in ogni settore tecnologico.
---

### Video RAM (VRAM) e Bus Grafici 

[Analizza la memoria dedicata alla gestione delle immagini e il collegamento con la CPU].

1) **VRAM (Video RAM)**: Memoria speciale situata nel controller video, necessaria per gestire il refresh dello schermo (60/100 Hz).

2) **Bitmap** : La VRAM contiene una rappresentazione dell'immagine (bitmap); l'uso di *due bitmap* contemporaneamente facilita la fluidità del passaggio tra le immagini.

3) **Profondità Colore** : Ogni pixel è identificato da 3 *byte* (24 bit), corrispondenti ai colori primari **RGB** (Red, Green, Blue).

4) **Necessità di Bus Specifici (AGP/PCIe)**:  Rappresentare un video richiede una banda minima di *155 MB/s*. Poiché i bus standard dell'epoca (EISA o PCI 132 MB/s) erano troppo lenti, sono stati creati bus dedicati: L'**AGP (Accelerated Graphics Port)** e successivamente il **PCIe**.

---
### Dispositivi di puntamento 

[L'introduzione di strumenti in grado di puntare oggetti sullo schermo è diventato essenziale con l'evoluzione delle interfacce grafiche].

- **Evoluzione del software** : 
	Il passaggio dalle interfacce a caratteri (*Linea di comando*) a quelle basate su icone (*punta e clicca*) ha creato la necessità di questi dispositivi.
	
- **Esempi di tecnologie citate** :
	Mouse generico, Magic Trackpad, Stick di puntamento.

##### Mouse 

[Nel tempo sono stati realizzati tre diversi tipi di  mouse basati su tecnologie differenti] : 

- *Meccanico* : Utilizza una *pallina* che muove due potenziometri. La distanza percorsa viene calcolata in base al valore delle sue resistenze rilevate nei due assi.

- *Ottico* : Un **LED** illumina la superficie. Una piccola fotocamera rileva le imperfezioni del fondo per comprendere il movimento del dispositivo.

- *Opto-meccanico* : simile al meccanico (dotato di pallina), ma muove due cilindretti perpendicolari con dei fori. La distanza viene calcolata attraverso il *Passaggio della luce* attraverso i fori durante la rotazione.

---
### Stampanti

**Definizione**:  È un dispositivo di *uscita* (output) che permette di trasferire documenti elettronici su un supporto fisico (tipicamente carta).

1) **Tecnologie principali** : 
  - *A matrice* : Monocromatiche o bi-cromatiche
  - *A getto d'inchiostro* : Monocromatiche e a colori.
  - *Laser* monocromatiche a colori

1) **Settore professionale (Alta qualità)** : 
   Esistono tecnologie specifiche per mercati professionali: 
- Ad inchiostro solido 
- A getto di cera
- A sublimazione

### Stampanti ad impatto a matrice 

**Come funzionano**?: Usano una testina come una *matrice di aghi* che colpiscono un nastro inchiostrato mentre scorrono sul foglio.

**Qualità variabile** : Si può migliorare la risoluzione aumentando il numero di aghi o ripassando più volte sulla stessa riga (*overlapping).

**Pro e Contro** 
- *Pro* : Il nastro costa poco e dura molto; sono le uniche che possono stampare su *Moduli multicopia* (grazie all'impatto fisico)
- *Contro* : Sono rumorose, lente e hanno una qualità grafica bassa.

- **Usi principali** : Grandi moduli prestampati, Ricevute, Documenti che richiedono la copia carbone.

### Stampanti a getto d'inchiostro (inkjet)

**Meccanismo** : Simile alle stampanti ad impatto, ha una *testina mobile* che scorre orizzontalmente mentre il foglio avanza. L'inchiostro viene spruzzato sul foglio attraverso piccoli *ugelli*.

*Tecnologie di espulsione* : Esistono due modi per spruzzare l'inchiostro :

- *Piezoelettriche (Epson)* : Usano un cristallo che si deforma con la tensione elettrica e spinge fuori l'inchiostro. Più tensione c'è più inchiostro esce.
- *Termiche (Canon, HP, Lexmark)* : Dette anche "a getto di bolle". Una resistenza scalda l'inchiostro finché la pressione lo spinge fuori dall'ugello 

**Caratteristiche** : Sono economiche e silenziose con una buona qualità di stampa.
**Svantaggi** : Sono lente e hanno *costi di manutenzione elevati* a causa del prezzo delle cartucce


### Stampanti Laser 

$Caratteristiche$ $generali$ :
	Combinano un'altra qualità di stampa, velocità elevata, silenziosità e costi di gestione moderati.
	
$Tecnologia$ :
	Utilizzano un sistema simile a quello delle macchine fotocopiatrici.
	
$Il$ $Tamburo$ (*Drum*):  È il cuore della stampante. Si tratta di un cilindro rotante di precisione rivestito di materiale fotosensibile.

$Processo$ $di$ $stampa$ :
1) *Carica* : All'inizio del ciclo, il tamburo viene caricato elettricamente fino a 1000v.

2) *Esposizione* : Un raggio **laser** modulato colpisce il tamburo mentre ruota, facendogli perdere la carica nelle zone colpite (creando l'immagine elettrostatica).

3) *Sviluppo* : Il tamburo ruota e attrae sulle zone cariche la polvere nera chiamata *toner* (che è elettrostaticamente sensibile).

4) *Trasferimento* : Il toner passa dal tamburo al foglio di carta.

![[Pasted image 20260421175040.png]]


---
### Apparati per le telecomunicazioni 


- **Connessione alla rete**: Chiunque utilizzi internet da casa necessita di un apparato per connettersi tramite la linea telefonica.

- **Il doppino telefonico** : Nato per la trasmissione **analogica** dell'audio, non è adatto nativamente ai segnali binari (digitali). È quindi necessario convertire i segnali digitali in analogici. 

- **La Portante** : Si utilizza un segnale sinusoidale (detto portante) con frequenza tra **1 kHz e 2kHz**, che subisce una distorsione accettabile sulla linea.

$NOTE$ : Una sinusoide è l'**onda perfetta**. È un segnale che oscilla in modo fluido e regolare nel tempo. Le tre caratteristiche che la definiscono (e che il modem modifica) sono : **Ampiezza, Frequenza e Fase**.

- **Trasmissione binaria** : Variando le tre caratteristiche della sinusoide, è possibile "codificare" e trasmettere informazioni binarie (0 e 1).

- **Modulazione di ampiezza** : Nello specifico, si utilizzano due diverse tensioni (ampiezze della sinusoide) per rappresentare i valori binari.
	- Una tensione per il valore 0 
	- Una tensione diversa per il valore 1 

![[Pasted image 20260422093319.png]]

---

## Modem e la Modulazione

[Oltre alla modulazione di ampiezza vista prima, esistono altri due modi per "nascondere" i bit dentro un'onda analogica].

- **Modulazione di frequenza (FSK)** : L'ampiezza dell'onda resta uguale, ma cambia la velocità dell'oscillazione.
	- **Alta frequenza** = 1
	- **Bassa frequenza** = 0
	
- **Modulazione di fase (PSK)** : Ampiezza e frequenza restano costanti, ma l'onda subisce un "salto" (cambio di fase) in corrispondenza del passaggio tra **0** e **1**

 - **Cos'è il Modem** : 
	 Il nome è l'abbreviazione del **MO**dulatore-**DEM**odulatore. È il dispositivo che: 
 
	1) *Modula* : Trasforma i segnali digitali (bit) del PC in segnali analogici per inviarli sulla linea.
	2) *Demodula* : Trasforma i segnali analogici in arrivo dalla linea in segnali digitali comprensibili al PC

		![[Pasted image 20260422095839.png|333]]
Prima linea rossa = Modulazione di frequenza .
Seconda linea rossa = Modulazione di fase.

---

## Digital Subsciber Line (DSL)

- **Obiettivo** : Tecnologia nata per superare i limiti di velocità dei vecchi modem ($56 \text{ Kbps}$), causati dal fatto che la linea telefonica era stata progettata originariamente solo per la voce.

- **ADSL (Asymmetric DSL)** : È la variante più diffusa. Si definisce "asimmetrica" perché offre velocità diverse per il download (ricezione) e l'upload (invio).

- **Local Loop (Ultimo Miglio)** : È il cavo di rame che collega l'abbonato alla centrale telefonica (armadietto TELCO).

- **Frequenze e Filtri** : Inizialmente la banda era limitata a soli $3 \text{ kHz}$ a causa di filtri fisici.
	- La tecnologia DSL rimuove questi limiti: banda disponibile dipende dalla lunghezza del cavo (solitamente pochi km) e può arrivare a 1,1 $MHz$. 
- **Canali Indipendenti** : 
	 Questa banda  $1,1 \text{ MHz}$ viene suddivisa in **256 canali indipendenti**, ciascuno  ampio  $4,3 \text{ kHz}$, per ottimizzare la trasmissione dei dati.
	![[Pasted image 20260422101200.png|375]]

## Asymmetric Digital Subscribe Line (ADSL)

Ora spiegheremo come vengono utilizzati i **256 canali** visti precedentemente per permettere il funzionamento di internet e dal telefono insieme.
- **Divisione dei Canali** 
	- **Canali 0** : Dedicato al servizio telefonico tradizionale (**POTS** Plain Old Telephone Service). È per questo che puoi telefonare mentre navighi.
	- **Canali 1-5** : Non vengono utilizzati (servono come "zona cuscinetto" per evitare interferenze tra voce e dati).
	- **Canali di Controllo** : Due canali sono riservati alla gestione del traffico in uscita (**upstream**) e in entrata (**downstream**).
	- **Canali Dati** : I restanti **248 canali** sono usati esclusivamente per lo scambio dati.
	
- **Potenza di calcolo** : Un sistema ADSL equivale praticamente alla potenza di **250 modem** che lavorano insieme.

- **L'Asimmetria** : Poiché gli utenti medi scaricano molti più dati (web, video) di quanti ne inviino, i provider assegnano **l'80-90% della banda al download**.  Questa differenza di velocità crea l'asimmetria tipica dell'ADSL.

![[Pasted image 20260422101949.png|403]]

---
### Codifica dei caratteri 

[Per interagire con gli esseri umani, il computer deve essere in grado di riconoscere i simboli dell'alfabeto]. 

- **Definizione di Codice** : La corrispondenza tra un carattere (lettera/simbolo) e un numero naturale è detta **codifica dei caratteri**

- **Standardizzazione** : Per permettere a computer diversi di comunicare tra loro senza errori di interpretazione, sono stati creati degli standard universali.

- **Standard principali** : 
	- **ASCII** (American Standard Code for Information Interchange): Lo standard più storico di base.
	- **UNICODE** : standard universale che copre quasi tutti i sistemi di scrittura del mondo.
	- **UTF-8** la codifica più diffusa sul web (compatibile con ASCII).


### ASCII 

[È lo standard di codifica dei caratteri più diffuso]. 
- **Struttura**  : Utilizza *7 bit*, permettendo di definire **128 caratteri totali**
- **Caratteri di controllo** : I codici da 00 a 1F (es. NUL, TAB, LF) sono caratteri di controllo **non stampabili**, usati per gestire la trasmissione o il formato del testo.
- ![[Pasted image 20260422102733.png|392]]

#### Problema  del codice ASCII 
[Sebbene rivoluzionario, il codice ASCII standard presenta limitazioni strutturali che ne hanno richiesto l'evoluzione] :

- **Limiti linguistici**  : È perfetto per la lingua inglese, ma non gestisce i caratteri speciali di altre lingue (es. accenti francesi, segni diacritici tedeschi come la dieresi). 

- **Mancanza di simboli** : Molti simboli matematici scientifici o alfabeti diversi (greco $\Omega$, tedesco $\beta$, ecc.) non sono inclusi nei 128 caratteri originali. 

- **Alfabeti non latini** Lingue come il russo (cirillico) o l'arabo richiedono set di caratteri completamente diversi.

- **Lingue ideografiche** : Lingue come il cinese non usano il concetto di alfabeto e richiedono migliaia di simboli, impossibili da mappare con pochi bit.

- **Il tentativo di "ASCI Esteso"** : Per risolvere parte dei problemi è stato aggiunto **1 bit** alla codifica (passando da 7 a **8bit**).

	- Questo ha raddoppiato i caratteri disponibili (**256** invece di 128).
	- Le prime 128 posizioni sono rimaste identiche all'ASCII originale per compatibilità.
	- **Esito** : Questo tentativo non è stato soddisfacente perché 256 caratteri sono comunque troppo pochi per coprire tutte le lingue del mondo contemporaneamente.

---
### Unicode 

[Dato che l'ASCII (anche quello esteso a 256 caratteri) non bastava per tutte le lingue del mondo, è nato lo standard **UNICODE**].

- *Il Consorozio* : Un gruppo di grandi  aziende informatiche si è unito per creare un sistema di codifica universale.
- *I 16-bit e i Code Point* :
	- A differenza dell'ASCII, UNICODE assegna a ogni carattere un valore di *16 bit* ( chiamato *code point*).
	- Con 16 bit, le combinazioni possibili passano da 256 a ben *65.536*.

- *Compatibile con ASCII : 
	- Per facilitare il passaggio del vecchio al nuovo sistema, i primi 256 caratteri di UNICODE (code point da 0 a 255 ) sono *identici* alla mappa ASCII.
	- In questo modo, un documento scritto in ASCII può essere convertito in UNICODE molto facilmente. 

### Limiti di UNICODE 

[Nonostante UNICODE sia lo standard universale, noteremo come esistano ancora delle sfide legate alle culture locali]. 

- *Ordinamento* : Gestire l'ordine alfabetico o logico degli ideogrammi (come quelli cinesi o giapponesi) nella mappa non è banale.

- *Nuovi Ideogrammi* : A differenza delle parole occidentali (composte da lettere esistenti), in alcune culture nascono nuovi simboli grafici che devono essere aggiunti.

- *Caratteri "Confondibili"* : UNICODE a volte usa la stessa codifica per caratteri che appaiono uguali visivamente ma hanno significati e origini diverse in culture differenti (questo accade perché i codepoint sono vasti ma non infiniti).

---
### UTF-8 

[Lo standard **UTF-8** (Universal Charcater Set Transformation Format) è nato per ottimizzare Unicode, che presentava due problemi principali].

1) **Spreco di spazio** : Unicode usa sempre 16 bit (2byte), anche per i caratteri semplici come la "A", raddoppiando la dimensione dei file di testo occidentali.
2) **Esaurimento posti** : Per alcune lingue (come il giapponese che ha oltre 50.000 simboli Kanji), i 65.536 posti di Unicode stavano iniziando a stare stretti.

**Caratteristiche principali di UTF-8** : 

- **Lunghezza Variabile** : A differenza di Unicode, UTF-8 usa da *1 a 4 byte* per carattere. 

- **Efficienza con ASCII** : I primi 128 caratteri (quelli della tastiera standard) usano solo *1 byte*. Questo lo rende retrocompatibile al 100% con ASCII senza sprecare memoria.

- **Capacità enorme** : Può codificare circa *2 miliardi di caratteri*, risolvendo il problema delle lingue orientali.
 
- **Standard del Web** : È la codifica universale utilizzata oggi su internet (**WWW**).

**Come funziona il meccanismo dei Byte**
- Se il computer legge un byte che inizia con lo 0, sa che è un carattere singolo (tipo di ASCII).
- Se il bit più significativo (il primo) è 1, il computer capisce che quel carattere non è finito e che deve leggere anche i byte successivi

### Il funzionamento tecnico di UTF-8

[Se Unicode era il "dizionario", UTF-8 è il "metodo di scrittura" intelligente. La caratteristica rivoluzionaria è che il computer capisce quanti byte leggere semplicemente guardando l'inizio del primo byte].

**La regola dei bit iniziali**
UTF-8 utlizza un sistema di "segnaletica" nei bit più significativi (quelli a sinistra).
- **1 Byte (ASCII)**:  Se il byte inizia con 0 (es 0xxxxxxx). È il risparmio massimo per i caratteri occidentali.

- **Più Byte** : Se il carattere è complesso (emoji, simboli orientali), il primo byte indica il numero totale di byte necessari: 
	- - **`110xxxxx`**: servono **2 byte** in totale.
    
	- **`1110xxxx`**: servono **3 byte** in totale.
    
	- **`11110xxx`**: servono **4 byte** in totale.
- **Byte di continuazione** : Tutti i byte successivi al primo iniziano sempre con 10xxxxxx. Questo serve al computer per non confondersi se "inizia a leggere a metà" di un file.
![[Pasted image 20260423132129.png|402]]


### Vantaggi di UTF-8 


- **Ottimizzazione dei byte** 

	-  UTF-8 è "furbo". Se deve scrivere un testo semplice (come i vecchi codici **ASCII**), usa **solo 1 byte**.
	
	- Questo significa che un file di testo in inglese non occupa spazio extra rispetto al passato, a differenza di UNICODE puro che ne userebbe sempre due.
- **Auto-sincronizzazione** : 

	- È una caratteristica tecnica fondamentale : guardando il primo byte, il computer capisce immediatamente **quanti byte compongono la codifica** di quel carattere specifico.
	
	- Se un byte viene perso o corrotto durante la trasmissione, il computer può "sincronizzarsi" di nuovo appena incontra l'inizio del carattere successivo.

- **Flessibilità Infinita** :
	- La slide sottolinea che UTF-8 è "a prova di futuro". Anche se scoprissimo nuove lingue o inventassimo migliaia di nuove emoji, lo standard sarebbe in grado di codificarle tutte senza dover cambiare sistema.

$SINTESI$ : Mentre L'ASCII era un sistema "chiuso" e rigido, **UTF-8 è un sistema elastico**. Si stringe per risparmiare spazio con le lettere semplici e si allunga quando deve gestire simboli complessi, rendendolo lo standard perfetto per il WorldWideWeb.