package test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import main.Board;
import main.Direction;
import main.Position;
import main.PositionValidator;
import main.ToyRobot;
import main.Validatable;

import org.junit.Test;
import org.junit.runners.Parameterized;

import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class RobotMovingTests {

	private int expectedX;
	private int expectedY;
	private Direction inputDirection;
	
	public RobotMovingTests(Direction inputDirection, int x, int y) {
		this.inputDirection = inputDirection;
	    this.expectedX = x;
	    this.expectedY = y;
	}
	
	// Initial position 2,2
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
		Board board = new Board(5,5);		
		Position defaultPosition = new Position(4,4);
		Validatable positionValidator = new PositionValidator(board);
		ToyRobot robot = new ToyRobot(positionValidator);
				
		robot.place(defaultPosition, inputDirection);
		robot.move();
		
		assertEquals(this.expectedX, robot.get_Position().get_x());
		assertEquals(this.expectedY, robot.get_Position().get_y());
	}
}
