package pursuit;

import java.awt.*;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static ArrayList<Point> toDraw = new ArrayList<>();


    public static double goalX;
    public static double goalY;
    public static MathUtils.point[] pts;

    public static void main(String[] args) throws IOException, InterruptedException, NoninvertibleTransformException {
        pts = new MathUtils.point[]{new MathUtils.point(10, 10),
                new MathUtils.point(300, 400),
                new MathUtils.point(500, 400),
                new MathUtils.point(700, 100),
                new MathUtils.point(900, 500),
                new MathUtils.point(100, 600)};

//        pts = new MathUtils.point[]{new MathUtils.point(10, 10),
//                new MathUtils.point(700, 100),
//                new MathUtils.point(700, 600),
//                new MathUtils.point(10, 600)};
        FX.init();

        Robot.setXVelocity(0);
        Robot.setYVelocity(0);

        Thread.sleep(2000);


        int curLine = 0;

        while(true){

            if(Math.abs(Robot.getX() - pts[pts.length-1].getX()) < 80 && Math.abs(Robot.getY() - pts[pts.length-1].getY()) < 80){
                break;
            }


            MathUtils.point a = pts[curLine];
            MathUtils.point b = pts[curLine + 1];

            List<Point2D> d2 =  MathUtilsPasted.intersection(new Point2D.Double(a.getX(), a.getY()), new Point2D.Double(b.getX(), b.getY()), new Point2D.Double(Robot.getX(), Robot.getY()), 100, true);
            int ind = 1;
            if(d2.size() == 1) ind =0;
            if(d2.size() != 0) {
                goalX = d2.get(ind).getX();
                goalY = d2.get(ind).getY();
            }


            MathUtils.toPoint(6);


            Robot.moveX();
            Robot.moveY();

            if(curLine + 2 < pts.length) {
                MathUtils.point c = pts[curLine + 2];
                List<Point2D> d22 = MathUtilsPasted.intersection(new Point2D.Double(b.getX(), b.getY()), new Point2D.Double(c.getX(), c.getY()), new Point2D.Double(Robot.getX(), Robot.getY()), 100, true);
                if (d22.size() != 0) {
                    curLine++;
                }
            }


            toDraw.add(new Point((int)Robot.getX(), (int)Robot.getY()));
            Thread.sleep(80);

        }
    }
}
