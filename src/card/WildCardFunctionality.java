/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Maduka Rodrigo
 */
public class WildCardFunctionality {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */

    static int wildCardUseChecksum = 0;   //to check whether wild card used or not

    public String wordGenerates( String[] mainL, String[] otherL) throws FileNotFoundException {

        String main_string = null;
        StringBuilder alphabat = new StringBuilder();
        String output = null;

        String a[] = mainL;
        String b[] = otherL;
        List list = new ArrayList(Arrays.asList(a));
        list.addAll(Arrays.asList(b));
        Object[] letters = list.toArray();

        while (output == null) {
            Random numberGenerator = new Random();/* Generate A Random Number */

            int nextRandom = numberGenerator.nextInt(11);
            Set<Integer> validate = new HashSet<>();/* Add First Randomly Genrated Number To Set */

            validate.add(nextRandom);
            for (int i = 0; i < 10; i++) {
                /* Generate Randoms Till You Find A Unique Random Number */
                while (validate.contains(nextRandom)) {
                    nextRandom = numberGenerator.nextInt(11);

                }
                /* Add Newly Found Random Number To Validate */
                validate.add(nextRandom);
                // System.out.println(letters[nextRandom]);
                main_string = alphabat.append(letters[nextRandom]).toString().toLowerCase();

            }

            File file=new File("./");
            String filepath=file.getAbsolutePath();
            filepath=filepath.substring(0,filepath.length()-1)+"/src/text/words.txt";
            file=new File(filepath);
            BufferedReader in;
           // URL url = this.getClass().getResource("words.txt");
           // File file = new File(url.getPath());
            Scanner inFile = new Scanner(new BufferedReader(new FileReader(file)));

            String currentword;
            String word = main_string; //first input String

            // String output = "/----Output----\\ \n";
            while (inFile.hasNextLine()) {
                currentword = inFile.nextLine();

                // starts checking if the first letter of the dictionary word matches first letter of given word.
                // if first letter matches, check last letter to match.
                if ((currentword.charAt(0) != word.charAt(0))
                        || (currentword.charAt(currentword.length() - 1) != word.charAt(word.length() - 1))) {
                    //next! No match!
                } else {
                    int c = 0;
                    for (int i = 0; ((i < (word.length())) && (c < currentword.length())); i++) {
                        if (word.charAt(i) == currentword.charAt(c)) {
                            c++;

                        }
                    } // should be called if the number of matching letters was the same as the length of the word itself

                    if (c == currentword.length()) {
                        //output += currentword + "\n";
                        currentword.length();
                        if (currentword.length() > 3) {
                            output = currentword;

                        }
                    }
                }

            }

            
        }
       System.out.println(output); 
       return output;
    }
}
