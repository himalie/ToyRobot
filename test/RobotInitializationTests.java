package test;

import main.Board;
import main.Position;
import main.PositionValidator;
import main.ToyRobot;
import main.Direction;
import main.Validatable;
import static org.junit.Assert.*;

import org.junit.Test;

public class RobotInitializationTests {	

	private final Validatable _positionValidator;
	
	public RobotInitializationTests() {
		Board board = new Board(5,5);
		_positionValidator = new PositionValidator(board);
	}
	@Test
	public void ShouldValidatePositionOnInitialization() {			
		Position initialPosition= new Position(1,2);
		ToyRobot robot= new ToyRobot(_positionValidator);
		boolean isPlacedSuccesfully =robot.place(initialPosition,  Direction.NORTH);
		assertEquals(true, isPlacedSuccesfully);
		
	}
	
}
