package linear_algebra;

import linear_algebra.exceptions.*;

import static linear_algebra.Vector_Calculations.*;

public class Visual_Line_Checks {
	public void printLine(Line l) {
		System.out.println("Line : " + l.toString());
	}

	public void printAreLinesParallel(Line l1, Line l2) {
		System.out.println("Lines : " + l1.toString() + "  ,  " + l2 + "   parallel:   "
				+ Line_Calculations.areLinesParallel(l1, l2));
	}

	public void printAreLinesCoincidental(Line l1, Line l2) {
		System.out.println("Lines : " + l1.toString() + "  ,  " + l2 + "  coincidental:   "
				+ Line_Calculations.areLinesCoincidental(l1, l2));
	}

	public void printVectorOrthogonalComponent(Vector v1, Vector base) {
		System.out.println("Vector: " + v1.toString() + "  Base: " + base.toString()
				+ "  Orthogonal componentProjection:  " + findVectorComponentOrthogonalToBbaseUsingAddition(v1, base));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Visual_Line_Checks vc = new Visual_Line_Checks();

			Vector nv1 = new Vector(new double[] { 4.046, 2.836 });
			Vector nv2 = new Vector(new double[] { 10.115, 7.09 });

		

			Vector nv4 = new Vector(new double[] { 2, -1 });
			Vector nv5 = new Vector(new double[] { 4, -2 });

			Line l1 = new Line(nv4, 0);
			Line l2 = new Line(nv5, 0);

			vc.printLine(l1);
			vc.printLine(l2);

			vc.printAreLinesParallel(l1, l2);
			vc.printAreLinesCoincidental(l1, l2);
			 

		} catch (DiffernetDimentionsVectorException e) {
			e.printStackTrace();
		}
	}

}
