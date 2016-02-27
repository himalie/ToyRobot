package test;

import static org.junit.Assert.*;

import main.Board;
import main.Direction;
import main.Position;
import main.PositionValidator;
import main.ToyRobot;
import main.Validatable;

import org.junit.Test;

public class RobotTurningTests {

	@Test
	public void ShouldTurnLeftFromGivenDirection() {
		Board board = new Board(5,5);
		Validatable positionValidator= new PositionValidator(board);
		ToyRobot robot = new ToyRobot(positionValidator);
		
		Position defaultPosition = new Position(2,2);
		robot.place(defaultPosition, Direction.NORTH);
		robot.Left();
		
		assertEquals(Direction.WEST, robot.get_Direction());
		
	}
	@Test
	public void ShouldTurnRightFromGivenDirection() {
		Board board = new Board(5,5);
		Validatable positionValidator= new PositionValidator(board);
		ToyRobot robot = new ToyRobot(positionValidator);
		
		Position defaultPosition = new Position(2,2);
		robot.place(defaultPosition, Direction.WEST);
		robot.Right();
		
		assertEquals(Direction.NORTH, robot.get_Direction());
		
	}
	@Test
	public void ShouldReturnFalseWhenTurningIfNotPlaced(){
		Board board = new Board(5,5);
		Validatable positionValidator= new PositionValidator(board);
		ToyRobot robot = new ToyRobot(positionValidator);
				
		boolean isTurned = robot.Right();
		assertEquals(false, isTurned);
	}

}
