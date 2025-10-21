package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(MovementChecker movementChecker) {
        if (movementChecker.canMove()) {
            this.position++;
        }
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
