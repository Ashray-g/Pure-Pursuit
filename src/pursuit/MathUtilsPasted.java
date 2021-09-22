package pursuit;

import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class MathUtilsPasted {
    /**
     * Formulas taken from stackoverflow
     */
    public static List<Point2D> intersection(Point2D p1, Point2D p2, Point2D center,
                                             double radius, boolean isSegment) throws NoninvertibleTransformException, NoninvertibleTransformException {
        List<Point2D> result = new ArrayList<>();
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        AffineTransform trans = AffineTransform.getRotateInstance(dx, dy);
        trans.invert();
        trans.translate(-center.getX(), -center.getY());
        Point2D p1a = trans.transform(p1, null);
        Point2D p2a = trans.transform(p2, null);
        double y = p1a.getY();
        double minX = Math.min(p1a.getX(), p2a.getX());
        double maxX = Math.max(p1a.getX(), p2a.getX());
        if (y == radius || y == -radius) {
            if (!isSegment || (0 <= maxX && 0 >= minX)) {
                p1a.setLocation(0, y);
                trans.inverseTransform(p1a, p1a);
                result.add(p1a);
            }
        } else if (y < radius && y > -radius) {
            double x = Math.sqrt(radius * radius - y * y);
            if (!isSegment || (-x <= maxX && -x >= minX)) {
                p1a.setLocation(-x, y);
                trans.inverseTransform(p1a, p1a);
                result.add(p1a);
            }
            if (!isSegment || (x <= maxX && x >= minX)) {
                p2a.setLocation(x, y);
                trans.inverseTransform(p2a, p2a);
                result.add(p2a);
            }
        }
        return result;
    }
}
