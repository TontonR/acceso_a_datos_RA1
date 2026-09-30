# PT1 – Análisis de texto con `FileReader`

Práctica de acceso a datos: lectura de un fichero de texto carácter a carácter con la API de E/S de Java (`java.io`) y cálculo de estadísticas básicas.

## Descripción

El programa `ruben.net.Pt1` lee el fichero `data/ruben.txt` y muestra por pantalla:

1. Total de caracteres
2. Total de líneas
3. Total de palabras
4. La letra que más se repite y cuántas veces aparece

## Estructura

```
pt1/
├── data/
│   └── ruben.txt          # Fichero de entrada
├── src/main/java/ruben/net/
│   └── Pt1.java           # Código fuente
└── pom.xml                # Proyecto Maven (JDK 21)
```

## Métodos

| Método | Descripción |
|---|---|
| `count_characters(File)` | Cuenta los caracteres, ignorando los saltos de línea (`\n`, `\r`) |
| `count_lines(File)` | Cuenta los saltos de línea |
| `count_words(File)` | Cuenta los separadores (espacios y saltos de línea) |
| `most_frequent_letter(File)` | Devuelve un `Map` con la letra más frecuente (sin distinguir mayúsculas) y su conteo |

Todas las lecturas se hacen con `FileReader` en un bloque try-with-resources, de modo que el flujo se cierra automáticamente.

## Requisitos

- JDK 21 o superior
- Maven

## Ejecución

Desde la carpeta `pt1` (las rutas son relativas al directorio de trabajo):

```bash
mvn -q compile
java -cp target/classes ruben.net.Pt1
```

O directamente con el plugin de ejecución:

```bash
mvn -q compile exec:java
```

## Notas

- El fichero se abre con la ruta relativa `data/ruben.txt`: si se ejecuta desde otra carpeta hay que ajustar la ruta.
- En `main` los resultados se imprimen con un `+1` añadido, teniéndolo en cuenta al comparar con los valores reales del fichero.
