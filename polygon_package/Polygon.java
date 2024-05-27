package polygon_package;

import java.util.ArrayList;
import java.util.List;
import shape_package.Shape;
import canvas_package.Canvas;

public class Polygon extends Shape {
    protected List<Pair<Integer, Integer>> points = new ArrayList<>();

    public void AddPoint(Pair<Integer, Integer> p) {
        points.add(p);
    }

    @Override
    public Pair<Integer, Integer> GetLeftMostPoint() {
        Pair<Integer, Integer> leftMost = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getFirst() < leftMost.getFirst()) {
                leftMost = points.get(i);
            }
        }
        return leftMost;
    }

    @Override
    public Pair<Integer, Integer> GetRightMostPoint() {
        Pair<Integer, Integer> rightMost = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getFirst() > rightMost.getFirst()) {
                rightMost = points.get(i);
            }
        }
        return rightMost;
    }

    @Override
    public Pair<Integer, Integer> GetTopMostPoint() {
        Pair<Integer, Integer> topMost = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getSecond() < topMost.getSecond()) {
                topMost = points.get(i);
            }
        }
        return topMost;
    }

    @Override
    public Pair<Integer, Integer> GetBottomMostPoint() {
        Pair<Integer, Integer> bottomMost = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i).getSecond() > bottomMost.getSecond()) {
                bottomMost = points.get(i);
            }
        }
        return bottomMost;
    }

    @Override
    public void Draw(Canvas c) {
        for (int i = 1; i < points.size(); i++)
            c.DrawLine(points.get(i - 1), points.get(i));
    }
}
