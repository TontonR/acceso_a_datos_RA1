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
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("--MENU--\n\n 1. Xifrar fitxer\n 2. Desxifrar fitxer\n 3. Sortir");
            switch (sc.nextInt()) {
                case 1:
                    try {
                        sc.nextLine();
                        System.out.println("Escriu la ruta del fitxer a encriptar:");
                        String origin_path = sc.nextLine();
                        System.out.println("Ruta elegida: " + origin_path);
                        File file = new File(origin_path);
                        System.out.println("Escriu la ruta on guardar el fitxer encriptat:");
                        String path = sc.nextLine();
                        System.out.println("Ruta elegida: " + path);
                        System.out.println("Numero de sucesions: ");
                        int d = sc.nextInt();
                        crypt(file, d, path);
                        System.out.println("Fitxer encriptat correctament.");

                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        sc.nextLine();
                        System.out.println("Escriu la ruta del fitxer a desencriptar:");
                        String origin_path = sc.nextLine();
                        System.out.println("Ruta elegida: " + origin_path);
                        File file = new File(origin_path);
                        System.out.println("Escriu la ruta on guardar el fitxer desencriptat:");
                        String path = sc.nextLine();
                        System.out.println("Ruta elegida: " + path);
                        System.out.println("Numero de sucesions: ");
                        int d = sc.nextInt();
                        decrypt(file, d, path);
                        System.out.println("Fitxer desencriptat correctament.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }

    public static void crypt(File f, int displacemenet, String path) {
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
                pw.write(crypt_line + "\n");
            }
            pw.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Fitxer no trobat: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error d' entrada/sortida: " + e.getMessage());
        }
    }

    public static void decrypt(File f, int displacement, String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(f)); BufferedWriter bw = new BufferedWriter(new FileWriter(path)); PrintWriter pw = new PrintWriter(bw)) {
            String line;
            while ((line = br.readLine()) != null) {
                String displaced_line = "";
                for (char c : line.toCharArray()) {
                    int index = (int) c;
                    index -= displacement;
                    displaced_line += (char) index;
                }
                StringBuilder sb = new StringBuilder(displaced_line);
                String decrypt_line = sb.reverse().toString();
                pw.write(decrypt_line + "");
            }
            pw.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Fitxer no trobat: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error d' entrada/sortida: " + e.getMessage());
        }
    }
}
