import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        baseballGame = new BaseballGame(numbers);
    }


    @DisplayName("위치가 다르면 Ball")
    @Test
    void evaluateBall() {
        Ball ball = new Ball(2, 1);

        BallStatus res = baseballGame.evaluate(ball);

        assertThat(res).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("값과 위치가 맞으면 Strike")
    @Test
    void evaluateStrike() {
        Ball ball = new Ball(2, 2);

        BallStatus res = baseballGame.evaluate(ball);

        assertThat(res).isEqualTo(BallStatus.STRIKE);
    }

    @DisplayName("1ball 1strike ")
    @Test
    void play() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        PlayResult result = baseballGame.play(numbers);

        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.isDone()).isFalse();
    }

    @DisplayName("2ball  ")
    @Test
    void play2() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        PlayResult result = baseballGame.play(numbers);

        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.isDone()).isFalse();
    }

    @DisplayName("result nothing")
    @Test
    void play3() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(6);
        numbers.add(4);
        PlayResult result = baseballGame.play(numbers);

        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.isDone()).isFalse();
        assertThat(result.isNothing()).isTrue();
    }

    @DisplayName("3 strike")
    @Test
    void play4() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        PlayResult result = baseballGame.play(numbers);

        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isDone()).isTrue();
    }

}