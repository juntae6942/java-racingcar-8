package racingcar.ui;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("우승자가 여럿인 경우 테스트")
    void winnersTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni, jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "jun : -", "최종 우승자 : pobi, jun");
                    },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("아무도 움직이지 못한 경우")
    void movingForwardTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi, woni,jun", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "jun : ", "최종 우승자 : pobi, woni, jun");
                },
                STOP, STOP, STOP
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
