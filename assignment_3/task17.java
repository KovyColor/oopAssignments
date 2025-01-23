package assignment_3;

import java.awt.*;

public class task17 {
    public static void main(String[] args) throws Exception {
        BigFox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());
    }

    public interface Animal {
        default Color getColor(){
            return Color.RED;
        }
    }

    public static abstract class Fox implements Animal {
        public String getName() {
            return "Fox.";
        }
    }

    public static class BigFox extends Fox {
        @Override
        public Color getColor() {
            return Color.RED;
        }
    }
}
