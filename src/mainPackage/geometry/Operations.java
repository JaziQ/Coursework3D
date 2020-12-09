package mainPackage.geometry;

import java.awt.image.BandCombineOp;

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

    public static double fromAngleToRadians(double angle){
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
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if (m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {         // rows from m1
            for (int j = 0; j < mRColLength; j++) {     // columns from m2
                for (int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
}
