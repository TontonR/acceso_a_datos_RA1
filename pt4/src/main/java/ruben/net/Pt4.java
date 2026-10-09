/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ruben.net;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author usuari-tarda
 */
public class Pt4 {

    public static void main(String[] args) {
        ArrayList<animal> animals = new ArrayList<>();
        animals.add(new animal(1, "Pingüí", "Aptenodytes forsteri", "Peix", 5));
        animals.add(new animal(2, "Lleó", "Panthera leo", "Carn", 8));
        
        create_zoo(animals, "data/zoo.xml");
    }

    private static void create_zoo(ArrayList<animal> animals, String path){
        try {
            File file = new File(path);
            File parentDir = file.getParentFile();

            if(parentDir != null && !parentDir.exists()){
                parentDir.mkdir();
            }
            // Crear builder i nou document DOM
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Crear l'etiqueta arrel <zoo>
            var arrel = doc.createElement("zoo");
            doc.appendChild(arrel);

            for (animal a : animals){
                // <animal id="...">
                Element elemAnimal = doc.createElement("animal");
                elemAnimal.setAttribute("id", String.valueOf(a.id));

                // <nom>
                Element nom = doc.createElement("nom");
                nom.appendChild(doc.createTextNode(a.nom));
                elemAnimal.appendChild(nom);

                // <especie>
                Element especie = doc.createElement("especie");
                especie.appendChild(doc.createTextNode(a.especie));
                elemAnimal.appendChild(especie);

                // <aliment>
                Element aliment = doc.createElement("aliment");
                especie.appendChild(doc.createTextNode(a.aliment));
                elemAnimal.appendChild(aliment);

                // <edat>
                Element edat = doc.createElement("edat");
                especie.appendChild(doc.createTextNode(String.valueOf(a.edat)));
                elemAnimal.appendChild(edat);

                // afegir animal a la red
                arrel.appendChild(elemAnimal);
            }
            // Tranformar l'arbre DOM i guardar-ho en un fitxer XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(path));

            // Guardar el fitxer
            transformer.transform(source, result);

            System.out.println("Fitxer XML creat correctament!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
