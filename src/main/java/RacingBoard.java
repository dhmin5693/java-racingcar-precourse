import java.util.List;

public class RacingBoard {

    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingBoard(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void race() {
        cars.moveAll(numberGenerator);
    }

    public List<String> getResult() {
        return cars.getCarsStatus();
    }

    public String getWinnerNames() {
        return cars.getWinnerNames();
    }
}
