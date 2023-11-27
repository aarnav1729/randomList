import java.util.ArrayList;

public class RandomListTester {

    public static void main(String[] args) {

        System.out.println("New RandomList with Strings");
        RandomList<String> stringList = new RandomList<>();

        stringList.randomAdd("One");
        stringList.randomAdd("Two");
        stringList.randomAdd("Three");
        stringList.randomAdd("Four");
        stringList.randomAdd("Five");
        stringList.randomAdd("Six");
        stringList.randomAdd("Seven");
        stringList.randomAdd("Eight");
        stringList.randomAdd("Nine");
        stringList.randomAdd("Ten");

        stringList.printList();
        stringList.printReverseList();

        String tmpString = stringList.randomRemove();
        System.out.println("Removed Element: " + tmpString);

        stringList.printList();

        stringList.randomAdd("Eleven");
        stringList.printList();

        tmpString = stringList.randomGet();
        System.out.println("Random Element: " + tmpString);

        tmpString = stringList.get(1);
        System.out.println("Specific Element (1): " + tmpString);

        tmpString = stringList.get(10);
        System.out.println("Specific Element (10): " + tmpString);

        tmpString = stringList.get(19);
        System.out.println("Specific Element (19): " + tmpString);

        tmpString = stringList.get(9);
        System.out.println("Specific Element (9): " + tmpString);

        tmpString = stringList.get(0);
        System.out.println("Specific Element (0): " + tmpString);

        //now to do the same thing with Integers
        System.out.println("\nNew RandomList with Integers");
        RandomList<Integer> intList = new RandomList<>();

        intList.randomAdd(1);
        intList.randomAdd(2);
        intList.randomAdd(3);
        intList.randomAdd(4);
        intList.randomAdd(5);
        intList.randomAdd(6);
        intList.randomAdd(7);
        intList.randomAdd(8);
        intList.randomAdd(9);
        intList.randomAdd(10);

        intList.printList();

        int removedInt = intList.randomRemove();
        System.out.println("Removed Item: " + removedInt);

        removedInt = intList.randomRemove();
        System.out.println("Removed Item: " + removedInt);

        System.out.println("List after Removals");
        intList.printList();

        int randomInt = intList.randomGet();

        System.out.println("Random Item is: " + randomInt);

    }
}