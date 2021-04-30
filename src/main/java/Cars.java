import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final int REQUIRED_MINIMUM_NUMBER_TO_MOVE = 4;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            moveCar(car, numberGenerator);
        }
    }

    private void moveCar(Car car, NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator)) {
            car.move();
        }
    }

    private boolean isMovable(NumberGenerator numberGenerator) {
        return numberGenerator.nextNumber() >= REQUIRED_MINIMUM_NUMBER_TO_MOVE;
    }

    public List<String> getCarsStatus() {

        List<String> status = new ArrayList<>();

        for (Car car : cars) {
            status.add(car.toString());
        }

        return status;
    }

    public String getWinnerNames() {

        int maxScore = getMaxScore();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinnerName(car, winners, maxScore);
        }

        return String.join(", ", winners);
    }

    private void addWinnerName(Car car, List<String> winners, int maxScore) {
        if (car.getScore() == maxScore) {
            winners.add(car.getName());
        }
    }

    private int getMaxScore() {

        int maxScore = 0;

        for (Car car : cars) {
            maxScore = Math.max(maxScore, car.getScore());
        }

        return maxScore;
    }
}
