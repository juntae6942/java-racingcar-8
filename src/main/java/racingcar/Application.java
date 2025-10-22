package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.application.RacingGame;
import racingcar.application.Referee;
import racingcar.common.NameParser;
import racingcar.domain.Car;
import racingcar.domain.MovementChecker;
import racingcar.domain.RandomMovementChecker;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NameParser nameParser = new NameParser();
        InputView inputView = new InputView(nameParser);
        List<String> carNames = inputView.carNames();
        int repeatCount = inputView.repeatCount();

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        MovementChecker movementChecker = new RandomMovementChecker();
        RacingGame racingGame = new RacingGame(cars, movementChecker);
        cars = racingGame.race(repeatCount);

        Referee referee = new Referee(cars);
        List<Car> winner = referee.findWinner();

        OutputView outputView = new OutputView();
        outputView.finalResult(winner);
        Console.close();
    }
}
