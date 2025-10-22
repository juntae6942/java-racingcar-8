package racingcar.domain;

public class AlwaysFalseMovementChecker implements MovementChecker {

    @Override
    public boolean canMove() {
        return false;
    }
}
