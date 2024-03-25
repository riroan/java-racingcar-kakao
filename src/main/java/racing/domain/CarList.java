package racing.domain;

import racing.generator.NumberGenerator;
import racing.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class CarList {
    LinkedHashMap<String, Car> carHashMap;

    public CarList(List<Car> carList) {
        this.carHashMap = createCarHashMap(carList);
    }

    private LinkedHashMap<String, Car> createCarHashMap(List<Car> carList) {
        LinkedHashMap<String, Car> tmpCarHashMap = new LinkedHashMap<>();
        for (Car car : carList) {
            tmpCarHashMap.put(car.getCarName(), car);
        }

        return tmpCarHashMap;
    }

    public void proceed() {
        for (Car car : this.carHashMap.values()) {
            car.proceed();
        }
    }

    public Car findByName(String name) {
        return this.carHashMap.get(name);
    }

    public List<Car> getCarList() {
        return new ArrayList<>(this.carHashMap.values());
    }

    public List<Car> getWinner() {
        int maxPosition = 0;
        for (Car car : this.carHashMap.values()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<Car> winner = new ArrayList<>();
        for (Car car : this.carHashMap.values()) {
            if (car.getPosition() == maxPosition) {
                winner.add(car);
            }
        }
        return winner;
    }
}
