package main.linear_algebra.plane;

import lombok.Getter;
import main.linear_algebra.vector.Vector;

public class Plane {

	@Getter
	private Vector normal_vector;
	// @Getter
	// private Vector basepoint;
	@Getter
	private double constant;

	double coeficient_x1;
	double coeficient_x2;
	double coeficient_x3;

	public Plane(Vector normal_vector, double constant) {
		this.normal_vector = normal_vector;
		this.constant = constant;

		if (normal_vector == null) {
			this.normal_vector = new Vector(new Double[] { 0.0, 0.0, 0.0 });
		}
		coeficient_x1 = normal_vector.getCoordinates()[0];
		coeficient_x2 = normal_vector.getCoordinates()[1];
		coeficient_x3 = normal_vector.getCoordinates()[2];
		// calculateBasepoint();
	}

	// private void calculateBasepoint() {
	// basepoint = new Vector(new double[] { 0, 0 });
	// if (coeficient_x2 != 0) {
	// basepoint.getCoordinates()[1] = constant / coeficient_x2;
	//
	// } else if (coeficient_x1 != 0) {
	// basepoint.getCoordinates()[0] = constant / coeficient_x1;
	// }
	// }

	public Vector calculatePoint(Double x1, Double x2, Double x3) {
		// System.out.println("s constat: " + constant);
		// System.out.println("s coeficient_x1: " + coeficient_x1);
		// System.out.println("s coeficient_x2: " + coeficient_x2);

		if (x2 == null && coeficient_x2 != 0 && x1 != null && x3 != null) {
			x2 = (constant - (coeficient_x1 * x1) - (coeficient_x3 * x3)) / coeficient_x2;
		} else if (x1 == null && coeficient_x1 != 0 && x2 != null && x3 != null) {
			x1 = (constant - (coeficient_x2 * x2) - (coeficient_x3 * x3)) / coeficient_x1;
		} else if (x3 == null && coeficient_x3 != 0 && x1 != null && x2 != null) {
			x3 = (constant - (coeficient_x2 * x2) - (coeficient_x1 * x1)) / coeficient_x3;
		}
		return new Vector(new Double[] { x1, x2, x3 });
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Plane) {
			Plane p = (Plane) o;
			if (p.getConstant() != this.constant) {
				return false;
			}
			if (!p.getNormal_vector().equals(this.normal_vector)) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for (double c : normal_vector.getCoordinates()) {
			if (c >= 0) {
				sb.append("+" + c + " x" + i + " ");
			} else {
				sb.append(+c + " x" + i + " ");
			}
			i++;
		}
		sb.append("= ").append(constant);
		return sb.toString();
	}
}
