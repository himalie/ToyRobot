package main;

public class ToyRobot {
	private Position _position;
	private Direction _direction;
	private final Validatable _positionValidator;
	private final Turnable _robotTurner;
	private final Movable _robotMover;
	
	public ToyRobot(Validatable positionValidator, Turnable robotTurner, Movable robotMover){
		this._positionValidator = positionValidator;
		this._robotTurner = robotTurner;
		this._robotMover = robotMover;
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
	public boolean LeftTurn()	
	{
		if(isPlaced()){
			_direction =  _robotTurner.LeftTurn(_direction);
			return true;
		}
		else{
			return false;
		}
	}
	public boolean RightTurn()	
	{
		if(isPlaced()){
			_direction = _robotTurner.RightTurn(_direction);
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
		Position position = _robotMover.move(this._position, this._direction);
		if (position != null)
		{
			set_Position(position);
			return true;
		}
		return false;		
	}
	
}