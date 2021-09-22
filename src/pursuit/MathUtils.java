package pursuit;

public class MathUtils {

    /**
     * Credit ElectricWhizz for inspiration
     */
    public static void toPoint(double turnSpeed){
        double robotX = Robot.getX();
        double robotY = Robot.getY();

        double targetX = Main.goalX;
        double targetY = Main.goalY;

        double relativeDistanceX = targetX - robotX;
        double relativeDistanceY = targetY - robotY;

        double relativeDistance = Math.hypot(relativeDistanceX, relativeDistanceY);

        double angleToTargetDegrees = wrapAngle(unwrap(unwrap(Math.toDegrees(Math.atan2(relativeDistanceY, relativeDistanceX))) - (((int)Robot.getAngleDegrees()))));

        double turn = Math.min(Math.max(angleToTargetDegrees/30, -1), 1) * turnSpeed;
        Robot.setAngleDegrees((int)Robot.getAngleDegrees() + turn);

        double maxVel = Math.min(Robot.getVelocity() + 1.5, 13);
        double minVel = 1.5;
        Robot.setVelocity(Math.min(
                Math.min(
                        Math.max(
                                (relativeDistance/40) / (angleToTargetDegrees*5),
                                minVel
                        ),
                        maxVel
                ) + Math.max( Robot.getVelocity() - angleToTargetDegrees/26, minVel),
                maxVel
        )
        );

    }

    public static double wrapAngle(double angle){
        angle %= 360;
        if(angle > 180){
            return 180 - angle;
        }
        return angle;
    }
    public static double unwrap(double angle){
        if(angle < 0){
            angle = 360 + angle;
        }
        return angle;
    }

    public static class point{
        @Override
        public String toString() {
            return "point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        private double x, y;
        public point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }
        public double getY() {
            return y;
        }

    }
}
