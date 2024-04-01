package racing.domain;

import racing.generator.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    Map<String, Car> carHashMap;

    public RacingGame(String[] carNames) {
        List<Car> cars = createCarList(carNames);
        this.carHashMap = createCarHashMap(cars);
    }

    private List<Car> createCarList(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (String carName : carNames) {
            Car car = new Car(carName, randomNumberGenerator);
            carList.add(car);
        }

        return carList;
    }

    private Map<String, Car> createCarHashMap(List<Car> carList) {
        return carList
                .stream()
                .collect(Collectors.toMap(Car::getCarName, car->car, (x, y) -> y, LinkedHashMap::new));
    }

    public void proceed() {
        for (Car car : getCarList()) {
            car.proceed();
        }
    }

    public Car findByName(String name) {
        return this.carHashMap.get(name);
    }

    public List<Car> getCarList() {
        return new ArrayList<>(this.carHashMap.values());
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinner(List<Car> cars, int maxPosition) {
        return cars
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
