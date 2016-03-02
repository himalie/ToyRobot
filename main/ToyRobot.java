package main;

public class ToyRobot {
	private Position _position;
	private Direction _direction;
	private final Validatable _positionValidator;
	private final Turnable _robotTurner;
	
	public ToyRobot(Validatable positionValidator, Turnable robotTurner){
		this._positionValidator = positionValidator;
		this._robotTurner = robotTurner;
	}
		
	private void set_Position(Position position){
		_position = position;
	}
	public Position get_Position(){
		return _position;
	}
	private void set_direction(Direction _direction) {
		this._direction = _direction;
	}
	public Direction get_Direction(){
		return this._direction;
	}
	
	public boolean place(Position position, Direction direction){
		if (_positionValidator.validate(position)){
			set_Position(position);
			set_direction(direction);					
			return true;
		}
		return false;	
	}
	public boolean isPlaced()
	{
		if (_position != null){
			return true;
		}
		return false;		
	}
	public boolean Left()	
	{
		if(isPlaced()){
			_direction =  _robotTurner.Left(_direction);
			return true;
		}
		else{
			return false;
		}
	}
	public boolean Right()	
	{
		if(isPlaced()){
			_direction = _robotTurner.Right(_direction);
			return true;
		}
		else{
			return false;
		}		
	}
	
	public String report() {
		if (isPlaced()){
			String _output = _position.get_x()+", "+_position.get_y()+", "+_direction;
		return _output;
		}
		return null;
	}
	public boolean move()
	{
		if (isPlaced()){
			Position nextPosition = new Position(_position.get_x(), _position.get_y());
			switch(this._direction){
			case NORTH:
				nextPosition = nextPosition.change_Position(nextPosition, 0,1);
				break;
			case EAST:
				nextPosition = nextPosition.change_Position(nextPosition,1,0);
				break;
			case SOUTH:
				nextPosition = nextPosition.change_Position(nextPosition,0,-1);
				break;
			case WEST:
				nextPosition = nextPosition.change_Position(nextPosition,-1, 0);
				break;
			}
			if (_positionValidator.validate(nextPosition))
			{
				set_Position(nextPosition);
				return true;
			}
			else{
				return false;
			}		
		}
		return false;
	}

	
}