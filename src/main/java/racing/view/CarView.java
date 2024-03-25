package racing.view;

import racing.domain.Car;
import racing.domain.CarList;

import java.util.ArrayList;
import java.util.List;

public class CarView {
    public void printCarList(CarList carList) {
        for (Car car : carList.getCarList()) {
            printCar(car);
        }
    }

    private void printCar(Car car) {
        String status = car.getCarName() + " : ";
        for (int i = 0; i < car.getPosition(); i++) {
            status += "-";
        }

        System.out.println(status);
    }

    public void printWinner(CarList carList) {
        List<Car> winners = carList.getWinner();
        List<String> winnerNameList = new ArrayList<>();
        for (Car winner : winners) {
            winnerNameList.add(winner.getCarName());
        }
        System.out.println(String.join(", ", winnerNameList) + "가 최종 우승 했습니다.");
    }

    public void getCarNames() {

    }
}
