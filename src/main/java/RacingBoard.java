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

    public String getWinnerName() {

        int maxScore = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (maxScore < car.getScore()) {
                winners.clear();
                winners.add(car.getName());
                maxScore = car.getScore();
                continue;
            }

            if (maxScore == car.getScore()) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }
}
