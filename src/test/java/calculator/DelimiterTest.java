package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DelimiterTest {
    Delimiter delimiter;

    @BeforeEach
    void setUp() {
        delimiter = new Delimiter();
    }

    @Test
    void getDelimiter() {
        assertThat(delimiter.getDelimiter()).isEqualTo("[,;]");
    }

    @Test
    void delimiterContains() {
        assertAll(
                () -> assertThat(delimiter.contains(",")).isTrue(),
                () -> assertThat(delimiter.contains(";")).isTrue(),
                () -> assertThat(delimiter.contains("?")).isFalse()
        );
    }

    @Test
    void findCustomOperator() {
        String expression = "//?\\n1,2;3?4";

        expression = delimiter.findCustomOperator(expression);

        assertThat(expression).isEqualTo("1,2;3?4");
        assertThat(delimiter.contains("?")).isTrue();
    }
}
