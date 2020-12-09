package mainPackage.geometry;

public class Point {
    private double[][] coordinates;
    private final double[][] startCoordinates;

    public Point(double x, double y, double z) {
        startCoordinates = new double[][]{{x, y, z, 1}};
        coordinates = startCoordinates;
    }

    public Point(double[][] coordinates) {
        this.coordinates = coordinates;
        this.startCoordinates = coordinates;
    }

    public Point(Point point) {
        coordinates = point.coordinates;
        startCoordinates = point.startCoordinates;
    }

    public void resetCoordinates() {
        coordinates = startCoordinates;
    }

    public double[][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][] coordinates) {
        this.coordinates = coordinates;
    }

    public void setX(double x) {
        coordinates[0][0] = x;
    }

    public void setY(double y) {
        coordinates[0][1] = y;
    }

    public void setZ(double z) {
        coordinates[0][2] = z;
    }

    public double getX() {
        return coordinates[0][0];
    }

    public double getY() {
        return coordinates[0][1];
    }

    public double getZ() {
        return coordinates[0][2];
    }

    public double getLast() {
        return coordinates[0][3];
    }
}
