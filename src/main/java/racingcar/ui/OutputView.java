package racingcar.ui;

import java.util.List;

public class OutputView {

    public void finalResult(List<String> names) {
        if (names.size() > 1) {
            System.out.println(String.join(", ", names));
        } else {
            System.out.println(names.getFirst());
        }
    }
}
