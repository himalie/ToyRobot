package test;

import static org.junit.Assert.*;

import main.Board;
import main.Direction;
import main.Position;
import main.PositionValidator;
import main.ToyRobot;
import main.Validatable;

import org.junit.Test;
 
public class RobotReportingTests {
	
	private final Validatable _positionValidator;
	
	public RobotReportingTests(){
		Board board = new Board(5,5);
		_positionValidator = new PositionValidator(board);
	}
	
	@Test
	public void ShouldReportCurrentPositionIfPositioned() {
		
		ToyRobot robot = new ToyRobot(_positionValidator);
		
		Position defaultPosition = new Position(1,2);
		robot.place(defaultPosition, Direction.NORTH);
		String _output = robot.report();
		
		assertEquals("1, 2, NORTH", _output);
	}
	@Test
	public void ShouldNotReturnReportIfNotPlaced() {
		
		ToyRobot robot = new ToyRobot(_positionValidator);		
		String _output = robot.report();
		
		assertEquals(null, _output);
	}

}
