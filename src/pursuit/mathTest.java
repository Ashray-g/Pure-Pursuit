package pursuit;

import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.List;

public class mathTest {
    public static void main(String[] args) throws NoninvertibleTransformException {
        MathUtils.point a = new MathUtils.point(0, 0);
        MathUtils.point b = new MathUtils.point(100, 200);

        MathUtils.point c = new MathUtils.point(50, 50);

//        MathUtils.point f = MathUtils.circleLine2(a, b, 40);
        List<Point2D> f = MathUtilsPasted.intersection(new Point2D.Double(0, 0), new Point2D.Double(100, 200), new Point2D.Double(50, 50), 40, false);
//        System.out.println(f.getX()+c.getX() + " "+(f.getY()+c.getY()));
        System.out.println(f.get(0).getX() + " "+(f.get(0).getY()));
    }
}
