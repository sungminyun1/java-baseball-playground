public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public static boolean isStrike(BallStatus ballStatus) {
        return ballStatus == BallStatus.STRIKE;
    }

    public static boolean isBall(BallStatus ballStatus) {
        return ballStatus == BallStatus.BALL;
    }

    public static boolean isNotNothing(BallStatus ballStatus) {
        return ballStatus != BallStatus.NOTHING;
    }
}
