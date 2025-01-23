package assignment_3.OOP_part2.Task6all;

public class Task6 {
    public static void main(String[] args) {
            Bugatti myBugatti = new Bugatti();

            System.out.println("Current body type: " + myBugatti.getBody());

            myBugatti.setBody("Convertible");

            System.out.println("Updated body type: " + myBugatti.getBody());
    }
}

