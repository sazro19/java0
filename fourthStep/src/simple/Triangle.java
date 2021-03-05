package simple;

public class Triangle {

    private final double A;

    private final double B;

    private final double C;

    private final double[][] points;

    public Triangle(double[][] points) {
        if (points.length != 3) {
            throw new IllegalArgumentException("Invalid points number");
        } else {
            if (points[0].length != 2 || points[1].length != 2 || points[2].length != 2) {
                throw new IllegalArgumentException("Invalid coordinates");
            } else {
                this.points = points;
                A = Math.sqrt(Math.pow(points[1][0] - points[0][0], 2) + Math.pow(points[1][1] - points[0][1], 2));
                B = Math.sqrt(Math.pow(points[2][0] - points[1][0], 2) + Math.pow(points[2][1] - points[1][1], 2));
                C = Math.sqrt(Math.pow(points[2][0] - points[0][0], 2) + Math.pow(points[2][1] - points[0][1], 2));
                if (!checkValidTriangle()) {
                    throw new IllegalArgumentException("Invalid sides");
                }
            }
        }
    }

    public double perimeter() {
        return A + B + C;
    }

    public double area() {
        return Math.sqrt((perimeter() / 2) * (perimeter() / 2 - A) * (perimeter() / 2 - B) * (perimeter() / 2 - C));
    }

    public double[] coordinatesOfMediansIntersection() {
        double[] middle = new double[]{(points[1][0] + points[2][0]) / 2, (points[1][1] + points[2][1]) / 2};
        return new double[]{(1 * points[0][0] + 2 * middle[0]) / 3, (1 * points[0][1] + 2 * middle[1]) / 3};
    }

    private boolean checkValidTriangle() {
        return (A < B + C) && (B < A + C) && (C < A + B);
    }
}
