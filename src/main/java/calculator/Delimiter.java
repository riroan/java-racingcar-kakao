package calculator;

import java.util.HashSet;
import java.util.Set;

public class Delimiter {
    private final Set<Character> delimiterSet;

    Delimiter() {
        delimiterSet = new HashSet<>();
        delimiterSet.add(',');
        delimiterSet.add(';');
    }

    public void add(char delimiter) {
        delimiterSet.add(delimiter);
    }

    public boolean contains(char token) {
        if (delimiterSet.contains(token)) {
            return true;
        }

        return false;
    }
}
