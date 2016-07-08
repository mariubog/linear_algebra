package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.linear_algebra.system_equations.LinearSystem;
import main.linear_algebra.system_equations.LinearSystem.Equation;
import main.linear_algebra.vector.Vector;

public class LinearSystemTest {

	Equation e1 = new Equation(new Vector(new Double[] { 1.0, 1.0, 1.0 }), 1.0);
	Equation e2 = new Equation(new Vector(new Double[] { 0.0, 1.0, 0.0 }), 2.0);
	Equation e3 = new Equation(new Vector(new Double[] { 1.0, 1.0, -1.0 }), 3.0);
	Equation e4 = new Equation(new Vector(new Double[] { 1.0, 0.0, -2.0 }), 4.0);

	LinearSystem oryginalSystem;

	@Before
	public void setUp() {
		oryginalSystem = new LinearSystem(3);
		oryginalSystem.addEquation(e1);
		oryginalSystem.addEquation(e2);
		oryginalSystem.addEquation(e3);
		oryginalSystem.addEquation(e4);
	}

	@After
	public void tearDown() {
		oryginalSystem = null;
	}

	@Test
	public void evaluateSwap() {

		LinearSystem expected = new LinearSystem(3);
		expected.addEquation(e2);
		expected.addEquation(e1);
		expected.addEquation(e3);
		expected.addEquation(e4);
		oryginalSystem.swapRows(1, 2);
		assertTrue(expected.equals(oryginalSystem));
	}

	@Test
	public void evaluateMultiplyCoeficientAndRow() {
		Equation expected = new Equation(new Vector(new Double[] { -1.0, -1.0, -1.0 }), -1.0);
		oryginalSystem.multiplyRowPermanent(1, -1);
		assertTrue(expected.equals(oryginalSystem.getRow(1)));
	}

	@Test
	public void evaluateAddMultipliedRowToRow() {
	
		Equation expected1 = new Equation(new Vector(new Double[] { 2.0, 3.0, 2.0 }), 4.00);
		Equation expected2 = new Equation(new Vector(new Double[] { 3.0, 3.0, 1.0 }), 5.00);

		oryginalSystem.addMultipliedRowToRow(1, 2, 2);
		assertTrue(expected1.equals(oryginalSystem.getRow(2)));
		
		oryginalSystem.addMultipliedRowToRow(1, 2, 3);
		assertTrue(expected2.equals(oryginalSystem.getRow(3)));

	}

}
