package calculator;


import java.util.*;
import java.util.stream.Collectors;

public class Splitter {
    private Delimiter delimiter;

    public Splitter(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public List<Integer> split(String expression) {
        String delimiters = delimiter.getDelimiter();
        List<String> numberList = Arrays.asList(expression.split(delimiters));

        return numberList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
