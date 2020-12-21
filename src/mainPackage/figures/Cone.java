package mainPackage.figures;

import mainPackage.geometry.Edge;
import mainPackage.geometry.Face;
import mainPackage.geometry.Point;

public class Cone extends Figure {
    public Cone(Point... points) {
        super(points);
    }

    @Override
    public void buildEdges() {
        int length = getPoints().length - 1;

        for (int i = 0; i < length; i++) {
            if (i == length - 1){
                faces[i].setEdges(new Edge[]{
                        new Edge(points[i], points[0]),
                        new Edge(points[0], points[length]),
                        new Edge(points[length], points[i])
                });
            }else{
            faces[i].setEdges(new Edge[]{
                    new Edge(points[i], points[i + 1]),
                    new Edge(points[i + 1], points[length]),
                    new Edge(points[length], points[i])
            });
            }
        }
    }

    @Override
    public void buildFaces() {
        int length = getPoints().length - 1;

        faces = new Face[length];
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                faces[i] = new Face(points[i], points[0], points[length]);
            } else {
                faces[i] = new Face(points[i], points[i + 1], points[length]);
            }
        }
    }

    @Override
    public Figure getCopy() {
        return new Cone(getPoints());
    }
}
