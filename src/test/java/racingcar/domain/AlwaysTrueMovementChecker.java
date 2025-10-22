package racingcar.domain;

public class AlwaysTrueMovementChecker implements MovementChecker{

    @Override
    public boolean canMove() {
        return true;
    }
}
