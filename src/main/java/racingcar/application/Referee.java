package racingcar.application;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Referee {

    private final List<Car> cars;
    private final List<Car> winners;
    private int maxPosition;

    public Referee(List<Car> cars) {
        this.cars = cars;
        winners = new ArrayList<>();
        maxPosition = -1;
    }

    public List<Car> findWinner() {
        for (Car car : cars) {
            if (car.position() > maxPosition) {
                winners.clear();
                winners.add(car);
                maxPosition = car.position();
            } else if (car.position() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
