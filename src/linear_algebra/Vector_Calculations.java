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

	public void printVector(Vector v) {
		System.out.println("Vector : " + v.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Vector_Calculations vc = new Vector_Calculations();
			Vector v1 = new Vector(new double[] { 8.218, -9.341 });
			Vector v2 = new Vector(new double[] { -1.129, 2.111 });

			Vector v3 = new Vector(new double[] { 7.119, 8.215 });
			Vector v4 = new Vector(new double[] { -8.223, 0.878 });

			Vector v5 = new Vector(new double[] { 1.671, -1.012, -0.318 });
			double scalar = 7.41;

			// vc.comparePrintVectors(v1, v2);
			// vc.comparePrintVectors(v1, v3);
			// vc.comparePrintVectors(v1, v4);

			vc.addPrintVectors(v1, v2);
			System.out.println("");
			vc.subtractPrintVectors(v3, v4);
			System.out.println("");
			vc.multiplyByScalarPrintVectors(v5, scalar);

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

	public void multiplyByScalarPrintVectors(Vector v1, double scalar) throws DiffernetDimentionsVectorException {
		System.out.println("Multiply By Scalart vectors:" + v1.toString() + " * " + scalar + "  =  "
				+ multiplyVectorsByScalar(v1, scalar));
	}

}
