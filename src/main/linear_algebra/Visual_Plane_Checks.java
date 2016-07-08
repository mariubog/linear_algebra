package main.linear_algebra;

import static main.linear_algebra.plane.Plane_Calculations.*;

import main.linear_algebra.exceptions.*;
import main.linear_algebra.plane.Plane;
import main.linear_algebra.vector.Vector;

public class Visual_Plane_Checks {
	public void printLine(Plane p) {
		System.out.println("Plane : " + p.toString());
	}

	public void printArePlanesParallel(Plane p1, Plane p2) {
		System.out.println("Planes : " + p1.toString() + "  ,  " + p2 + "   parallel:   " + arePlanesParallel(p1, p2));
	}

	public void printArePlanesCoincidental(Plane l1, Plane l2) {
		System.out.println(
				"Lines : " + l1.toString() + "  ,  " + l2 + "  coincidental:   " + arePlanesCoincidental(l1, l2));
	}

	// public void printPointOfIntersection(Plane l1, Plane l2) {
	// System.out.println(
	// "Lines : " + l1.toString() + " , " + l2 + " intersection: " +
	// findLinesIntersection(l1, l2));
	// }

	// public void printVectorOrthogonalComponent(Vector v1, Vector base) {
	// System.out.println("Vector: " + v1.toString() + " Base: " +
	// base.toString()
	// + " Orthogonal componentProjection: " +
	// findVectorComponentOrthogonalToBbaseUsingAddition(v1, base));
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Visual_Plane_Checks vc = new Visual_Plane_Checks();

			Plane l1 = new Plane(new Vector(new Double[] { -0.412, 3.806, 0.728 }), -3.46);
			Plane l2 = new Plane(new Vector(new Double[] { 1.03, -9.515, -1.82 }), 8.65);

			Plane l3 = new Plane(new Vector(new Double[] { 2.611, 5.528, 0.283 }), 4.6);
			Plane l4 = new Plane(new Vector(new Double[] { 7.715, 8.306, 5.342 }), 3.76);

			Plane l5 = new Plane(new Vector(new Double[] { -7.926, 8.625, -7.217 }), -7.952);
			Plane l6 = new Plane(new Vector(new Double[] { -2.642, 2.875, -2.404 }), -2.443);

			vc.printLine(l1);
			vc.printLine(l2);
			if (arePlanesCoincidental(l1, l2)) {
				vc.printArePlanesCoincidental(l1, l2);
			} else {
				if (arePlanesParallel(l1, l2)) {
					vc.printArePlanesParallel(l1, l2);
				} else {
					// vc.printPointOfIntersection(l1, l2);
				}
			}

			System.out.println("");

			vc.printLine(l3);
			vc.printLine(l4);
			if (arePlanesCoincidental(l3, l4)) {
				vc.printArePlanesCoincidental(l3, l4);
			} else {
				if (arePlanesParallel(l3, l4)) {
					vc.printArePlanesParallel(l3, l4);
				} else {
					// vc.printPointOfIntersection(l3, l4);
				}
			}

			System.out.println("");

			vc.printLine(l5);
			vc.printLine(l6);
			if (arePlanesCoincidental(l5, l6)) {
				vc.printArePlanesCoincidental(l5, l6);
			} else {
				if (arePlanesParallel(l5, l6)) {
					vc.printArePlanesParallel(l5, l6);
				} else {
					// vc.printPointOfIntersection(l5, l6);
				}
			}
			System.out.println("");

		} catch (DiffernetDimentionsVectorException e) {
			e.printStackTrace();
		}
	}
}
