package src;
import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testValidateInputFormat() {
		Validator.validateInputFormat("12345");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateMoreThanTwoParametersInputLenght() {
		String[] parameters = {"1", "234", "213"};
		Validator.validateParametersInputLenght(parameters);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidateLessThanTwoParametersInputLenght() {
		String[] parameters = {"1"};
		Validator.validateParametersInputLenght(parameters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateInputCharacterCase() {
		String[] parameters = {"a", "234"};
		Validator.validateInput(parameters);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidateInputNumberBetweenOneAndTenCase() {
		String[] parameters = {"-1", "234"};
		Validator.validateInput(parameters);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateInputCharacter() {
		Validator.validateInputCharacter('x');
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidateSpaceBetweenDigitsIsMoreThanFive() {
		Validator.validateSpaceBetweenDigits("6");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidateSpaceBetweenDigitsIsLessThanOne() {
		Validator.validateSpaceBetweenDigits("-3");
	}

	@Test
	public void testIsNumericPass() {
		boolean isNumeric = Validator.isNumeric("3");
		assertTrue(isNumeric);
	}
	
	@Test
	public void testIsNumericTrueFail() {
		boolean isNumeric = Validator.isNumeric("x");
		assertFalse(isNumeric);
	}
	
}
