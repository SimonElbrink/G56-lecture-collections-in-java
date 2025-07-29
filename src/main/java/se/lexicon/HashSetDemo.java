package se.lexicon;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.TreeSet;

public class HashSetDemo {

    public static void main(String[] args) {
        ex2();
    }

    public static void ex1(){

        TreeSet<String> fruits = new TreeSet<>(); // No Duplicated Values & Sorted
//        HashSet<String> fruits = new HashSet<>(); // No Duplicated Values
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Cherry");

        System.out.println("fruits = " + fruits);

    }

    public static void ex2(){
        HashSet<Person> people = new HashSet<>();
        people.add(new Person(3, "John", "john@test.se"));
        people.add(new Person(1, "Alice", "alice@test.se"));
        people.add(new Person(2, "Alice", "alice@xyz.se"));
        people.add(new Person(4, "Bob", "bob@test.se"));
        // ** Override equal and hashCode** to allow proper handling of duplicates in HashSet.
        people.add(new Person(2, "Alice", "alice@xyz.se"));

        for (Person person : people){
            System.out.println(person);
        }
    }
}
