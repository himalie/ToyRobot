package main;

public class ToyRobot {
	private Position _position;
	private Direction _direction;
	private final Validatable _positionValidator;
	
	
	public ToyRobot(Validatable positionValidator){
		this._positionValidator = positionValidator;
	}
		
	private void set_Position(Position position){
		_position = position;
	}
	private void set_direction(Direction _direction) {
		this._direction = _direction;
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
}
