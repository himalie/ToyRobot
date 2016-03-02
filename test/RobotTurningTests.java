package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import main.Direction;
import main.Movable;
import main.Position;
import main.PositionValidator;
import main.ToyRobot;
import main.Turnable;
import main.Validatable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RobotTurningTests {	

	private Direction expectedDirectionTurnedLeft;
	private Direction expectedDirectionTurnedRight;
	private Direction inputDirection;
	private final Validatable _positionValidator;
	private final Turnable _robotTurner;
	private final Movable _robotMover;
	
	public RobotTurningTests(Direction expectedDirectionTurnedLeft, Direction expectedDirectionTurnedRight, Direction inputDirection) {
		this.expectedDirectionTurnedLeft = expectedDirectionTurnedLeft;
		this.expectedDirectionTurnedRight = expectedDirectionTurnedRight;
		this.inputDirection = inputDirection;
		_positionValidator = mock(PositionValidator.class);
		_robotTurner = mock(Turnable.class);
		_robotMover = mock(Movable.class);
	}

	@Parameterized.Parameters
	   public static Collection TurnDirections() {
	      return Arrays.asList(new Object[][]{	    		 
	 	         { Direction.EAST,  Direction.WEST,  Direction.SOUTH},
	 	         { Direction.NORTH, Direction.SOUTH, Direction.EAST},
	 	         { Direction.WEST,  Direction.EAST,  Direction.NORTH},
	 	         { Direction.SOUTH, Direction.NORTH, Direction.WEST}
	   });
	}

	@Test
	public void ShouldTurnLeftFromGivenDirection() {		
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);		
		Position defaultPosition = new Position(2,2);
		when(_positionValidator.validate(defaultPosition))
			.thenReturn(true);
		robot.place(defaultPosition, inputDirection);
		robot.turnLeft();		
		verify(_robotTurner, times(1)).turnLeft(inputDirection);
		
	}
	
	@Test
	public void ShouldTurnRightFromGivenDirection() {		
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);		
		Position defaultPosition = new Position(2,2);
		when(_positionValidator.validate(defaultPosition))
			.thenReturn(true);
		robot.place(defaultPosition, inputDirection);
		robot.turnRight();		
		verify(_robotTurner, times(1)).turnRight(inputDirection);
		
	}
	
	@Test
	public void ShouldReturnFalseWhenTurningIfNotPlaced(){
		
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);
						
		boolean isTurnedLeft = robot.turnLeft();
		boolean isTurnedRight = robot.turnRight();
		assertEquals(false, isTurnedLeft);
		assertEquals(false, isTurnedRight);
				
	}

}
