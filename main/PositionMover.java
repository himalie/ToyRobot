package main;

public class PositionMover implements Movable{
	
	private Validatable _positionValidator;
	public PositionMover(Validatable positionValidator){
		_positionValidator = positionValidator;		
	}
	public Validatable get_tt()
	{
		return _positionValidator;
	}
	public Position move(Position position, Direction direction){
		Position _position = position;
		if (_position != null){
			Position nextPosition = new Position(_position.get_x(), _position.get_y());
			switch(direction){
			case NORTH:
				nextPosition = nextPosition.change_Position(nextPosition, 0, 1);
				break;
			case EAST:
				nextPosition = nextPosition.change_Position(nextPosition, 1, 0);
				break;
			case SOUTH:
				nextPosition = nextPosition.change_Position(nextPosition, 0, -1);
				break;
			case WEST:
				nextPosition = nextPosition.change_Position(nextPosition, -1, 0);
				break;
			}
			if (_positionValidator.validate(nextPosition))
			{
				return nextPosition;
			}
		}
		return position;
	}
}
