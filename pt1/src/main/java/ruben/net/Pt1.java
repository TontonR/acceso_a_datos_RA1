/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ruben.net;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        System.err.println("4. La lletra que més surt és: '" + most_frequent_letter(file).keySet().toArray()[0] + "' (" + most_frequent_letter(file).values().toArray()[0]+" vegades)");    
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

    public static Map<Character, Integer> most_frequent_letter(File f){
    try (FileReader fr = new FileReader(f)){
        Map<Character, Integer> letters = new HashMap<>();
        int c;
        while ((c = fr.read()) != -1){
            char ch = (char) c;
            if (ch != '\n' && ch != '\r' && ch != ' '){
                ch = Character.toLowerCase(ch);
                letters.put(ch, letters.getOrDefault(ch, 0) + 1);
            }
        }

        char max_char = ' ';
        int max_freq = 0;
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (entry.getValue() > max_freq) {
                max_freq = entry.getValue();
                max_char = entry.getKey();
            }
        }

        Map<Character, Integer> result = new HashMap<>();
        if (max_freq > 0) { 
            result.put(max_char, max_freq);
        }

        return result;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }    
}

}
