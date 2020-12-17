package mainPackage.figures;

import mainPackage.geometry.Face;
import mainPackage.geometry.Operations;
import mainPackage.geometry.Point;

import java.awt.*;

public abstract class Figure {
    protected Face[] faces;
    protected Point[] points;
    private Point center;

    public Figure(Point... points) {
        this.points = points;
        center = new Point(-10,-10,0);
        buildFaces();
        buildEdges();
    }

    public abstract void buildEdges();

    public abstract void buildFaces();


    public void drawFigure(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(2));
        //TODO: Запилить нормальную проверку
        if (faces == null) {
            System.out.println("Null");
            return;
        }
        for (Face face : faces) {
            face.drawFace(graphics2D);
        }
    }

    public void rotate(double angleX, double angleY, double angleZ) {
        for (Point point : points) {
            Operations.rotate(point, angleX, angleY, angleZ);
        }
    }

    public void transit(double dx, double dy, double dz) {
        for (Point point : points) {
            Operations.transit(point, dx, dy, dz);
        }
    }

    public void scale(double sx, double sy, double sz) {
        for (Point point : points) {
            Operations.scale(point, sx, sy, sz);
        }
    }

    public void axonometric(double psi, double fi) {
        for (Point point : points) {
            Operations.axonometric(point, psi, fi);
        }
    }

    public void oblique(double l, double ro) {
        for (Point point : points) {
            Operations.oblique(point, l, ro);
        }
    }

    public void reset() {
        for (Point point : points) {
            point.resetCoordinates();
        }
        center.resetCoordinates();
    }

    public Face[] getFaces() {
        return faces;
    }

    public void setFaces(Face[] faces) {
        this.faces = faces;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }
}
