package linear_algebra;

import linear_algebra.Vector.DiffernetDimentionsVectorException;

public class Vector_Calculations {

	public Vector addVectors(Vector v1, Vector v2) throws DiffernetDimentionsVectorException, NullPointerException {
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

	public Vector subtractVectors(Vector v1, Vector v2)
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

	public Vector multiplyVectorsByScalar(Vector v1, double scalar)
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

	public double calculateVectorMagnitude(Vector v) {
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

	public Vector calculateUnitVector(Vector v) throws IllegalArgumentException {
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

	public double calculateInnerProduct(Vector v1, Vector v2) throws DiffernetDimentionsVectorException {
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

	public double calculateVectorsAngle(Vector v1, Vector v2) throws DiffernetDimentionsVectorException {
		double dot = 0.00;
		double k = 0.00;
		double v1_mag = 0.00;
		double v2_mag = 0.00;
		if (v1 != null && v2 != null) {
			dot = calculateInnerProduct(v1, v2);

	//		System.out.println("dot : " + dot);

			v1_mag = calculateVectorMagnitude(v1);
			v2_mag = calculateVectorMagnitude(v2);

			double mag_prod = (v1_mag * v2_mag);

		//	System.out.println("mag_prod : " + mag_prod);

			k = dot / (v1_mag * v2_mag);

	//		System.out.println("K : " + k);

			k = Math.acos(k);

	//		System.out.println("K : " + k);

		} else {
			throw new NullPointerException();
		}
		return k;
	}

	public void printVector(Vector v) {
		System.out.println("Vector : " + v.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Vector_Calculations vc = new Vector_Calculations();
//			Vector v1 = new Vector(new double[] { 8.218, -9.341 });
//			Vector v2 = new Vector(new double[] { -1.129, 2.111 });
//
//			Vector v3 = new Vector(new double[] { 7.119, 8.215 });
//			Vector v4 = new Vector(new double[] { -8.223, 0.878 });
//
//			Vector v5 = new Vector(new double[] { 1.671, -1.012, -0.318 });
//			double scalar = 7.41;
//
//			// vc.comparePrintVectors(v1, v2);
//			// vc.comparePrintVectors(v1, v3);
//			// vc.comparePrintVectors(v1, v4);
//
//			vc.addPrintVectors(v1, v2);
//			System.out.println("");
//			vc.subtractPrintVectors(v3, v4);
//			System.out.println("");
//			vc.multiplyByScalarPrintVectors(v5, scalar);
//			System.out.println("");
//
//			Vector v6 = new Vector(new double[] { -1, 1, 1 });
//			vc.printVectorMagnitude(v6);
//			System.out.println("");
//			vc.printUnitVector(v6);
//			System.out.println("");
//			vc.multiplyByScalarPrintVectors(vc.calculateUnitVector(v6), vc.calculateVectorMagnitude(v6));
//			System.out.println("");
//
//			Vector v7 = new Vector(new double[] { -0.221, 7.437 });
//			Vector v8 = new Vector(new double[] { 8.813, -1.331, -6.247 });
//			Vector v9 = new Vector(new double[] { 5.581, -2.136 });
//			Vector v10 = new Vector(new double[] { 1.996, 3.108, -4.554 });
//
//			vc.printVectorMagnitude(v7);
//			System.out.println("");
//			vc.printVectorMagnitude(v8);
//			System.out.println("");
//			vc.printUnitVector(v9);
//			System.out.println("");
//			vc.printUnitVector(v10);
//			System.out.println("");

			Vector v11 = new Vector(new double[] { 7.887, 4.138 });
			Vector v12 = new Vector(new double[] { -8.802, 6.776 });
			Vector v13 = new Vector(new double[] { -5.955, -4.904, -1.874 });
			Vector v14 = new Vector(new double[] { -4.496, -8.755, 7.103 });
			Vector v15 = new Vector(new double[] { 3.183, -7.627 });
			Vector v16 = new Vector(new double[] { -2.668, 5.319 });
			Vector v17 = new Vector(new double[] { 7.35, 0.221, 5.188 });
			Vector v18 = new Vector(new double[] { 2.751, 8.259, 3.985 });

			vc.printVectorInnerProduct(v11, v12);
			System.out.println("");
			vc.printVectorInnerProduct(v13, v14);
			System.out.println("");
			
			vc.printVectorsAngleInRadians(v15, v16);
			System.out.println("");
			vc.printVectorsAngleInDegrees(v17, v18);
			System.out.println("");

		} catch (DiffernetDimentionsVectorException e) {
			e.printStackTrace();
		}
	}

	public void comparePrintVectors(Vector v1, Vector v2) throws DiffernetDimentionsVectorException {
		System.out.println("Compare vectors:" + v1.toString() + " to " + v2.toString() + "  -->  " + v1.equals(v2));
	}

	public void addPrintVectors(Vector v1, Vector v2) throws DiffernetDimentionsVectorException {
		System.out.println("Add vectors:" + v1.toString() + " + " + v2.toString() + "  =  " + addVectors(v1, v2));
	}

	public void subtractPrintVectors(Vector v1, Vector v2) throws DiffernetDimentionsVectorException {
		System.out.println(
				"Subtract vectors:" + v1.toString() + " - " + v2.toString() + "  =  " + subtractVectors(v1, v2));
	}

	public void multiplyByScalarPrintVectors(Vector v1, double scalar) {
		System.out.println("Multiply By Scalart vectors:" + v1.toString() + " * " + scalar + "  =  "
				+ multiplyVectorsByScalar(v1, scalar));
	}

	public void printVectorMagnitude(Vector v) {
		System.out.println("Vector  :" + v.toString() + " -->   Vector magnitude: " + calculateVectorMagnitude(v));
	}

	public void printUnitVector(Vector v) {
		System.out.println("Vector  :" + v.toString() + " -->  Unit vector: " + calculateUnitVector(v));
	}

	public void printVectorInnerProduct(Vector v1, Vector v2) {
		System.out.println("Inner Product vectors:" + v1.toString() + " dot " + v2.toString() + "  =  "
				+ calculateInnerProduct(v1, v2));
	}

	public void printVectorsAngle(Vector v1, Vector v2) {
		System.out.println(
				"Vectors angle:" + v1.toString() + " and " + v2.toString() + "  =  " + calculateVectorsAngle(v1, v2));
	}

	public void printVectorsAngleInRadians(Vector v1, Vector v2) {
		System.out.println("Vectors angle rad:" + v1.toString() + " + " + v2.toString() + "  =  "
				+ Math.toRadians(Math.toDegrees(calculateVectorsAngle(v1, v2))));
	}

	public void printVectorsAngleInDegrees(Vector v1, Vector v2) {
		System.out.println("Vectors angle deg:" + v1.toString() + " + " + v2.toString() + "  =  "
				+ Math.toDegrees(calculateVectorsAngle(v1, v2)));
	}

}
