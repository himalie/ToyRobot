package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import main.Board;
import main.Direction;
import main.DirectionTurner;
import main.Movable;
import main.Position;
import main.PositionValidator;
import main.RobotMover;
import main.ToyRobot;
import main.Turnable;
import main.Validatable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DirectionTurningTests {

	private Direction expectedDirection;
	private Direction inputDirection;	
	
	public DirectionTurningTests(Direction expectedDirection, Direction inputDirection) {
		this.expectedDirection = expectedDirection;
		this.inputDirection = inputDirection;
	}	
	
	@Parameterized.Parameters
	   public static Collection leftTurnDirections() {
	      return Arrays.asList(new Object[][]{	    		 
	 	         { Direction.EAST, Direction.SOUTH},
	 	         { Direction.NORTH, Direction.EAST },
	 	         { Direction.WEST, Direction.NORTH},
	 	         { Direction.SOUTH, Direction.WEST }
	   });
	}

	@Test
	public void ShouldTurnLeftFromGivenDirection() {

		Turnable directionTurner= new DirectionTurner();
		Direction _direction = directionTurner.Left(inputDirection);
		
		assertEquals(expectedDirection, _direction);
		
	}
}
