package assignment_3;

public class task4 {
    public static void main(String[] args) {

    }

    public interface CanRun {
        void run();
    }
    public interface CanSwim {
        void swim();
    }

    public abstract class Human implements CanRun, CanSwim {

    }
}
