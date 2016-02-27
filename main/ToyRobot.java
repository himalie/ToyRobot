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
	public void turn_Left()	
	{
		_direction = _direction.turn(-1);		
	}
	public void turn_Right()	
	{
		_direction = _direction.turn(1);		
	}
	
}
