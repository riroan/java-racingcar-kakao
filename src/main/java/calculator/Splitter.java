package calculator;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Splitter {
    private final Set<Character> delimiterSet;

    Splitter() {
        delimiterSet = new HashSet<>();
        delimiterSet.add(',');
        delimiterSet.add(';');
    }

    public void add(char delimiter) {
        delimiterSet.add(delimiter);
    }

    public List<Integer> split(String expression) {
        List<Integer> result = new ArrayList<>();
        Integer saver = 0;
        for (char token : expression.toCharArray()) {
            if (isDigit(token)) {
                saver = saver * 10 + Character.getNumericValue(token);
            }

            if (!isDigit(token)) {
                result.add(saver);
                saver = 0;
            }
        }

        result.add(saver);

        return result;
    }

    private boolean isDigit(char token) {
        if (delimiterSet.contains(token)) {
            return false;
        }

        return true;
    }
}
