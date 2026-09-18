/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ruben.net;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author usuari-tarda
 */
public class Pt1 {
    
    public static void main(String[] args) {
        File file = new File("data/ruben.txt");
        System.err.println("1. Total de caracters: " + count_characters(file)+1);
        System.err.println("2. Total de linies: " + count_lines(file)+1);
        System.err.println("3. Total de paraules: " + count_words(file)+1);    
    }

    public static int count_characters(File f){
        try (FileReader fr = new FileReader(f)){
            int c;
            int total = 0;
            while ((c = fr.read()) != -1){
                if (c != '\n' && c != '\r'){
                    total++;
                    //char character = (char) c;
                    // System.out.println(character);
                }
            }
            return total;
        } catch (IOException e) {
            e.getStackTrace();
            return -1;
        }    
    }

    public static int count_lines(File f){
        try (FileReader fr = new FileReader(f)){
            int c;
            int total = 0;
            while ((c = fr.read()) != -1){
                if (c == '\n' || c == '\r'){
                    total++;
                }
            }
            return total;
        } catch (IOException e) {
            e.getStackTrace();
            return -1;
        }    
    }

    public static int count_words(File f){
        try (FileReader fr = new FileReader(f)){
            int c;
            int total = 0;
            while ((c = fr.read()) != -1){
                if (c == '\n' || c == '\r' || c == ' '){
                    total++;
                }
            }
            return total;
        } catch (IOException e) {
            e.getStackTrace();
            return -1;
        }    
    }
}
