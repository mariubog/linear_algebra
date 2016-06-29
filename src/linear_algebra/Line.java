package linear_algebra;

import lombok.Getter;

public class Line {

	@Getter
	private Vector normal_vector;
	@Getter
	private Vector basepoint;
	@Getter
	private double constant;

	double coeficient_x1;
	double coeficient_x2;

	public Line(Vector normal_vector, double constant) {
		this.normal_vector = normal_vector;
		this.constant = constant;

		if (normal_vector == null) {
			this.normal_vector = new Vector(new double[] { 0, 0 });
		}
		coeficient_x1 = normal_vector.getCoordinates()[0];
		coeficient_x2 = normal_vector.getCoordinates()[1];
		calculateBasepoint();
	}

	private void calculateBasepoint() {
		basepoint = new Vector(new double[] { 0, 0 });
		if (coeficient_x2 != 0) {
			basepoint.getCoordinates()[1] = constant / coeficient_x2;

		} else if (coeficient_x1 != 0) {
			basepoint.getCoordinates()[0] = constant / coeficient_x1;
		}
	}

	public Vector calculatePoint(Double x1, Double x2) {
//		System.out.println("s constat: " + constant);
//		System.out.println("s coeficient_x1: " + coeficient_x1);
//		System.out.println("s coeficient_x2: " + coeficient_x2);

		if (x2 == null && coeficient_x2 != 0) {
			x2 = (constant - (coeficient_x1 * x1)) / coeficient_x2;
		} else if (x1 == null && coeficient_x1 != 0) {
			x1 = (constant - (coeficient_x2 * x2)) / coeficient_x1;
		}
		return new Vector(new double[] { x1, x2 });
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Line) {
			Line l = (Line) o;
			if (l.getConstant() != this.constant) {
				return false;
			}
			if (!l.getNormal_vector().equals(this.normal_vector)) {
				return false;
			}

		}
		return true;
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
