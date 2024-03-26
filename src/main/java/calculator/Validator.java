package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Delimiter delimiter;

    Validator(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public boolean validate(String expression) {
        expression = checkCustomDelimiter(expression);

        for (char token : expression.toCharArray()) {
            if (isInvalidToken(token)) {
                throw new RuntimeException();
            }
        }
        return true;
    }

    private boolean isDigit(char token) {
        return '0' <= token && token <= '9';
    }

    private boolean isInvalidToken(char token) {
        return !(delimiter.contains(token) || isDigit(token));
    }

    private String checkCustomDelimiter(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiter.add(customDelimiter.charAt(0));
            return expression.substring(4);
        }

        return expression;
    }
}
