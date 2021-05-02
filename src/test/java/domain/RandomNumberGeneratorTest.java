package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("숫자 생성 결과는 0 ~ 9 사이의 값이 나와야 한다.")
    @RepeatedTest(100)
    void randomNumberTest() {
        RandomNumberGenerator randomBooleanGenerator = new RandomNumberGenerator();
        assertThat(randomBooleanGenerator.nextNumber()).isGreaterThanOrEqualTo(0)
                                                       .isLessThanOrEqualTo(9);
    }
}