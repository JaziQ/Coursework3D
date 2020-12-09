package mainPackage.geometry;

import mainPackage.Main;

import java.awt.*;

public class Edge {
    private Point p1;
    private Point p2;

    public Edge(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Edge(Edge edge) {
        this.p1 = new Point(edge.getP1());
        this.p2 = new Point(edge.getP2());
    }

    public double getX1() {
        return  p1.getCoordinates()[0][0];
    }
    public double getX2() {
        return  p2.getCoordinates()[0][0];
    }

    public double getY1() {
        return  p1.getCoordinates()[0][1];
    }
    public double getY2() {
        return  p2.getCoordinates()[0][1];
    }

    public double getZ1() {
        return  p1.getCoordinates()[0][2];
    }
    public double getZ2() {
        return  p2.getCoordinates()[0][2];
    }

    public Point getP1() {
        return p1;
    }
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void drawEdge(Graphics2D graphics2D) {
        graphics2D.drawLine((int) p1.getX() + Main.getMainFrame().getWidth() / 2,
                -(int) p1.getY() + Main.getMainFrame().getHeight() / 2,
                (int) p2.getX() + Main.getMainFrame().getWidth() / 2,
                -(int) p2.getY()  + Main.getMainFrame().getHeight() / 2);
    }
}
