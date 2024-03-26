package calculator;

public class Validator {
    private Delimiter delimiter;

    public Validator(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public void validate(String expression) {
        for (String token : expression.split("")) {
            checkValidToken(token);
        }
    }

    void checkValidToken(String token){
        if (isInvalidToken(token)) {
            throw new RuntimeException();
        }
    }

    private boolean isDigit(String token) {
        char tokenChar = token.charAt(0);

        return '0' <= tokenChar && tokenChar <= '9';
    }

    private boolean isInvalidToken(String token) {
        return !(delimiter.contains(token) || isDigit(token));
    }
}
