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
	
	public RobotTurningTests(Direction expectedDirectionTurnedLeft, Direction expectedDirectionTurnedRight, Direction inputDirection) {
		this.expectedDirectionTurnedLeft = expectedDirectionTurnedLeft;
		this.expectedDirectionTurnedRight = expectedDirectionTurnedRight;
		this.inputDirection = inputDirection;
		_positionValidator = mock(PositionValidator.class);
		_robotTurner = mock(Turnable.class);
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
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner);		
		Position defaultPosition = new Position(2,2);
		when(_positionValidator.validate(defaultPosition))
			.thenReturn(true);
		robot.place(defaultPosition, inputDirection);
		robot.LeftTurn();		
		verify(_robotTurner, times(1)).LeftTurn(inputDirection);
		
	}
	
	@Test
	public void ShouldTurnRightFromGivenDirection() {		
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner);		
		Position defaultPosition = new Position(2,2);
		when(_positionValidator.validate(defaultPosition))
			.thenReturn(true);
		robot.place(defaultPosition, inputDirection);
		robot.RightTurn();		
		verify(_robotTurner, times(1)).RightTurn(inputDirection);
		
	}
	
	@Test
	public void ShouldReturnFalseWhenTurningIfNotPlaced(){
		
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner);
						
		boolean isTurnedLeft = robot.LeftTurn();
		boolean isTurnedRight = robot.RightTurn();
		assertEquals(false, isTurnedLeft);
		assertEquals(false, isTurnedRight);
				
	}

}
