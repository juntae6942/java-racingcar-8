package racingcar.common;

public class NameValidator {

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
           throw new IllegalArgumentException("잘못된 자동차 이름입니다.");
        }
    }
}
