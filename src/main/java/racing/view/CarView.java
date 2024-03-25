package racing.view;

import racing.domain.Car;
import racing.domain.CarList;
import racing.validator.CarNameValidator;
import racing.validator.TryCountValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarView {
    private final Scanner scanner;

    public CarView() {
        scanner = new Scanner(System.in);
    }

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

    public String getCarNames() {
        CarNameValidator carNameValidator = new CarNameValidator();
        boolean nameValidated;
        String inputNames;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            inputNames = scanner.nextLine();
            nameValidated = carNameValidator.validate(inputNames);
            printNameError(nameValidated);
        } while (!nameValidated);

        return inputNames;
    }

    private void printNameError(boolean nameValidated) {
        if (!nameValidated) {
            System.out.println("[Error] 잘못된 이름 형식입니다. 다시 입력해주세요.");
        }
    }

    public String getTryCount() {
        TryCountValidator tryCountValidator = new TryCountValidator();
        boolean tryCountValidated;
        String inputCount;

        do {
            System.out.println("시도할 회수는 몇회인가요?");
            inputCount = scanner.nextLine();
            tryCountValidated = tryCountValidator.validate(inputCount);
            printTryCountError(tryCountValidated);
        } while(!tryCountValidated);

        return inputCount;
    }

    private void printTryCountError(boolean tryCountValidated) {
        if (!tryCountValidated) {
            System.out.println("[Error] 잘못된 횟수 입니다. 다시 입력해주세요.");
        }
    }
}
