package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

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
import org.junit.runners.Parameterized;

import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class RobotMovingTests {

	private int expectedX;
	private int expectedY;
	private Direction inputDirection;
	
	private final Validatable _positionValidator;
	private final Movable _robotMover;
	private final Turnable _robotTurner;
	
	public RobotMovingTests(Direction inputDirection, int x, int y) {
		this.inputDirection = inputDirection;
	    this.expectedX = x;
	    this.expectedY = y;
	    _positionValidator = mock(PositionValidator.class);
		_robotMover = mock(Movable.class);
		_robotTurner = mock(Turnable.class);
	}
	
	// Initial position 4,4
	@Parameterized.Parameters
	   public static Collection<Object[]> resultedPosition() {
	      return Arrays.asList(new Object[][] {
	         { Direction.EAST, 4, 4 },
	         { Direction.SOUTH, 4, 3 },
	         { Direction.WEST, 3, 4 },
	         { Direction.NORTH, 4, 4 }
	      });
	   }
	@Test 
	public void ShouldMoveOneStepInTheDirectionGiven()
	{	
		Position defaultPosition = new Position(4,4);
		ToyRobot robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);
		
		when(_positionValidator.validate(defaultPosition))
		.thenReturn(true);
		robot.place(defaultPosition, inputDirection);
		
		robot.move();
		verify(_robotMover, times(1)).move(defaultPosition, inputDirection);
					
	}
}
