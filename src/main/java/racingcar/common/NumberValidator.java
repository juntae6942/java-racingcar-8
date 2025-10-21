package racingcar.common;

public class NumberValidator {

    public static void validateNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("정수형이 아닌 잘못된 입력입니다.");
        }
    }
}
