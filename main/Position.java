package main;

public class Position {
	private final int _x;
	private final int _y;
	
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
	
}
