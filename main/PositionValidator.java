package main;

public class PositionValidator implements Validatable {

	private final Board _board;
	
	public PositionValidator(Board board)
	{
		this._board = board;
	}
	public boolean validate(Position position) {
		if ((position.get_x() >= _board.get_width())|| (position.get_x()<0 ) ||
				(position.get_y()>= _board.get_height()) || (position.get_y() <0))
			{
				return false;			
			}
		return true;
	}
	

}
