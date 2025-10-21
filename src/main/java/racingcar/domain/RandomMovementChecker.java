package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementChecker implements MovementChecker {

    @Override
    public boolean canMove() {
        int threshold = Randoms.pickNumberInRange(0, 9);
        return threshold >= 4;
    }
}
