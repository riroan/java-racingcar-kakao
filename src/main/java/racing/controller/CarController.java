package racing.controller;

import racing.domain.Car;
import racing.domain.CarList;
import racing.generator.RandomNumberGenerator;
import racing.view.CarView;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private final CarView carView;

    public CarController() {
        carView = new CarView();
    }

    public void run() {
        String carNames = carView.getCarNames();
        CarList carList = new CarList(createCarList(carNames));

        int turn = carView.getTryCount();

        carView.printResultDescription();
        for (int i = 0; i < turn; i++) {
            runOneTurn(carList);
        }

        carView.printWinner(carList);
    }

    private void runOneTurn(CarList carList) {
        carList.proceed();
        carView.printCarList(carList);

    }

    private List<Car> createCarList(String carNames) {
        String[] carNamesList = carNames.split(",");
        List<Car> carList = new ArrayList<>();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (String carName : carNamesList) {
            Car car = new Car(carName, randomNumberGenerator);
            carList.add(car);
        }

        return carList;
    }
}
