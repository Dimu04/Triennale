Appunti aggiornati e riordinati con le definizioni chiare di **Core**, **Multi-Core** e **Hyper-Threading (SMT)** incluse proprio all'inizio.
  

# Architettura dei Calcolatori

### Concetti Chiave da Ricordare (Lessico Hardware)

- **Core (Nocciolo):** È una singola unità di elaborazione fisica completa (il "cervello" reale dotato di proprie ALU, registri e Cache L1/L2).
    
      
    
- **Multi-Core:** Presenza di **più CPU/Core indipendenti stampati all'interno dello stesso chip fisico**. Comunicano a bassissima latenza attraverso la memoria Cache L3 condivisa.
    
      
    
- **Thread:** È una singola sequenza/flusso di istruzioni di un programma in esecuzione.
    
      
    
- **Hyper-Threading (o SMT - Simultaneous Multithreading):** Tecnologia hardware che duplica i registri interni di un singolo Core fisico per fargli gestire **2 thread contemporaneamente**. Il Sistema Operativo "vede" il doppio delle CPU rispetto a quelle fisiche reali (es. 4 Core fisici con Hyper-Threading = 8 CPU logiche).
    
      
    

## Esempi di CPU

### INTEL CORE i7 (Multicore Moderno a 64-bit)

- **Struttura Multi-Core:** Integra 4 (o più) Core fisici indipendenti su un singolo chip di silicio.
    
      
    
- **Hyper-Threading:** Ogni Core gestisce 2 thread paralleli (il Sistema Operativo vede **8 CPU logiche**).
    
      
    
- **Gerarchia a 3 Livelli di Cache:**
    
      
    - **L1 & L2:** Dedicate privatamente a ciascun singolo Core (velocissime).
        
          
        
    - **L3:** Di grandi dimensioni, **condivisa** tra tutti i Core per scambiare dati rapidamente senza passare dalla RAM.
        
          
        
- **Bus QPI (QuickPath Interconnect):** Sostituisce il vecchio bus condiviso (FSB) con connessioni seriali punto-a-punto ad alta velocità tra CPU, RAM e chipset.
    
      
    

### PENTIUM 4 (CPU Monocore x86)

- **Compatibilità:** Gestisce dati su corsie interne a 64-bit ma dal punto di vista software lavora a **32-bit** per garantire la retrocompatibilità con l'architettura x86 (80386/80486).
    
      
    
- **Bus Sincroni Primari:**
    
      
    1. **Primary BUS (o Front Side Bus):** Usato per accedere alla memoria principale (RAM).
        
          
        
    2. **BUS PCI:** Usato per gestire le periferiche di I/O.
        
          
        
- **Microarchitettura NETBURST:**
    
      
    - **Pipeline profonda:** Divide l'esecuzione in molti micro-passaggi per raggiungere frequenze di clock elevate (GHz).
        
          
        
    - **ALU a frequenza doppia:** Lavora a velocità doppia rispetto al clock generale.
        
          
        
    - **Hyper-Threading di 1ª generazione:** Introduce 2 insiemi di registri distinti per simulare 2 CPU fisiche.
        
          
        
- **Snooping (Consistenza della Cache):** Spia continuamente l'Address Bus per verificare che i dati in cache siano sempre aggiornati e coerenti con la memoria RAM.
    
      
    
- **Pin e Segnali (478 pin):**
    
      
    - `BR0#` / `BPRI#` / `LOCK#`: Arbitraggio del bus.
        
          
        
    - `RS#` (codice di stato), `TRDY#` (slave pronto), `BNR#` (stato di attesa - wait state).
        
          
        
- **Gestione Energetica:** 5 stati di funzionamento dal regime **Attivo** fino al **Sonno Profondo (Deep Sleep)**, dove il clock si spegne e il risveglio avviene solo via segnale hardware.
    
      
    

### ULTRASPARC III (CPU RISC a 64-bit per Server)

- **Architettura RISC:** Esegue istruzioni semplici e a lunghezza fissa, progettate per un'esecuzione rapida (filosofia **Load/Store**: operazioni algebriche solo su registri, accesso alla RAM solo via `LOAD`/`STORE`).
    
      
    
- **Pipeline:** Esegue fino a 4 istruzioni per ciclo di clock su pipeline dedicate (da 2 a 14 stadi per interi, 2 per virgola mobile, 1 per memoria, 1 per salti/branch).
    
      
    
- **Bus Dati Ampio:** Bus verso la RAM a **128 bit** per un throughput elevatissimo.
    
      
    
- **Gestione della Cache:**
    
      
    - Cache L1 divisa (Istruzioni e Dati).
        
          
        
    - Cache L2 esterna gestita da un controller di cache integrato nel chip.
        
          
        

### MICROCONTROLLORE 8051 (Embedded / Basso Costo)

- **Caratteristiche:** Dispositivo integrato su singolo chip a 40 pin (16-bit Address Bus, 8-bit Data Bus, 32 linee di I/O).
    
      
    
- **Segnali e Pin Principali:**
    
      
    - **EA (External Access):** Se Low ($0$) usa la sola memoria esterna; se High ($1$) usa la ROM interna.
        
          
        
    - **RD / WR:** Linee di lettura e scrittura.
        
          
        
    - **ALE:** Indica la presenza di un indirizzo valido sul bus.
        
          
        
    - **TXD / RXD:** Linee di trasmissione e ricezione seriale.
        
          
        
    - **RST:** Reset hardware del chip.
        
          
        

## Esempi di BUS

### BUS ISA ed EISA

- **ISA:** Bus a 8 bit con frequenza a 8,33 MHz.
    
      
    
- **EISA:** Successore a 32 bit con larghezza di banda maggiorata.
    
      
    
- _Limite:_ Velocità insufficiente per la gestione di contenuti multimediali moderni.
    
      
    

### BUS PCI (Parallel Component Interconnect)

- Bus condiviso a 66 MHz per connettere schede di espansione e I/O.
    
      
    
- **Arbitraggio Centralizzato:** Un componente "Arbitro" (integrato nel chip Bridge) gestisce le richieste d'accesso tramite le linee:
    
      
    - `REQ#` (Richiesta bus dal dispositivo).
        
          
        
    - `GNT#` (Concessione del bus dall'arbitro).
        
          
        

### BUS PCI Express (PCIe)

- Sostituisce il bus condiviso con una **rete punto-a-punto seriale commutata via Switch**.
    
      
    
- Comunicazione a pacchetti con controllo d'errore (CRC).
    
      
    
- Architettura scalabile (aggiunta di nuovi switch) e connettori ridotti.
    
      
    

### BUS USB (Universal Serial Bus)
#### 1) Architettura generale
- Standard seriale a stella gestito da un **Root Hub** per periferiche a velocità ridotta è presente anche una connessione punto-a-punto, non è consentita la comunicazione diretta tra due periferiche.
- **Assenza di Interrupt Hardware tradizionali:** Gestito a intervalli regolari via software/polling (frame periodici).
####  2) Gestione dei Dispostivi 
( Il Root Hub rileva il collegamento e genera un'interrupt per il SO che interroga il dispositivo per conoscere il tipo e la banda.)
- **Root Hub $\rightarrow$ CPU:** Usa un **interrupt hardware reale** (via bus di sistema) solo per eventi di gestione come il _Plug & Play_ (connessione/disconnessione).
    
- **Periferica $\rightarrow$ Root Hub:** **Nessun interrupt hardware**; l'hub interroga le periferiche a tempo (polling ogni $1\text{ ms}$) invia un broadcast chiamato **FRAME**.
#### 3) 4 Tipi di Frame (Trasferimenti)

- **Controllo:** Utilizzati per configurare, inviare comandi e interrogare lo stato del dispositivo.
    
- **Isocroni:** Dati in tempo reale senza ritrasmissione in caso di errore (es. microfoni, audio, streaming video).
    
- **Bulk:** Grandi quantità di dati non in tempo reale, con garanzia di correttezza (es. stampanti, chiavette USB).
    
- **Interrupt:** Simulano le interruzioni interrogando la periferica a intervalli regolari (polling) per dispositivi come mouse e tastiere.

#### 4) 4 Tipi di pacchetti (Contenuti nei Frame)

- **Token (Controllo):** Pacchetti inviati dall'hub per dirigere il traffico.
    
    - `SOF` (_Start-Of-Frame_): Segnala l'inizio di un nuovo frame temporale.
        
    - `IN`: Chiede alla periferica di inviare dati verso l'hub.
        
    - `OUT`: Avvisa la periferica che l'hub le sta inviando dati.
        
    - `SETUP`: Invia comandi di configurazione alla periferica.
        
- **Dati:** Trasportano il carico utile (_Payload_). Sono composti da:
    
    - **8 bit di sincronizzazione (`SYN`)**
        
    - **Identificatore tipo pacchetto (`PID`)**
        
    - **Payload** (i dati veri e propri)
        
    - **CRC a 16 bit** (per il controllo degli errori)
        
- **Handshake (Risposta/Conferma):**
    
    - `ACK`: Dati ricevuti correttamente (CRC valido).
        
    - `NAK`: Errore nei dati/CRC oppure dispositivo occupato.
        
    - `STALL`: Il dispositivo è bloccato o richiede attenzione.
        
- **Speciali:** Riservati per usi e funzioni specifiche del protocollo.

![[Pasted image 20260926223559.png]]
## Interfacce I/O

- **Chip Standard:**
    
      
    - **UART:** Conversione dati da parallelo (bus) a seriale (1 bit alla volta).
        
          
        
    - **USART:** UART con supporto alla trasmissione sincrona.
        
          
        
    - **PIO:** 
    - La **PIO** è un'interfaccia programmabile che gestisce la comunicazione parallela tra CPU e periferiche, trasferendo più bit contemporaneamente (es. 8, 16, 32 bit) su linee fisiche dedicate.
	    - Inoltre la **PIO**  è composta da registri interni Data register, Control Register, Statu Register, DDR (Data Direction Register)
	    - E la **Sincronizzazione** avviene tramite l'**Handshaking** lo stesso dei bus asincroni.

	- (**Gestione del Flusso)
		- **Polling:** La CPU controlla ciclicamente il Registro di Stato finché il dato non è pronto.
	    - **Interrupt:** La PIO interrompe la CPU tramite hardware solo quando il trasferimento è completato.
        
          
        
- **Tipologie di Indirizzamento dell'I/O:**
    
      
    1. **Port-Mapped I/O (Isolato):** L'I/O ha uno spazio di indirizzi separato dalla RAM. Richiede una linea del Control Bus dedicata per distinguere l'accesso e istruzioni assembly specifiche (`IN`, `OUT`).
        
          
        
    2. **Memory-Mapped I/O:** L'I/O condivide lo stesso spazio di indirizzamento della memoria RAM. Si usano le normali istruzioni di lettura/scrittura in memoria (`MOV`, `LOAD`, `STORE`).