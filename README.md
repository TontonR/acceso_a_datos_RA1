# ACCES A DADES RA1

## Rubén Muñoz Blanco

Aquest repositori conté totes les pràctiques de la RA1 d'Accés a Dades. Està seccionat en carpetes de diferents pràctiques; dins de cada pràctica n'hi ha un `README.md` on s'explica de manera breu com està estructurada aquella pràctica.

Les pràctiques estan fetes amb **Java 21** i **Maven**.

## Pràctiques

| Pràctica | Descripció | Estat |
|---|---|---|
| [pt1](pt1/README.md) | Anàlisi de text amb `FileReader`: comptar caràcters, línies, paraules i la lletra més freqüent | Acabada |
| [pt2](pt2/README.md) | Xifratge i desxifratge de fitxers de text amb `BufferedReader` / `BufferedWriter` | Pendent d'acabar |

## Estructura

```
acceso_a_datos_RA1/
├── pt1/
│   ├── data/ruben.txt        # Fitxer d'entrada
│   ├── src/main/java/ruben/net/Pt1.java
│   └── pom.xml
├── pt2/
│   ├── data/ruben.txt
│   ├── src/main/java/ruben/net/Pt1.java
│   └── pom.xml
└── README.md
```

Cada pràctica és un projecte Maven independent, amb la classe principal `ruben.net.Pt1`.

## Requisits

- JDK 21 o superior
- Maven

## Execució

Les rutas dels fitxers (`data/ruben.txt`) són relatives al directori de treball, així que cal executar **des de dins de la carpeta de la pràctica**:

```bash
cd pt1
mvn -q compile exec:java
```

```bash
cd pt2
mvn -q compile exec:java
```
