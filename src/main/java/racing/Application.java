package racing;

import racing.controller.CarController;
import racing.domain.Car;
import racing.domain.RacingGame;
import racing.view.CarView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        CarView carView = new CarView();

        String inputCarNames = carView.getCarNames();
        String[] carNames = inputCarNames.split(",");
        RacingGame racingGame = new RacingGame(carNames);
        CarController carController = new CarController(racingGame);

        int turn = carView.getTryCount();

        carController.run(turn);

        carView.printResultDescription();
        for (int time = 0; time < turn; time++) {
            carView.printCarList(racingGame, time);
        }

        List<Car> cars = racingGame.getCarList();
        int maxPosition = racingGame.getMaxPosition(cars);
        List<Car> winners = racingGame.getWinner(cars, maxPosition);

        carView.printWinner(winners);
    }
}
