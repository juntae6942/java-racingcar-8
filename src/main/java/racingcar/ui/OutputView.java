package racingcar.ui;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void finalResult(List<Car> cars) {
        if (cars.size() > 1) {
            List<String> names = cars.stream().map(Car::name).toList();
            System.out.println(String.join(", ", names));
        } else {
            System.out.println(cars.getFirst().name());
        }
    }
}
