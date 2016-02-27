package test;

import static org.junit.Assert.*;

import main.Board;
import main.Position;
import main.PositionValidator;
import main.Validatable;

import org.junit.Test;

public class PositionValidationTests {
	private final Validatable _positionValidator;
	
	public PositionValidationTests() {
		Board board = new Board(5,5);
		_positionValidator = new PositionValidator(board);
	}

	@Test
	public void ShouldReturnFalseOnNegativePosition() {
		Position invalidPosition = new Position(0, -1);
		boolean result = _positionValidator.validate(invalidPosition);
		assertEquals(false, result);
	}
	
	@Test
	public void ShouldReturnFalseOnOutOfBoardPosition() {
		Position invalidPosition = new Position(0, 5);
		boolean result = _positionValidator.validate(invalidPosition);
		assertEquals(false, result);
	}
	
	@Test
	public void ShouldReturnTrueForInBoardPosition() {
		Position inBoardPosition = new Position(0, 4);
		boolean result = _positionValidator.validate(inBoardPosition);
		assertEquals(true, result);
	}
}
