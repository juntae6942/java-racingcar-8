package racingcar.common;

import java.util.Arrays;
import java.util.List;

public class NameParser {

    private final String DELIMITER = ",";

    public List<String> parse(String input) {
        return Arrays.stream(input.split(DELIMITER)).toList();
    }
}
