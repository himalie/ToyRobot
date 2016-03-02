package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import main.Direction;
import main.Movable;
import main.Position;
import main.PositionValidator;
import main.ToyRobot;
import main.Turnable;
import main.Validatable;

import org.junit.Test;
 
public class RobotReportingTests {
	
	private final Validatable _positionValidator;
	private final Movable _robotMover;
	private final Turnable _robotTurner;
	
	public RobotReportingTests(){
		_positionValidator = mock(PositionValidator.class);
		_robotMover = mock(Movable.class);
		_robotTurner = mock(Turnable.class);
	}
	
	@Test
	public void ShouldReportCurrentPositionIfPositioned() {
		
		Position position = new Position(1,2);		
		
		when(_positionValidator.validate(position)).thenReturn(true);
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);
		robot.place(position, Direction.NORTH);
		
		when(robot.isPlaced()).thenReturn(true);
		String output = robot.report();
		
		assertEquals("1, 2, NORTH", output);
	}
	@Test
	public void ShouldNotReturnReportIfNotPlaced() {
		
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);		
		String _output = robot.report();
		
		assertEquals(null, _output);
	}

}
