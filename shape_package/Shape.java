package shape_package;

import Canvases.Canvas;

public abstract class Shape {
    private int ZOrder;

    public int getZOrder() {
        return ZOrder;
    }

    public void setZOrder(int ZOrder) {
        this.ZOrder = ZOrder;
    }

    public abstract void Draw(Canvas c);

    public abstract Pair<Integer, Integer> GetLeftMostPoint();
    public abstract Pair<Integer, Integer> GetRightMostPoint();
    public abstract Pair<Integer, Integer> GetTopMostPoint();
    public abstract Pair<Integer, Integer> GetBottomMostPoint();
}
