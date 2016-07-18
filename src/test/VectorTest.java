package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.linear_algebra.vector.Vector;
import static main.linear_algebra.vector.Vector_Calculations.*;

public class VectorTest {

	Vector v1 = new Vector(new Double[] { 1.0, 1.0, 2.0 });
	Vector v2 = new Vector(new Double[] { -1.0, -1.0, 1.0 });
	Vector v3 = new Vector(new Double[] { -1.0, -1.0, 1.0 });

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void evaluateAdding() {
		Vector expected = new Vector(new Double[] { 0.0, 0.0, 3.0 });
		assertTrue(expected.equals(addVectors(v1, v2)));
	}

	@Test
	public void evaluateSubtracting() {
		Vector expected = new Vector(new Double[] { 2.0, 2.0, 1.0 });
		assertTrue(expected.equals(subtractVectors(v1, v2)));
	}

	@Test
	public void evaluateMultiplyVectorsByScalar() {
		Vector expected = new Vector(new Double[] { 2.0, 2.0, 4.0 });
		assertTrue(expected.equals(multiplyVectorsByScalar(v1, 2)));
	}

	@Test
	public void evaluateCalculateVectorMagnitude() {
		Double expected = Math.sqrt(1 + 1 + 2 * 2);
		assertTrue(expected.equals(calculateVectorMagnitude(v1)));
	}

	@Test
	public void evaluateCalculateUnitVector() {
		Vector expected = new Vector(new Double[] { 1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6), 2.0 / Math.sqrt(6) });
		assertTrue(expected.equals(calculateUnitVector(v1)));
	}

	@Test
	public void evaluateCalculateInnerProduct() {
		Double expected = 1.0 * -1.0 + 1.0 * -1.0 + 2.0 * 1.0;
		assertTrue(expected.equals(calculateInnerProduct(v1, v2)));
	}

	@Test
	public void evaluateCalculateCrossProduct() {
		Vector expected = new Vector(
				new Double[] { 1.0 * 1.0 - 2.0 * -1.0, -(1.0 * 1.0 - 2.0 * -1.0), 1.0 * -1.0 - 1.0 * -1.0 });
		assertTrue(expected.equals(calculateCrossProduct(v1, v2)));
	}

	@Test
	public void evaluateCalculateVectorsAngle() {
		Vector v4 = new Vector(new Double[] { 1.0, 0.0, 0.0 });
		Vector v5 = new Vector(new Double[] { 0.0, 1.0, 0.0 });
		Double expected = Math.toRadians(90.00);
		assertTrue(expected.equals(calculateVectorsAngle(v4, v5)));
	}

	@Test
	public void evaluateAreVectorsParallel() {
		Vector v6 = new Vector(new Double[] { 1.0, 0.0, 0.0 });
		Vector v7 = new Vector(new Double[] { -1.0, 0.0, 0.0 });
		Vector v8 = new Vector(new Double[] { 1.0, 1.0, 0.0 });

		assertTrue(areVectorsParallel(v6, v7));
		assertFalse(areVectorsParallel(v6, v8));
	}

	@Test
	public void evaluateAreVectorsOrthogonal() {
		Vector v6 = new Vector(new Double[] { 1.0, 0.0, 0.0 });
		Vector v7 = new Vector(new Double[] { 0.0, 1.0, 0.0 });
		Vector v8 = new Vector(new Double[] { 1.0, 1.0, 0.0 });
		Vector v9 = new Vector(new Double[] { 0.0, 0.0, 1.0 });

		assertTrue(areVectorsOrthogonal(v6, v7));
		assertTrue(areVectorsOrthogonal(v6, v9));
		assertFalse(areVectorsOrthogonal(v6, v8));
	}

	@Test
	public void evaluateVectorProjectionOnBaseU() {
		Vector v6 = new Vector(new Double[] { 2.0, 1.0, 0.0 });
		Vector b7 = new Vector(new Double[] { 4.0, 0.0, 0.0 });
		Vector v9 = new Vector(new Double[] { 2.0, 0.0, 0.0 });

		assertTrue(findVectorProjectionOnBaseU(v6, b7).equals(v9));
	}

	@Test
	public void evaluateFindVectorComponentOrthogonalToBbaseUsingAddition() {
		Vector v6 = new Vector(new Double[] { 2.0, 1.0, 0.0 });
		Vector b7 = new Vector(new Double[] { 4.0, 0.0, 0.0 });
		Vector v9 = new Vector(new Double[] { 0.0, 1.0, 0.0 });

		assertTrue(findVectorComponentOrthogonalToBbaseUsingAddition(v6, b7).equals(v9));
	}

}
