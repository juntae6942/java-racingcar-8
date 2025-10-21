package racingcar.ui;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.NameParser;
import racingcar.common.NameValidator;
import racingcar.common.NumberValidator;

public class InputView {

    private final NameParser nameParser;
    private int repeatCount;

    public InputView(NameParser nameParser) {
        this.nameParser = nameParser;
    }

    public List<String> carNames() {
        String input = Console.readLine();
        List<String> names = nameParser.parse(input);
        names.forEach(NameValidator::validateName);
        return names;
    }

    public void initRepeatCount() {
        String input = Console.readLine();
        NumberValidator.validateNumber(input);
        repeatCount = Integer.parseInt(input);
    }

    public int repeatCount() {
        return repeatCount;
    }
}
