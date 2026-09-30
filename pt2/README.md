# PT2 – Xifratge de fitxers de text

Pràctica d'accés a dades: xifratge i desxifratge de fitxers de text fent servir les classes d'E/S de Java (`BufferedReader` / `BufferedWriter`).

## Descripció

El programa `ruben.net.Pt1` mostra un menú per consola des del `main`, que crida les funcions encarregades de la lògica d'encriptació:

```
--MENU--

 1. Xifrar fitxer
 2. Desxifrar fitxer
 3. Sortir
```

En triar una opció es demana la ruta d'origen, la ruta de destí i el nombre de desplaçaments, i es crida a `crypt(...)` per processar el fitxer.

## Algoritme

Per a cada línia del fitxer:

1. Invertir els caràcters de la línia (`StringBuilder.reverse()`).
2. Desplaçar el valor `char` de cada caràcter el nombre d'unitats indicat (xifratge tipus Cèsar).

## Estructura

```
pt2/
├── data/
│   └── ruben.txt          # Fitxer d'exemple
├── src/main/java/ruben/net/
│   └── Pt1.java           # Codi font
├── pom.xml                # Projecte Maven (JDK 21)
└── README.md
```

## Ús de `data/`

La carpeta `/data` està pensada per a contenir tots els fitxers que utilitza la pràctica, encara que en aquest exercici es pot triar qualsevol *path*.

## Execució

Des de la carpeta `pt2` (els paths són relatius al directori de treball):

```bash
mvn -q compile
java -cp target/classes ruben.net.Pt1
```

O directament amb el plugin d'execució:

```bash
mvn -q compile exec:java
```

## Requisits

- JDK 21 o superior
- Maven

## Estat

Pràctica pendent d'acabar: el menú i el mètode `crypt(...)` estan implementats, però `decrypt(...)` encara no compila i falta connexió entre les dues opcions del menú.
