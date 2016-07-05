package linear_algebra;

import static linear_algebra.vector.Vector_Calculations.*;

import linear_algebra.exceptions.*;
import linear_algebra.vector.Vector;

public class Visual_Vector_Checks {
	public void printVector(Vector v) {
		System.out.println("Vector : " + v.toString());
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

	public void printVectorCrossProduct(Vector v1, Vector v2) {
		System.out.println("Cross Product vectors:" + v1.toString() + " X " + v2.toString() + "  =  "
				+ calculateCrossProduct(v1, v2));
	}

	public void printCrossParallelogramArea(Vector v1, Vector v2) {
		System.out.println("Parallelogram for vectors:" + v1.toString() + " and " + v2.toString() + "  =  "
				+ calculateVectorMagnitude(calculateCrossProduct(v1, v2)));
	}

	public void printCrossTriangle(Vector v1, Vector v2) {
		System.out.println("Triangle for vectors:" + v1.toString() + " and " + v2.toString() + "  =  "
				+ calculateVectorMagnitude(calculateCrossProduct(v1, v2)) / 2);
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

	public void printVectorsParallelnesCheck(Vector v1, Vector v2) {
		System.out.println(
				"Vectors parallel : " + v1.toString() + " + " + v2.toString() + "  ?  " + areVectorsParallel(v1, v2));
	}

	public void printVectorsOrthogonalnessCheck(Vector v1, Vector v2) {
		System.out.println("Vectors orthogonal : " + v1.toString() + " + " + v2.toString() + "  ?  "
				+ areVectorsOrthogonal(v1, v2));
	}

	public void printVectorParallelProjection(Vector v1, Vector base) {
		System.out.println("Vector: " + v1.toString() + "  Base: " + base.toString() + "  Parallel Projection:  "
				+ findVectorProjectionOnBaseU(v1, base));
	}

	public void printVectorOrthogonalComponent(Vector v1, Vector base) {
		System.out.println("Vector: " + v1.toString() + "  Base: " + base.toString()
				+ "  Orthogonal componentProjection:  " + findVectorComponentOrthogonalToBbaseUsingAddition(v1, base));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Visual_Vector_Checks vc = new Visual_Vector_Checks();
			// Vector v1 = new Vector(new double[] { 8.218, -9.341 });
			// Vector v2 = new Vector(new double[] { -1.129, 2.111 });
			//
			// Vector v3 = new Vector(new double[] { 7.119, 8.215 });
			// Vector v4 = new Vector(new double[] { -8.223, 0.878 });
			//
			// Vector v5 = new Vector(new double[] { 1.671, -1.012, -0.318 });
			// double scalar = 7.41;
			//
			// // vc.comparePrintVectors(v1, v2);
			// // vc.comparePrintVectors(v1, v3);
			// // vc.comparePrintVectors(v1, v4);
			//
			// vc.addPrintVectors(v1, v2);
			// System.out.println("");
			// vc.subtractPrintVectors(v3, v4);
			// System.out.println("");
			// vc.multiplyByScalarPrintVectors(v5, scalar);
			// System.out.println("");
			//
			// Vector v6 = new Vector(new double[] { -1, 1, 1 });
			// vc.printVectorMagnitude(v6);
			// System.out.println("");
			// vc.printUnitVector(v6);
			// System.out.println("");
			// vc.multiplyByScalarPrintVectors(vc.calculateUnitVector(v6),
			// vc.calculateVectorMagnitude(v6));
			// System.out.println("");
			//
			// Vector v7 = new Vector(new double[] { -0.221, 7.437 });
			// Vector v8 = new Vector(new double[] { 8.813, -1.331, -6.247 });
			// Vector v9 = new Vector(new double[] { 1, 0 });
			// Vector v10 = new Vector(new double[] { 1.996, 3.108, -4.554 });
			//
			// vc.printVectorMagnitude(v7);
			// System.out.println("");
			// vc.printVectorMagnitude(v8);
			// System.out.println("");
			// vc.printUnitVector(v8);
			// System.out.println("");
			// vc.printUnitVector(v10);
			// System.out.println("");
			//
			// Vector v11 = new Vector(new double[] { 7.887, 4.138 });
			// Vector v12 = new Vector(new double[] { -8.802, 6.776 });
			// Vector v13 = new Vector(new double[] { -5.955, -4.904, -1.874 });
			// Vector v14 = new Vector(new double[] { -4.496, -8.755, 7.103 });
			// Vector v15 = new Vector(new double[] { 3.183, -7.627 });
			// Vector v16 = new Vector(new double[] { -2.668, 5.319 });
			// Vector v17 = new Vector(new double[] { 7.35, 0.221, 5.188 });
			// Vector v18 = new Vector(new double[] { 2.751, 8.259, 3.985 });
			//
			// vc.printVectorInnerProduct(v11, v12);
			// System.out.println("");
			// vc.printVectorInnerProduct(v13, v14);
			// System.out.println("");
			//
			// vc.printVectorsAngleInRadians(v15, v16);
			// System.out.println("");
			// vc.printVectorsAngleInDegrees(v17, v18);
			// System.out.println("");

			// Vector v1 = new Vector(new double[] { -7.579, -7.88 });
			// Vector v2 = new Vector(new double[] { 22.737, 23.64 });
			// Vector v3 = new Vector(new double[] { -2.029, 9.97, 4.172 });
			// Vector v4 = new Vector(new double[] { -9.231, -6.639, -7.245 });
			// Vector v5 = new Vector(new double[] { -2.328, -7.284, -1.214 });
			// Vector v6 = new Vector(new double[] { -1.821, 1.072, -2.94 });
			// Vector v7 = new Vector(new double[] { 2.118, 4.827 });
			// Vector v8 = new Vector(new double[] { 0, 0 });
			//
			// vc.printVectorsAngleInDegrees(v1, v2);
			// vc.printVectorsParallelnesCheck(v1, v2);
			// vc.printVectorsOrthogonalnessCheck(v1, v2);
			// System.out.println("");
			// vc.printVectorsAngleInDegrees(v3, v4);
			// vc.printVectorsParallelnesCheck(v3, v4);
			// vc.printVectorsOrthogonalnessCheck(v3, v4);
			// System.out.println("");
			// vc.printVectorsAngleInDegrees(v5, v6);
			// vc.printVectorsParallelnesCheck(v5, v6);
			// vc.printVectorsOrthogonalnessCheck(v5, v6);
			// System.out.println("");
			// vc.printVectorsAngleInDegrees(v7, v8);
			// vc.printVectorsParallelnesCheck(v7, v8);
			// vc.printVectorsOrthogonalnessCheck(v7, v8);
			// System.out.println("");

			// Vector v1 = new Vector(new double[] { 3.039, 1.879 });
			// Vector v2 = new Vector(new double[] { 0.825, 2.036 });
			//
			// Vector v3 = new Vector(new double[] { -9.88, -3.264, -8.159 });
			// Vector v4 = new Vector(new double[] { -2.155, -9.353, -9.473 });
			//
			// Vector v5 = new Vector(new double[] { 3.009, -6.172, 3.692, -2.51
			// });
			// Vector v6 = new Vector(new double[] { 6.404, -9.144, 2.759, 8.718
			// });
			//
			// vc.printVectorParallelProjection(v1, v2);
			// System.out.println("");
			// vc.printVectorOrthogonalComponent(v3, v4);
			// System.out.println("");
			// vc.printVectorParallelProjection(v5, v6);
			// vc.printVectorOrthogonalComponent(v5, v6);

			Vector v1 = new Vector(new Double[] { 8.462, 7.893, -8.187 });
			Vector v2 = new Vector(new Double[] { 6.984, -5.975, 4.778 });
			Vector v3 = new Vector(new Double[] { -8.987, -9.838, 5.031 });
			Vector v4 = new Vector(new Double[] { -4.268, -1.861, -8.866 });
			Vector v5 = new Vector(new Double[] { 1.5, 9.547, 3.691 });
			Vector v6 = new Vector(new Double[] { -6.007, 0.124, 5.772 });

			vc.printVectorCrossProduct(v1, v2);
			vc.printCrossParallelogramArea(v3, v4);

			vc.printCrossTriangle(v5, v6);

			// vc.printVectorMagnitude(v1);
			// vc.printVectorMagnitude(v2);
			// vc.printVectorInnerProduct(v1, v2);
			// vc.printVectorsAngleInDegrees(v1, v2);
			// vc.printVectorsAngleInDegrees(v2, v1);

			// vc.printVectorMagnitude(v3);
			vc.printVectorCrossProduct(v1, v2);
			System.out.println("X \u2082");

		} catch (DiffernetDimentionsVectorException e) {
			e.printStackTrace();
		}
	}

}
