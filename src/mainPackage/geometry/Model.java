package mainPackage.geometry;

import mainPackage.figures.Cone;
import mainPackage.figures.Figure;
import mainPackage.figures.Parallelepiped;
import mainPackage.window.interfaces.Projections;
import mainPackage.window.operationPanel.ObliquePanel;

import java.awt.*;

public class Model implements Projections {
    private final Figure[] figures;
    private int projection = NO;
    private double l;
    private double fi;
    private double psi;
    private double ro;
    private double teta;
    private double d;

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

        vertices[approximation] = new Point(a + h, dy, dz);

        figures = new Figure[]{
                parallelepiped, new Cone(vertices)
        };
    }

    public void drawModel(Graphics2D graphics2D) {
        Figure[] figures1 = new Figure[]{figures[0].getCopy(), figures[1].getCopy()};
        switch (projection) {
            case AXONOMETRIC:
                for (Figure figure : figures1) {
                    Operations.axonometric(figure, l, ro);
                    figure.drawFigure(graphics2D, projection);
                }
                break;
            case OBLIQUE:
                for (Figure figure : figures1) {
                    Operations.oblique(figure, psi, fi);
                    figure.drawFigure(graphics2D, projection);
                }
                break;
            case PERSPECTIVE:
                for (Figure figure : figures1) {
                    Operations.perspective(figure, d, ro, fi, teta);
                    figure.drawFigure(graphics2D, projection);
                }
                break;

            /*case FRONTAL:
                for (Figure figure : figures1) {
                    figure.drawFigure(graphics2D);
                }
                break;
            case HORIZONTAL:
                for (Figure figure : figures1) {
                    figure.drawFigure(graphics2D);
                }
                break;
            case PROFILE:
                for (Figure figure : figures1) {

                    figure.drawFigure(graphics2D);
                }
                break;*/
            default:
                for (Figure figure : figures) {
                    figure.drawFigure(graphics2D, projection);
                }
                break;
        }
    }

    public Figure[] getFigures() {
        return figures;
    }

    public void setProjection(int projection) {
        this.projection = projection;
    }

    public void setAxonometric(double l, double ro) {
        this.l = l;
        this.ro = ro;
    }

    public void setOblique(double psi, double fi){
        this.psi = psi;
        this.fi = fi;
    }

    public void setPerspective(double d, double ro, double fi, double teta) {
        this.d = d;
        this.ro = ro;
        this.fi = fi;
        this.teta = teta;
    }
}
