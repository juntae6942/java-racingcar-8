package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.NameParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private static InputView inputView;

    @BeforeAll
    static void init() {
        NameParser nameParser = new NameParser();
        inputView = new InputView(nameParser);
    }

    @BeforeEach
    void inputSetUp() {
        System.setIn(System.in);
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    @DisplayName("자동차 이름을 정상적으로 추출하는 테스트")
    void carNameParseTest() {
        String input = "모닝, 소나타, 쿠퍼, 포터";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> result = inputView.carNames();

        assertThat(result).containsExactly("모닝", "소나타", "쿠퍼", "포터");
    }

    @Test
    @DisplayName("자동차 이름으로 빈 문자열이 들어왔을 때 테스트")
    void emptyCarNameParseTest() {
        String input = "모닝, ";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<String> result = inputView.carNames();

        assertThat(result).containsExactly("모닝");
    }

    @Test
    @DisplayName("자동차 이름의 길이 제한 테스트")
    void carNameLengthLimitTest() {
        String input = "햄부기햄북스닥스, 햄부기함부르크, 햄버거";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> inputView
                  .carNames())
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 횟수 입력 테스트")
    void repeatCountTest() {
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = inputView.repeatCount();

        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("정수가 아닌 이동 횟수 입력 테스트")
    void wrongTypeRepeatCountTest() {
        String input = "햄북스";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> inputView
                .repeatCount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동 횟수 빈문자열 입력 테스트")
    void emptyRepeatCountTest() {
        String input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> inputView
                .repeatCount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
