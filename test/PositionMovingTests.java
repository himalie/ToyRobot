package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import main.Board;
import main.Direction;
import main.Movable;
import main.Position;
import main.PositionMover;
import main.PositionValidator;
import main.Validatable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PositionMovingTests {
	private int expectedX;
	private int expectedY;
	private Direction inputDirection;
	
	public PositionMovingTests(Direction inputDirection, int x, int y) {
		this.inputDirection = inputDirection;
	    this.expectedX = x;
	    this.expectedY = y;
	}
	
	// position 4,4
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
			Validatable _positionValidator = new PositionValidator(board);
			Movable _robotMover = new PositionMover(_positionValidator);

			Position p =_robotMover.move(defaultPosition, inputDirection);
			
			assertEquals(this.expectedX, p.get_x());
			assertEquals(this.expectedY, p.get_y());
			
		}
}
