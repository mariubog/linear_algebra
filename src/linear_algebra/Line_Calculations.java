package linear_algebra;

import static linear_algebra.Vector_Calculations.*;

public class Line_Calculations {

	public static final double TOLERANCE = 1e-4;

	public static boolean areLinesParallel(Line line_1, Line line_2) {
		return Vector_Calculations.areVectorsParallel(line_1.getNormal_vector(), line_2.getNormal_vector());
	}

	public static boolean areLinesCoincidental(Line line_1, Line line_2) {

		if (Vector_Calculations.areVectorsParallel(line_1.getNormal_vector(), line_2.getNormal_vector())) {

			Vector point_l1 = line_1.calculatePoint(1.00, null);
			Vector point_l2 = line_2.calculatePoint(2.00, null);

			Line l = calculateLineInteresectingTwoPoints2D(point_l1, point_l2);

			if (areVectorsOrthogonal(getDirectionVector(l), line_1.getNormal_vector())
					&& areVectorsOrthogonal(getDirectionVector(l), line_2.getNormal_vector())) {
				return true;
			}
		}
		return false;
	}

	public static Line calculateLineInteresectingTwoPoints2D(Vector point1, Vector point2) {

		double coeficient_x1;
		double coeficient_x2;

		coeficient_x1 = (point2.getCoordinates()[1] - point1.getCoordinates()[1])
				/ (point2.getCoordinates()[0] - point1.getCoordinates()[0]);

		coeficient_x2 = 1;

		double constant = point1.getCoordinates()[1] - (coeficient_x1 * point1.getCoordinates()[0]);

		Vector normal_vector = new Vector(new double[] { -coeficient_x1, coeficient_x2 });

		// System.out.println("coef x1: " + coeficient_x1);
		// System.out.println("coef x2: " + coeficient_x2);
		// System.out.println("coord 1: " + point1.getCoordinates()[1]);
		// System.out.println("conns: " + constant);

		return new Line(normal_vector, constant);
	}

	public static Vector getDirectionVector(Line l) {
		Vector v = new Vector(new double[] { 0, 0 });

		v.getCoordinates()[0] = l.getNormal_vector().getCoordinates()[1];
		v.getCoordinates()[1] = -l.getNormal_vector().getCoordinates()[0];

		return v;
	}
}
