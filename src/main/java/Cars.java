import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
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
