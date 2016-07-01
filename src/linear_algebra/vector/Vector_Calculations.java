package linear_algebra.vector;

import static linear_algebra.Settings.*;
import linear_algebra.exceptions.*;

public class Vector_Calculations {

	public static Vector addVectors(Vector v1, Vector v2)
			throws DiffernetDimentionsVectorException, NullPointerException {
		Vector resultVector;
		if (v1 != null && v2 != null) {
			if (v1.compareDimention(v2) == 0) {
				resultVector = new Vector(v1.getCoordinates().length);

				for (int i = 0; i < resultVector.getCoordinates().length; i++) {
					resultVector.getCoordinates()[i] = v1.getCoordinates()[i] + v2.getCoordinates()[i];
				}
			} else {
				throw new DiffernetDimentionsVectorException();
			}
		} else {
			throw new NullPointerException();
		}
		return resultVector;
	}

	public static Vector subtractVectors(Vector v1, Vector v2)
			throws DiffernetDimentionsVectorException, NullPointerException {
		Vector resultVector;
		if (v1 != null && v2 != null) {
			if (v1.compareDimention(v2) == 0) {
				resultVector = new Vector(v1.getCoordinates().length);

				for (int i = 0; i < resultVector.getCoordinates().length; i++) {
					resultVector.getCoordinates()[i] = v1.getCoordinates()[i] - v2.getCoordinates()[i];
				}
			} else {
				throw new DiffernetDimentionsVectorException();
			}
		} else {
			throw new NullPointerException();
		}
		return resultVector;
	}

	public static Vector multiplyVectorsByScalar(Vector v1, double scalar)
			throws DiffernetDimentionsVectorException, NullPointerException {
		Vector resultVector;
		if (v1 != null) {
			resultVector = new Vector(v1.getCoordinates().length);
			for (int i = 0; i < resultVector.getCoordinates().length; i++) {
				resultVector.getCoordinates()[i] = v1.getCoordinates()[i] * scalar;
			}
		} else {
			throw new NullPointerException();
		}
		return resultVector;
	}

	public static double calculateVectorMagnitude(Vector v) {
		double m = 0.00;
		if (v != null) {
			for (double d : v.getCoordinates()) {
				m += d * d;
			}
		} else {
			throw new NullPointerException();
		}
		return Math.sqrt(m);
	}

	public static Vector calculateUnitVector(Vector v) throws IllegalArgumentException {
		Vector u = null;

		if (v != null) {
			double magnitude = calculateVectorMagnitude(v);
			if (magnitude <= 0) {
				throw new IllegalArgumentException("Magnitude of vector is 0 vector can not be normalized");
			}
			u = multiplyVectorsByScalar(v, 1 / magnitude);
		} else {
			throw new NullPointerException();
		}
		return u;
	}

	public static double calculateInnerProduct(Vector v1, Vector v2) throws DiffernetDimentionsVectorException {
		double k = 0.00;
		if (v1 != null && v2 != null) {
			if (v1.getCoordinates().length != v2.getCoordinates().length) {
				throw new DiffernetDimentionsVectorException();
			}
			for (int i = 0; i < v1.getCoordinates().length; i++) {
				k += v1.getCoordinates()[i] * v2.getCoordinates()[i];
			}
		} else {
			throw new NullPointerException();
		}
		return k;
	}

	public static Vector calculateCrossProduct(Vector v1, Vector v2) throws DiffernetDimentionsVectorException {
		Vector cross = null;
		if (v1 != null && v2 != null) {
			if (v1.getCoordinates().length != v2.getCoordinates().length) {
				throw new DiffernetDimentionsVectorException();
			}
			if (v1.getCoordinates().length != 3) {
				throw new InaplicableDimentionsVectorException();
			}

			cross = new Vector(v1.getCoordinates().length);

			cross.getCoordinates()[0] = (v1.getCoordinates()[1] * v2.getCoordinates()[2])
					- ((v2.getCoordinates()[1] * v1.getCoordinates()[2]));

			cross.getCoordinates()[1] = -((v1.getCoordinates()[0] * v2.getCoordinates()[2])
					- ((v2.getCoordinates()[0] * v1.getCoordinates()[2])));

			cross.getCoordinates()[2] = (v1.getCoordinates()[0] * v2.getCoordinates()[1])
					- ((v2.getCoordinates()[0] * v1.getCoordinates()[1]));

		} else {
			throw new NullPointerException();
		}
		return cross;
	}

	public static double calculateVectorsAngle(Vector v1, Vector v2) throws DiffernetDimentionsVectorException {
		double dot = 0.00;
		double k = 0.00;
		double v1_mag = 0.00;
		double v2_mag = 0.00;
		if (v1 != null && v2 != null) {
			dot = calculateInnerProduct(v1, v2);
			v1_mag = calculateVectorMagnitude(v1);
			v2_mag = calculateVectorMagnitude(v2);

			k = dot / (v1_mag * v2_mag);
			k = Math.acos(k);

		} else {
			throw new NullPointerException();
		}
		return k;
	}

	public static boolean areVectorsParallel(Vector v1, Vector v2) {

		if (v1 != null && v2 != null) {
			if (v1.getCoordinates().length != v2.getCoordinates().length) {
				throw new DiffernetDimentionsVectorException();
			}
			if (calculateVectorMagnitude(v1) == 0 || calculateVectorMagnitude(v2) == 0) {
				return true;
			}

			if (checkParallelWithDotProductZeroAngle(v1, v2) == true && checkParallelWithUnitvector(v1, v2) == true) {
				return true;
			}
		} else {
			throw new NullPointerException();
		}
		return false;
	}

	public static boolean checkParallelWithDotProductZeroAngle(Vector v1, Vector v2) {

		if (v1 != null && v2 != null) {
			if (v1.getCoordinates().length != v2.getCoordinates().length) {
				throw new DiffernetDimentionsVectorException();
			}
			double dot_product = calculateInnerProduct(v1, v2);
			double v1_mag = calculateVectorMagnitude(v1);
			double v2_mag = calculateVectorMagnitude(v2);
			if (Math.abs(dot_product) - (v1_mag * v2_mag) < TOLERANCE) {
				return true;
			}
		} else {
			throw new NullPointerException();
		}
		return false;
	}

	public static boolean checkParallelWithUnitvector(Vector v1, Vector v2) {

		if (v1 != null && v2 != null) {
			if (v1.getCoordinates().length != v2.getCoordinates().length) {
				throw new DiffernetDimentionsVectorException();
			}
			Vector uv1 = calculateUnitVector(v1);
			Vector uv2 = calculateUnitVector(v2);
			Vector difference_vector_1 = subtractVectors(uv1, uv2);
			Vector difference_vector_2 = subtractVectors(uv1, multiplyVectorsByScalar(uv2, -1));

			for (int i = 0; i < difference_vector_1.getCoordinates().length; i++) {
				if (Math.abs(difference_vector_1.getCoordinates()[i]) > TOLERANCE
						&& Math.abs(difference_vector_2.getCoordinates()[i]) > TOLERANCE) {
					return false;
				}
			}
		} else {
			throw new NullPointerException();
		}
		return true;
	}

	public static boolean areVectorsOrthogonal(Vector v1, Vector v2) {
		if (v1 != null && v2 != null) {
			if (v1.getCoordinates().length != v2.getCoordinates().length) {
				throw new DiffernetDimentionsVectorException();
			}
			double dot_product = calculateInnerProduct(v1, v2);
			if (Math.abs(dot_product) < TOLERANCE) {
				return true;
			}
		} else {
			throw new NullPointerException();
		}
		return false;
	}

	public static Vector findVectorProjectionOnBaseU(Vector v1, Vector b) {
		Vector v_parallel = null;
		if (v1 != null && b != null) {
			if (v1.getCoordinates().length != b.getCoordinates().length) {
				throw new DiffernetDimentionsVectorException();
			}
			Vector b_unit_vector = calculateUnitVector(b);
			v_parallel = multiplyVectorsByScalar(b_unit_vector, calculateInnerProduct(v1, b_unit_vector));

		} else {
			throw new NullPointerException();
		}
		return v_parallel;
	}

	public static Vector findVectorComponentOrthogonalToBbaseUsingAddition(Vector v1, Vector b) {
		Vector orthogonalComponent = null;
		if (v1 != null && b != null) {
			if (v1.getCoordinates().length != b.getCoordinates().length) {
				throw new DiffernetDimentionsVectorException();
			}
			Vector parallel_component = findVectorProjectionOnBaseU(v1, b);
			orthogonalComponent = subtractVectors(v1, parallel_component);

		} else {
			throw new NullPointerException();
		}
		return orthogonalComponent;
	}

	public static Vector findVectorGivenTwoPoints(Vector point1, Vector point2)
			throws DiffernetDimentionsVectorException {
		Vector v = new Vector(point1.getCoordinates().length);

		if (point1.getCoordinates().length != point2.getCoordinates().length) {
			throw new DiffernetDimentionsVectorException();

		}

		for (int i = 0; i < v.getCoordinates().length; i++) {
			v.getCoordinates()[i] = point2.getCoordinates()[i] - point1.getCoordinates()[i];
		}

		return v;
	}

}
