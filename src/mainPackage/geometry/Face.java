package mainPackage.geometry;

import java.awt.*;

public class Face {
    private final Point[] points;
    private Edge[] edges;

    public Face(Point... points) {
        this.points = points;
    }

    public Face(Face f) {
        Point[] vert = f.getPoints();
        Edge[] edg = f.getEdges();
        points = new Point[vert.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(vert[i]);
        }
        edges = new Edge[edg.length];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge(edg[i]);
        }
    }

    public void drawFace(Graphics2D graphics2D) {
        for (Edge edge : edges) {
            edge.drawEdge(graphics2D);
        }
    }

    public void drawEdges(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(2));
        graphics2D.setColor(Color.BLACK);
        for (Edge edge : edges) {
            edge.drawEdge(graphics2D);
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }
}
