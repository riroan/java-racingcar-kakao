package racing.domain;

import racing.generator.NumberGenerator;
import racing.generator.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

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

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinner() {
        List<Car> cars = getCarList();
        final int maxPosition = getMaxPosition(cars);

        return cars
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
