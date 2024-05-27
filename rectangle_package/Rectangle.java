package rectangle_package;

import java.util.Arrays;
import polygon_package.Polygon;

public class Rectangle extends Polygon {
    private Pair<Integer, Integer> topLeft;
    private Pair<Integer, Integer> bottomRight;

    public Rectangle(Pair<Integer, Integer> topLeft, Pair<Integer, Integer> bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        super.AddPoint(new Pair<Integer, Integer> (topLeft.getFirst(), topLeft.getSecond()));
        super.AddPoint(new Pair<Integer, Integer> (topLeft.getFirst(), bottomRight.getSecond()));
        super.AddPoint(new Pair<Integer, Integer> (bottomRight.getFirst(), bottomRight.getSecond()));
        super.AddPoint(new Pair<Integer, Integer> (bottomRight.getFirst(), topLeft.getSecond()));
    }
}
