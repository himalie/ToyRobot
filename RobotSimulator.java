import main.Board;
import main.Direction;
import main.DirectionTurner;
import main.Movable;
import main.Position;
import main.PositionMover;
import main.PositionValidator;
import main.ToyRobot;
import main.Turnable;
import main.Validatable;


public class RobotSimulator {
	private ToyRobot _robot;
	private final Validatable _positionValidator;
	private final Movable _robotMover;
	private final Turnable _robotTurner;
	
	public RobotSimulator()
	{
		Board board = new Board(5,5);
		_positionValidator = new PositionValidator(board);
		_robotMover = new PositionMover(_positionValidator);
		_robotTurner = new DirectionTurner();
		_robot = new ToyRobot(_positionValidator, _robotTurner, _robotMover);
				
	}
	
	public boolean place(int x, int y, Direction direction)
	{
		Position position = new Position(x, y);
		return _robot.place(position, direction);
	}	
	public boolean move()
	{
		return _robot.move();				
	}
	
	public boolean turnLeft()
	{
		return _robot.turnLeft();
	}
	public boolean turnRight()
	{
		return _robot.turnRight();
	}
	public String report()
	{
		return _robot.report();
	}

}
