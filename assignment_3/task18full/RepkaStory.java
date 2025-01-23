package assignment_3.task18full;

import java.util.List;

public class RepkaStory {
    static void tell(List<Person> items) {
        for (int i = items.size() - 1; i > 0; i--) {
            Person first = items.get(i - 1);
            Person second = items.get(i);
            second.pull(first);
        }
    }
}
