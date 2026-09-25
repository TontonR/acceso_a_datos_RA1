/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ruben.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class Pt1 {

    public static void main(String[] args) {
        File file = new File("data/ruben.txt");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("--MENU--\n\n 1. Xifrar fitxer\n 2. Desxifrar fitxer\n 3. Sortir");
            switch (sc.nextInt()) {
                case 1:
                    String path = "";
                    System.out.println("Selecciona la ubicació del fitxer a encriptar");
                    path = sc.nextLine();
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static String crypt(File f, int displacemenet, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(f)); BufferedWriter bw = new BufferedWriter(new FileWriter(path)); PrintWriter pw = new PrintWriter(bw)) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder(line);
                String reverse_line = sb.reverse().toString();
                String crypt_line = "";
                for (char c : reverse_line.toCharArray()) {
                    int index = (int) c;
                    index += displacemenet;
                    crypt_line += (char) index;
                }
                pw.write(crypt_line);
            }
            pw.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Fitxer no trobat: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error d' entrada/sortida: " + e.getMessage());
        }
        return null;
    }
}
