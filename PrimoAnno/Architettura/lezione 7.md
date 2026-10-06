---
tags:
---

#### 1) Trucco del Barrel Schifter (Shift immediato nell'istruzione)

In ARM, quasi tutte le istruzioni aritmetiche e logiche possono *applicare uno scgit o una rotazione al secondo operando gratis (senza un'istruzione separata).
- **`LSL #n` (Logical Shift Left):** Moltiplica per $2^n$.
    
- **`LSR #n` (Logical Shift Right):** Divide per $2^n$ (senza segno).
    
- **`ASR #n` (Arithmetic Shift Right):** Divide per $2^n$ preservando il segno (negativo rimane negativo).
    
- **`ROR #n` / `RRX`:** Ruota i bit a destra (eventualmente includendo il flag Carry $C$).

### 1. Perché si chiamano tutti `R2`, `R3`... e a cosa servono?

Un processore (CPU) non può fare operazioni direttamente sulla memoria del computer (RAM) perché è troppo lenta. Ha quindi delle sue **"scatole di memoria ultra-veloci"** interne, chiamate **Registri**.

In ARM ci sono 16 registri principali chiamati semplicemente R0, R1, R2, R3, fino a R15, *r* sta per  *register*, il numero è solo il nome della scatola e dentro ogni scatola puoi metterci un numero a 32 bit.

### 2. Perché i registri sono scritti più volte? (La Struttura Standard)

La maggior parte delle istruzioni aritmetiche in ARM segue **sempre questa regola fissa a 3 posti**:

$$\text{ISTRUZIONE} \quad \text{Destinazione}, \quad \text{Primo Operando}, \quad \text{Secondo Operando}$$

- **Primo posto (Destinazione):** Dove la CPU salva il risultato finale.
    
- **Secondo e Terzo posto (Operandi):** Quali valori prende per fare il calcolo.
    

#### Vediamo l'esempio:  ->`ADD R0, R1, R2`

- `ADD`: Vuol dire "Somma".
    
- Significa: _Prendi il contenuto di **R1**, sommalo al contenuto di **R2**, e metti il risultato dentro **R0**._
    
- In formula normale: $\text{R0} = \text{R1} + \text{R2}$.
#### Un altro esempio: `ADD R3, R3, R3`?

Perché nulla vieta di usare la stessa "scatola" sia per leggere sia per salvare il risultato aggiornato!

- `ADD R3, R3, R3` significa: _Prendi R3, sommalo a R3, e sovrascrivi il vecchio valore di R3 con il nuovo risultato._
    
- In formula normale: $\text{R3} = \text{R3} + \text{R3}$ (ovvero raddoppi R3).

### 3. Che cosa significano `ADD` e `RSB`?

Sono abbreviazioni dei comandi in inglese:

- **`ADD` (Addition):** Fa una normale somma $\text{Risultato} = \text{Primo Operando} + \text{Secondo Operando}$.
    
- **`SUB` (Subtract):** Fa una normale sottrazione $\text{Risultato} = \text{Primo Operando} - \text{Secondo Operando}$.
    
- **`RSB` (Reverse Subtract):** È una "sottrazione al contrario". Sottrae il _Primo Operando_ dal _Secondo Operando_!

	$$\text{Risultato} = \text{Secondo Operando} - \text{Primo Operando}$$

### 4. Il trucco del `LSL` (Logical Shift Left)

`LSL #n` significa "sposta i bit a sinistra di $n$ posizioni". In matematica, **spostare i bit a sinistra di $n$ equivale a moltiplicare per $2^n$**:

- `LSL #1` $\rightarrow$ moltiplica per $2^1 = 2$
    
- `LSL #2` $\rightarrow$ moltiplica per $2^2 = 4$
    
- `LSL #3` $\rightarrow$ moltiplica per $2^3 = 8$
    
- `LSL #4` $\rightarrow$ moltiplica per $2^4 = 16$

#### Esempi classici da esercizio d'esame
 - `ADD R3, R3, R3, LSL #2` $\rightarrow$ Traduzione: $R3 = R3 + (R3 \times 2^2) = R3 + 4 \cdot R3 = 5 \cdot R3$.
    
- `RSB R2, R2, R2, LSL #4` $\rightarrow$ Traduzione: **RSB** sta per _Reverse Subtract_ ($OP_2 - Rn$). Quindi $R2 = (R2 \times 2^4) - R2 = 16 \cdot R2 - R2 = 15 \cdot R2$.

### 5. Smontiamo i due esempi riga per riga

#### Esempio 1: `ADD R3, R3, R3, LSL #2`

Visualizzalo così:

$$\text{ADD} \quad \underbrace{\text{R3}}_{\text{Destinazione}}, \quad \underbrace{\text{R3}}_{\text{1° Operando}}, \quad \underbrace{\text{R3, LSL \#2}}_{\text{2° Operando}}$$

1. **Guarda il 2° Operando:** `R3, LSL #2` significa $\text{R3} \times 4$.
    
2. **Guarda l'Istruzione (`ADD`):** Devo sommare il 1° Operando con il 2° Operando.
    
    $$\text{Risultato} = \text{R3} + (\text{R3} \times 4)$$
    
3. **Guarda la Destinazione:** Salviamo il risultato dentro **R3**.
    
    $$\text{Nuovo R3} = \text{R3} + 4 \cdot \text{R3} = 5 \cdot \text{R3}$$
    

> **Morale:** Questa singola istruzione serve per **moltiplicare il valore di R3 per 5** in un solo colpo d'orologio!



#### Esempio 2: `RSB R2, R2, R2, LSL #4`

Visualizzalo così:

$$\text{RSB} \quad \underbrace{\text{R2}}_{\text{Destinazione}}, \quad \underbrace{\text{R2}}_{\text{1° Operando}}, \quad \underbrace{\text{R2, LSL \#4}}_{\text{2° Operando}}$$

1. **Guarda il 2° Operando:** `R2, LSL #4` significa $\text{R2} \times 16$.
    
2. **Guarda l'Istruzione (`RSB`):** È la sottrazione invertita, cioè $(\text{2° Operando}) - (\text{1° Operando})$.
    
    $$\text{Risultato} = (\text{R2} \times 16) - \text{R2}$$
    
3. **Guarda la Destinazione:** Salviamo il risultato dentro **R2**.
    
    $$\text{Nuovo R2} = 16 \cdot \text{R2} - \text{R2} = 15 \cdot \text{R2}$$
---

## Le modalità di Indirizzamento di Load (LDR) e Store (STR)
	
Per accedere alla memoria RAM si usano **`LDR`** (carica dato da RAM a Registro) e **`STR`** (salva dato da Registro a RAM). Le parentesi quadre `[]` indicano che stiamo leggendo/scrivendo all'indirizzo contenuto dentro il registro.
	![[Pasted image 20260927113454.png|700]]

[Ricorda Rn significa Register Number]

##### Esempio pratico (immagina $R1 = 0x1000$):

- `LDR R0, [R1, #4]` $\rightarrow$ Legge da $0x1004$. Alla fine $R1$ resta $0x1000$.
    
- `LDR R0, [R1, #4]!` $\rightarrow$ Legge da $0x1004$. Alla fine $R1$ diventa $0x1004$.
    
- `LDR R0, [R1], #4` $\rightarrow$ Legge da $0x1000$. Alla fine $R1$ diventa $0x1004$. _(È la modalità usata nei cicli per scorrere gli array!)_

[Inoltre in questo caso il simbolo cancelletto # sta per (Valore immediato) quindi #4 significa letteralmente numero 4 non è 2^4].

[La somma degli indirizzi in esadecimale se il registro  vale R1=0x1000 e aggiungiamo #4 stiamo facendo una semplice somma aritmetica 0x1000 + 4 = 0x1004. Le potenze di 2 le uso SOLO con l'istruzione di SHIFT (LSL)  ]
### Ripassiamo i 3 esempi con questa nuova consapevolezza:

Immagina $R1 = \text{0x1000}$ (indirizzo in RAM):

1. **`LDR R0, [R1, #4]`** (Offset Semplice)
    
    - Calcola l'indirizzo: $\text{0x1000} + 4 = \text{0x1004}$.
        
    - Legge il dato che si trova in RAM all'indirizzo $\text{0x1004}$ e lo mette in $R0$.
        
    - **$R1$ NON cambia**: rimane $\text{0x1000}$.
        
2. **`LDR R0, [R1, #4]!`** (Pre-indicizzato con `!`)
    
    - Il punto esclamativo `!` dice: _"Aggiorna subito il registro base!"_
        
    - $R1$ viene aggiornato a $\text{0x1000} + 4 = \text{0x1004}$.
        
    - Legge il dato all'indirizzo $\text{0x1004}$ e lo mette in $R0$.
        
    - **$R1$ ORA vale $\text{0x1004}$**.
        
3. **`LDR R0, [R1], #4`** (Post-indicizzato)
    
    - L'offset `#4` è **fuori** dalle parentesi quadre.
        
    - Legge prima il dato all'indirizzo corrente di $R1$ ($\text{0x1000}$) e lo mette in $R0$.
        
    - **DOPO** aver letto, aumenta $R1$ di 4: $R1 = \text{0x1000} + 4 = \text{0x1004}$.


### Gestione delle Condizioni e dei Cicli (`CMP` e Salti)

Per scrivere programmi con strutture `if/else` o cicli `for/while`, ARM usa il confronto `CMP` e le istruzioni di salto **`B`** (_Branch_).  *CMP* sta per *COMPERE o CONFRONTA*.

#### Il confronto `CMP`:

- Se $R0 - R1 = 0$ $\rightarrow$ Significa che **i due numeri erano UGUALI**. La CPU accende una spia chiamata **`Z` (Zero)**.
    
- Se $R0 - R1 > 0$ $\rightarrow$ Significa che **$R0$ era più GRANDE di $R1$**.
		
`CMP R0, R1` $\rightarrow$ Sottrae $R1$ da $R0$ (senza salvare il risultato) solo per aggiornare i **flag** della CPU ($Z$ per Zero, $N$ per Negativo, ecc.).

#### I Salti Condizionali principali:

Nel codice normale, la CPU legge le istruzioni **una dietro l'altra, dall'alto verso il basso**. I **Salti (Branch, lettera `B`)** servono per dire alla CPU: **"Ehi, fai un salto a quella riga di codice là sotto!**

- **`B etichetta`** $\rightarrow$ Salta sempre (_Unconditional Branch_).
    
- **`BEQ etichetta`** $\rightarrow$ Salta se **Uguali** (_Branch if Equal_).
    
- **`BNE etichetta`** $\rightarrow$ Salta se **Diversi** (_Branch if Not Equal_).
    
- **`BGT etichetta`** $\rightarrow$ Salta se **Maggiore** (_Branch if Greater Than_).
    
- **`BLE etichetta`** $\rightarrow$ Salta se **Minore o Uguale** (_Branch if Less or Equal_).


### 7. Gli Algorithmi Classici d'Esame

#### Esercizio Tipo A: Somma degli $N$ elementi di un Array

**DNS / Logica:**

1. Azzera la somma.
    
2. Controlla se $N$ è 0. Se sì, termina.
    
3. Leggi il valore corrente dall'array ed avanza il puntatore di 4 byte (una parola a 32 bit).
    
4. Aggiungi il valore alla somma e decrementa $N$.
    
5. Ripeti finché $N > 0$.