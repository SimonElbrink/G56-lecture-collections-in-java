package se.lexicon;


import java.lang.reflect.Array;
import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>(); //Size 0

        // <> = Generics, Generalizes what type of element.
        ArrayList<Integer> number = new ArrayList<>();

        //Primitive = int
        //Wrapper classes = Integer

        // int -> Integer
        // long -> Long
        // boolean - Boolean


        ex6();
    }


    public static void ex1 (){

        ArrayList<String> bookNames = new ArrayList<>();
        bookNames.add("Java"); // ["Java"]
        bookNames.add("Java"); // ["Java", "Java"]
        bookNames.add("Spring");
        bookNames.add("React");
        bookNames.add("Clean Code");
        bookNames.add("OCP");
        bookNames.add("OCP");

        System.out.println(bookNames);

        System.out.println(bookNames.size());

        System.out.println(bookNames.get(0));
        System.out.println(bookNames.get(1));
        System.out.println(bookNames.get(2));
//        System.out.println(bookNames.get(10)); // Throws IndexOutOfBoundsException

        System.out.println("----- Iterator Okay to modify or delete -----");
        Iterator<String> iterator = bookNames.iterator();
        while(iterator.hasNext()){
            String bookName = iterator.next();
            if (bookName.equals("OCP")){
                bookNames.remove(bookName);
            }

        }

        System.out.println("--------- For Print out / Reading - Not Modify------------");
        for (String bookName : bookNames){
/*            if (bookName.equals("OCP")){
                bookNames.remove(bookName);
            }
*/
            System.out.println(bookName);
        }

        System.out.println("-------------");
        for (int i = 0; i < bookNames.size(); i++) {
            System.out.println(bookNames.get(i));
        }

    }

    public static void ex2(){

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(100);
        numbers.add(100);
        numbers.add(400);
        numbers.add(200);
        numbers.add(300);

        System.out.println(numbers.size());

//        numbers.remove(new Integer(100)); // Deprecated
        boolean isRemoved = numbers.remove(Integer.valueOf(100)); // ✅

        System.out.println("isRemoved = " + isRemoved);
        System.out.println(numbers);


        Integer removedNumber = numbers.remove(2);

        System.out.println(numbers.size());
        System.out.println(removedNumber);

    }

    public static void ex3(){

        ArrayList<String> cars = new ArrayList<>();
        cars.add("Volvo");
        //"Tesla"
        //"Ford"
        cars.add("BMW");
        cars.add("Volvo");


        System.out.println(cars);

        ArrayList<String> usaCars = new ArrayList<>();
        usaCars.add("Tesla");
        usaCars.add("Ford");

//        cars.addAll(usaCars);
        cars.addAll(1,usaCars);

        System.out.println(cars);

        System.out.println(cars.indexOf("Volvo"));
        System.out.println(cars.lastIndexOf("Volvo"));

    }

    public static void ex4(){

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);

        System.out.println("Original List = " + numbers);

        Collections.sort(numbers);
//        Collections.sort(numbers, Collections.reverseOrder());

        System.out.println("Sorted List = " + numbers);

//        numbers.sort(Comparator.naturalOrder());
        numbers.sort(Comparator.reverseOrder());
        System.out.println("Reversed List = " + numbers);

        Collections.shuffle(numbers);
        System.out.println(numbers);

        List<String> letters = new ArrayList<>();
        letters.add("D");
        letters.add("C");
        letters.add("A");
        letters.add("B");
        letters.add("a");

//        Collections.sort(letters);
        Collections.sort(letters, String.CASE_INSENSITIVE_ORDER);
        System.out.println(letters);
    }

    public static void ex5(){


        Person person1 = new Person(1, "Simon", "Simon@test.com");
        Person person2 = new Person(1, "Simon", "Simon@test.com");

        System.out.println(person1.toString());

        //Memory address = Default ?
        //Object Values = after overriding default?
        boolean isEqualTwoPersons = person1.equals(person2);
        System.out.println("isEqualTwoPersons = " + isEqualTwoPersons); //True / False

        Person person3 = person1;
        //InstanceOf = for comparing instances

        String test1 = "TEST";
        String test2 = "TEST";
        System.out.println(test1.equals(test2));

        int num1 = 100;
        int num2 = 100;

        boolean isEqualNumbers = num1 == num2;
        System.out.println("isEqualNumbers = " + isEqualNumbers);
    }

    public static void ex6(){


        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(3, "John", "john@test.se"));
        people.add(new Person(1, "Alice", "alice@test.se"));
        people.add(new Person(2, "Alice", "alice@xyz.se"));
        people.add(new Person(4, "Bob", "bob@test.se"));


        System.out.println("-------------");

        System.out.println("Original List:");
        for (Person person: people){
            System.out.println(person);
        }

        //Comparator
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });

        // if o1.getId < o2.getId -> returns a negative number = o1 should be before o2
        // if o1.getId == o2.getId -> returns a zero = both are considered equal
        // if o1.getId > o2.getId -> returns a positive number = o1 should be after o2

        Collections.sort(people, (o1, o2) -> Integer.compare(o1.getId(), o2.getId()));

        Collections.sort(people, Comparator.comparingInt(Person::getId));

        System.out.println("Sorted List:");
        for (Person person: people){
            System.out.println(person);
        }

    }
}
