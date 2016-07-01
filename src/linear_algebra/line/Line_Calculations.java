package linear_algebra.line;

import static linear_algebra.vector.Vector_Calculations.*;

import linear_algebra.vector.Vector;
import linear_algebra.vector.Vector_Calculations;

public class Line_Calculations {

	
	public static boolean areLinesParallel(Line line_1, Line line_2) {
		return Vector_Calculations.areVectorsParallel(line_1.getNormal_vector(), line_2.getNormal_vector());
	}

	public static boolean areLinesCoincidental(Line line_1, Line line_2) {

		if (Vector_Calculations.areVectorsParallel(line_1.getNormal_vector(), line_2.getNormal_vector())) {

			Vector point_l1 = line_1.calculatePoint(0.00, null);
			Vector point_l2 = line_2.calculatePoint(1.00, null);

			Vector vector_connecting_two_lines = findVectorGivenTwoPoints(point_l1, point_l2);

			if (areVectorsOrthogonal(vector_connecting_two_lines, line_1.getNormal_vector())
					&& areVectorsOrthogonal(vector_connecting_two_lines, line_2.getNormal_vector())) {
				return true;
			}
		}
		return false;
	}

	public static Vector findLinesIntersection(Line line_1, Line line_2) {
		Vector intersection = null;

		if (Vector_Calculations.areVectorsParallel(line_1.getNormal_vector(), line_2.getNormal_vector())) {
			return null;
		}
		double x = (line_2.getNormal_vector().getCoordinates()[1] * line_1.getConstant()
				- line_1.getNormal_vector().getCoordinates()[1] * line_2.getConstant())
				/ (line_1.getNormal_vector().getCoordinates()[0] * line_2.getNormal_vector().getCoordinates()[1]
						- line_1.getNormal_vector().getCoordinates()[1]
								* line_2.getNormal_vector().getCoordinates()[0]);
		double y =

				(-line_2.getNormal_vector().getCoordinates()[0] * line_1.getConstant()
						+ line_1.getNormal_vector().getCoordinates()[0] * line_2.getConstant())
						/ (line_1.getNormal_vector().getCoordinates()[0] * line_2.getNormal_vector().getCoordinates()[1]
								- line_1.getNormal_vector().getCoordinates()[1]
										* line_2.getNormal_vector().getCoordinates()[0]);

		intersection = new Vector(new double[] { x, y });
		return intersection;
	}

//	public static Vector findVectorGivenTwoPoints(Vector point1, Vector point2) {
//		Vector v = new Vector(new double[] { 0, 0 });
//		v.getCoordinates()[0] = point2.getCoordinates()[0] - point1.getCoordinates()[0];
//		v.getCoordinates()[1] = point2.getCoordinates()[1] - point1.getCoordinates()[1];
//		return v;
//	}

	public static Line findLineInteresectingTwoPoints2D(Vector point1, Vector point2) {

		double coeficient_x1;
		double coeficient_x2;

		coeficient_x1 = (point2.getCoordinates()[1] - point1.getCoordinates()[1])
				/ (point2.getCoordinates()[0] - point1.getCoordinates()[0]);

		coeficient_x2 = 1;
		double constant = point1.getCoordinates()[1] - (coeficient_x1 * point1.getCoordinates()[0]);
		Vector normal_vector = new Vector(new double[] { -coeficient_x1, coeficient_x2 });
		return new Line(normal_vector, constant);
	}

	public static Vector getDirectionVector(Line l) {
		Vector v = new Vector(new double[] { 0, 0 });
		v.getCoordinates()[0] = l.getNormal_vector().getCoordinates()[1];
		v.getCoordinates()[1] = -l.getNormal_vector().getCoordinates()[0];
		return v;
	}
}
