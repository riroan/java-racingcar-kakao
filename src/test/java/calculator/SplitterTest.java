package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SplitterTest {
    @Test
    void split() {
        Splitter splitter = new Splitter();
        String expression = "1,2;3";

        List<Integer> numberList = splitter.split(expression);

        Assertions.assertThat(numberList.size()).isEqualTo(3);
        Assertions.assertThat(numberList.get(0)).isEqualTo(1);
        Assertions.assertThat(numberList.get(1)).isEqualTo(2);
        Assertions.assertThat(numberList.get(2)).isEqualTo(3);
    }

    @Test
    void customSplit() {
        Splitter splitter = new Splitter();
        splitter.add('?');

        String expression = "1,2;3?4";

        List<Integer> numberList = splitter.split(expression);

        Assertions.assertThat(numberList.size()).isEqualTo(4);
        Assertions.assertThat(numberList.get(0)).isEqualTo(1);
        Assertions.assertThat(numberList.get(1)).isEqualTo(2);
        Assertions.assertThat(numberList.get(2)).isEqualTo(3);
        Assertions.assertThat(numberList.get(3)).isEqualTo(4);
    }
}
