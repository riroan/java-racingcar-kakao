package racing.controller;

import racing.domain.Car;
import racing.domain.CarList;
import racing.generator.FalseNumberGenerator;
import racing.generator.TrueNumberGenerator;
import racing.view.CarView;

import java.util.Arrays;

public class CarController {
    public void run(int turn) {
        CarView carView = new CarView();

        TrueNumberGenerator trueNumberGenerator = new TrueNumberGenerator();
        FalseNumberGenerator falseNumberGenerator = new FalseNumberGenerator();
        CarList carList = new CarList(
                Arrays.asList(
                        new Car("car1", trueNumberGenerator),
                        new Car("car2", falseNumberGenerator)
                )
        );
        System.out.println("실행결과");
        for (int i = 0; i < turn; i++) {
            carList.proceed();
            carView.printCarList(carList);
            System.out.println();
        }

        carView.printWinner(carList);
    }
}
