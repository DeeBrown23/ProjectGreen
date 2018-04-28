package com.company;

import java.time.LocalDate;

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

    public LinkedList() {
        LinkedList a = new LinkedList(123443, "Mississippi", LocalDate.now(), null);
    }

    public void LinkedList(LinkedList next) {
        this.next = next;
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
}
