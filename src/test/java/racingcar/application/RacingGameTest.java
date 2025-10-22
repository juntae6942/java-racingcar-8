package racingcar.application;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.AlwaysFalseMovementChecker;
import racingcar.domain.AlwaysTrueMovementChecker;
import racingcar.domain.Car;
import racingcar.domain.MovementChecker;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private static RacingGame racingGame;
    private static List<Car> cars;

    @BeforeEach
    void setUp() {
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car junCar = new Car("jun");
        cars = List.of(pobiCar, woniCar, junCar);
    }

    @Test
    @DisplayName("MovementChecker가 항상 true일 때 자동차 움직임 테스트")
    void carMovesForwardWhenCheckerAllows() {
        MovementChecker movementChecker = new AlwaysTrueMovementChecker();
        racingGame = new RacingGame(cars, movementChecker);

        racingGame.race(3);

        assertThat(cars)
                .allSatisfy(car -> assertThat(car.position()).isEqualTo(3));
    }

    @Test
    @DisplayName("MovementChecker가 항상 false일 때 자동차 움직임 없음 테스트")
    void carStopWhenCheckerNotAllows() {
        MovementChecker movementChecker = new AlwaysFalseMovementChecker();
        racingGame = new RacingGame(cars, movementChecker);

        racingGame.race(3);

        assertThat(cars)
                .allSatisfy(car -> assertThat(car.position()).isEqualTo(0));
    }
}
