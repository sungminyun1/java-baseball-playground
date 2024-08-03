import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BaseballGame {
    List<Ball> balls;

    public BaseballGame(List<Integer> ballNumbers) {
        this.balls = mappingBalls(ballNumbers);
    }

    private List<Ball> mappingBalls(List<Integer> ballNumbers) {
        return IntStream.range(0, ballNumbers.size())
                .mapToObj(i -> new Ball(ballNumbers.get(i), i + 1))
                .collect(Collectors.toList());
    }

    public PlayResult play(List<Integer> userInputBallNumbers) {
        PlayResult playResult = new PlayResult();
        List<Ball> userInputBalls = mappingBalls(userInputBallNumbers);
        userInputBalls.stream()
                .map(this::evaluate)
                .forEach(playResult::setResult);

        return playResult;
    }

    public BallStatus evaluate(Ball inputBall) {
        return balls.stream()
                .map(ball -> ball.evaluate(inputBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
