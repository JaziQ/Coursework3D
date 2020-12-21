package mainPackage.geometry;

import mainPackage.figures.Figure;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Operations {
    public static void transit(Point point, double dx, double dy, double dz) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createTransitMatr(dx, dy, dz)));
    }

    public static void scale(Point point, double sx, double sy, double sz) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createScaleMatr(sx, sy, sz)));
    }

    public static void rotate(Point point, double angleX, double angleY, double angleZ) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createRotateMatr(angleX, angleY, angleZ)));
    }

    public static void oblique(Figure figure, double l, double a) {
        for (Point point : figure.getPoints()) {
            point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createObliqueMatr(l, a)));
        }
    }

    public static void axonometric(Figure figure, double psi, double fi) {
        for (Point point : figure.getPoints()) {
            point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createAxonometricMatr(psi, fi)));
        }
    }

    public static void perspective(Figure figure, double d, double ro, double fi, double teta) {
        for (Point point : figure.getPoints()) {
            point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createViewMatr(ro, fi, teta)));
            point.setCoordinates(new double[][]{{-point.getY(), point.getX(), point.getZ(), 1}});
            if ((point.getZ() >= 0) && (point.getZ() < 0.1)) {
                point.setZ(0.1);
            }
            if ((point.getZ() < 0) && (point.getZ() > -0.1)) {
                point.setZ(-0.1);
            }
            point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createPerspectiveMatr(d)));
            point.setCoordinates(new double[][]{{point.getX() / point.getLast(), point.getY() / point.getLast(),
                    point.getZ() / point.getLast(), 1}});
        }
    }

    private static double[][] createObliqueMatr(double l, double a) {
        return new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {l * cos(a), l * sin(a), 1, 0},
                {0, 0, 0, 1}};
    }

    private static double[][] createAxonometricMatr(double psi, double fi) {
        psi = fromAngleToRadians(psi);
        fi = fromAngleToRadians(fi);
        return new double[][]{
                {cos(psi), sin(fi) * sin(psi), 0, 0},
                {0, cos(fi), 0, 0},
                {sin(psi), -sin(fi) * cos(psi), 1, 0},
                {0, 0, 0, 1}};
    }

    private static double[][] createTransitMatr(double dx, double dy, double dz) {
        return new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {dx, dy, dz, 1}};
    }

    private static double[][] createScaleMatr(double sx, double sy, double sz) {
        return new double[][]{
                {sx, 0, 0, 0},
                {0, sy, 0, 0},
                {0, 0, sz, 0},
                {0, 0, 0, 1}};
    }


    private static double[][] createViewMatr(double ro, double fi, double teta) {
        return new double[][]{
                {-sin(teta), -cos(fi) * cos(teta), -sin(fi) * cos(teta), 0},
                {cos(teta), -cos(fi) * sin(teta), -sin(fi) * sin(teta), 0},
                {0, sin(fi), cos(fi), 0},
                {0, 0, ro, 1}};
    }

    private static double[][] createPerspectiveMatr(double d) {
        return new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1 / d},
                {0, 0, 0, 0}};
    }

    public static double fromAngleToRadians(double angle) {
        return Math.toRadians(angle);
    }

    private static double[][] createRotateMatr(double angleX, double angleY, double angleZ) {
        angleX = fromAngleToRadians(angleX);
        angleY = fromAngleToRadians(angleY);
        angleZ = fromAngleToRadians(angleZ);
        double[][] ROx = {
                {1.0, 0, 0, 0},
                {0, Math.cos(angleX), Math.sin(angleX), 0},
                {0, -Math.sin(angleX), Math.cos(angleX), 0},
                {0, 0, 0, 1.0}};
        double[][] ROy = {
                {Math.cos(angleY), 0, -Math.sin(angleY), 0},
                {0, 1.0, 0, 0},
                {Math.sin(angleY), 0, Math.cos(angleY), 0},
                {0, 0, 0, 1.0}};
        double[][] ROz = {
                {Math.cos(angleZ), Math.sin(angleZ), 0, 0},
                {-Math.sin(angleZ), Math.cos(angleZ), 0, 0},
                {0, 0, 1.0, 0},
                {0, 0, 0, 1.0}};
        double[][] R = multiplyByMatrix(ROx, ROy);
        R = multiplyByMatrix(R, ROz);
        return R;
    }

    private static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;
        if (m1ColLength != m2RowLength) return null;
        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {
            for (int j = 0; j < mRColLength; j++) {
                for (int k = 0; k < m1ColLength; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
}
