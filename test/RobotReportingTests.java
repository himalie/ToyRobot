package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import main.Direction;
import main.Position;
import main.PositionValidator;
import main.ToyRobot;
import main.Validatable;

import org.junit.Test;
 
public class RobotReportingTests {
	
	private final Validatable _positionValidator;
	
	public RobotReportingTests(){
		_positionValidator = mock(PositionValidator.class);
	}
	
	@Test
	public void ShouldReportCurrentPositionIfPositioned() {
		
		Position position = new Position(1,2);		
		
		when(_positionValidator.validate(position)).thenReturn(true);
		ToyRobot robot = new ToyRobot(_positionValidator);
		robot.place(position, Direction.NORTH);
		
		when(robot.isPlaced()).thenReturn(true);
		String output = robot.report();
		
		assertEquals("1, 2, NORTH", output);
	}
	@Test
	public void ShouldNotReturnReportIfNotPlaced() {
		
		ToyRobot robot = new ToyRobot(_positionValidator);		
		String _output = robot.report();
		
		assertEquals(null, _output);
	}

}
