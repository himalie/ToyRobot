package test;

import main.Movable;
import main.Position;
import main.PositionValidator;
import main.ToyRobot;
import main.Direction;
import main.Turnable;
import main.Validatable;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class RobotInitializationTests {	
	private final Validatable _positionValidator;
	private final Movable _robotMover;
	private final Turnable _robotTurner;
	
	public RobotInitializationTests(){
		_positionValidator = mock(PositionValidator.class);
		_robotMover = mock(Movable.class);
		_robotTurner = mock(Turnable.class);
	}

	@Test
	public void ShouldValidatePositionOnInitialization() {			
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);
		Position position = new Position(1,2);
		
		robot.place(position, Direction.NORTH);
		verify(_positionValidator, atLeastOnce()).validate(position);		
	}
	@Test 
	public void ShouldNotBeInAPlaceIfNotPlaced() {
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);
		
		boolean isPlaced = robot.isPlaced();
		assertEquals(false, isPlaced);
	}
	@Test
	public void ShouldBeInAPlaceIfPlaced(){
			
		Position position = new Position(1,2);
		when(_positionValidator.validate(position))
			.thenReturn(true);
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);
		robot.place(position, Direction.NORTH);
		
		boolean isPlaced = robot.isPlaced();
		assertEquals(true, isPlaced);
	}
}
