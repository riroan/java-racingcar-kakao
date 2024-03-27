package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SplitterTest {
    Delimiter delimiter;
    Splitter splitter;

    @BeforeEach
    void setUp() {
        this.delimiter = new Delimiter();
        this.splitter = new Splitter();
    }

    @Test
    void split() {
        String expression = "1,2;3";

        List<Integer> numberList = splitter.split(expression, delimiter);

        assertAll(
                () -> assertThat(numberList.size()).isEqualTo(3),
                () -> assertThat(numberList.get(0)).isEqualTo(1),
                () -> assertThat(numberList.get(1)).isEqualTo(2),
                () -> assertThat(numberList.get(2)).isEqualTo(3)
        );


    }

    @Test
    void customSplit() {
        delimiter = new Delimiter(new String[]{"?"});

        String expression = "1,2;3?4";

        List<Integer> numberList = splitter.split(expression, delimiter);

        assertThat(numberList.size()).isEqualTo(4);
        assertThat(numberList.get(0)).isEqualTo(1);
        assertThat(numberList.get(1)).isEqualTo(2);
        assertThat(numberList.get(2)).isEqualTo(3);
        assertThat(numberList.get(3)).isEqualTo(4);
    }
}
