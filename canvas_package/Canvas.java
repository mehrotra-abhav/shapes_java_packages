package canvas_package;

import java.util.ArrayList;
import java.util.List;
import canvas_package.VectorGraphicsCanvas;
import shape_package.Shape;

public class Canvas extends VectorGraphicsCanvas {
    private List<Shape> shapes = new ArrayList<>();

    public void DrawLine(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
        // Custom logic here
        super.DrawLine(p1, p2);
    }

    public void AddShape(Shape shape) {
        this.shapes.add(shape);
        this.Paint();
    }

    public void Paint() {
        for (Shape shape : this.shapes) {
            shape.Draw(this);
        }
    }

    // Returns the Old and New Z-orders of the shape
    public Pair<Integer, Integer> BringForward(Shape shape) {
        Pair<Integer, Integer> z = new Pair<>(0, 0);

        // Logic to bring front and update old, new Z orders
        // Does shape overlap with any other shape?
        for (int i = 0; i < this.shapes.size(); i++) {
            if (!this.shapes.get(i).equals(shape)) {
                // Is to the left of the shape
                Pair<Integer, Integer> rightMost = this.shapes.get(i).GetRightMostPoint();
                Pair<Integer, Integer> leftMost = shape.GetLeftMostPoint();
                if (rightMost.getFirst() > leftMost.getFirst()) {
                    // Overlapping
                    z = new Pair<>(shape.ZOrder, Math.max(shape.ZOrder, this.shapes.get(i).ZOrder + 1));
                }

                // Is to the right of the shape
                Pair<Integer, Integer> leftMost2 = this.shapes.get(i).GetLeftMostPoint();
                Pair<Integer, Integer> rightMost2 = shape.GetRightMostPoint();
                if (leftMost2.getFirst() < rightMost2.getFirst()) {
                    // Overlapping
                    z = new Pair<>(shape.ZOrder, Math.max(shape.ZOrder, this.shapes.get(i).ZOrder + 1));
                }

                // Is above the shape
                Pair<Integer, Integer> bottomMost = this.shapes.get(i).GetBottomMostPoint();
                Pair<Integer, Integer> topMost = shape.GetTopMostPoint();
                if (bottomMost.getSecond() > topMost.getSecond()) {
                    // Overlapping
                    z = new Pair<>(shape.ZOrder, Math.max(shape.ZOrder, this.shapes.get(i).ZOrder + 1));
                }

                // Is below the shape
                Pair<Integer, Integer> topMost2 = this.shapes.get(i).GetTopMostPoint();
                Pair<Integer, Integer> bottomMost2 = shape.GetBottomMostPoint();
                if (topMost2.getSecond() < bottomMost2.getSecond()) {
                    // Overlapping
                    z = new Pair<>(shape.ZOrder, Math.max(shape.ZOrder, this.shapes.get(i).ZOrder + 1));
                }
            }
        }

        return z;
    }
}
