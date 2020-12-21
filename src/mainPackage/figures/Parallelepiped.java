package mainPackage.figures;

import mainPackage.geometry.Edge;
import mainPackage.geometry.Face;
import mainPackage.geometry.Point;

public class Parallelepiped extends Figure {
    //private Face[] faces;
    //private Vertex[] vertices;
    private Point center;

    public Parallelepiped(Point... vertices) {
        super(vertices);
    }

    @Override
    public void buildEdges() {
        faces[0].setEdges(new Edge[]{
                new Edge(points[0], points[1]),
                new Edge(points[1], points[2]),
                new Edge(points[2], points[7]),
                new Edge(points[7], points[0])
        });
        faces[1].setEdges(new Edge[]{
                new Edge(points[1], points[2]),
                new Edge(points[2], points[3]),
                new Edge(points[3], points[6]),
                new Edge(points[6], points[1])
        });
        faces[2].setEdges(new Edge[]{
                new Edge(points[7], points[2]),
                new Edge(points[2], points[3]),
                new Edge(points[3], points[4]),
                new Edge(points[4], points[7])
        });
        faces[3].setEdges(new Edge[]{
                new Edge(points[4], points[3]),
                new Edge(points[3], points[6]),
                new Edge(points[6], points[5]),
                new Edge(points[5], points[4])
        });
        faces[4].setEdges(new Edge[]{
                new Edge(points[5], points[6]),
                new Edge(points[6], points[1]),
                new Edge(points[1], points[0]),
                new Edge(points[0], points[5])
        });
        faces[5].setEdges(new Edge[]{
                new Edge(points[0], points[7]),
                new Edge(points[7], points[4]),
                new Edge(points[4], points[5]),
                new Edge(points[5], points[0])
        });
    }

    @Override
    public void buildFaces() {
        faces = new Face[]{
                new Face(points[0], points[1], points[2], points[7]),
                new Face(points[1], points[2], points[3], points[6]),
                new Face(points[7], points[2], points[3], points[4]),
                new Face(points[4], points[3], points[6], points[5]),
                new Face(points[5], points[6], points[1], points[0]),
                new Face(points[0], points[7], points[4], points[5])
        };
    }

    @Override
    public Figure getCopy() {
        return new Parallelepiped(getPoints());
    }
}
