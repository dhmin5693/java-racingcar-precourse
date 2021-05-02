package domain;

import java.util.ArrayList;
import java.util.List;
import ui.IOManager;

public class RacingBoard {

    private static final String NAME_DELIMITER = ",";

    private final IOManager ioManager;

    public RacingBoard(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    public static void run() {
        RacingBoard racingBoard = new RacingBoard(IOManager.defaultIOManager());
        racingBoard.play();
    }

    public void play() {
        String playerNames = inputNames();
        int tryCount = inputTryCount();

        startRace(playerNames, tryCount);
    }

    private int inputTryCount() {
        ioManager.printInputTryCount();
        return ioManager.inputTryCount();
    }

    private String inputNames() {
        ioManager.printInputNames();
        return ioManager.inputNames();
    }

    private Cars makeCarsByNames(String playerNames) {

        List<Car> carList = new ArrayList<>();
        String[] names = playerNames.split(NAME_DELIMITER);

        for (String name : names) {
            carList.add(new Car(name));
        }

        return new Cars(carList);
    }

    private void startRace(String playerNames, int tryCount) {
        Cars cars = makeCarsByNames(playerNames);

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll();
            ioManager.printStatus(cars.getCarsStatus());
        }

        ioManager.printResult(cars.getWinners());
    }
}
