import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingBoardTest {

    private NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new NumberGenerator() {

            private int count = -1;

            // 1, 3, 5, 7, 9, 1, 3, ...
            @Override
            public int nextNumber() {
                count += 2;
                return count % 10;
            }
        };
    }

    private Cars createCars(int size) {

        List<Car> cars = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append((char)(i + 'A'));
            cars.add(new Car(sb.toString()));
            sb.deleteCharAt(0);
        }

        return new Cars(cars);
    }

    @DisplayName("숫자 생성 결과가 4 이상인 차량만 전진 가능 - 0번 시도")
    @Test
    void raceTest00() {
        RacingBoard racingBoard = new RacingBoard(createCars(4), numberGenerator);

        List<String> expected = Arrays.asList("A: ", "B: ", "C: ", "D: ");
        List<String> actual = racingBoard.getResult();
        assertEquals(expected, actual);
    }

    @DisplayName("숫자 생성 결과가 4 이상인 차량만 전진 가능 - 1번 시도")
    @Test
    void raceTest01() {
        RacingBoard racingBoard = new RacingBoard(createCars(4), numberGenerator);
        racingBoard.race();

        List<String> expected = Arrays.asList("A: ", "B: ", "C: -", "D: -");
        List<String> actual = racingBoard.getResult();
        assertEquals(expected, actual);
    }

    @DisplayName("숫자 생성 결과가 4 이상인 차량만 전진 가능 - 2번 시도")
    @Test
    void raceTest02() {
        RacingBoard racingBoard = new RacingBoard(createCars(4), numberGenerator);
        racingBoard.race();
        racingBoard.race();

        List<String> expected = Arrays.asList("A: -", "B: ", "C: -", "D: --");
        List<String> actual = racingBoard.getResult();
        assertEquals(expected, actual);
    }

    @DisplayName("숫자 생성 결과가 4 이상인 차량만 전진 가능 - 3번 시도")
    @Test
    void raceTest03() {
        RacingBoard racingBoard = new RacingBoard(createCars(4), numberGenerator);
        racingBoard.race();
        racingBoard.race();
        racingBoard.race();

        List<String> expected = Arrays.asList("A: --", "B: -", "C: -", "D: --");
        List<String> actual = racingBoard.getResult();
        assertEquals(expected, actual);
    }

    @DisplayName("가장 많이 전진한 차가 우승 - 2번 경주")
    @Test
    void winnerTest01() {
        RacingBoard racingBoard = new RacingBoard(createCars(4), numberGenerator);
        racingBoard.race();
        racingBoard.race();

        String expected = "D";
        String actual = racingBoard.getWinnerNames();
        assertEquals(expected, actual);
    }

    @DisplayName("가장 많이 전진한 차가 우승 - 3번 경주")
    @Test
    void winnerTest02() {
        RacingBoard racingBoard = new RacingBoard(createCars(4), numberGenerator);
        racingBoard.race();
        racingBoard.race();
        racingBoard.race();

        String expected = "A, D";
        String actual = racingBoard.getWinnerNames();
        assertEquals(expected, actual);
    }
}
