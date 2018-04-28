package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\n Welcome to the Project Green! \n");
        Scanner kb = new Scanner(System.in);
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
                            "userId is " + (Integer.parseInt(split[0])+10) +
                            ", state is " + split[1] +
                            ", and date is " + LocalDate.parse(split[2]).minusDays(10));
                }
                input.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //output how many tweets from each state


        //get users that appeared more than once(set)

        //Which months had most tweets(set)

        //Which states has more tweets than [c]

    }
}