package linear_algebra.plane;

import static linear_algebra.vector.Vector_Calculations.*;

import linear_algebra.line.Line;
import linear_algebra.vector.Vector;
import linear_algebra.vector.Vector_Calculations;

public class Plane_Calculations {

	public static boolean arePlanesParallel(Plane plane_1, Plane plane_2) {
		return Vector_Calculations.areVectorsParallel(plane_1.getNormal_vector(), plane_2.getNormal_vector());
	}

	public static boolean arePlanesCoincidental(Plane plane_1, Plane plane_2) {

		if (Vector_Calculations.areVectorsParallel(plane_1.getNormal_vector(), plane_2.getNormal_vector())) {

			Vector point_l1 = plane_1.calculatePoint(0.00, 0.00, null);
			Vector point_l2 = plane_2.calculatePoint(0.00, 1.00, null);

			Vector vector_connecting_two_planes = findVectorGivenTwoPoints(point_l1, point_l2);

			if (areVectorsOrthogonal(vector_connecting_two_planes, plane_1.getNormal_vector())
					&& areVectorsOrthogonal(vector_connecting_two_planes, plane_2.getNormal_vector())) {
				return true;
			}
		}
		return false;
	}

	public static Vector getDirectionVector(Line l) {
		Vector v = new Vector(new Double[] { 0.0, 0.0 });
		v.getCoordinates()[0] = l.getNormal_vector().getCoordinates()[1];
		v.getCoordinates()[1] = -l.getNormal_vector().getCoordinates()[0];
		v.getCoordinates()[2] = 0.0;

		return v;
	}
}
