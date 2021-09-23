package pursuit;

public class Robot {
    private static double xVelocity = 0;
    private static double yVelocity = 0;
    private static double velocity = 0;

    private static double angleDegrees = 0;

    private static double x = 200;
    private static double y = 280;

    public static double getAngleDegrees() {
        return angleDegrees;
    }

    public static double getVelocity() {
        return velocity;
    }

    public static void setVelocity(double velocity) {
        Robot.velocity = velocity;
        Robot.yVelocity  = Math.sin(Math.toRadians(angleDegrees)) * Robot.velocity;
        Robot.xVelocity  = Math.cos(Math.toRadians(angleDegrees)) * Robot.velocity;
    }

    public static void setAngleDegrees(double angleDegrees) {
        Robot.angleDegrees = angleDegrees;
        Robot.angleDegrees %= 360;
    }

    public static void setXVelocity(double xVelocity) {
        Robot.xVelocity = xVelocity;
    }

    public static void setYVelocity(double yVelocity) {
        Robot.yVelocity = yVelocity;
    }

    public static double getX() {
        return x;
    }

    public static double getY() {
        return y;
    }

    public static void moveY() {
        y += yVelocity;
    }
    public static void moveX() {
        x += xVelocity;
    }
}
