import java.util.List;

public class RacingBoard {

    private final Cars cars;

    public RacingBoard(Cars cars) {
        this.cars = cars;
    }

    public void race() {
        cars.moveAll();
    }

    public List<String> getResult() {
        return cars.getCarsStatus();
    }

    public String getWinnerNames() {
        return cars.getWinnerNames();
    }
}
