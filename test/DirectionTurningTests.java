package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import main.Direction;
import main.DirectionTurner;
import main.Turnable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DirectionTurningTests {

	private Direction expectedDirectionTurnedLeft;
	private Direction expectedDirectionTurnedRight;
	private Direction inputDirection;	
	
	public DirectionTurningTests(Direction expectedDirectionTurnedLeft, Direction expectedDirectionTurnedRight, Direction inputDirection) {
		this.expectedDirectionTurnedLeft = expectedDirectionTurnedLeft;
		this.expectedDirectionTurnedRight = expectedDirectionTurnedRight;
		this.inputDirection = inputDirection;
	}	
	
	@Parameterized.Parameters
	   public static Collection TurnDirections() {
	      return Arrays.asList(new Object[][]{	    		 
	 	         { Direction.EAST, Direction.WEST, Direction.SOUTH},
	 	         { Direction.NORTH, Direction.SOUTH, Direction.EAST },
	 	         { Direction.WEST, Direction.EAST, Direction.NORTH},
	 	         { Direction.SOUTH, Direction.NORTH, Direction.WEST }
	   });
	}

	@Test
	public void ShouldTurnLeftFromGivenDirection() {

		Turnable directionTurner= new DirectionTurner();
		Direction _direction = directionTurner.Left(inputDirection);
		
		assertEquals(expectedDirectionTurnedLeft, _direction);
		
	}
	@Test
	public void ShouldTurnRightFromGivenDirection() {

		Turnable directionTurner= new DirectionTurner();
		Direction _direction = directionTurner.Right(inputDirection);
		
		assertEquals(expectedDirectionTurnedRight, _direction);
		
	}
}
