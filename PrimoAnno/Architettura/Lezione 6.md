# Il livello di microarchitettura e macro architettura


# 1. Livelli di Astrazione dell'Architettura

Il corso si fonda sul modello di stratificazione a livelli del calcolatore:

- *Livello 0* (*Digital Logic*): La logica digitale, ovvero i circuiti elettronici, le porte logiche e i flip-flop.

- *Livello 1*(*Microarchitecture*): Il livello di microarchitettura, dove risiedono il data path (percorso dati) e la memoria di controllo che segue le microistruzioni.

- *Livello 2 (ISA- Instruction Set Architecture)*: Il livello di macroarchitettura, ovvero l'interfaccia/linguaggio macchina direttamente visibile dal programmatore o dal compilatore.

- *Livelli 3,4,5* : Sistemi operativi, linguaggio Assembly e linguaggi di alto livello (come C, Java, Fortran).

Il livello di *Microarchitettura (livello 1)* ha il compito di interpretare ed eseguire direttamente le istruzioni del *ISA (livello 2)*.


![[Pasted image 20260926170933.png]]

# 2. Il ciclo di Esecuzione e il Data path 

L'esecuzione di ogni istruzione segue un modello basilare in 3 fasi:

1) Fetch : Recupero dell'istruzione dalla memoria.
2) Decode : riconoscimento del tipo di istruzione.
3) Execute : Svolgimento dell'operazione da parte dei circuiti della CPU.

**Il Data Path** (Percorso Dati)
Il Data Path rappresenta il cuore operativo della CPU. È formato da:

- **ALU (Arithmetic Logic Unit):** Esegue calcoli aritmetici e logici guidati da 6 linee di controllo ($F_0, F_1, \text{ENA}, \text{ENB}, \text{INVA}, \text{INC}$) che generano flag come $N$ (negativo) e $Z$ (zero).

- **Shifter** : Posizionato all'uscita dell'ALU, effettua lo scorrimento dei bit a destra o a sinistra. 

- **Bus(B e C)** : Il bus B trasporta i dati dai registri verso l'input B dell'ALU, mentre il bus C riporta il risultato dell'ALU/Shifter nei registri. L'input A dell'ALU è sempre alimentato dal registro *H (Holding)*.

- **Registri interni** : 
	- **MAR/MDR** : Registri di indirizzo e dato per interfacciarsi con la memoria a parole (32 bit).
	- **PC/MBR**: Program Counter e Memory Byte Register (usato per leggere lo stream di byte delle istruzioni).
	- **SP, LV, CPP, TOS, OPC :** Registri specifici per la gestione dello stack, delle variabili locali e dei puntatori.

**Ciclo di Clock**
Nel corso di un ciclo di clock (suddiviso nelle sotto-fasi $\Delta w, \Delta x, \Delta y, \Delta z$), i segnali stabilizzano i bus, l'ALU esegue il calcolo, lo shifter applica lo scorrimento e il risultato viene riscritto nel registro di destinazione attraverso il bus C.
 
![[Pasted image 20260926173052.png]]



### 3. La Microarchitettura Mic-1 e il formato delle Microistruzioni

La **Mic-1** è una microarchitettura d'esempio basata su microprogramma:

- **Control Store:** Una memoria interna speciale (512 parole $\times$ 36 bit) che contiene l'insieme delle **microistruzioni** (il microprogramma).
    
- **MIR (Microinstruction Register) & MPC (Microprogram Counter):** MPC punta alla prossima microistruzione da caricare nel registro MIR.
    
- **Formato della Microistruzione (36 bit):**
    
    - `Addr` (9 bit): Indirizzo della potenziale microistruzione successiva.
        
    - `JAM` (3 bit): Gestisce i salti condizionati in base ai flag $N$ e $Z$ dell'ALU.
        
    - `ALU` (8 bit): Controlla la funzione dell'ALU e dello shifter.
        
    - `C` (9 bit): Seleziona su quali registri scrivere il risultato dal bus C.
        
    - `Mem` (3 bit): Invia i comandi di lettura/scrittura alla memoria.
        
    - `B` (4 bit): Seleziona quale registro deve depositare il proprio dato sul bus B.

![[Pasted image 20260926174132.png]]

### 4. Esempio di ISA: la macchina IJVM (Integer Java Virtual Machine)

La IJVM è un'architettura ISA d'esempio basata su un modello **a Stack (LIFO)**:

- **Modello di Memoria:** Considera la memoria come uno spazio di 4 GB diviso in parole da 32 bit, ripartito in:
    
    - **Constant Pool:** Area costanti puntata da `CPP`.
        
    - **Local Variable Frame:** Variabili locali puntate da `LV`.
        
    - **Operand Stack:** Cima dello stack puntata da `SP`.
        
    - **Method Area:** Area contenente il codice eseguibile puntata da `PC`.
        
- **Notazione Polacca Inversa (RPN):** Le espressioni matematiche vengono convertite da forma infissa ad algebrica postfissa (senza parentesi) per consentirne la rapida valutazione impilando gli operandi ed eseguendo le operazioni sui valori affioranti nello stack (es. `IADD`, `ISUB`, `IMUL`).
    

### 5. Il Livello di Macroarchitettura (ISA in dettaglio)

Il livello ISA definisce ciò che il programmatore in Assembly vede:

- **Retrocompatibilità e Modalità Operative:** Deve garantire l'esecuzione del codice legacy. Prevede una **Modalità Kernel** (accesso completo e operazioni protette) e una **Modalità Utente** (esecuzione confinata).
    
- **Tipi di Dati:** Interi (con segno via complemento a due o senza segno), Reali (notazione scientifica in floating point con mantissa ed esponente), Booleani, Caratteri e Puntatori.
    

#### Case Study: Intel Core i7 (IA-32 / x86-64)

- **Modalità:** Reale (compatibile 8088), Virtuale e Protetta (suddivisa su 4 livelli di privilegio, Anelli 0..3).
    
- **Registri ISA di uso generale:** `EAX` (accumulatore), `EBX` (base), `ECX` (contatore), `EDX` (dati/moltiplicazioni).
    
- **Registri di puntatore/indice:** `ESI` (sorgente), `EDI` (destinazione), `EBP` (base frame/variabili locali), `ESP` (stack pointer) e `EIP` (program counter).
    
- **Flag (EFLAGS / PSW):** $N$ (negativo), $Z$ (zero), $V$ (overflow), $C$ (riporto), $P$ (parità).
    

### 6. Formati di Istruzione e Modalità di Indirizzamento

- **Progettazione:** Istruzioni più corte riducono l'occupazione di memoria e ottimizzano l'uso della memoria cache, ma richiedono codici operativi espandibili.
    
- **Modalità di Indirizzamento Principali:**
    
    - **Immediato:** L'operando è specificato direttamente nell'istruzione (es. `MOV R1, #0`).
        
    - **A Registro:** L'operando risiede in un registro (es. `CMP R2, R3`).
        
    - **Diretto:** Viene fornito l'indirizzo esatto di memoria.
        
    - **Indiretto a Registro:** Il registro contiene l'indirizzo di memoria dell'operando (es. `ADD R1, (R2)`).
        
    - **Indicizzato / Indicizzato Esteso:** L'indirizzo finale si calcola sommando un registro di base ad un registro di indice o una costante.
        
    - **A Stack:** Operandi prelevati ed inseriti in cima allo stack tramite `PUSH` e `POP`.
        
- **Ortogonalità:** Un'architettura è ortogonale se _qualsiasi_ modalità di indirizzamento può essere combinata con _qualsiasi_ codice operativo (spesso non presente nelle architetture Intel x86 a causa dell'eredità storica).
    

### 7. Tipi di Istruzioni ed Operazioni Bitwise

- **Istruzioni Unarie e Binarie:** Dalla semplice inversione di bit o incremento, fino a trasferimenti dati, salti di controllo, chiamate a procedura ed operazioni I/O (via Polling, Interrupt o DMA).
    
- **Shift e Rotazioni:**
    
    - **Shift Logico/Aritmetico:** Fa scorrere i bit estendendo eventualmente il segno.
        
    - **Rotazione:** I bit usciti ad un estremo rientrano dall'estremo opposto.
        
    - **Applicazione pratica:** Uno shift a sinistra di $k$ posizioni equivale a moltiplicare il valore per $2^k$; sfruttando la proprietà distributiva, si possono sostituire costose operazioni di moltiplicazione con combinazioni di semplici shift e somme (es. $18 \cdot n = 2^4 \cdot n + 2^1 \cdot n$).