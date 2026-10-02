package ruben.net;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import ruben.net.videogame.Platform;
import ruben.net.videogame.Videogame;

/**
 *
 * @author usuari-tarda
 */
public class Pt3 {

    public static void main(String[] args) {
        String vg_data = "data/videogames.dat";
        Scanner sc = new Scanner(System.in);
        ArrayList<Videogame> videogames = new ArrayList<>();
        while (true) { 
            System.out.println("--MENU--\n\n 1. Afegir videojoc\n 2. Llistar tots els videojocs\n 3. Cercar videojocs per títol\n 4. Actualitzar un videojoc\n 5. Eliminar un videojoc\n 6. Sortir del programa");
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(vg_data))){ 
                out.writeObject(videogames);
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Nom del videojoc:");
                        String name = sc.next();
                        try {
                            System.out.println("Gènere del videojoc:");
                            String genre = sc.next();
                            System.out.println("Any llançament:");
                            int ry = sc.nextInt();
                            System.out.println("Plataforma: (1) PC, (2) PlayStation, (3) XBox, (4) Nintendo");
                            Platform platform = null;
                            while (platform == null){
                                int n = sc.nextInt();
                                if (n >= 1 && n <= 5){
                                    platform = Platform.values()[n-1];
                                } else {
                                    System.out.println("Opció incorrecta, torna a provar");
                                }
                            }
                            double price = sc.nextDouble();
                            Videogame vg = new Videogame(name, genre, ry, platform, price);
                            videogames.add(vg);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
            }
            
        }
    }
}
