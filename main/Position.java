package main;

public class Position {
	private int _x;
	private int _y;
	
	public Position()
	{}
	public Position(int x, int y)
	{		
		this._x = x;
		this._y =y;
	}

	public int get_x() {
		return _x;
	}

	public int get_y() {
		return _y;
	}
	public Position change_Position(Position position, int x, int y){
		position._x += x;
		position._y +=y;
		return position;
	}	
}
