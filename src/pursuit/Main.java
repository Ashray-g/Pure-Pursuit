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
    public static MathUtils.point[] pts = new MathUtils.point[100];
    public static int ptsN = 0;

    public static void main(String[] args) throws IOException, InterruptedException, NoninvertibleTransformException {
//        pts = new MathUtils.point[]{new MathUtils.point(10, 10),
//                new MathUtils.point(300, 400),
//                new MathUtils.point(500, 400),
//                new MathUtils.point(700, 100),
//                new MathUtils.point(900, 500),
//                new MathUtils.point(100, 600)};
//
//        pts = new MathUtils.point[]{new MathUtils.point(10, 10),
//                new MathUtils.point(700, 100),
//                new MathUtils.point(700, 600),
//                new MathUtils.point(10, 600)};

        pts = new MathUtils.point[]{ //lightspeed circuit
                new MathUtils.point(201,283),
                new MathUtils.point(223,242),
                new MathUtils.point(263,178),
                new MathUtils.point(322,151),
                new MathUtils.point(377,150),
                new MathUtils.point(404,160),
                new MathUtils.point(482,282),
                new MathUtils.point(561,307),
                new MathUtils.point(644,307),
                new MathUtils.point(724,252),
                new MathUtils.point(798,149),
                new MathUtils.point(811,147),
                new MathUtils.point(834,155),
                new MathUtils.point(885,224),
                new MathUtils.point(952,402),
                new MathUtils.point(882,470),
                new MathUtils.point(724,454),
                new MathUtils.point(562,462),
                new MathUtils.point(523,450),
                new MathUtils.point(488,415),
                new MathUtils.point(472,375),
                new MathUtils.point(433,342),
                new MathUtils.point(390,325),
                new MathUtils.point(346,325),
                new MathUtils.point(314,329),
                new MathUtils.point(261,349),
                new MathUtils.point(224,380),
                new MathUtils.point(207,418),
                new MathUtils.point(204,447)};

        ptsN = 28;
        FX.init();

        Robot.setXVelocity(0);
        Robot.setYVelocity(0);

        Thread.sleep(2000);


        int curLine = 0;

        while(true){

            if(Math.abs(Robot.getX() - pts[pts.length-1].getX()) < 30 && Math.abs(Robot.getY() - pts[pts.length-1].getY()) < 30){
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
//                    curLine %=27;
                }
            }


            toDraw.add(new Point((int)Robot.getX(), (int)Robot.getY()));
            Thread.sleep(70);

        }
    }
}
