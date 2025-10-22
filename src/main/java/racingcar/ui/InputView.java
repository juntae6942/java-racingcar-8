package racingcar.ui;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.NameParser;
import racingcar.common.NameValidator;
import racingcar.common.NumberValidator;

public class InputView {

    private final NameParser nameParser;

    public InputView(NameParser nameParser) {
        this.nameParser = nameParser;
    }

    public List<String> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> names = nameParser.parse(input);
        names.forEach(NameValidator::validateName);
        return names;
    }

    public int repeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        NumberValidator.validateNumber(input);
        return Integer.parseInt(input);
    }
}
