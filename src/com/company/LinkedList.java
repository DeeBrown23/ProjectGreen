package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LinkedList {
    private int userID;
    private String state;
    private LocalDate tweetDate;
    private LinkedList next;

    public LinkedList(int userID, String state, LocalDate tweetDate, LinkedList next) {
        this.userID = userID;
        this.state = state;
        this.tweetDate = tweetDate;
        this.next = null;
    }


    public void LinkedList(LinkedList next) {
        this.next = next;
    }


    public LinkedList listBuilder(LinkedList a) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File file = new File(input.nextLine());
        input = new Scanner(file);
        while (input.hasNext()) {
            String line = input.next();
            String[] split = line.split("\\|");
            userID = (Integer.parseInt(split[0]) + 10);
            state = split[1];
            tweetDate = LocalDate.parse(split[2]).minusDays(10);
            LinkedList b = new LinkedList(userID, state, tweetDate, a);
            a.prepend(b);
        }
        return a;
    }

    public static Map<String, Integer> getState(LinkedList a) {
        Map<String, Integer> wordCount = new HashMap<>();
        while (a.next != null) {
            String word = String.valueOf(a.get(Integer.parseInt(a.state)));
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            }
            else{
                wordCount.put("Georgia" , 1);
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
            }
        }
        return wordCount;
    }

    public int size() {
        if (this == null) {
            return 0;
        } else if (this.next == null) {
            return 1;
        } else {
            return 1 + this.next.size();
        }
    }

    public LinkedList prepend(LinkedList head) {
        head.next = this;
        return head;

    }

    public LinkedList get(int index) {
        int count = 0;
        LinkedList temp = this;
        while (index != count) {
            temp = temp.next;
            count++;
        }
        return temp.next;
    }

    public LinkedList remove(int index) {
        LinkedList temp = this;
        while (index != this.size()) {
            temp = temp.next;
            temp.remove(index);
        }
        return temp.next;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "userID=" + userID +
                ", state='" + state + '\'' +
                ", tweetDate=" + tweetDate +
                ", next=" + next +
                '}';
    }
}
