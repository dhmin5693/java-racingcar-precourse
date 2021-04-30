import java.util.ArrayList;
import java.util.List;

public class RacingBoard {

    private static final int REQUIRED_MINIMUM_NUMBER_TO_MOVE = 4;

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public RacingBoard(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void race() {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if (isMovable()) {
            car.move();
        }
    }

    private boolean isMovable() {
        return numberGenerator.nextNumber() >= REQUIRED_MINIMUM_NUMBER_TO_MOVE;
    }

    public List<String> getResult() {

        List<String> result = new ArrayList<>();

        for (Car car : cars) {
            result.add(car.toString());
        }

        return result;
    }
}
