package se.lexicon;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        ex1();
    }

    public static void ex1(){

        HashMap<String, String> emails = new HashMap<>();
        emails.put("Simon", "simon@lexicon.se");
        emails.put("Ulf", "ulf@lexicon.se");
        emails.put("Mehrdad", "mehrdad@lexicon.se");

        System.out.println(emails.get("Simon"));

        HashMap<Integer, Person> people = new HashMap<>();
        int personOneId = 1;
        people.put(personOneId, new Person(personOneId, "Simon","simon@lexicon.se"));
        people.put(2, new Person(2, "Ulf", "ulf@lexicon.se"));
        people.put(3, new Person(3, "Mehrdad", "mehrdad@lexicon.se"));


    }
}
