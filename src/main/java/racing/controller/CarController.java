package racing.controller;

import racing.domain.Car;
import racing.domain.CarList;
import racing.generator.FalseNumberGenerator;
import racing.generator.RandomNumberGenerator;
import racing.generator.TrueNumberGenerator;
import racing.view.CarView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarController {
    public void run() {
        CarView carView = new CarView();

        String carNames = carView.getCarNames();
        CarList carList = new CarList(createCarList(carNames));

        String tryCount = carView.getTryCount();
        int turn = Integer.parseInt(tryCount);

        System.out.println("\n실행결과");
        for (int i = 0; i < turn; i++) {
            carList.proceed();
            carView.printCarList(carList);
            System.out.println();
        }

        carView.printWinner(carList);
    }

    private List<Car> createCarList(String carNames) {
        List<String> carNamesList = Arrays.asList(carNames.split(","));
        List<Car> carList = new ArrayList<>();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (String carName : carNamesList) {
            Car car = new Car(carName, randomNumberGenerator);
            carList.add(car);
        }

        return carList;
    }
}
