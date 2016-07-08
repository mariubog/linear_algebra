package main.linear_algebra;

import main.linear_algebra.exceptions.*;
import main.linear_algebra.line.Line;
import main.linear_algebra.vector.Vector;

import static main.linear_algebra.line.Line_Calculations.*;
import static main.linear_algebra.vector.Vector_Calculations.*;

public class Visual_Line_Checks {
	public void printLine(Line l) {
		System.out.println("Line : " + l.toString());
	}

	public void printAreLinesParallel(Line l1, Line l2) {
		System.out.println("Lines : " + l1.toString() + "  ,  " + l2 + "   parallel:   " + areLinesParallel(l1, l2));
	}

	public void printAreLinesCoincidental(Line l1, Line l2) {
		System.out.println(
				"Lines : " + l1.toString() + "  ,  " + l2 + "  coincidental:   " + areLinesCoincidental(l1, l2));
	}

	public void printPointOfIntersection(Line l1, Line l2) {
		System.out.println(
				"Lines : " + l1.toString() + "  ,  " + l2 + "  intersection:   " + findLinesIntersection(l1, l2));
	}

	public void printVectorOrthogonalComponent(Vector v1, Vector base) {
		System.out.println("Vector: " + v1.toString() + "  Base: " + base.toString()
				+ "  Orthogonal componentProjection:  " + findVectorComponentOrthogonalToBbaseUsingAddition(v1, base));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Visual_Line_Checks vc = new Visual_Line_Checks();

			Line l1 = new Line(new Vector(new Double[] { 4.046, 2.836 }), 1.21);
			Line l2 = new Line(new Vector(new Double[] { 10.115, 7.09 }), 3.025);

			Line l3 = new Line(new Vector(new Double[] { 7.204, 3.182 }), 8.68);
			Line l4 = new Line(new Vector(new Double[] { 8.172, 4.114 }), 9.883);

			Line l5 = new Line(new Vector(new Double[] { 1.182, 5.562 }), 6.744);
			Line l6 = new Line(new Vector(new Double[] { 1.773, 8.343 }), 9.525);

			vc.printLine(l1);
			vc.printLine(l2);
			if (areLinesCoincidental(l1, l2)) {
				vc.printAreLinesCoincidental(l1, l2);
			} else {
				if (areLinesParallel(l1, l2)) {
					vc.printAreLinesParallel(l1, l2);
				} else {
					vc.printPointOfIntersection(l1, l2);
				}
			}

			System.out.println("");

			vc.printLine(l3);
			vc.printLine(l4);
			if (areLinesCoincidental(l3, l4)) {
				vc.printAreLinesCoincidental(l3, l4);
			} else {
				if (areLinesParallel(l3, l4)) {
					vc.printAreLinesParallel(l3, l4);
				} else {
					vc.printPointOfIntersection(l3, l4);
				}
			}

			System.out.println("");

			vc.printLine(l5);
			vc.printLine(l6);
			if (areLinesCoincidental(l5, l6)) {
				vc.printAreLinesCoincidental(l5, l6);
			} else {
				if (areLinesParallel(l5, l6)) {
					vc.printAreLinesParallel(l5, l6);
				} else {
					vc.printPointOfIntersection(l5, l6);
				}
			}
			System.out.println("");

			// Vector nv4 = new Vector(new double[] { 2, -1 });
			// Vector nv5 = new Vector(new double[] { 4, -2 });
			//
			// Line l1 = new Line(nv4, 0);
			// Line l2 = new Line(nv5, 0);
			//
			// vc.printLine(l1);
			// vc.printLine(l2);
			//
			// vc.printAreLinesParallel(l1, l2);
			// vc.printAreLinesCoincidental(l1, l2);

		} catch (DiffernetDimentionsVectorException e) {
			e.printStackTrace();
		}
	}

}
