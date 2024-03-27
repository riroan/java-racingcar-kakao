package racing.domain;

import org.junit.jupiter.api.Test;

import racing.generator.FalseNumberGenerator;
import racing.generator.TrueNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void go() {
        Car car = new Car("car_name", new TrueNumberGenerator());

        assertThat(car.proceed()).isTrue();
    }

    @Test
    void stop() {
        Car car = new Car("car_name", new FalseNumberGenerator());

        assertThat(car.proceed()).isFalse();
    }
}
