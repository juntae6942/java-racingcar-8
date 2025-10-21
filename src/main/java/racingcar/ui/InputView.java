package racingcar.ui;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.common.NameParser;
import racingcar.common.NameValidator;

public class InputView {

    private final NameParser nameParser;

    public InputView(NameParser nameParser) {
        this.nameParser = nameParser;
    }

    public List<String> carNames() {
        String input = Console.readLine();
        List<String> names = nameParser.parse(input);
        names.forEach(NameValidator::validateName);
        return names;
    }
}
