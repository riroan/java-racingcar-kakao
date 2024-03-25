package racing.domain;

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
}
