import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void calculate() {
        int res = stringCalculator.calculate("2 + 3 * 4 / 2");

        assertThat(res).isEqualTo(10);
    }

    @Test
    void evaluate() {
        stringCalculator.evaluate("5");
        assertThat(stringCalculator.getResult()).isEqualTo(5);

        stringCalculator.evaluate("+");
        assertThat(stringCalculator.getOperation()).isEqualTo("+");

        stringCalculator.evaluate("6");
        assertThat(stringCalculator.getResult()).isEqualTo(11);
    }

    @CsvSource({"+,true", "-,true", "*,true", "/,true", "&,false"})
    @ParameterizedTest
    void isOperator(String operator, boolean expected) {
        assertThat(stringCalculator.isOperator(operator)).isEqualTo(expected);
    }

    @Test
    void setOperation() {
        stringCalculator.setOperation("+");
        assertThat(stringCalculator.getOperation()).isEqualTo("+");
    }

    @Test
    void calcNum() {
        stringCalculator.calcNum(5);
        assertThat(stringCalculator.getResult()).isEqualTo(5);

        stringCalculator.setOperation("+");

        stringCalculator.calcNum(5);
        assertThat(stringCalculator.getResult()).isEqualTo(10);
    }

    @Test
    void isFirst() {
        assertThat(stringCalculator.isFirst()).isTrue();

        stringCalculator.setOperation("+");

        assertThat(stringCalculator.isFirst()).isFalse();
    }
}