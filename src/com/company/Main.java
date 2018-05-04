package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\n Welcome to the Project Green! \n");
       /* Scanner kb = new Scanner(System.in);
        System.out.println("Type name of File: (FluTweets.txt) ");
        File infile = new File("FluTweets.txt");
        if (!infile.exists()) {
            System.out.println("Oh no, you can't read from a file that doesn't exist!");
        } else {
            try {
                Scanner input = new Scanner(System.in);
                File file = new File(input.nextLine());
                input = new Scanner(file);

                System.out.println("\nJust because I can... Add 10 to userID and subtract 10 days from date:");
                while (input.hasNext()) {
                    String line = input.next();
                    String[] split = line.split("\\|");
                    System.out.println(
                            "userId is " + (Integer.parseInt(split[0]) + 10) +
                                    ", state is " + split[1] +
                                    ", and date is " + LocalDate.parse(split[2]).minusDays(10));
                }
                input.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }*/

        System.out.println("Type name of File: (FluTweets.txt) ");
        File infile = new File("FluTweets.txt");
        if (!infile.exists()) {
            System.out.println("Oh no, you can't read from a file that doesn't exist!");
        }

        Scanner input = getFile(infile);
        System.out.println(input);
        //output how many tweets from each state
        Map<String, Integer> counts = getState(input);
        System.out.println(counts);


        //get users that appeared more than once(set)

        //Which months had most tweets(set)

        //Which states has more tweets than [c]

    }

    public static Scanner getFile(File infile) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File file = new File(input.nextLine());
        input = new Scanner(file);

        System.out.println("\nJust because I can... Add 10 to userID and subtract 10 days from date:");
        while (input.hasNext()) {
            String line = input.next();
            String[] split = line.split("\\|");
            System.out.println(
                    "userId is " + (Integer.parseInt(split[0]) + 10) +
                            ", state is " + split[1] +
                            ", and date is " + LocalDate.parse(split[2]).minusDays(10));
        }
        return input;

    }



    public static Map<String, Integer> getState(Scanner input) throws FileNotFoundException {
        Map<String, Integer> wordCount = new HashMap<>();
        while (input.hasNext()) {
            String word = input.next();
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            }
            else{
                wordCount.put("Georgia" , 1);
            }
        }
        return wordCount;
    }
}