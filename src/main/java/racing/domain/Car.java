package racing.domain;

import racing.generator.NumberGenerator;

import java.util.*;

public class Car {
    private final String carName;
    private final NumberGenerator numberGenerator;
    private final int THRESHOLD = 3;
    private int position;
    private List<Integer> history;

    public Car(String carName, NumberGenerator numberGenerator) {
        this.carName = carName;
        this.numberGenerator = numberGenerator;
        this.position = 0;
        this.history = new ArrayList<>();
    }

    public boolean proceed() {
        int number = numberGenerator.generate();
        if (this.canGo(number)) {
            this.position++;
            this.history.add(this.position);
            return true;
        }
        this.history.add(this.position);
        return false;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public int getPosition(int time) {
        return history.get(time);
    }

    private boolean canGo(int number) {
        return (number > THRESHOLD);
    }
}
