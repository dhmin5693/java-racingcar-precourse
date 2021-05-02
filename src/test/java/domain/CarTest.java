package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @DisplayName("자동차 이름은 null일 수 없다.")
    @NullSource
    @ParameterizedTest
    void nameIsNotNull(String name) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car(name));
    }

    @DisplayName("자동차 이름은 어떤 형태의 공백도 올 수 없다.")
    @NullAndEmptySource
    @ValueSource(strings = {"", " ", "     ", "\t", "\n"})
    @ParameterizedTest
    void nameIsNotBlank(String name) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car(name));
    }

    @DisplayName("자동차 이름은 5자 이하여야 한다.")
    @ValueSource(strings = {"123456", "1234567", "12345678", "123456789"})
    @ParameterizedTest
    void nameSizeIsLessThenAndEqualsTo5(String name) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car(name));
    }

    @DisplayName("자동차는 메시지로 전진시킬 수 있으며, N번 전진한 자동차는 '-'가 N번 출력되어야 한다."
        + "전진 결과 출력 시 차이름: ---- 의 형식으로 출력한다.")
    @ValueSource(ints = {1, 3, 5})
    @ParameterizedTest
    void test03(int moveCount) {

        Engine engine = new Engine(new CarMoveRule(), () -> 5);
        Car car = new Car("name", engine);

        StringBuilder marks = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            car.move();
            marks.append("-");
        }

        String expected = "name: " + marks;
        assertEquals(expected, car.toString());
    }
}