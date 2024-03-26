package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {
    Delimiter delimiter;
    Validator validator;

    @BeforeEach
    void setUp() {
        this.delimiter = new Delimiter();
        this.validator = new Validator(delimiter);
    }

    @Test
    void validateSuccess() {
        String expression = "1,2;3";

        validator.validate(expression);
    }

    @Test
    void validateFailWithInvalidDelimiter() {
        String expression = "1?2;3";
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            validator.validate(expression);
        });
    }

    @Test
    void validateCustomDelimiter() {
        String expression = "//?\\n1,2;3?4";
        expression = delimiter.customExpression(expression);
        validator.validate(expression);
    }
    
    @Test
    void test() {
        String expression = "1,2;3;4";
        String[] arr = expression.split("[,;]");
        for(String i : arr){
            System.out.println("i = " + i);
        }
    }
}
