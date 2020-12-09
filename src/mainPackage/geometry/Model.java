package mainPackage.geometry;

import mainPackage.figures.Cone;
import mainPackage.figures.Figure;
import mainPackage.figures.Parallelepiped;

import java.awt.*;

public class Model {
    private final Figure[] figures;

    public Model(double a, double b, double c, double dy, double dz, double h, double r, int approximation) {
        Parallelepiped parallelepiped = new Parallelepiped(
                new Point(0, 0, 0),
                new Point(0, c, 0),
                new Point(0, c, b),
                new Point(a, c, b),
                new Point(a, 0, b),
                new Point(a, 0, 0),
                new Point(a, c, 0),
                new Point(0, 0, b)
        );

       Point[] vertices = new Point[approximation + 1];

        for (int i = 0; i < approximation; i++) {
            double y = (r * Math.cos(i * (2 * Math.PI / approximation))) + dy;
            double z = (r * Math.sin(i * (2 * Math.PI / approximation))) + dz;
            vertices[i] = new Point(a, y, z);
        }

        vertices[approximation] = new Point(a+h, dy, dz);

        figures = new Figure[]{
                parallelepiped , new Cone(vertices)
        };
    }

    public void drawModel(Graphics2D graphics2D) {
        for (Figure figure: figures) {
            figure.drawFigure(graphics2D);
        }
    }

    public Figure[] getFigures(){ return figures; }
}
