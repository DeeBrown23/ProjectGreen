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
        System.out.println("Type name of File: (FluTweets.txt) ");
        File infile = new File("FluTweets.txt");
        if (!infile.exists()) {
            System.out.println("Oh no, you can't read from a file that doesn't exist!");
        }

        LinkedList files = new LinkedList(12345, "Kansas", LocalDate.now(), null);
        files.listBuilder(files);
        System.out.println(files);

        Map<String, Integer> states;
        states = files.getState(files);
        System.out.println(states);
    }
}
