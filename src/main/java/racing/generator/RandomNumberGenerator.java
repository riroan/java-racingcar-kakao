package racing.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private final int MAX_VALUE = 10;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return Math.abs(random.nextInt()) % MAX_VALUE;
    }
}
