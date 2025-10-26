package racingcar.application;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.MovementChecker;

public class RacingGame {

    private final MovementChecker movementChecker;
    private final List<Car> cars;

    public RacingGame(List<Car> cars, MovementChecker movementChecker) {
        this.cars = cars;
        this.movementChecker = movementChecker;
    }

    public List<Car> race(int repeatCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < repeatCount; i++) {
            moveAllCars();
            showRoundStatus();
        }
        return cars;
    }

    private void moveAllCars() {
        for (Car car : cars) {
            car.move(movementChecker);
        }
    }

    private void showRoundStatus() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
