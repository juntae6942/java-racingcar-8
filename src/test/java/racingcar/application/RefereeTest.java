package racingcar.application;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.AlwaysTrueMovementChecker;
import racingcar.domain.Car;
import racingcar.domain.MovementChecker;

class RefereeTest {

    private static List<Car> cars;
    private static Referee referee;
    private static MovementChecker movementChecker;

    @BeforeAll
    static void setUp() {
        movementChecker = new AlwaysTrueMovementChecker();
    }

    @BeforeEach
    void init() {
        Car pobiCar = new Car("pobi");
        Car woniCar = new Car("woni");
        Car junCar = new Car("jun");
        cars = List.of(pobiCar, woniCar, junCar);
        referee = new Referee(cars);
    }

    @Test
    @DisplayName("다수 우승자 정상 분류 테스트")
    void findWinnersTest() {
        cars.get(0).move(movementChecker);
        cars.get(1).move(movementChecker);

        List<Car> winner = referee.findWinner();

        Assertions.assertThat(winner)
                .extracting(Car::name)
                .containsExactly("pobi", "woni")
                .hasSize(2);
    }

    @Test
    @DisplayName("단일 우승자 정상 분류 테스트")
    void findWinnerTest() {
        cars.get(2).move(movementChecker);

        List<Car> winner = referee.findWinner();

        Assertions.assertThat(winner)
                .extracting(Car::name)
                .containsExactly("jun")
                .hasSize(1);
    }
}