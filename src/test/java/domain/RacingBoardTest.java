package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.IOManager;
import ui.Input;
import ui.StandardOutput;

class RacingBoardTest {

    @DisplayName("통합 테스트")
    @Test
    void integrationTest() {

        Input input = new Input() {
            @Override
            public String nextLine() {
                return "pobi,crong,honux";
            }

            @Override
            public int nextInt() {
                return 5;
            }
        };

        IOManager ioManager = new IOManager(input, new StandardOutput());
        RacingBoard racingBoard = new RacingBoard(ioManager);
        racingBoard.play();
    }
}