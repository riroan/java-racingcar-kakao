package racing.controller;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.generator.RandomNumberGenerator;
import racing.view.CarView;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    private final RacingGame racingGame;

    public CarController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void run(int turn) {
        for (int i = 0; i < turn; i++) {
            racingGame.proceed();
        }
    }
}
